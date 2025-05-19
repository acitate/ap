package ap.projects.mid_project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileHandler {
    final private Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateGson()).setPrettyPrinting().create();
    private Library library;

    private File file;
    private FileReader reader;
    private FileWriter writer;

    public FileHandler() {
        file = new File("library.json");
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public boolean fileExists() {
        return this.file.exists();
    }

    public Library loadFromFile() {
        try {
            if (file.exists()) {
                reader = new FileReader(file);
                library = gson.fromJson(reader, Library.class);

            } else {
                System.out.println("File does not exist!");;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return library;
    }

    public void saveToFile() {
        try {
            writer = new FileWriter(file);
            gson.toJson(library, writer);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LocalDateGson extends TypeAdapter<LocalDate> {
    private static DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public void write(JsonWriter out, LocalDate value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value.format(formatter));
        }
    }

    @Override
    public LocalDate read(JsonReader in) throws IOException {
        if (in.peek() == null || in.peek().name().equals("NULL")) {
            in.nextNull();
            return null;
        } else {
            return LocalDate.parse(in.nextString(), formatter);
        }
    }
}
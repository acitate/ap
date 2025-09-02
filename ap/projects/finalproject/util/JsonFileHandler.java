package ap.projects.finalproject.util;

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

public class JsonFileHandler {
    final private Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateGson()).setPrettyPrinting().create();

    public Object loadFromFile(File file, Class managerClass) {
        // tries to load a json file and convert it to a Manager object, returning null if the file does not exist.

        Object manager = null;
        try {
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                manager = gson.fromJson(reader, managerClass);

            } else {
                System.out.println("File does not exist!");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manager;
    }

    public void saveToFile(Object manager, File file) {
        // converts a Manager object to json and saves it to a file.
        try {
            FileWriter writer = new FileWriter(file);
            gson.toJson(manager, writer);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class LocalDateGson extends TypeAdapter<LocalDate> {
    // This class help makes LocalDate a usable format for gson.
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
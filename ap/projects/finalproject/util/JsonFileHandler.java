package ap.projects.finalproject.util;

import ap.projects.finalproject.manager.StudentManager;
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

    public StudentManager loadStudents(File file) {
        // tries to load a json file and convert it to a StudentManager object, returning null if the file does not exist.

        StudentManager students = new StudentManager();
        try {
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                students = gson.fromJson(reader, StudentManager.class);

            } else {
                System.out.println("File does not exist!");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public void saveStudents(StudentManager manager, File file) {
        // converts a StudentManager object and saves it to a file.
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
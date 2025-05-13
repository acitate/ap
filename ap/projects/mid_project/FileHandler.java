package ap.projects.mid_project;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandler {
    final private Gson gson = new Gson();
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
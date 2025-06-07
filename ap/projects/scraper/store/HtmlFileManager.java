package ap.projects.scraper.store;

import ap.projects.scraper.utils.DirectoryTools;

import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

public class HtmlFileManager {

    private String saveFileBasePath;
    private static int saveCounter=0;

    public HtmlFileManager(String saveFileBasePath) {
//        this.saveFileBasePath = DirectoryTools.createDirectoryWithTimeStamp(saveFileBasePath);

        this.saveFileBasePath = saveFileBasePath;
        DirectoryTools.createDirectory(saveFileBasePath);
    }

    public void save(List<String> lines, String name) {
        try {
            String saveHtmlFileAddress = saveFileBasePath + "/" + name;
            if (lines.size() != 0) {
            PrintWriter out = new PrintWriter(saveHtmlFileAddress);
            for (String line : lines) {
                out.println(line);
            }
            out.close();
            }
            System.out.println("save counter: " + saveCounter);
        }catch (Exception e){
            System.out.println("save failed: " + e.getMessage());
        }
    }

    public void save(List<String> lines, Path path) {
        try {
            String saveHtmlFileAddress = saveFileBasePath + "/" + path + "/" + saveCounter + ".html";
            System.out.println("\nsave:    " + saveHtmlFileAddress + "\n");
            System.out.println(saveHtmlFileAddress.substring(0,saveHtmlFileAddress.lastIndexOf("/")));
            DirectoryTools.createDirectory(saveHtmlFileAddress.substring(0,saveHtmlFileAddress.lastIndexOf("/")));
            if (lines.size() != 0) {
                PrintWriter out = new PrintWriter(saveHtmlFileAddress);
                for (String line : lines) {
                    out.println(line);
                }
                out.close();
            }
            System.out.println("save counter: " + saveCounter);
        }catch (Exception e){
            System.out.println("save failed: " + e.getMessage());
        }
        saveCounter++;
    }

    public String getSaveHtmlFileAddress(){
        saveCounter++;
        return saveFileBasePath +"/"+ saveCounter;
    }
}

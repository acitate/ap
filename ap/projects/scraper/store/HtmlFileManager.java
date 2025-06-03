package ap.projects.scraper.store;

import ap.projects.scraper.utils.DirectoryTools;

import java.io.PrintWriter;
import java.util.List;

public class HtmlFileManager {

    private String saveFileBasePath;
    private static int saveCounter=0;

    public HtmlFileManager(String saveFileBasePath) {
//        this.saveFileBasePath = DirectoryTools.createDirectoryWithTimeStamp(saveFileBasePath);

        this.saveFileBasePath = saveFileBasePath;
        DirectoryTools.createDirectory(saveFileBasePath);
    }

    public void save(List<String> lines, String url) {
        try {
            String saveHtmlFileAddress = saveFileBasePath + "/" + url.replaceFirst("https://", "")
                    .replaceAll("/", "#");
//            String saveHtmlFileAddress = getSaveHtmlFileAddress();
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

    public String getSaveHtmlFileAddress(){
        saveCounter++;
        return saveFileBasePath +"/"+ saveCounter;
    }
}

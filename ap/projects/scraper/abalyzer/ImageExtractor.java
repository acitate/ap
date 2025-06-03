package ap.projects.scraper.abalyzer;

import ap.projects.scraper.Conf;
import ap.projects.scraper.fetcher.ImageDownloader;
import ap.projects.scraper.parser.HtmlParser;
import ap.projects.scraper.utils.DirectoryTools;
import ap.projects.scraper.utils.FileTools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageExtractor {
    private static List<String> fileList = DirectoryTools.getFilesAbsolutePathInDirectory(Conf.SAVE_DIRECTORY);

    public static List<String> getAllImgUrls() {
        List<String> urls = new ArrayList<>();

        for (String address : fileList) {
            List<String> lines = FileTools.getTextFileLines(address);
            if (lines != null) {
                String name = FileTools.getName(address).replaceAll("#", "/");
                try {
                    urls.addAll(HtmlParser.getAllImgsFromList(lines, name));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return urls;
    }

    public static void main(String[] args) {
        List<String> urls = getAllImgUrls();

        for (String url : urls) {
            try {
                ImageDownloader.downloadImage(url, "fetched_images/" + url.replaceAll("/", "#"));
            } catch (Exception e) {
                System.out.println("Image download failed!");
                System.out.println(e.getMessage());
            }
        }

    }
}

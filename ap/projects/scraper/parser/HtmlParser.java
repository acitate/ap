package ap.projects.scraper.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HtmlParser {

    public static String getFirstUrl(String htmlLine) {
        String url = null;
        int startIndex = htmlLine.indexOf("href=\"");
        if (startIndex >= 0) {
            try {
                int hrefLength = "href\"".length();
                int endIndex = htmlLine.indexOf("\"", startIndex + hrefLength + 1);
                url = htmlLine.substring(startIndex + hrefLength + 1, endIndex);
            } catch (Exception e) {
            }
        }
        return url;
    }

    private static List<String> getAllUrlsFromHtmlLinesStream(Stream<String> htmlLinesStream) throws IOException {
        List<String> urls = htmlLinesStream
                .map(line -> getFirstUrl(line))
                .filter(s -> s != null)
                .collect(Collectors.toList());
        return urls;
    }

    public static List<String> getAllUrlsFromFile(String filePath) throws IOException {
        return getAllUrlsFromHtmlLinesStream(Files.lines(Path.of(filePath)));
    }

    public static List<String> getAllUrlsFromList(List<String> htmlLines) throws IOException {
        return getAllUrlsFromHtmlLinesStream(htmlLines.stream());
    }

    public static String getImg(String htmlLine, String url) {
        boolean containsSrc = htmlLine.contains("src=");
        boolean containsSuffix = htmlLine.contains(".png\"") || htmlLine.contains(".jpg\"");
        String img = null;

        if (containsSrc && containsSuffix) {
            htmlLine = htmlLine.replaceAll("src=", "").replaceAll("\"", "");
            if (htmlLine.contains("http")) {
                img = htmlLine;
            } else {
            img = "https://" + url + ((url.endsWith("/"))? htmlLine.replaceFirst("/", "") : htmlLine);
            }
        }

        return(img);
    }

    public static List<String> getAllImgsFromList(List<String> htmlLines, String url) throws IOException {
        return getAllImgsFromHtmlLinesStream(htmlLines.stream(), url);
    }

    public static List<String> getAllImgsFromHtmlLinesStream(Stream<String> htmlLines, String url) throws  IOException{
        List<String> list = htmlLines.map(line -> getImg(line, url))
                .filter(s -> s != null)
                .collect(Collectors.toList());
        return list;
    }
}

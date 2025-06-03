package ap.projects.scraper;

import ap.projects.scraper.fetcher.HtmlFetcher;
import ap.projects.scraper.parser.HtmlParser;
import ap.projects.scraper.store.HtmlFileManager;

import java.io.IOException;
import java.util.*;

public class DomainHtmlScraper {
    private String domainAddress;
    private Queue<String> queue;

    private HtmlFileManager htmlFileManager;

    public DomainHtmlScraper(String domainAddress, String savePath) {
        this.domainAddress = domainAddress;
        this.queue = new LinkedList<>();
        this.htmlFileManager=new HtmlFileManager(savePath);
    }

    public void start() throws IOException {
        List<String> htmlLines = HtmlFetcher.fetchHtml(domainAddress);
        this.htmlFileManager.save(htmlLines, domainAddress);

        List<String> urls = HtmlParser.getAllUrlsFromList(htmlLines);
        queue.addAll(new HashSet<>(urls));
        int counter=1;

        while (!queue.isEmpty()) {
            String url = queue.remove();
            counter++;
            try {
                htmlLines = HtmlFetcher.fetchHtml(url);
                this.htmlFileManager.save(htmlLines, url);

                urls = HtmlParser.getAllUrlsFromList(htmlLines);
                HtmlParser.getAllImgsFromList(htmlLines, url);
                queue.addAll(new HashSet<>(urls));
            }
            catch (Exception e){
                System.out.println("ERROR: "+url+"\t -> "+e.getMessage());
            }
            System.out.println("["+counter+"] "+url+" fetch and saved (queue size:"+queue.size()+").");
            System.out.println("--------------------------------------------------------------------");
        }
        System.out.println("Operation complete");
    }

}

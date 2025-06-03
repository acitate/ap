package ap.projects.scraper;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String domainAddress = ap.projects.scraper.Conf.DOMAIN_ADDRESS;
        String savePath = Conf.SAVE_DIRECTORY;

        DomainHtmlScraper domainHtmlScraper = new DomainHtmlScraper(domainAddress,savePath);

        domainHtmlScraper.start();
    }
}

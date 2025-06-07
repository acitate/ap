package ap.projects.scraper.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UrlTools {

    public static boolean isFromDomain(String url, String domain, String mode) {
        boolean res;
        try {
            String host = new URL(url).getHost();
            if (mode.equals("exclusive")) {
                res = host.equals(domain);
            } else if (mode.equals("inclusive")) {
                res = host.equals(domain) || host.endsWith('.' + domain);
            } else {
                throw new IllegalArgumentException("Invalid mode. modes:\n'imclusive': allow subdomains.\n'exclusive': don't allow subdomains.");
            }
        } catch (MalformedURLException e) {
            res = false;
        }
        return res;
    }

    public static String getSubDomain(String url) {
        // Assumin the domain is always like example.ac.ir. and anything before it is a subdomain.
        String sub = "";
        try {
            String domain = new URL(url).getHost();
            List<String> labels = new ArrayList<>(List.of(domain.split("\\.")));
            if (labels.size() <= 3) {
                sub = "";
            } else {
                if (!labels.get(0).equals("www")) {
                    sub += labels.get(0);
                    for (int i = 1; i < labels.size() - 3; i++) {
                        sub += '.'+labels.get(i);
                    }
                }
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return sub;
    }

    public static Path urlToPath(String url) {
        String path = "";
        try {
            if (getSubDomain(url).length() == 0) {
                path += new URL(url).getPath().replaceFirst("/", "");
            } else {
                path += '_' + getSubDomain(url) + new URL(url).getPath();
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return Path.of(path);
    }
}

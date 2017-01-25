package pcbuilder.controllers.transport;

import pcbuilder.domain.Crawler;

import java.util.ArrayList;
import java.util.List;

public class CrawlerResponse {

    private List<Crawler> crawlers = new ArrayList<>();

    public List<Crawler> getCrawlers() {
        return crawlers;
    }

    public void setCrawlers(Iterable<Crawler> crawlers) {
        for (Crawler crawler : crawlers) {
            this.crawlers.add(crawler);
        }
    }
}

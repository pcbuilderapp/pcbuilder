package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.transport.CrawlerResponse;
import pcbuilder.domain.Crawler;
import pcbuilder.repository.CrawlerRepository;

import java.util.List;


/**
 * The Class CrawlerController.
 */
@RestController
public class CrawlerController {


    /** The shop repository. */
    @Autowired
    private CrawlerRepository crawlerRepository;


    /**
     * Gets all crawlers.
     *
     * @return an Iterable<Crawler> containing all crawlers.
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/crawler/getall", method= RequestMethod.GET)
    public CrawlerResponse getAllCrawlers() {

        CrawlerResponse crawlerResponse = new CrawlerResponse();
        crawlerResponse.setCrawlers(crawlerRepository.findAll());
        return crawlerResponse;

    }

    /**
     * Searches a crawler by name.
     *
     * @return a Crawler.
     */
    @RequestMapping(value="/crawler/findbyname", method= RequestMethod.GET)
    public Crawler findCrawlerByName(String name) {
        return crawlerRepository.findByName(name);
    }

    /**
     * Creates the crawler.
     *
     * @param Crawler crawler
     * @return ResponseEntity<String> response"
     */
    @RequestMapping(value="/crawler/create", method=RequestMethod.POST)
    public ResponseEntity<String> createCrawler(@RequestBody Crawler crawler) {

        if (crawlerRepository.findByName(crawler.getName()) == null) {

            crawlerRepository.save(crawler);

        } else {

            return new ResponseEntity<String>("Crawler already exists!", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<String>("Crawler '"+crawler.getName()+"' has been created!", HttpStatus.OK);
    }

    /**
     * Updates the crawler.
     *
     * @param Crawler crawler
     * @return ResponseEntity<String> response"
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/crawler/update", method=RequestMethod.POST)
    public ResponseEntity<String> updateCrawler(@RequestBody Crawler crawlerUpdate) {

        Crawler crawler = crawlerRepository.findByName(crawlerUpdate.getName());

        if (crawler == null) {

            return new ResponseEntity<String>("Crawler does not exists, unable to update!", HttpStatus.CONFLICT);

        } else {

            crawler.setActivated(crawlerUpdate.getActivated());
            crawlerRepository.save(crawler);

        }

        return new ResponseEntity<String>("Crawler '"+crawler.getName()+"' has been updated!", HttpStatus.OK);
    }
}
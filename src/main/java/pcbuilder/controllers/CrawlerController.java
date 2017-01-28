package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.dto.CrawlerResponse;
import pcbuilder.domain.Crawler;
import pcbuilder.repository.CrawlerRepository;

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
     * @return Iterable
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
     * @param name String
     * @return a Crawler.
     */
    @RequestMapping(value="/crawler/findbyname", method= RequestMethod.GET)
    public Crawler findCrawlerByName(String name) {
        return crawlerRepository.findByName(name);
    }

    /**
     * Creates the crawler.
     *
     * @param crawler Crawler
     * @return ResponseEntity
     */
    @RequestMapping(value="/crawler/create", method=RequestMethod.POST)
    public ResponseEntity<String> createCrawler(@RequestBody Crawler crawler) {

        if (crawlerRepository.findByName(crawler.getName()) == null) {

            crawlerRepository.save(crawler);

        } else {

            return new ResponseEntity<>("Crawler already exists!", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>("Crawler '"+crawler.getName()+"' has been created!", HttpStatus.OK);
    }

    /**
     * Updates the crawler.
     *
     * @param crawlerUpdate Crawler
     * @return ResponseEntity
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/crawler/update", method=RequestMethod.POST)
    public ResponseEntity<String> updateCrawler(@RequestBody Crawler crawlerUpdate) {

        Crawler crawler = crawlerRepository.findByName(crawlerUpdate.getName());

        if (crawler == null) {

            return new ResponseEntity<>("Crawler does not exists, unable to update!", HttpStatus.CONFLICT);

        } else {

            crawler.setActivated(crawlerUpdate.getActivated());
            crawlerRepository.save(crawler);

        }

        return new ResponseEntity<>("Crawler '"+crawler.getName()+"' has been updated!", HttpStatus.OK);
    }
}
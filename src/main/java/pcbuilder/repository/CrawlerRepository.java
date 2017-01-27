package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pcbuilder.domain.Crawler;
import javax.transaction.Transactional;

/**
 * The Interface CrawlerRepository
 */
@Transactional
public interface CrawlerRepository extends CrudRepository<Crawler, Long> {

    /**
     * Find by name.
     *
     * @param name String
     * @return Crawler
     */
    Crawler findByName(@Param("name")String name);
}

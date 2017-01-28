package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import pcbuilder.domain.PricePoint;
import javax.transaction.Transactional;

/**
 * The Interface PricePointRepository is used to add pricepoints when products are added.
 */
@Transactional
public interface PricePointRepository extends CrudRepository<PricePoint, Long> {}

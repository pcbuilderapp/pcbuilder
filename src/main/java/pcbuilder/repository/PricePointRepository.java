package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pcbuilder.domain.Component;
import pcbuilder.domain.PricePoint;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The Interface PricePointRepository.
 */
@Transactional
public interface PricePointRepository extends CrudRepository<PricePoint, Long> {

    //List<PricePoint> findByComponent(@Param("component")Component component);
}

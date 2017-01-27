package pcbuilder.repository;

import org.springframework.data.domain.Sort;
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

    List<PricePoint> findByProductComponent(@Param("component")Component component, Sort sort);
}

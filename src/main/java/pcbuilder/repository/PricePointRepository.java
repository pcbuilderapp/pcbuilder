package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import pcbuilder.domain.PricePoint;

public interface PricePointRepository extends CrudRepository<PricePoint, Long> {

}

package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pcbuilder.domain.Component;
import pcbuilder.domain.PricePoint;

import java.util.List;

public interface PricePointRepository extends CrudRepository<PricePoint, Long> {

    //List<PricePoint> findByComponent(@Param("component")Component component);
}

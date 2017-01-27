package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pcbuilder.domain.MaxDailyPriceView;
import java.util.List;

public interface MaxDailyPriceViewRepository  extends CrudRepository<MaxDailyPriceView, Long> {

    List<MaxDailyPriceView> findByComponentIdOrderByDate(@Param("componentId")long component_id);
}

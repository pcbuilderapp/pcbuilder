package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pcbuilder.domain.MaxDailyPriceView;

import java.util.Date;
import java.util.List;

public interface MaxDailyPriceViewRepository  extends CrudRepository<MaxDailyPriceView, Long> {

    List<MaxDailyPriceView> findByComponentIdOrderByDate(@Param("componentId")long componentId);

    List<MaxDailyPriceView> findByComponentIdAndDateBetweenOrderByDate(
            @Param("componentId")long componentId,
            @Param("fromDate")Date fromDate,
            @Param("toDate")Date toDate);
}

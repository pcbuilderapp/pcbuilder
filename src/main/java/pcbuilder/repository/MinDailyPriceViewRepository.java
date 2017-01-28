package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pcbuilder.domain.MinDailyPriceView;

import java.util.Date;
import java.util.List;

public interface MinDailyPriceViewRepository  extends CrudRepository<MinDailyPriceView, Long> {

    List<MinDailyPriceView> findByComponentIdOrderByDate(@Param("componentId")long componentId);

    List<MinDailyPriceView> findByComponentIdAndDateBetweenOrderByDate(
            @Param("componentId")long componentId,
            @Param("fromDate")Date fromDate,
            @Param("toDate")Date toDate);
}

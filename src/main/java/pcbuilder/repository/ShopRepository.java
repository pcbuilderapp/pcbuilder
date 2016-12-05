package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pcbuilder.domain.Shop;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ShopRepository extends CrudRepository<Shop, Long> {
    List<Shop> findByName(@Param("name")String name);
}

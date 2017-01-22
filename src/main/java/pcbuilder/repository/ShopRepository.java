package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pcbuilder.domain.Shop;
import javax.transaction.Transactional;
import java.util.List;

/**
 * The Interface ShopRepository.
 */
@Transactional
public interface ShopRepository extends CrudRepository<Shop, Long> {
    
    /**
     * Find by name.
     *
     * @param name
     * @return the list
     */
    List<Shop> findByName(@Param("name")String name);
}

package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pcbuilder.domain.Shop;
import javax.transaction.Transactional;

/**
 * The Interface ShopRepository.
 */
@Transactional
public interface ShopRepository extends CrudRepository<Shop, Long> {
    
    /**
     * Find by name.
     *
     * @param String name
     * @return Shop
     */
    Shop findByName(@Param("name")String name);
}

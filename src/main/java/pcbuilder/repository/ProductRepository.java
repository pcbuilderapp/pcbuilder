package pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pcbuilder.domain.Component;
import pcbuilder.domain.Product;
import pcbuilder.domain.Shop;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The Interface ProductRepository.
 */
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    /**
     * Find by component and shop.
     *
     * @param component 
     * @param shop 
     * @return the list
     */
    List<Product> findByComponentAndShop(Component component, Shop shop);
    
    /**
     * Find by component order by current price asc.
     *
     * @param component
     * @return the list
     */
    List<Product> findByComponentOrderByCurrentPriceAsc(Component component);
}

package pcbuilder.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    Product findByComponentAndShop(Component component, Shop shop);
    
    /**
     * Find by component order by current price asc.
     *
     * @param component
     * @return the list
     */
    List<Product> findByComponentOrderByCurrentPriceAsc(Component component);

    //@Query( "SELECT p FROM Product p WHERE p.component IN (SELECT c FROM Component c WHERE c.name LIKE %:name%)")
    Page<Product> findByComponentNameContaining(String name, Pageable pageable);
}

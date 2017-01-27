package pcbuilder.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
     * @param component Component
     * @param shop Shop
     * @return Product
     */
    Product findByComponentAndShop(Component component, Shop shop);
    
    /**
     * Find by component order by current price asc.
     *
     * @param component Component
     * @return List
     */
    List<Product> findByComponentOrderByCurrentPriceAsc(Component component);

    /**
     * Find a paged list of products by a component name.
     *
     * @param name String
     * @param pageable Pageable
     * @return Page
     */
    Page<Product> findByComponentNameContaining(String name, Pageable pageable);

}

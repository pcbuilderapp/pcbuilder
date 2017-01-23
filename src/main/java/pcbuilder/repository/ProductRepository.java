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

@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByComponentAndShop(Component component, Shop shop);
    List<Product> findByComponentOrderByCurrentPriceAsc(Component component);

    @Query( "SELECT p FROM Product p WHERE p.component.name LIKE %:name%")
    Page<Product> findByNameContaining(@Param("name")String name, Pageable pageable);
}

package pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pcbuilder.domain.Component;
import pcbuilder.domain.Product;
import pcbuilder.domain.Shop;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByComponentAndShop(Component component, Shop shop);
    List<Product> findByComponentOrderByCurrentPriceAsc(Component component);
}

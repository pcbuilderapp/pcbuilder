package pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pcbuilder.domain.Product;

@RepositoryRestResource(path = "component")
public interface ProductRepository extends JpaRepository<Product, Long> {

}

package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pcbuilder.domain.components.Motherboard;

@RepositoryRestResource
public interface MotherboardRepository extends CrudRepository<Motherboard, Long> {

    Iterable<Motherboard> findByBrand(String brand);

}

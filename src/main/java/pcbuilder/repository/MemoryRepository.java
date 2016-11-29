package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pcbuilder.domain.components.Memory;

@RepositoryRestResource
public interface MemoryRepository extends CrudRepository<Memory, Long> {

    Iterable<Memory> findByBrand(@Param("brand")String brand);

}

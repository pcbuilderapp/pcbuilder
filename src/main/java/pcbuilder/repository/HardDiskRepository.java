package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pcbuilder.domain.components.HardDisk;

@RepositoryRestResource
public interface HardDiskRepository extends CrudRepository<HardDisk, Long> {

    Iterable<HardDisk> findByBrand(@Param("brand")String brand);

}

package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pcbuilder.domain.components.Cpu;

@RepositoryRestResource
public interface CpuRepository extends CrudRepository<Cpu, Long> {

    Iterable<Cpu> findByBrand(String brand);

}

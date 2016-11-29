package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pcbuilder.domain.components.Case;

@RepositoryRestResource
public interface CaseRepository extends CrudRepository<Case, Long> {

    Iterable<Case> findByBrand(@Param("brand")String brand);

}

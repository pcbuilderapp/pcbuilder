package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pcbuilder.domain.Connector;

public interface ConnectorRepository extends CrudRepository<Connector, Long> {
    Connector findByName(@Param("name")String name);
}
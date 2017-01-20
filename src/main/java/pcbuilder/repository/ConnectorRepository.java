package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pcbuilder.domain.CType;
import pcbuilder.domain.Connector;

import javax.transaction.Transactional;

@Transactional
public interface ConnectorRepository extends CrudRepository<Connector, Long> {

    Connector findByNameAndType(@Param("name")String name, @Param("type")CType type);
}
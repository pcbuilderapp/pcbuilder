package pcbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pcbuilder.domain.CType;
import pcbuilder.domain.Connector;

import javax.transaction.Transactional;

/**
 * The Interface ConnectorRepository.
 */
@Transactional
public interface ConnectorRepository extends CrudRepository<Connector, Long> {

    /**
     * Find by name and type.
     *
     * @param name
     * @param type
     * @return the connector
     */
    Connector findByNameAndType(@Param("name")String name, @Param("type")CType type);
}
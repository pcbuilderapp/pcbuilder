package pcbuilder.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.domain.Pageable;
import pcbuilder.domain.CType;
import pcbuilder.domain.Component;
import pcbuilder.domain.Connector;

import java.util.Collection;
import java.util.List;

/**
 * The Interface ComponentRepository.
 */
@RepositoryRestResource(path = "components")
public interface ComponentRepository extends JpaRepository<Component, Long> {

    /**
     * Find by brand and manufacturer part number.
     *
     * @param brand
     * @param manufacturerPartNumber
     * @return the component list
     */
    List<Component> findByBrandAndManufacturerPartNumber(@Param("brand")String brand, @Param("manufacturerPartNumber")String manufacturerPartNumber);

    /**
     * Find by name containing and type.
     *
     * @param name
     * @param type 
     * @param pageable 
     * @return the page
     */
    Page<Component> findByNameContainingAndType(@Param("name")String name, @Param("type")CType type, Pageable pageable);

    /**
     * Find by name containing and type and connectors in.
     *
     * @param name
     * @param type
     * @param connectors
     * @param pageable
     * @return the page
     */
    Page<Component> findByNameContainingAndTypeAndConnectorsIn(String name, CType type, Collection<Connector> connectors, Pageable pageable);

    /**
     * Find by name containing and with all connectors paged.
     *
     * @param name
     * @param type
     * @param connectors
     * @param connectorsSize
     * @param pageable
     * @return the page
     */
    @Query( "SELECT c FROM Component c INNER JOIN c.connectors yt " +
            "WHERE c.name LIKE %:name% " +
            "AND c.type = :type " +
            "AND yt IN (:connectors) " +
            "GROUP BY c " +
            "HAVING COUNT(DISTINCT yt) = (:connectorsSize)")
    Page<Component> findByNameContainingAndWithAllConnectorsPaged(@Param("name")String name, @Param("type")CType type, @Param("connectors")Collection<Connector> connectors, @Param("connectorsSize")Long connectorsSize, Pageable pageable);

    /**
     * Find by name containing and with all connectors.
     *
     * @param name
     * @param type
     * @param connectors
     * @param connectorsSize
     * @return the list
     */
    @Query( "SELECT c FROM Component c INNER JOIN c.connectors yt " +
            "WHERE c.name LIKE %:name% " +
            "AND c.type = :type " +
            "AND yt IN (:connectors) " +
            "GROUP BY c " +
            "HAVING COUNT(DISTINCT yt) = (:connectorsSize)")
    List<Component> findByNameContainingAndWithAllConnectors(@Param("name")String name, @Param("type")CType type, @Param("connectors")Collection<Connector> connectors, @Param("connectorsSize")Long connectorsSize);
}

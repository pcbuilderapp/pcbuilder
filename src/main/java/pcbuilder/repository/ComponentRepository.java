package pcbuilder.repository;

import org.springframework.data.domain.Page;
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

@RepositoryRestResource(path = "components")
public interface ComponentRepository extends JpaRepository<Component, Long> {

    List<Component> findByNameContaining(@Param("name")String name);
    Component findByManufacturerPartNumber(@Param("manufacturerPartNumber")String manufacturerPartNumber);
    List<Component> findByEuropeanArticleNumber(@Param("europeanArticleNumber")String europeanArticleNumber);
    Page<Component> findByNameContainingAndType(@Param("name")String name, @Param("type")CType type, Pageable pageable);
    Page<Component> findByNameContainingAndTypeAndConnectorsIn(String name, CType type, Collection<Connector> connectors, Pageable pageable);

    @Query( "SELECT c FROM Component c INNER JOIN c.connectors yt " +
            "WHERE c.name LIKE %:name% " +
            "AND c.type = :type " +
            "AND yt IN (:connectors) " +
            "GROUP BY c " +
            "HAVING COUNT(DISTINCT yt) = (:connectorsSize)")
    Page<Component> findByNameContainingAndWithAllConnectorsPaged(@Param("name")String name, @Param("type")CType type, @Param("connectors")Collection<Connector> connectors, @Param("connectorsSize")Long connectorsSize, Pageable pageable);

    @Query( "SELECT c FROM Component c INNER JOIN c.connectors yt " +
            "WHERE c.type = :type " +
            "AND yt IN (:connectors) " +
            "GROUP BY c " +
            "HAVING COUNT(DISTINCT yt) = (:connectorsSize)")
    List<Component> findByTypeAndConnectors(@Param("type")CType type, @Param("connectors")Collection<Connector> connectors, @Param("connectorsSize")Long connectorsSize);

    List<Component> findByTypeAndConnectorsIn(@Param("type")CType type, @Param("connectors")Collection<Connector> connectors);

    @Query( "SELECT c FROM Component c INNER JOIN c.connectors yt " +
            "WHERE c.name LIKE %:name% " +
            "AND c.type = 'MOTHERBOARD' " +
            "AND yt IN (:connectors) " +
            "GROUP BY c ")
    Page<Component> findMotherboardByConnectorsIn(@Param("name")String name, @Param("connectors")Collection<Connector> connectors, Pageable pageable);
}

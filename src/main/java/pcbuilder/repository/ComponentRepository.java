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

    List<Component> findByName(@Param("name")String name);
    List<Component> findByNameContaining(@Param("name")String name);

    List<Component> findByBrand(@Param("brand")String brand);

    //List<Component> findByEuropeanArticleNumber(@Param("europeanArticleNumber")String europeanArticleNumber);
    List<Component> findByBrandAndManufacturerPartNumber(@Param("brand")String brand, @Param("manufacturerPartNumber")String manufacturerPartNumber);
    List<Component> findByType(@Param("type")CType type);

    Page<Component> findByNameContainingAndType(@Param("name")String name, @Param("type")CType type, Pageable pageable);

    Page<Component> findByNameContainingAndTypeAndConnectorsIn(String name, CType type, Collection<Connector> connectors, Pageable pageable);

    Page<Component> findByNameContainingAndTypeAndConnectorsInAndConnectorsIn(String name, CType type, Collection<Connector> connectors, Collection<Connector> connectors2, Pageable pageable);

    Page<Component> findByNameContainingAndTypeAndConnectorsInAndConnectorsInAndConnectorsIn(String name, CType type, Collection<Connector> connectors, Collection<Connector> connectors2, Collection<Connector> connectors3, Pageable pageable);

    Page<Component> findByNameContainingAndTypeAndConnectorsInAndConnectorsInAndConnectorsInAndConnectorsIn(String name, CType type, Collection<Connector> connectors, Collection<Connector> connectors2, Collection<Connector> connectors3, Collection<Connector> connectors4, Pageable pageable);

    Page<Component> findByNameContainingAndTypeAndConnectorsInAndConnectorsInAndConnectorsInAndConnectorsInAndConnectorsIn(String name, CType type, Collection<Connector> connectors, Collection<Connector> connectors2, Collection<Connector> connectors3, Collection<Connector> connectors4, Collection<Connector> connectors5, Pageable pageable);

    Page<Component> findByNameContainingAndTypeAndConnectorsInAndConnectorsInAndConnectorsInAndConnectorsInAndConnectorsInAndConnectorsIn(String name, CType type, Collection<Connector> connectors, Collection<Connector> connectors2, Collection<Connector> connectors3, Collection<Connector> connectors4, Collection<Connector> connectors5, Collection<Connector> connectors6, Pageable pageable);


    //List<Component> findByNameContainingAndTypeAndConnector(@Param("name")String name, @Param("type")String type, @Param("Connector")Connector connector);
}

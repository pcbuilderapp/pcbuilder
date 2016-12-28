package pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pcbuilder.domain.CType;
import pcbuilder.domain.Component;
import pcbuilder.domain.Connector;

import java.util.List;

@RepositoryRestResource(path = "components")
public interface ComponentRepository extends JpaRepository<Component, Long> {

    List<Component> findByName(@Param("name")String name);
    List<Component> findByNameContaining(@Param("name")String name);

    List<Component> findByBrand(@Param("brand")String brand);

    //List<Component> findByEuropeanArticleNumber(@Param("europeanArticleNumber")String europeanArticleNumber);
    List<Component> findByBrandAndManufacturerPartNumber(@Param("brand")String brand, @Param("manufacturerPartNumber")String manufacturerPartNumber);
    List<Component> findByType(@Param("type")CType type);

    List<Component> findByNameContainingAndType(@Param("name")String name, @Param("type")CType type);

    //List<Component> findByNameContainingAndTypeAndConnector(@Param("name")String name, @Param("type")String type, @Param("Connector")Connector connector);
}

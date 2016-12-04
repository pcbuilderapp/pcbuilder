package pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pcbuilder.domain.Component;

import java.util.List;

@RepositoryRestResource(path = "component")
public interface ComponentRepository extends JpaRepository<Component, Long> {

    List<Component> findByName(@Param("name")String name);
    List<Component> findByBrand(@Param("brand")String brand);
    List<Component> findByEuropeanArticleNumber(@Param("europeanArticleNumber")String europeanArticleNumber);
    List<Component> findByType(@Param("type")String type);
}

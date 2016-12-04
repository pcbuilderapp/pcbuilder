package pcbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pcbuilder.domain.Component;

@RepositoryRestResource(path = "component")
public interface ComponentRepository extends JpaRepository<Component, Long> {

    Iterable<Component> findByName(@Param("name")String name);
    Iterable<Component> findByBrand(@Param("brand")String brand);
    Iterable<Component> findByEuropeanArticleNumber(@Param("europeanArticleNumber")String europeanArticleNumber);
    Iterable<Component> findByType(@Param("type")String type);
}

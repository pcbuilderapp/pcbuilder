package pcbuilder.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pcbuilder.domain.Component;
import pcbuilder.domain.SearchQuery;
import pcbuilder.domain.SearchQueryType;

import javax.transaction.Transactional;

@Transactional
public interface SearchQueryRepository extends CrudRepository<SearchQuery, Long> {

    Page<SearchQuery> findByFilterContaining(@Param("filter")String filter,Pageable pageable);

    SearchQuery findByFilterAndTypeAndComponent(@Param("filter")String filter, @Param("type")SearchQueryType type, @Param("component")Component component);
}

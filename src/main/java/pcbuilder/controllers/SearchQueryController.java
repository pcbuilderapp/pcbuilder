package pcbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pcbuilder.controllers.dto.*;
import pcbuilder.domain.Component;
import pcbuilder.domain.SearchQuery;
import pcbuilder.repository.ComponentRepository;
import pcbuilder.repository.SearchQueryRepository;

@RestController
public class SearchQueryController {
    @Autowired
    private SearchQueryRepository searchQueryRepository;

    @Autowired
    private ComponentRepository componentRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/searches/get", method = RequestMethod.POST)
    public SearchQueryResponse getSearches(@RequestBody SearchQueryRequest request) {
        Sort sort = createSort(request.getSort());

        // creating a page request to setup paginated query results
        PageRequest pageRequest = new PageRequest(request.getPage().intValue(), request.getMaxItems().intValue(), sort);

        Page<SearchQuery> page = searchQueryRepository.findByFilterContaining(request.getFilter(),pageRequest);

        SearchQueryResponse response = new SearchQueryResponse();
        response.setPageCount(page.getTotalPages());
        response.setPage(page.getNumber());
        response.setSearches(page.getContent());

        return response;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/searches/add", method = RequestMethod.POST)
    public void add(@RequestBody SearchQueryAddRequest request) {
        Component component = request.getComponent() != null ?
                componentRepository.findOne(request.getComponent().getId()) : null;

        SearchQuery existingQuery = searchQueryRepository.findByFilterAndTypeAndComponent(request.getFilter(),request.getType(),component);

        if (existingQuery != null) {
            existingQuery.setCount(existingQuery.getCount()+1);
            searchQueryRepository.save(existingQuery);
        } else {
            SearchQuery searchQuery = new SearchQuery();
            searchQuery.setFilter(request.getFilter());
            searchQuery.setComponent(component);
            searchQuery.setType(request.getType());
            searchQuery.setCount(Long.valueOf(1));
            searchQueryRepository.save(searchQuery);
        }
    }

    private Sort createSort(String sortingColumn) {
        boolean asc = !sortingColumn.startsWith("!");

        Sort sort;
        Sort.Direction direction;
        if (asc) {
            direction = Sort.Direction.ASC;
        } else {
            sortingColumn = sortingColumn.substring(1);
            direction = Sort.Direction.DESC;
        }

        if (sortingColumn == null || "".equals(sortingColumn)) {
            sort = new Sort(Sort.Direction.DESC,"count");
        } else {
            if (sortingColumn != "component") {
                sort = new Sort(direction,sortingColumn);
            } else {
                sort = new Sort(direction,"count");
            }
        }

        return sort;
    }
}

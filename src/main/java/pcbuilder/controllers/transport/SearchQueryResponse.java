package pcbuilder.controllers.transport;

import pcbuilder.domain.SearchQuery;

import java.util.List;

public class SearchQueryResponse {
    private List<SearchQuery> searches;
    private int page;
    private int pageCount;

    public List<SearchQuery> getSearches() {
        return searches;
    }

    public void setSearches(List<SearchQuery> searches) {
        this.searches = searches;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}

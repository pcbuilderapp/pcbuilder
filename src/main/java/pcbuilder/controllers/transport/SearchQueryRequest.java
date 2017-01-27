package pcbuilder.controllers.transport;

public class SearchQueryRequest {
    private String filter;
    private Long page;
    private Long maxItems;
    private String sort;

    public String getFilter() {
        return filter;
    }

    @SuppressWarnings("unused")
    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getMaxItems() {
        return maxItems;
    }

    @SuppressWarnings("unused")
    public void setMaxItems(Long maxItems) {
        this.maxItems = maxItems;
    }

    @SuppressWarnings("unused")
    public String getSort() {
        return sort;
    }

    @SuppressWarnings("unused")
    public void setSort(String sort) {
        this.sort = sort;
    }
}

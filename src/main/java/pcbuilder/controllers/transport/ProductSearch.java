package pcbuilder.controllers.transport;

public class ProductSearch {
    String filter;
    Long page;
    Long maxItems;
    String sort;

    public String getFilter() {
        return filter;
    }

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

    public void setMaxItems(Long maxItems) {
        this.maxItems = maxItems;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "ProductSearch{" +
                "filter='" + filter + '\'' +
                ", page=" + page +
                ", maxItems=" + maxItems +
                ", sort='" + sort + '\'' +
                '}';
    }
}

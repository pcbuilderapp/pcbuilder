package pcbuilder.controllers.dto;

public class ProductSearch {

    private String filter;
    private int page;
    private int maxItems;
    private String sort;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(int maxItems) {
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

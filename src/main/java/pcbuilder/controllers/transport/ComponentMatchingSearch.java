package pcbuilder.controllers.transport;

import pcbuilder.domain.CType;

public class ComponentMatchingSearch {

    String filter;
    CType type;
    Configuration configuration;
    Long page;
    Long maxItems;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public CType getType() {
        return type;
    }

    public void setType(CType type) {
        this.type = type;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
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
}

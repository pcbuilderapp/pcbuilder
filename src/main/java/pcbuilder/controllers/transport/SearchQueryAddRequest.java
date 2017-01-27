package pcbuilder.controllers.transport;

import pcbuilder.domain.SearchQueryType;

public class SearchQueryAddRequest {
    private String filter;
    private SearchQueryType type;
    private ComponentRef component;

    public String getFilter() {
        return filter;
    }

    @SuppressWarnings("unused")
    public void setFilter(String filter) {
        this.filter = filter;
    }

    public SearchQueryType getType() {
        return type;
    }

    public void setType(SearchQueryType type) {
        this.type = type;
    }

    /**
     * Getter for property 'component'.
     *
     * @return Value for property 'component'.
     */
    public ComponentRef getComponent() {
        return component;
    }

    /**
     * Setter for property 'component'.
     *
     * @param component ComponentRef
     */
    public void setComponent(ComponentRef component) {
        this.component = component;
    }
}

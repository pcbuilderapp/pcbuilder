package pcbuilder.controllers.transport;

import pcbuilder.domain.CType;

/**
 * The Class ComponentMatchingSearch.
 */
public class ComponentMatchingSearch {

    private String filter;
    private CType type;
    private Configuration configuration;
    private Long page;
    private Long maxItems;
    private String sort;

    /**
     * Gets the filter.
     *
     * @return the filter
     */
    public String getFilter() {
        return filter;
    }

    /**
     * Sets the filter.
     *
     * @param filter String
     */
    @SuppressWarnings("unused")
    public void setFilter(String filter) {
        this.filter = filter;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public CType getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type CType
     */
    public void setType(CType type) {
        this.type = type;
    }

    /**
     * Gets the configuration.
     *
     * @return the configuration
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Sets the configuration.
     *
     * @param configuration Configuration
     */
    @SuppressWarnings("unused")
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Gets the page.
     *
     * @return the page
     */
    public Long getPage() {
        return page;
    }

    /**
     * Sets the page.
     *
     * @param page Long
     */
    public void setPage(Long page) {
        this.page = page;
    }

    /**
     * Gets the max items.
     *
     * @return the max items
     */
    public Long getMaxItems() {
        return maxItems;
    }

    /**
     * Sets the max items.
     *
     * @param maxItems Long
     */
    @SuppressWarnings("unused")
    public void setMaxItems(Long maxItems) {
        this.maxItems = maxItems;
    }

    /**
     * Gets the sort.
     *
     * @return sort
     */
    public String getSort() {
        return sort;
    }

    /**
     * Sets the sort.
     *
     * @param sort String
     */
    @SuppressWarnings("unused")
    public void setSort(String sort) {
        this.sort = sort;
    }
}

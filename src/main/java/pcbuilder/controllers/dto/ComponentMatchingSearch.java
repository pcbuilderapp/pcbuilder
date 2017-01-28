package pcbuilder.controllers.dto;

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
     * @return String
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
     * @return CType
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
     * @return Configuration
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
     * @return Long
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
     * @return Long
     */
    public Long getMaxItems() {
        return maxItems;
    }

    /**
     * Sets the max items.
     *
     * @param maxItems Long
     */
    public void setMaxItems(Long maxItems) {
        this.maxItems = maxItems;
    }

    /**
     * Gets the sort.
     *
     * @return String
     */
    public String getSort() {
        return sort;
    }

    /**
     * Sets the sort.
     *
     * @param sort String
     */
    public void setSort(String sort) {
        this.sort = sort;
    }
}

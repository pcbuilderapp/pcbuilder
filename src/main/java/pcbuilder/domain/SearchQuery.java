package pcbuilder.domain;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"component_id"})
})
public class SearchQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String filter;
    private SearchQueryType type;
    @OneToOne(cascade = CascadeType.ALL)
    private Component component;
    private Long count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public SearchQueryType getType() {
        return type;
    }

    public void setType(SearchQueryType type) {
        this.type = type;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

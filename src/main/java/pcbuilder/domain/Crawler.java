package pcbuilder.domain;

import javax.persistence.*;

/**
 * The crawler entity is intended to store settings used to control crawler programs
 */
@Entity
public class Crawler {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean activated;

    /**
     * Must be empty.
     */
    @SuppressWarnings("unused")
    public Crawler() {
        // This dummy constructor is needed by springboot
    }

    @SuppressWarnings("unused")
    public Crawler(String name, Boolean activated) {
        this.name = name;
        this.activated = activated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
}

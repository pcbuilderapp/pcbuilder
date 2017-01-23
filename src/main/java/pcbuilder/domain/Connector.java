package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A connector serves the purpose of connecting components together.
 * Components are mixable if they share a connector with the same CType and name
 */
@Entity
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames = {"name", "type"})
})
public class Connector implements Serializable {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The name. */
	@Column(nullable = false)
	private String name;

    /** The type. */
    @Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CType type;

    /**
     * Instantiates a new connector.
     */
    public Connector() {}

	/**
	 * Instantiates a new connector.
	 *
	 * @param String name
	 * @param CType type
	 */
	public Connector(String name, CType type) {
    	this.name = name;
    	this.type = type;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param type
	 */
	public void setType(CType type) {
		this.type = type;
	}
}

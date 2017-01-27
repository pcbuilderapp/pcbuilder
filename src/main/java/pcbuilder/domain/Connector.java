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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
    @Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CType type;

    /**
	 * Must be empty.
	 */
	@SuppressWarnings("unused")
	public Connector() {
		// This dummy constructor is needed by springboot
	}

	/**
	 * Instantiates a new connector.
	 *
	 * @param name String
	 * @param type CType
	 */
	public Connector(String name, CType type) {
    	this.name = name;
    	this.type = type;
	}

	/**
	 * Gets the id.
	 *
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id Long
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
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
}

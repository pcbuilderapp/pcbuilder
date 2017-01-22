package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class Component.
 */
@Entity
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames = {"brand", "manufacturerPartNumber"})
})
public class Component implements Serializable{

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The name. */
	@Column(nullable = false)
	private String name;

	/** The brand. */
	@Column(nullable = false)
	private String brand;

	/** The european article number. */
	private String europeanArticleNumber;

	/** The manufacturer part number. */
	@Column(nullable = false)
	private String manufacturerPartNumber;

	/** The type. */
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CType type;

	/** The connectors. */
	@ManyToMany(cascade = CascadeType.ALL)
	@OrderBy("type ASC")
	private List<Connector> connectors = new ArrayList<>();

	/** The picture url. */
	private String pictureUrl;

	/**
	 * Instantiates a new component.
	 */
	public Component(){}

	/**
	 * Instantiates a new component.
	 *
	 * @param name
	 * @param brand
	 * @param europeanArticleNumber
	 * @param manufacturerPartNumber
	 * @param type
	 * @param pictureUrl
	 */
	public Component(String name, String brand, String europeanArticleNumber, String manufacturerPartNumber, CType type, String pictureUrl) {
		this.name = name;
		this.brand = brand;
		this.europeanArticleNumber = europeanArticleNumber;
		this.manufacturerPartNumber = manufacturerPartNumber;
		this.type = type;
		this.pictureUrl = pictureUrl;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId(){
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
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand.
	 *
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the european article number.
	 *
	 * @return the european article number
	 */
	public String getEuropeanArticleNumber() {
		return europeanArticleNumber;
	}

	/**
	 * Sets the european article number.
	 *
	 * @param europeanArticleNumber
	 */
	public void setEuropeanArticleNumber(String europeanArticleNumber) {
		this.europeanArticleNumber = europeanArticleNumber;
	}

	/**
	 * Gets the manufacturer part number.
	 *
	 * @return the manufacturer part number
	 */
	public String getManufacturerPartNumber() {
		return manufacturerPartNumber;
	}

	/**
	 * Sets the manufacturer part number.
	 *
	 * @param manufacturerPartNumber
	 */
	public void setManufacturerPartNumber(String manufacturerPartNumber) {
		this.manufacturerPartNumber = manufacturerPartNumber;
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

	/**
	 * Gets the connectors.
	 *
	 * @return the connectors
	 */
	public List<Connector> getConnectors() {
		return connectors;
	}

	/**
	 * Sets the connectors.
	 *
	 * @param connectors
	 */
	public void setConnectors(List<Connector> connectors) {
		this.connectors = connectors;
	}

	/**
	 * Adds the connector.
	 *
	 * @param connector
	 */
	public void addConnector(Connector connector) {
	    if (connector != null) {
            connectors.add(connector);
        }
	}

	/**
	 * Checks for connector.
	 *
	 * @param connectorName
	 * @param type
	 * @return true, if successful
	 */
	public boolean hasConnector(String connectorName, CType type) {
		for(Connector connector : connectors) {
			if (connector.getName().equals(connectorName) && connector.getType().name().equals(type.name())) return true;
		}
		return false;
	}

	/**
	 * Gets the picture url.
	 *
	 * @return the picture url
	 */
	public String getPictureUrl() {
		return pictureUrl;
	}

	/**
	 * Sets the picture url.
	 *
	 * @param pictureUrl
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
}

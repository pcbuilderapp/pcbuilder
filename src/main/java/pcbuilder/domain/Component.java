package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Component implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String brand;

	private String europeanArticleNumber;

	@Column(unique=true, nullable = false)
	private String manufacturerPartNumber;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CType type;

	@ManyToMany(cascade = CascadeType.ALL)
	@OrderBy("type ASC")
	private List<Connector> connectors = new ArrayList<>();

	private String pictureUrl;

	public Component(){}

	public Component(String name, String brand, String europeanArticleNumber, String manufacturerPartNumber, CType type, String pictureUrl) {
		this.name = name;
		this.brand = brand;
		this.europeanArticleNumber = europeanArticleNumber;
		this.manufacturerPartNumber = manufacturerPartNumber;
		this.type = type;
		this.pictureUrl = pictureUrl;
	}

	public Long getId(){
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getEuropeanArticleNumber() {
		return europeanArticleNumber;
	}

	public void setEuropeanArticleNumber(String europeanArticleNumber) {
		this.europeanArticleNumber = europeanArticleNumber;
	}

	public String getManufacturerPartNumber() {
		return manufacturerPartNumber;
	}

	public void setManufacturerPartNumber(String manufacturerPartNumber) {
		this.manufacturerPartNumber = manufacturerPartNumber;
	}

	public CType getType() {
		return type;
	}

	public void setType(CType type) {
		this.type = type;
	}

	public List<Connector> getConnectors() {
		return connectors;
	}

	public void setConnectors(List<Connector> connectors) {
		this.connectors = connectors;
	}

	public void addConnector(Connector connector) {
	    if (connector != null) {
            connectors.add(connector);
        }
	}

	public boolean hasConnector(String connectorName, CType type) {
		for(Connector connector : connectors) {
			if (connector.getName().equals(connectorName) && connector.getType().name().equals(type.name())) return true;
		}
		return false;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

/*    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }*/
}

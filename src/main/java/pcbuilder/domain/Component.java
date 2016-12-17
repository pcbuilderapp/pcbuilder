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

	private String name;
	private String brand;

	@Column(unique = true)
	private String europeanArticleNumber;

	@Enumerated(EnumType.STRING)
	private CType type;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Connector> connectors = new ArrayList<>();

	public Component(String name, String brand, String europeanArticleNumber, CType type, List<Connector> connectors) {
		this.name = name;
		this.brand = brand;
		this.europeanArticleNumber = europeanArticleNumber;
		this.type = type;
		this.connectors = connectors;
	}

	public Long getId(){
		return id;
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
		connectors.add(connector);
	}
}

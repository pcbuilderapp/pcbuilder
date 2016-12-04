package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "component")
public class Component implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String brand;
	private String europeanArticleNumber;
	private String type;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Connector> connectors;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Connector> getConnectors() {
		return connectors;
	}

	public void setConnectors(List<Connector> connectors) {
		this.connectors = connectors;
	}
}

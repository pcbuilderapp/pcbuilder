package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Component implements Serializable{

	public enum Type { }

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String brand;

	@Column(unique = true)
	private String europeanArticleNumber;

	@Enumerated(EnumType.STRING)
	private pcbuilder.domain.Type type;

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

	public pcbuilder.domain.Type getType() {
		return type;
	}

	public void setType(pcbuilder.domain.Type type) {
		this.type = type;
	}

	public List<Connector> getConnectors() {
		return connectors;
	}

	public void setConnectors(List<Connector> connectors) {
		this.connectors = connectors;
	}
}

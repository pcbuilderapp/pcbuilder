package pcbuilder.domain;

import javax.persistence.*;

@Entity
public abstract class Component {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String name;
	private String brand;
	private String europeanArticleNumber;

	public Component(String name, String brand, String europeanArticleNumber) {
		this.name = name;
		this.brand = brand;
		this.europeanArticleNumber = europeanArticleNumber;
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

	@Override
	public String toString() {
		return "Component{" +
				"name='" + name + '\'' +
				", brand='" + brand + '\'' +
				", europeanArticleNumber='" + europeanArticleNumber + '\'' +
				'}';
	}
}

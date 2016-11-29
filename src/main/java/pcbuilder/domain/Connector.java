package pcbuilder.domain;

import javax.persistence.*;

@Entity
public abstract class Connector {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Connector{" +
				"name='" + name + '\'' +
				'}';
	}
}

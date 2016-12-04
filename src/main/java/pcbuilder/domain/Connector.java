package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "connector")
public class Connector implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	private Product Component;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

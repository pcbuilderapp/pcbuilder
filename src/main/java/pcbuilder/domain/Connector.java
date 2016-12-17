package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Connector implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String name;

	@Enumerated(EnumType.STRING)
	private CType type;

	public Long getId() {
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

	public CType getType() {
		return type;
	}

	public void setType(CType type) {
		this.type = type;
	}
}

package pcbuilder.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Connector implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}

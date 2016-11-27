package pcbuilder.domain.connectors;

import pcbuilder.domain.Connector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FormFactor extends Connector {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private int order;

	public FormFactor(String name, int order) {
		super(name);
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}

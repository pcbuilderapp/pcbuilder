package pcbuilder.domain.connectors;

import pcbuilder.domain.Connector;
import javax.persistence.Entity;

@Entity
public class FormFactor extends Connector {

	private int order;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}

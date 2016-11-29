package pcbuilder.domain.components;

import pcbuilder.domain.Component;
import pcbuilder.domain.connectors.MemoryConnector;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Memory extends Component {

	private String speed;
	private String type;

	@OneToOne
	private MemoryConnector memoryConnector;

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MemoryConnector getMemoryConnector() {
		return memoryConnector;
	}

	public void setMemoryConnector(MemoryConnector memoryConnector) {
		this.memoryConnector = memoryConnector;
	}
}

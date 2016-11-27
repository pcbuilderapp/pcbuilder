package pcbuilder.domain.components;

import pcbuilder.domain.Component;
import pcbuilder.domain.connectors.MemoryConnector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Memory extends Component {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String speed;
	private String type;
	private MemoryConnector memoryConnector;

	public Memory(String name, String brand, String europeanArticleNumber, String speed, String type, MemoryConnector memoryConnector) {
		super(name, brand, europeanArticleNumber);
		this.speed = speed;
		this.type = type;
		this.memoryConnector = memoryConnector;
	}

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

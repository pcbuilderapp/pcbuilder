package pcbuilder.domain.components;

import pcbuilder.domain.Component;
import pcbuilder.domain.connectors.HardDiskConnector;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class HardDisk extends Component {

	private int readSpeed;
	private int writeSpeed;

	@OneToOne
	private HardDiskConnector hardDiskConnector;

	public HardDisk(String name, String brand, String europeanArticleNumber, int readSpeed, int writeSpeed, HardDiskConnector hardDiskConnector) {
		super(name, brand, europeanArticleNumber);
		this.readSpeed = readSpeed;
		this.writeSpeed = writeSpeed;
		this.hardDiskConnector = hardDiskConnector;
	}

	public int getReadSpeed() {
		return readSpeed;
	}

	public void setReadSpeed(int readSpeed) {
		this.readSpeed = readSpeed;
	}

	public int getWriteSpeed() {
		return writeSpeed;
	}

	public void setWriteSpeed(int writeSpeed) {
		this.writeSpeed = writeSpeed;
	}
}

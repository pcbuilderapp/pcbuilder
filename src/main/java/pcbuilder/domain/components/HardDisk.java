package pcbuilder.domain.components;

import pcbuilder.domain.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HardDisk extends Component {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private int readSpeed;
	private int writeSpeed;

	public HardDisk(String name, String brand, String europeanArticleNumber, int readSpeed, int writeSpeed) {
		super(name, brand, europeanArticleNumber);
		this.readSpeed = readSpeed;
		this.writeSpeed = writeSpeed;
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

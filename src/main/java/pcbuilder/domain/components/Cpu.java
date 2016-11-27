package pcbuilder.domain.components;

import pcbuilder.domain.Component;
import pcbuilder.domain.connectors.CpuSocket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cpu extends Component {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String generation;
	private int speed;
	private int turbo;
	private CpuSocket socket;

	public Cpu(String name, String brand, String europeanArticleNumber, String generation, int speed, int turbo, CpuSocket socket) {
		super(name, brand, europeanArticleNumber);
		this.generation = generation;
		this.speed = speed;
		this.turbo = turbo;
		this.socket = socket;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getTurbo() {
		return turbo;
	}

	public void setTurbo(int turbo) {
		this.turbo = turbo;
	}

	public CpuSocket getSocket() {
		return socket;
	}

	public void setSocket(CpuSocket socket) {
		this.socket = socket;
	}
}

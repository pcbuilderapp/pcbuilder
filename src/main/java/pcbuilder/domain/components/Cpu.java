package pcbuilder.domain.components;

import pcbuilder.domain.Component;
import pcbuilder.domain.connectors.CpuSocket;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Cpu extends Component {

	private String generation;
	private int speed;
	private int turbo;

	@OneToOne
	private CpuSocket socket;

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

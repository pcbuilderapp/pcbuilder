package pcbuilder.domain;

public class Connector {

	private String name;

	public Connector(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Connector{" +
				"name='" + name + '\'' +
				'}';
	}
}

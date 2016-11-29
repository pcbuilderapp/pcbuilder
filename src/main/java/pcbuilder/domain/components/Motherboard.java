package pcbuilder.domain.components;

import pcbuilder.domain.Component;
import pcbuilder.domain.connectors.CpuSocket;
import pcbuilder.domain.connectors.FormFactor;
import pcbuilder.domain.connectors.HardDiskConnector;
import pcbuilder.domain.connectors.MemoryConnector;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Motherboard extends Component {

	private String productCode;
	private String description;

	@OneToOne
	private FormFactor formFactor;

	@OneToMany
	private List<MemoryConnector> supportedMemoryConnectors;

	@OneToMany
	private List<CpuSocket> supportedCpuSockets;

	@OneToMany
	private List<FormFactor> supportedFormFactors;

	@OneToMany
	private List<HardDiskConnector> supportedHardDiskConnectors;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FormFactor getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(FormFactor formFactor) {
		this.formFactor = formFactor;
	}

	public List<MemoryConnector> getSupportedMemoryConnectors() {
		return supportedMemoryConnectors;
	}

	public void setSupportedMemoryConnectors(List<MemoryConnector> supportedMemoryConnectors) {
		this.supportedMemoryConnectors = supportedMemoryConnectors;
	}

	public List<CpuSocket> getSupportedCpuSockets() {
		return supportedCpuSockets;
	}

	public void setSupportedCpuSockets(List<CpuSocket> supportedCpuSockets) {
		this.supportedCpuSockets = supportedCpuSockets;
	}

	public List<FormFactor> getSupportedFormFactors() {
		return supportedFormFactors;
	}

	public void setSupportedFormFactors(List<FormFactor> supportedFormFactors) {
		this.supportedFormFactors = supportedFormFactors;
	}

	public List<HardDiskConnector> getSupportedHardDiskConnectors() {
		return supportedHardDiskConnectors;
	}

	public void setSupportedHardDiskConnectors(List<HardDiskConnector> supportedHardDiskConnectors) {
		this.supportedHardDiskConnectors = supportedHardDiskConnectors;
	}
}

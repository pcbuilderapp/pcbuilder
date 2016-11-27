package pcbuilder.domain.components;

import pcbuilder.domain.Component;
import pcbuilder.domain.connectors.CpuSocket;
import pcbuilder.domain.connectors.FormFactor;
import pcbuilder.domain.connectors.HardDiskConnector;
import pcbuilder.domain.connectors.MemoryConnector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.List;

@Entity
public class Motherboard extends Component {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String productCode;
	private String description;
	private FormFactor formFactor;
	private List<MemoryConnector> supportedMemoryConnectors;
	private List<CpuSocket> supportedCpuSockets;
	private List<FormFactor> supportedFormFactors;
	private List<HardDiskConnector> supportedHardDiskConnectors;

	public Motherboard(String name, String brand, String europeanArticleNumber, String productCode, String description, FormFactor formFactor, List<MemoryConnector> supportedMemoryConnectors, List<CpuSocket> supportedCpuSockets, List<FormFactor> supportedFormFactors, List<HardDiskConnector> supportedHardDiskConnectors) {
		super(name, brand, europeanArticleNumber);
		this.productCode = productCode;
		this.description = description;
		this.formFactor = formFactor;
		this.supportedMemoryConnectors = supportedMemoryConnectors;
		this.supportedCpuSockets = supportedCpuSockets;
		this.supportedFormFactors = supportedFormFactors;
		this.supportedHardDiskConnectors = supportedHardDiskConnectors;
	}

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

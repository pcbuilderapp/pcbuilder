package pcbuilder.domain.components;

import pcbuilder.domain.Component;
import pcbuilder.domain.connectors.FormFactor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Case extends Component {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private FormFactor formFactor;

	public Case(String name, String brand, String europeanArticleNumber, FormFactor formFactor) {
		super(name, brand, europeanArticleNumber);
		this.formFactor = formFactor;
	}

	public FormFactor getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(FormFactor formFactor) {
		this.formFactor = formFactor;
	}
}

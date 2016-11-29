package pcbuilder.domain.components;

import pcbuilder.domain.Component;
import pcbuilder.domain.connectors.FormFactor;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Case extends Component {

	@OneToOne
	private FormFactor formFactor;

	public FormFactor getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(FormFactor formFactor) {
		this.formFactor = formFactor;
	}
}

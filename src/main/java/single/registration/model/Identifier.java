package single.registration.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import single.registration.type.IdentifierType;

@AllArgsConstructor
public abstract class Identifier {

	@Getter
	@Setter
	private String value;

	private IdentifierType type;

	public boolean isValid() {
		return this.type.getValidator().isValid(value);
	}

}

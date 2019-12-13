package single.registration.model;

import lombok.Builder;
import single.registration.type.IdentifierType;

public class CPF extends Identifier {
	
	@Builder
	public CPF(String value) {
		super(value, IdentifierType.CPF);
	}

}

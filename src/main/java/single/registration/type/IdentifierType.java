package single.registration.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import single.registration.validator.CPFValidator;
import single.registration.validator.IdentifierValidator;

@Getter
@AllArgsConstructor
public enum IdentifierType {

	CPF("Proof of Registration Status", new CPFValidator());

	private String description;
	private IdentifierValidator validator;

}

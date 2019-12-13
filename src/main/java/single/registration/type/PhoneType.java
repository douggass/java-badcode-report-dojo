package single.registration.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import single.registration.validator.CellPhoneValidator;
import single.registration.validator.HomePhoneValidator;
import single.registration.validator.PhoneValidator;

@Getter
@AllArgsConstructor
public enum PhoneType {

	CELL_PHONE("cell phone", new CellPhoneValidator()), HOME_PHONE("home phone", new HomePhoneValidator());

	private String description;
	private PhoneValidator validator;

}

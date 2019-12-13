package single.registration.validator;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CellPhoneValidator implements PhoneValidator {

	private static final Integer MIN_DIGITS = 10;
	
	/**
	 * Method to check if the cell phone is valid
	 * @param number to the cell phone
	 */
	public boolean isValid(String number) {
		return number.length() >= MIN_DIGITS;
	}

}

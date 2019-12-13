package single.registration.validator;

public class HomePhoneValidator implements PhoneValidator {

	/**
	 * Method to check if the home phone is valid
	 * 
	 * @param number to the home phone
	 */
	public boolean isValid(String number) {
		return true;
	}

}

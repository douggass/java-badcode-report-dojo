package single.registration.validator;

import junit.framework.TestCase;

public class CellPhoneValidatorTest extends TestCase {

	private PhoneValidator cellPhoneValidator = new CellPhoneValidator();

	private static final String VALID_PHONE = "5199999999";
	private static final String NO_VALID_PHONE = "1234";

	public void testIsValidTrue() {
		boolean isValid = cellPhoneValidator.isValid(VALID_PHONE);
		assertEquals(Boolean.TRUE.booleanValue(), isValid);
	}

	public void testIsValidFalse() {
		boolean isValid = cellPhoneValidator.isValid(NO_VALID_PHONE);
		assertEquals(Boolean.FALSE.booleanValue(), isValid);
	}

}

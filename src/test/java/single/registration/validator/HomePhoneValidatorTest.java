package single.registration.validator;

import static org.mockito.ArgumentMatchers.anyString;

import junit.framework.TestCase;

public class HomePhoneValidatorTest extends TestCase {

	private PhoneValidator homePhoneValidator = new HomePhoneValidator();

	public void testIsValid() {
		boolean isValid = homePhoneValidator.isValid(anyString());
		assertEquals(Boolean.TRUE.booleanValue(), isValid);
	}

}

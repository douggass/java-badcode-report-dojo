package single.registration.type;

import junit.framework.TestCase;
import single.registration.validator.CellPhoneValidator;
import single.registration.validator.HomePhoneValidator;

public class PhoneTypeTest extends TestCase {

	public void testTypeCellPhone() {
		assertTrue(PhoneType.CELL_PHONE.getValidator() instanceof CellPhoneValidator);
	}

	public void testTypeHomePhone() {
		assertTrue(PhoneType.HOME_PHONE.getValidator() instanceof HomePhoneValidator);
	}

}

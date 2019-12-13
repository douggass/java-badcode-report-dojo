package single.registration.type;

import junit.framework.TestCase;
import single.registration.validator.CPFValidator;

public class IdentifierTypeTest extends TestCase {

	public void testTypeCpf() {
		assertTrue(IdentifierType.CPF.getValidator() instanceof CPFValidator);
	}

}

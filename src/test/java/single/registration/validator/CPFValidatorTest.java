package single.registration.validator;

import junit.framework.TestCase;

public class CPFValidatorTest extends TestCase {

	private IdentifierValidator cpfValidator = new CPFValidator();

	private static final String VALID_CPF = "15570599266";
	private static final String NO_VALID_CPF = "155705992";

	public void testIsValidTrue() {
		boolean isValid = cpfValidator.isValid(VALID_CPF);
		assertEquals(Boolean.TRUE.booleanValue(), isValid);
	}

	public void testIsValidFalse() {
		boolean isValid = cpfValidator.isValid(NO_VALID_CPF);
		assertEquals(Boolean.FALSE.booleanValue(), isValid);
	}

}

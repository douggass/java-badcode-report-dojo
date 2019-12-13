package single.registration.service;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;
import single.registration.model.CPF;
import single.registration.model.CellPhone;
import single.registration.model.HomePhone;
import single.registration.model.Identifier;
import single.registration.model.NaturalPerson;
import single.registration.model.Person;
import single.registration.model.Phone;

public class PersonServiceImplTest extends TestCase {

	private PersonServiceImpl personServiceImpl = new PersonServiceImpl();

	private static final String ANY_NAME = "Deus";
	private static final String ANY_CELL_PHONE = "51980249532";
	private static final String ANY_HOME_PHONE = "772782712";

	private static final String ANY_CPF = "57492817525";
	private static final String ANY_INVALID_CPF = "123";

	private static final String INVALID_NAME_MESSAGE = "Person with invalid name";
	private static final String INVALID_PHONES = "Invalid phones";
	private static final String INVALID_IDENTIFIER = "Person with invalid identifier";

	public void testBuildName() {
		Person person = NaturalPerson.builder().name(ANY_NAME).build();
		String name = personServiceImpl.buildName(person);
		assertEquals(ANY_NAME, name);
	}

	public void testBuildNameExpectedException() {
		Person person = NaturalPerson.builder().name(null).build();
		try {
			String name = personServiceImpl.buildName(person);
			fail("Expected an RuntimeException to be thrown, but return ".concat(name));
		} catch (RuntimeException e) {
			assertEquals(INVALID_NAME_MESSAGE, e.getMessage());
		}
	}

	public void testBuildPhones() {
		Phone cellphone = CellPhone.builder().number(ANY_CELL_PHONE).build();
		Phone homePhone = HomePhone.builder().number(ANY_HOME_PHONE).build();

		Person person = NaturalPerson.builder().phones(Arrays.asList(cellphone, homePhone)).build();
		List<Phone> phones = personServiceImpl.buildPhones(person);

		assertTrue(phones.contains(cellphone));
		assertTrue(phones.contains(homePhone));
	}

	public void testBuildPhonesExpectedException() {
		Person person = NaturalPerson.builder().name(null).build();
		try {
			List<Phone> phones = personServiceImpl.buildPhones(person);
			fail("Expected an RuntimeException to be thrown, but return ".concat(phones.toString()));
		} catch (RuntimeException e) {
			assertEquals(INVALID_PHONES, e.getMessage());
		}
	}

	public void testBuildIdentifier() {
		Identifier cpf = CPF.builder().value(ANY_CPF).build();

		Person person = NaturalPerson.builder().identifier(cpf).build();

		String identifier = personServiceImpl.buildIdentifier(person);

		assertEquals(ANY_CPF, identifier);
	}

	public void testBuildIdentifierExpectedException() {
		Identifier cpf = CPF.builder().value(ANY_INVALID_CPF).build();
		Person person = NaturalPerson.builder().identifier(cpf).build();
		try {
			String identifier = personServiceImpl.buildIdentifier(person);
			fail("Expected an RuntimeException to be thrown, but return ".concat(identifier));
		} catch (RuntimeException e) {
			assertEquals(INVALID_IDENTIFIER, e.getMessage());
		}
	}

}

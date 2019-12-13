package single.registration;

import java.util.Arrays;

import single.registration.model.CPF;
import single.registration.model.CellPhone;
import single.registration.model.HomePhone;
import single.registration.model.Identifier;
import single.registration.model.NaturalPerson;
import single.registration.model.Person;
import single.registration.model.Phone;
import single.registration.service.PersonService;
import single.registration.service.PersonServiceImpl;

public class App {

	public static void main(String[] args) {

		Phone cellphone = CellPhone.builder().number("51980249532").build();

		Phone homePhone = HomePhone.builder().number("772782712").build();
		
		Identifier identifier = CPF.builder()
				.value("79322094478")
				.build();

		Person naturalPerson = NaturalPerson.builder()
				.name("Douglas")
				.lastName("Gass")
				.identifier(identifier)
				.phones(Arrays.asList(cellphone, homePhone)).build();

		PersonService personService = new PersonServiceImpl();
		
		personService.printPersonInformations(naturalPerson);

	}
}

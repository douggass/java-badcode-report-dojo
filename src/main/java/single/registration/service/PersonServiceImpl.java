package single.registration.service;

import java.util.List;
import java.util.Optional;

import single.registration.model.Identifier;
import single.registration.model.Person;
import single.registration.model.Phone;

public class PersonServiceImpl implements PersonService {

	/**
	 * Method to print same informations from a person
	 * 
	 * @param person - person with valid data
	 */
	public void printPersonInformations(final Person person) {
		System.out.println("Name: ".concat(buildName(person)));
		System.out.println("Phone: ".concat(buildPhones(person).toString()));
		System.out.println("Identifier: ".concat(buildIdentifier(person)));
	}

	/**
	 * Method to extract a name from a person
	 * 
	 * @param person - person with valid name
	 * @return name from the person
	 */
	String buildName(final Person person) {
		return Optional.ofNullable(person).filter(Person::nameIsValid).map(Person::getName)
				.orElseThrow(() -> new RuntimeException("Person with invalid name"));
	}

	/**
	 * Method to extract a list of phone from the person
	 * 
	 * @param person - person with valid data
	 * @return list of the phone from the person
	 */
	List<Phone> buildPhones(final Person person) {
		return Optional.ofNullable(person.getPhones()).filter(phones -> phones.stream().allMatch(Phone::isValid))
				.orElseThrow(() -> new RuntimeException("Invalid phones"));
	}

	/**
	 * Method to extract a identifier from the person
	 * 
	 * @param person - person with valid identifier
	 * @return identifier from the person
	 */
	String buildIdentifier(final Person person) {
		return Optional.ofNullable(person.getIdentifier()).filter(Identifier::isValid).map(Identifier::getValue)
				.orElseThrow(() -> new RuntimeException("Person with invalid identifier"));
	}

}

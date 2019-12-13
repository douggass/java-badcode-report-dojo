package single.registration.model;

import java.util.List;
import java.util.Optional;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NaturalPerson extends Person {

	private String lastName;

	@Builder
	public NaturalPerson(final List<Phone> phones, final String name, final String lastName, final Identifier identifier) {
		super(name, identifier, phones);
		this.lastName = lastName;
	}

	@Override
	public boolean nameIsValid() {
		return Optional.ofNullable(name).isPresent();
	}

}

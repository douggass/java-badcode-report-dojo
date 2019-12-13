package single.registration.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public abstract class Person {

	@Getter
	@Setter
	protected String name;

	@Getter
	@Setter
	protected Identifier identifier;

	@Getter
	@Setter
	private List<Phone> phones;

	public abstract boolean nameIsValid();
}

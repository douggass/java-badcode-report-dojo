package single.registration.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import single.registration.type.PhoneType;

@AllArgsConstructor
@ToString
public abstract class Phone {
	
	@Getter
	@Setter
	private String number;

	@NonNull
	private PhoneType phoneType;

	public boolean isValid() {
		return phoneType.getValidator().isValid(number);
	}

}

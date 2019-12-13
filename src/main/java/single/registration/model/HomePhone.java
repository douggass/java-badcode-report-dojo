package single.registration.model;

import lombok.Builder;
import single.registration.type.PhoneType;

public class HomePhone extends Phone {
	
	@Builder
	public HomePhone(String number, PhoneType phoneType) {
		super(number, PhoneType.HOME_PHONE);
	}

}

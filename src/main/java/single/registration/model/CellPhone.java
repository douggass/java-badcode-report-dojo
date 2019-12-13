package single.registration.model;

import lombok.Builder;
import single.registration.type.PhoneType;

public class CellPhone extends Phone {
	
	@Builder
	public CellPhone(final String number) {
		super(number, PhoneType.CELL_PHONE);
	}

}

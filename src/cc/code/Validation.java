package cc.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Validation {

	protected List<String> validaPessoa(Pessoa pessoa) {

		List<String> constraints = new ArrayList<String>();
		if (pessoa != null) {
			if (pessoa.cpf == null || !CPF.CPF(pessoa.cpf)) {
				constraints.add("CPF invalido!");				
			}
			if (!cellPhoneIsValid(pessoa.telefonesCelulares)) {
				constraints.add("Telefone invalido!");				
			}
			if (pessoa.name != null) {
				if (pessoa.telefonesFixos != null) {
					for (String telefone : pessoa.telefonesFixos) {
						if (telefone != null) {
							if (telefone.isEmpty()) {
								constraints.add("Erro - Telefone inválido");
								return constraints;
							} else {
								if (telefone.length() < 7) {
									constraints.add("Erro - Telefone inválido");
									return constraints;
								}
							}
						} else {
							constraints.add("Erro - Telefone inválido");
							return constraints;
						}
					}
				}
			}
		}
		return constraints;
	}

	private boolean cellPhoneIsValid(final List<String> cellPhoneNumbers) {
		return Optional.ofNullable(cellPhoneNumbers)
				.orElse(Collections.emptyList())
				.stream()
				.allMatch(cellPhone -> cellPhone.length() == 10);
	}
}
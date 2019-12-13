package single.registration.validator;

import java.util.InputMismatchException;

public class CPFValidator implements IdentifierValidator {
	
	/*
	 * Copy from https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097
	 */
	public boolean isValid(String identifier) {
		// considera-se erro identifier's formados por uma sequencia de numeros iguais
		if (identifier.equals("00000000000") || identifier.equals("11111111111") || identifier.equals("22222222222")
				|| identifier.equals("33333333333") || identifier.equals("44444444444")
				|| identifier.equals("55555555555") || identifier.equals("66666666666")
				|| identifier.equals("77777777777") || identifier.equals("88888888888")
				|| identifier.equals("99999999999") || (identifier.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do identifier em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (identifier.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (identifier.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == identifier.charAt(9)) && (dig11 == identifier.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

}

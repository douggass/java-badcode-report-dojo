package cc.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Vector;

/**
 * Relatório de pessoas
 * 
 * @author Deus
 */
public class report_de_pessoas {
	/**
	 * a string para somar todos os nomes na lista
	 */
	static String _s;

	/**
	 * imprime a lista de pessoas
	 * 
	 * @param paramL
	 */
	@Deprecated
	public static void print_e_vai(Vector pessoas) {
		for (int i = 0; i < pessoas.size(); i++) {
			Pessoa p = (Pessoa) pessoas.get(i);
			Validation validador = new Validation();
			List<String> erro = validador.validaPessoa(p);
			if (!erro.isEmpty()) {
				erro.stream().forEach(System.out::println);
				continue;
			}
			_s += ", " + p.name;
		}
		_s = _s.substring(2);
		System.out.print(_s);
	}
	
	/**
	 * Method that will display a list of people or display why the person is invalid.
	 * @param personList List of persons
	 */
	private static void printPersonList(List<Pessoa> personList) {
		Validation validador = new Validation();
		Optional.ofNullable(personList).orElse(Collections.emptyList())
			.stream()
			.map(person -> 
				Optional.of(validador.validaPessoa(person))
					.map(errors -> {
						errors.parallelStream()
							.forEach(System.out::println);
						return errors;
					})
					.filter(List::isEmpty)
					.map(errors -> person)
					.orElse(null))
			.filter(Objects::nonNull)
			.forEach(System.out::println);
	}

	/**
	 * codigo principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Pessoa p = new Pessoa();
		p.name = "Fulano";
		p.cpf = "0033435457";
		ArrayList<String> telefonesCelulares = new ArrayList<>();
		telefonesCelulares.add("8765343");
		p.telefonesCelulares = telefonesCelulares;

		Pessoa pessoa = new Pessoa();
		pessoa.name = "Deus";
		pessoa.cpf = "48713261525";
		ArrayList<String> telefones = new ArrayList<>();
		telefones.add("8765343879");
		telefones.add("8765343879");
		telefones.add("0123456789");
		pessoa.telefonesCelulares = telefones;

		Pessoa pessoa2 = new Pessoa();
		pessoa2.name = "Vida";
		pessoa2.cpf = "83364424";
		ArrayList<String> telefones2 = new ArrayList<>();
		telefones2.add("8765343879");
		telefones2.add("8765343879");
		telefones2.add("0123456789");
		telefones2.add("0123456789");
		telefones2.add("0123456789");
		pessoa2.telefonesCelulares = telefones;

		Pessoa pessoa1 = new Pessoa();
		pessoa1.name = "Master";
		pessoa1.cpf = "83364424560";
		ArrayList<String> telefones1 = new ArrayList<>();
		telefones1.add("8765343879");
		telefones1.add("8765343879");
		telefones1.add("1213");
		pessoa1.telefonesCelulares = telefones1;

		printPersonList(Arrays.asList(pessoa, p, pessoa1, pessoa2));
	}

}

class Pessoa {
	String name;
	String cpf;
	int idade;
	List<String> telefonesFixos;
	List<String> telefonesCelulares;

	@Override
	public String toString() {
		return "Nome:".concat(name).concat("\n")
				.concat("Fone: ").concat(telefonesCelulares.toString()).concat("\n")
				.concat("CPF: ").concat(cpf).concat("\n");
	}

}
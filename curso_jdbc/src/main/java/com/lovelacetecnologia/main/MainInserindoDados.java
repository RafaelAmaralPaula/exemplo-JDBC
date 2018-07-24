package com.lovelacetecnologia.main;

import java.util.Scanner;

import com.lovelacetecnologia.dao.PessoaDAO;
import com.lovelacetecnologia.model.Pessoa;

public class MainInserindoDados {

	public static void main(String[] args) {
		
		
		Scanner teclado = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		PessoaDAO dao = new PessoaDAO(); 
		
		String continua = null;
		
		System.out.println("Deseja Cadastrar Pessoas?");
		continua = teclado.nextLine();
		
		while("S".equalsIgnoreCase(continua)) {
			
			System.out.println("INFORME O NOME :");
			pessoa.setNome(teclado.nextLine());
				
			System.out.println("Deseja Continuar S/N ?");
			continua = teclado.nextLine();
			
			dao.insert(pessoa);
			
		}
		
				
		
		teclado.close();
		
	}

}

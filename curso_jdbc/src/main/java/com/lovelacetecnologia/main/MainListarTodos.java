package com.lovelacetecnologia.main;

import java.util.List;

import com.lovelacetecnologia.dao.PessoaDAO;
import com.lovelacetecnologia.model.Pessoa;

public class MainListarTodos {
	
	public static void main(String[] args) {
		
		PessoaDAO dao = new PessoaDAO();
		
		List<Pessoa> lista = dao.listAll();
		
		for (Pessoa pessoa : lista) {
			
			System.out.println("ID - > " + pessoa.getId() + " , \n " + " NOME -> " + pessoa.getNome());
			System.out.println("");
			
		}
		
	}
	
}

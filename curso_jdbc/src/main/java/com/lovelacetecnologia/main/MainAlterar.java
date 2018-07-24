package com.lovelacetecnologia.main;

import com.lovelacetecnologia.dao.PessoaDAO;
import com.lovelacetecnologia.model.Pessoa;

public class MainAlterar {
	
	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		PessoaDAO dao = new PessoaDAO();
		
		pessoa.setId(5);
		pessoa.setNome("Edson Yanaga");
		
		dao.change(pessoa);
		
	}
}

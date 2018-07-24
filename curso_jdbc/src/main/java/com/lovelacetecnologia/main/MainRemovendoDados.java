package com.lovelacetecnologia.main;

import com.lovelacetecnologia.dao.PessoaDAO;

public class MainRemovendoDados {
	
	public static void main(String[] args) {
		
		PessoaDAO dao = new PessoaDAO();
		
		dao.remove(6);
		
	}
}

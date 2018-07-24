package com.lovelacetecnologia.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lovelacetecnologia.dao.PessoaDAO;
import com.lovelacetecnologia.model.Pessoa;

public class PessoaDAOTest {

	private PessoaDAO pessoaDAO;

	@Before
	public void setup() {
		pessoaDAO = new PessoaDAO();
	}

	@Test
	public void deveInserirPessoasNoBancoDeDados() throws Exception {

		int antes = pessoaDAO.listAll().size();

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Miguel Pereira");
		pessoaDAO.insert(pessoa);

		int depois = pessoaDAO.listAll().size();

		assertEquals(antes + 1, depois);

	}

	@Test
	public void deveRemoverPessoasDoBancoDeDados() throws Exception {

		int antes = pessoaDAO.listAll().size();

		pessoaDAO.remove(10);

		int depois = pessoaDAO.listAll().size();

		assertEquals(antes - 1, depois);

	}

	@Test
	public void deveListarTodoasAsPessoasDoBancoDeDados() throws Exception {

		int totalDePessoas = pessoaDAO.listAll().size();

		assertEquals(6, totalDePessoas);

	}

	@Test
	public void deveInseirEAlterarPessoasNoBancoDeDados() throws Exception {
			
	}

}

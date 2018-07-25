package com.lovelacetecnologia.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lovelacetecnologia.model.Pessoa;
import com.lovelacetecnologia.service.impl.PessoaService;

public class PessoaServiceTest {

	private IPessoaService service;

	@Before
	public void setup() {
		service = new PessoaService();

	}

	@Test
	public void deveInserirPessoasNoBancoDeDados() throws Exception {

		int antes = service.listarTodos().size();

		Pessoa pessoa = new Pessoa();

		pessoa.setNome("Pedro");
		service.incluir(pessoa);

		int depois = service.listarTodos().size();

		assertEquals(antes + 1, depois);

	}

	@Test
	public void deveRemoverPessoasDoBancoDeDados() throws Exception {

		int antes = service.listarTodos().size();

		service.excluir(2);

		int depois = service.listarTodos().size();

		assertEquals(antes - 1, depois);

	}

	@Test
	public void deveListarTodoasAsPessoasDoBancoDeDados() throws Exception {

		int totalDePessoas = service.listarTodos().size();

		assertEquals(3, totalDePessoas);

	}

	@Test
	public void deveInseirEAlterarPessoasNoBancoDeDados() throws Exception {

		Pessoa pessoa = new Pessoa();
		pessoa.setId(1);
		pessoa.setNome("Ana");

		Pessoa antes = service.buscarPorId(pessoa.getId());

		antes.setNome("Maria Aparecida");
		service.alterar(antes);

		Pessoa depois = service.buscarPorId(antes.getId());

		assertTrue(antes.getNome().equals(depois.getNome()));

	}

	@Test
	public void deveBuscarPessoasPeloId() throws Exception {

		Pessoa pessoa = new Pessoa();

		pessoa.setNome("Filipe Bastos");
		service.incluir(pessoa);

		assertNotNull(service.buscarPorId(pessoa.getId()).getId());

	}

}

package com.lovelacetecnologia.service;

import java.util.List;

import com.lovelacetecnologia.model.Pessoa;

public interface IPessoaService {

	void incluir(Pessoa pessoa);

	void alterar(Pessoa pessoa);

	void excluir(int id);

	List<Pessoa> listarTodos();
	
	Pessoa buscarPorId(int idPessoa);
	
}

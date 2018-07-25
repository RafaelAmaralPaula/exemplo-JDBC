package com.lovelacetecnologia.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lovelacetecnologia.model.Pessoa;
import com.lovelacetecnologia.service.IPessoaService;
import com.lovelacetecnologia.util.ConexaoUtil;

public class PessoaService implements IPessoaService {

	@Override
	public void incluir(Pessoa pessoa) {

		try {

			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = ("INSERT INTO pessoas (nome) VALUES(?)");

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, pessoa.getNome());

			statement.execute();
			connection.close();

			System.out.println("INSERINDO COM SUCESSO !");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Pessoa pessoa) {

		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "UPDATE pessoas SET nome = ? WHERE id = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, pessoa.getNome());
			statement.setInt(2, pessoa.getId());

			statement.execute();
			statement.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(int id) {

		try {

			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "DELETE FROM pessoas WHERE id = (?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, id);

			statement.execute();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Pessoa> listarTodos() {

		List<Pessoa> lista = new ArrayList<>();

		try {

			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "SELECT * FROM pessoas";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Pessoa pessoa = new Pessoa();

				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));

				lista.add(pessoa);

			}

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Pessoa buscarPorId(int idPessoa) {

		Pessoa pessoa = new Pessoa();

		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "SELECT * FROM pessoas WHERE id = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idPessoa);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {

				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));

			}
			
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pessoa;
	}

}

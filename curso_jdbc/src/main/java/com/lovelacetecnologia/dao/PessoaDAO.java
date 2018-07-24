package com.lovelacetecnologia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lovelacetecnologia.jdbc.ConexaoUtil;
import com.lovelacetecnologia.model.Pessoa;

public class PessoaDAO {

	public void insert(Pessoa pessoa) {

		try {

			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "INSERT INTO pessoas(nome) values(?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, pessoa.getNome());

			statement.execute();
			connection.close();

			System.out.println("INSERINDO COM SUCESSO !");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void remove(int idPessoa) {

		try {

			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "DELETE FROM pessoas WHERE id =(?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, idPessoa);

			statement.execute();
			connection.close();

			System.out.println("REMOVIDO COM SUCESSO !");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Pessoa> listAll() {

		List<Pessoa> lista = new ArrayList<>();
		try {

			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "SELECT * FROM pessoas";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Pessoa pessoa = new Pessoa();

				pessoa.setId(resultSet.getInt("id"));
				pessoa.setNome(resultSet.getString("nome"));

				lista.add(pessoa);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	public void change(Pessoa pessoa) {

		try {

			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "UPDATE pessoas SET nome = ? WHERE id = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, pessoa.getNome());
			statement.setInt(2, pessoa.getId());

			statement.execute();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

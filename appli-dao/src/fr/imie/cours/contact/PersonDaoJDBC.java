package fr.imie.cours.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoJDBC extends AbstractDAO<Person> {

	@Override
	public List<Person> findAll() {
		String sql = " SELECT id , firstname , lastname FROM person ";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet result = statement.executeQuery()) {
			List<Person> list = new ArrayList<>();
			while (result.next()) {
				Person person = mapResultToDTO(result);
				person.setId(result.getInt("id"));
				list.add(person);
			}
			return list;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public Person findOne(Person data) {
		return findOne(data.getId());
	}

	@Override
	public Person findOne(Integer id) {
		String sql = " SELECT firstname , lastname FROM person WHERE id = ? ";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, id);
			try (ResultSet result = statement.executeQuery();) {
				result.next();
				Person person = mapResultToDTO(result);
				person.setId(id);
				return person;
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	private Person mapResultToDTO(ResultSet result) throws SQLException {
		Person person = new Person();
		person.setFirstName(result.getString("firstname"));
		person.setLastName(result.getString("lastname"));
		return person;
	}

	@Override
	public Person insert(Person data) {
		String sql = " INSERT INTO person ( firstname , lastname ) VALUES ( ? , ? ) ";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
			fillStatement(data, statement, false);
			statement.executeUpdate();
			// récupère l'id après insertion
			ResultSet keys = statement.getGeneratedKeys();
			keys.next();
			// alimente le dto avec l'id trouvé
			data.setId(keys.getInt(1));
			return data;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void update(Person data) {
		String sql = " UPDATE person SET firstname = ? , lastname = ? WHERE id = ? ";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			fillStatement(data, statement, true);
			statement.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	private void fillStatement(Person data, PreparedStatement statement, boolean isUpdate) throws SQLException {
		int index = 1;
		statement.setString(index++, data.getFirstName());
		statement.setString(index++, data.getLastName());
		if (isUpdate) {
			statement.setInt(index++, data.getId());
		}
	}

	@Override
	public void delete(Person data) {
		delete(data.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = " DELETE FROM person WHERE id = ? ";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void delete(List<Person> data) {
		for (Person person : data) {
			delete(person);
		}
	}

	@Override
	public void deleteAll() {
		String sql = " DELETE FROM person ";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

}

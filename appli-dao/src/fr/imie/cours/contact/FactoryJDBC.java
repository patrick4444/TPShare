package fr.imie.cours.contact;

public class FactoryJDBC extends Factory {

	@Override
	public DAO<Person> getPersonDAO() {
		return new PersonDaoJDBC();
	}

	@Override
	public DAO<Product> getProductDAO() {
		return new ProductDaoJDBC();
	}

}

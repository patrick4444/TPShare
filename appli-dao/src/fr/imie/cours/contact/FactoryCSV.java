package fr.imie.cours.contact;

public class FactoryCSV extends Factory {

	@Override
	public DAO<Person> getPersonDAO() {
		return new PersonDaoCSV();
	}

	@Override
	public DAO<Product> getProductDAO() {
		return new ProductDaoCSV();
	}

}

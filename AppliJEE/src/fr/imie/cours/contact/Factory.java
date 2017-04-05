package fr.imie.cours.contact;

public abstract class Factory {


	public static Factory getInstance() {
		// try {
		Factory factory = new FactoryJDBC();
		return factory;
		// return (Factory) Class.forName("fr.imie.cours.contact.FactoryJDBC").newInstance();
		// } catch (ReflectiveOperationException ex) {
		// throw new RuntimeException(ex);
		// }
	}

	public abstract DAO<Person> getPersonDAO();

	public abstract DAO<Product> getProductDAO();

}

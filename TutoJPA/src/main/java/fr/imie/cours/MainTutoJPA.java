package fr.imie.cours;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTutoJPA {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TutoJPA");
		try {
			EntityManager em = factory.createEntityManager();
			try {
				Person p = em.find(Person.class, 1);
				System.out.println(p.getFirstName());
				System.out.println(p.getLastName());
			} finally {
				em.close();
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			factory.close();
		}
	}

}

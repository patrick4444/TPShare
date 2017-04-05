/**
 * 
 */
package fr.imie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author imiedev
 *
 */
public class Bibliotheque implements IBibliotheque {

	private List<Livre> catalogue = new ArrayList<>();
	private List<Adherent> adherents = new ArrayList<>();
	
	
	
	
	public Bibliotheque() {
		super();
		Livre oldSchool = new Livre();
		oldSchool.setNom("Design Patterns: Elements of Reusable Object-Oriented Software");

		Livre newSchool = new Livre();
		newSchool.setNom("Design Pattern - La tête la première");
		
		Adherent jr = new Adherent();
		jr.setNom("JR Tolkien");
		jr.setNumero(1);
		
		Adherent dare =  new Adherent();
		dare.setNom("Daredevil");
		dare.setNumero(2);
		
		this.ajouterAdherent(jr);
		this.ajouterAdherent(dare);
		this.ajouterLivre(oldSchool);
		this.ajouterLivre(newSchool);
		this.creerEmprunt(oldSchool, jr);
		this.creerEmprunt(newSchool, dare);
		this.creerEmprunt(newSchool, jr);
	}

	/* (non-Javadoc)
	 * @see fr.imie.IBibliotheque#listerCatalogue()
	 */
	@Override
	public List<Livre> listerCatalogue() {
		return this.catalogue;
	}
	
	/* (non-Javadoc)
	 * @see fr.imie.IBibliotheque#ajouterLivre(Livre livre)
	 */
	@Override
	public void ajouterLivre(Livre livre){
		this.catalogue.add(livre);
	}
	
	
	

	/* (non-Javadoc)
	 * @see fr.imie.IBibliotheque#creerEmprunt(fr.imie.Livre, fr.imie.Adherent)
	 */
	@Override
	public void creerEmprunt(Livre livre, Adherent adherent) {
		Emprunt emprunt = new Emprunt();
		emprunt.setEmprunteur(adherent);
		emprunt.setLivre(livre);
		adherent.ajouterEmprunts(emprunt);
	}

	@Override
	public List<Adherent> listerAdherents() {
		return this.adherents;
	}

	@Override
	public void ajouterAdherent(Adherent adherent) {
		this.adherents.add(adherent);
		
	}

	@Override
	public List<Emprunt> listerEmprunts() {
		List<Emprunt> out  =  new ArrayList<>();
		for (Adherent adherent : this.adherents) {
			for (Emprunt emprunt : adherent.getEmprunts()) {
				out.add(emprunt);
			}
		}
		return out;
	}
}

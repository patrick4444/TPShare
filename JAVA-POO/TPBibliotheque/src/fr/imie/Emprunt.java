package fr.imie;

public class Emprunt {

	private Adherent emprunteur;
	private Livre livre;
	
	
	public Adherent getEmprunteur() {
		return emprunteur;
	}
	public void setEmprunteur(Adherent emprunteur) {
		this.emprunteur = emprunteur;
	}
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	@Override
	public String toString() {
		return String.format(" livre : %S - emprunteur : %S", this.livre.getNom(),this.emprunteur.getNom());
	}
	
	
	
	
}

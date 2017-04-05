package fr.imie;

import java.util.ArrayList;
import java.util.List;

public class Adherent {

	private String Nom;
	private Integer Numero;
	
	private List<Emprunt> emprunts = new ArrayList<>();
	
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public Integer getNumero() {
		return Numero;
	}
	public void setNumero(Integer numero) {
		Numero = numero;
	}
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}
	public void ajouterEmprunts(Emprunt emprunt) {
		this.emprunts.add(emprunt);
	}
								
				
	
}

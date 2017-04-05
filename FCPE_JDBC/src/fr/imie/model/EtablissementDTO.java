/**
 * 
 */
package fr.imie.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author imiedev
 *
 */
public class EtablissementDTO {

	private String nom;
	private AdresseDTO adresse;
	private Integer id;
	private List<TypeEtablissementDTO> typeEtablissementDTOs=new ArrayList<>();
	
	
	
	public EtablissementDTO initDTO(String nom, AdresseDTO adresse) {
		this.nom = nom;
		this.adresse = adresse;
		return this;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public AdresseDTO getAdresse() {
		return adresse;
	}
	public void setAdresse(AdresseDTO adresse) {
		this.adresse = adresse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<TypeEtablissementDTO> getTypeEtablissementDTOs() {
		return typeEtablissementDTOs;
	}

	public void setTypeEtablissementDTOs(List<TypeEtablissementDTO> typeEtablissementDTOs) {
		this.typeEtablissementDTOs = typeEtablissementDTOs;
	}
	
	
	

}

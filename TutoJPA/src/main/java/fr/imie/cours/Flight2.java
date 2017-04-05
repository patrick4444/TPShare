package fr.imie.cours;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight2 {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	private String number;
//
//	@JoinTable(
//		name = "FLIGHT_AIRPORT",
//		joinColumns = @JoinColumn(name = "ID_FLIGHT", referencedColumnName = "ID"),
//		inverseJoinColumns = @JoinColumn(name = "ID_AIRPORT", referencedColumnName = "ID")
//		)
//	private List<Airport2> listAirports = new ArrayList<>();
//	public List<Airport2> getListAirports() { return listAirports; }

}

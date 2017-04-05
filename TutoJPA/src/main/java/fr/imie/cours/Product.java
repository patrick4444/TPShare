package fr.imie.cours;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "ID_CART")
	private Cart cart;
	public Cart getCart() { return cart; }
	public void setCart(Cart cart) { this.cart = cart; }
	
}

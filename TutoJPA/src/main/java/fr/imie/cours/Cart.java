package fr.imie.cours;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class git Cart {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	private String nom;
	
	@OneToMany(mappedBy = "cart")
	private List<Product> listProducts = new ArrayList<>();
	public List<Product> getListProducts() { return listProducts; }
	public void addProduct(Product product) {
		listProducts.add(product);
		product.setCart(this);
	}
	public void removeProduct(Product product) { listProducts.remove(product); }

}

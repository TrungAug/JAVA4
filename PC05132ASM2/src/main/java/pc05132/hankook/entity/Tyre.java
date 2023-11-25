package pc05132.hankook.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tyres")
public class Tyre {
	@Id
	private String idTyre;
	private String nameTyre;
	@OneToMany(mappedBy = "tyre")
	List<Product> products;
	public String getIdTyre() {
		return idTyre;
	}
	public void setIdTyre(String idTyre) {
		this.idTyre = idTyre;
	}
	public String getNameTyre() {
		return nameTyre;
	}
	public void setNameTyre(String nameTyre) {
		this.nameTyre = nameTyre;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}

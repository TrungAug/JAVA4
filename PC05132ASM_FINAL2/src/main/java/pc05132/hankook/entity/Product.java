package pc05132.hankook.entity;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
@NamedQueries({
	
	@NamedQuery(
				name = "Product.findByIdProd",
				query = "select p from Product p where p.idPro=:paramId"
			)
})
@Entity
@Table(name = "products")
public class Product {
	@Id
	private String idPro;
	private String prodName;
	private String description;
	private Integer buys = 0;
	private Boolean active = true;

	
	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
	@Cascade(value = CascadeType.REMOVE)
	List<RelProductTyre> detailProducts;
	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
	@Cascade(value = CascadeType.REMOVE)
	List<Image> images;
	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
	@Cascade(value = CascadeType.REMOVE)
	List<Like> likes;
	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
	@Cascade(value = CascadeType.REMOVE)
	List<Share> shares;
	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
	@Cascade(value = CascadeType.REMOVE)
	List<Size> sizes;
	
	public String getIdPro() {
		return idPro;
	}
	public void setIdPro(String idPro) {
		this.idPro = idPro;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getBuys() {
		return buys;
	}
	public void setBuys(Integer buys) {
		this.buys = buys;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public List<RelProductTyre> getDetailProducts() {
		return detailProducts;
	}
	public void setDetailProducts(List<RelProductTyre> detailProducts) {
		this.detailProducts = detailProducts;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public List<Like> getLikes() {
		return likes;
	}
	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	public List<Share> getShares() {
		return shares;
	}
	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	public List<Size> getSizes() {
		return sizes;
	}
	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}
	
	
}

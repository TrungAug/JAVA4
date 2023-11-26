package pc05132.hankook.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "products", uniqueConstraints = { @UniqueConstraint(columnNames = { "tyre_id_fk_product" }) })
public class Product {
	@Id
	private String idPro;
	private String prodName;
	private String description;
	private Integer buys = 0;
	private Boolean active = true;

	@ManyToOne
	@JoinColumn(name = "tyre_id_fk_product")
	private Tyre tyre;

	@OneToMany(mappedBy = "product")
	List<Image> images;
	@OneToMany(mappedBy = "product")
	List<Like> likes;
	@OneToMany(mappedBy = "product")
	List<Share> shares;
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
	public Tyre getTyre() {
		return tyre;
	}
	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
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
	
	
}

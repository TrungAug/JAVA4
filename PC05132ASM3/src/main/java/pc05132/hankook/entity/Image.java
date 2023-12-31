package pc05132.hankook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
		name = "images",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"product_id_fk_img"})
		}		
		)
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idImg;
	private String imgSrc;
	@ManyToOne
	@JoinColumn(name = "product_id_fk_img")
	private Product product;
	public int getIdImg() {
		return idImg;
	}
	public void setIdImg(int idImg) {
		this.idImg = idImg;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}

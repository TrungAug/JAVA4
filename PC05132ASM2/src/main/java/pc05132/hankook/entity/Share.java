package pc05132.hankook.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "shares")
public class Share {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idShare;
	@Temporal(TemporalType.DATE)
	private Date dateShare = new Date(System.currentTimeMillis());
	@ManyToOne
	@JoinColumn(name = "user_id_fk_share")
	private User userss;
	@ManyToOne
	@JoinColumn(name = "product_id_fk_share")
	private Product product;

	public int getIdShare() {
		return idShare;
	}

	public void setIdShare(int idShare) {
		this.idShare = idShare;
	}

	public Date getDateShare() {
		return dateShare;
	}

	public void setDateShare(Date dateShare) {
		this.dateShare = dateShare;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUserss() {
		return userss;
	}

	public void setUserss(User userss) {
		this.userss = userss;
	}

	public Product getProduct() {
		return product;
	}

}

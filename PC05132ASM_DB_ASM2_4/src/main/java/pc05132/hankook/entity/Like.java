package pc05132.hankook.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@NamedQueries({
	
	@NamedQuery(			
			name = "Favorite.SelectProductByUser",
			query = "select distinct l.product from Like l where l.userss=:user"
			),
	@NamedQuery(
			name = "Like.findByIdProd",
			query = "select l from Like l where l.product.idPro=:paramId"
		)
})

@Entity
@Table(name = "likes")
public class Like {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLike;
	@Temporal(TemporalType.DATE)
	private Date dateLike=new Date(System.currentTimeMillis());
	@ManyToOne
	@JoinColumn(name = "user_id_fk_like")
	private User userss;
	@ManyToOne
	@JoinColumn(name = "product_id_fk_like")
	private Product product;

	public int getIdLike() {
		return idLike;
	}

	public void setIdLike(int idLike) {
		this.idLike = idLike;
	}

	public Date getDateLike() {
		return dateLike;
	}

	public void setDateLike(Date dateLike) {
		this.dateLike = dateLike;
	}

	public Product getProduct() {
		return product;
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

}

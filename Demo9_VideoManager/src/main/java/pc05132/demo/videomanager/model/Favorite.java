package pc05132.demo.videomanager.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@NamedQuery(
		name = "UserAcc.findByFavoriteVideo",
		query = "select o.userx from Favorite o where o.videox.id=:videoId"
		
		)
@Entity
@Table(name = "favorites", uniqueConstraints = {@UniqueConstraint(columnNames = { "user_id", "video_id" }) })
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserAcc userx;
	@ManyToOne
	@JoinColumn(name = "video_id")
	private Video videox;
	@Temporal(TemporalType.DATE)
	private Date likeDate = new Date(System.currentTimeMillis());
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserAcc getUserx() {
		return userx;
	}
	public void setUserx(UserAcc userx) {
		this.userx = userx;
	}
	public Video getVideox() {
		return videox;
	}
	public void setVideox(Video videox) {
		this.videox = videox;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	
	
}

package pc05132.lab6.bai3.model;

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
import jakarta.persistence.UniqueConstraint;

@NamedQueries({
	@NamedQuery(
			name = "UserAcc.findUserFavoriteByVideoId",
			query = "select o.userx from Favorite o where o.videox.id=:videoId"
			
			),
	
	@NamedQuery(
			name = "Video.findFavoriteVideoByUserId",
			query = "select o.videox from Favorite o where o.userx.id=:paramUserId"
			
			),
	@NamedQuery(
			name = "UserAcc.getUserByUserId",
			query = "select o.userx from Favorite o where o.userx.id=:paramUserId"
			
			),
	@NamedQuery(			
			name = "Video.findVideoByKeyWord",
			query = "Select distinct o.videox from Favorite o where o.videox.title like :paramKeyword"		
			),
	@NamedQuery(name = "Video.findInMonths", query = "SELECT DISTINCT o.videox FROM Favorite o WHERE month(o.likeDate) IN (:months)")
	
})

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

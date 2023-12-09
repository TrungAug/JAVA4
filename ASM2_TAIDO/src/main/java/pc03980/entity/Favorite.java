package pc03980.entity;

import java.util.Date;

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
	@NamedQuery(name = "Favorite.FindAll", query ="from Favorite")
})

@Entity
@Table (name="favorites", uniqueConstraints = {@UniqueConstraint(columnNames = {"video_id","user_id"})})
public class Favorite {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@ManyToOne
@JoinColumn(name="user_id")
private Account account;

@ManyToOne
@JoinColumn(name="video_id")
private Video video;
@Temporal(TemporalType.DATE)
private Date like_date = new Date();
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Account getUser() {
	return account;
}
public void setUser(Account user) {
	this.account = user;
}
public Video getVideo() {
	return video;
}
public void setVideo(Video video) {
	this.video = video;
}
public Date getLike_date() {
	return like_date;
}
public void setLike_date(Date like_date) {
	this.like_date = like_date;
}



}
package pc03980.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@NamedQueries({
	@NamedQuery(name = "Share.FindAll", query ="from Share")
})

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"video_id","user_id"})})
public class Share {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@ManyToOne
@JoinColumn(name="user_id")
private Account accountShare;

@ManyToOne
@JoinColumn(name="video_id")
private Video videoShare;
private String Email;
private String dataShare;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Account getUserShare() {
	return accountShare;
}
public void setUserShare(Account userShare) {
	this.accountShare = userShare;
}
public Video getVideoShare() {
	return videoShare;
}
public void setVideoShare(Video videoShare) {
	this.videoShare = videoShare;
}
public String getEmail() {
	return Email;
}
public void setEmails(String email) {
	this.Email = email;
}
public String getDataShare() {
	return dataShare;
}
public void setDataShare(String dataShare) {
	this.dataShare = dataShare;
}


}
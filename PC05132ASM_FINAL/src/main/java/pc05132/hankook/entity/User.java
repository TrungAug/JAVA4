package pc05132.hankook.entity;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "userss")
public class User {
	@Id
	private String idUs;
	private String fullName;
	private String passWord;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date birthDay;
	private boolean admin;

	@OneToMany(mappedBy = "userss")
	@Cascade(value = CascadeType.REMOVE)
	List<Share> shares;
	
	@OneToMany(mappedBy = "userss")
	@Cascade(value = CascadeType.REMOVE)
	List<Like> likes;

	public String getIdUs() {
		return idUs;
	}

	public void setIdUs(String idUs) {
		this.idUs = idUs;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}


	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "User [idUs=" + idUs + ", fullName=" + fullName + ", passWord=" + passWord + ", email=" + email
				+ ", birthDay=" + birthDay + ", admin=" + admin + ", shares=" + shares + ", likes=" + likes + "]";
	}
	
	
}

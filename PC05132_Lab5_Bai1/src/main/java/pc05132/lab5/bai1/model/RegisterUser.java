package pc05132.lab5.bai1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Accout")
public class RegisterUser {
	@Id
	@Column(name = "id")
	private String iD;
	
	@Column(name="password")
	private String passWord;
	
	@Column(name="fullname")
	private String fullName;
	
	@Column(name="email")
	private String emailAdd;
	
	@Column(name="admin")
	private boolean isAdmin=false;

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	
	
}

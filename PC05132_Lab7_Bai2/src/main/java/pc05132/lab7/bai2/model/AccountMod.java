package pc05132.lab7.bai2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AccountFour")
public class AccountMod {
	@Id
	@Column(name = "username")
	private String id;
	@Column(name = "fullname")
	private String fullName;
	@Column(name = "emailadd")
	private String emailAdd;
	@Column(name = "password")
	private String passWord;
	@Column(name = "role")
	private boolean admin=false;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "AccountMod [id=" + id + ", fullName=" + fullName + ", emailAdd=" + emailAdd + ", passWord=" + passWord
				+ ", admin=" + admin + "]";
	}

	

}

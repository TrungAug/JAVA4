package pc05132.account.entity;

import java.util.Date;

import org.hibernate.annotations.Nationalized;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@NamedQuery(
		name = "Account.FindAll",
		query="from Account"
		)
@Entity
@Table(name="Acounts")
public class Account {
	@Id
	private String username;
	@Nonnull
	private String password;
	@Nationalized
	@Column(length = 100)
	private String fullname;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate = new Date();
	
//	@Temporal(TemporalType.DATE) => import java.sql.Date;
//	private Date createDate1 = new Date(System.currentTimeMillis());
	private Boolean admin=false;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	
	
}

package pc03980.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@NamedQueries({
	@NamedQuery(name = "Account.FindAll", query = "from Account")
})

@Entity
@Table
public class Account {
@Id
private String id;
private String password;
private String email;
private String fullname;
private boolean admin = false;
@OneToMany(mappedBy = "account")
List<Favorite> favorites;

@OneToMany(mappedBy = "accountShare")
List<Share> shares;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public boolean isAdmin() {
	return admin;
}
public void setAdmin(boolean admin) {
	this.admin = admin;
}
public List<Favorite> getFavorites() {
	return favorites;
}
public void setFavorites(List<Favorite> favorites) {
	this.favorites = favorites;
}
public List<Share> getShares() {
	return shares;
}
public void setShares(List<Share> shares) {
	this.shares = shares;
}

}
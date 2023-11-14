package pc05132.lab4.bai2.model;

public class Users {
	String username;
	String password;
	boolean remember;

	public Users() {

	}

	public Users(String username, String password, boolean remember) {
		super();
		this.username = username;
		this.password = password;
		this.remember = remember;
	}

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

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", remember=" + remember + "]";
	}

}

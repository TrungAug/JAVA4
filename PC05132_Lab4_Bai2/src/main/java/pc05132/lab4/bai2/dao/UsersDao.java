package pc05132.lab4.bai2.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pc05132.lab4.bai2.model.Users;

public class UsersDao {
	List<Users> listUs = new ArrayList<>();

	public static UsersDao getInstance() {
		return new UsersDao();
	}
	
	public List<Users> myData(){
		listUs.add(new Users("Username1", "Password1", false));
		listUs.add(new Users("Username2", "Password2", false));
		listUs.add(new Users("Username3", "Password3", true));
		listUs.add(new Users("Username4", "Password4", true));
		listUs.add(new Users("Username5", "Password5", false));
		
		return listUs;
	}
	
	public List<Users> getAllUsers(){
		return listUs;
	}
	
	public int insert(Users u) {
		listUs.add(u);
		return 1;
	}
	
	public int update(Users u) {
		for(int i=0;i<listUs.size();i++) {
			if(listUs.get(i).getUsername().equalsIgnoreCase(u.getUsername())) {
				listUs.set(i, u);
				return i;
			}
		}	
		return -1;
	}
	
	public Users getUsersByUsername(String username) {
		for (Users users : listUs) {
			if(users.getUsername().equals(username)) {
				return users;
			}
		}
		
		return null;
	}
	
	public int save (Users u) {
		if(getUsersByUsername(u.getUsername())!=null) {
			update(u);
		}else {
			insert(u);
		}
		return -1;
	}
}
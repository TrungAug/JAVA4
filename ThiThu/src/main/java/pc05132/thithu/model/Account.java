package pc05132.thithu.model;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table (
		uniqueConstraints = @UniqueConstraint(columnNames ="username")
		)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Nonnull
	private String username;
	@Nonnull
	private String password;
	@Nonnull
	private boolean role;
	
	@OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
	@Cascade(value = CascadeType.REMOVE)
	List<ToDoList> todoList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public List<ToDoList> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<ToDoList> todoList) {
		this.todoList = todoList;
	}
	
	
}

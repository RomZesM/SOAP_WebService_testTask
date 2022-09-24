package com.demoROM.producingwebservice.models;

import javax.persistence.*;
import java.util.List;
import com.demoROM.producingwebservice.models.User;

@Entity
@Table(name = "roles")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name = "role_name")
	public String roleName;

	@ManyToMany(mappedBy = "userRoleList")
	public List<User> userList;

	public UserRole() {
	}

	public UserRole(int id, String role) {
		this.id = id;
		this.roleName = role;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return roleName;
	}

	public void setRole(String role) {
		this.roleName = role;

			}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "UserRole{" +
				"id=" + id +
				", role='" + roleName + '\'' +
				'}';
	}
}

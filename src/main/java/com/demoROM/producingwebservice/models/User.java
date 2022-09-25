package com.demoROM.producingwebservice.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
@Valid
@Entity
@Table(name = "users")
public class User {
	@NotBlank(message = "Do not be empty")
	@Column(name = "name")
	private String name;
	@Id
	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(name = "login"),
			inverseJoinColumns = @JoinColumn(name = "id")
	)
	public List<UserRole> userRoleList;

		public User(){

	}

	public User(String name, String login, String password, List<UserRole> userRoleList) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.userRoleList = userRoleList;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}


	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", userRoleList=" + userRoleList +
				'}';
	}
}

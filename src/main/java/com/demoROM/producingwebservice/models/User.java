package com.demoROM.producingwebservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
	@Column(name = "name")
	private String name;
	@Id
	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;


	//public List<UserRole> userRoleList;

		public User(){

	}

	public User(String name, String login, String password, List<UserRole> userRoleList) {
		this.name = name;
		this.login = login;
		this.password = password;
		//this.userRoleList = userRoleList;
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

//	public List<UserRole> getUserRoleList() {
//		return userRoleList;
//	}
//
//	public void setUserRoleList(List<UserRole> userRoleList) {
//		this.userRoleList = userRoleList;
//	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}

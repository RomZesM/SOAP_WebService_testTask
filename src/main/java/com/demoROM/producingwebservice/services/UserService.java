package com.demoROM.producingwebservice.services;

import com.demoROM.producingwebservice.models.User;
import com.demoROM.producingwebservice.models.UserRole;
import com.demoROM.producingwebservice.repositories.UserRepository;
import io.spring.guides.gs_producing_web_service.UserInfo;
import io.spring.guides.gs_producing_web_service.UserInfoRole;
import io.spring.guides.gs_producing_web_service.UserRoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	private UserRoleService userRoleService;
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository, UserRoleService userRoleService) {
		this.userRepository = userRepository;
		this.userRoleService = userRoleService;
	}


	public UserInfoRole findUser(String login) {
		UserInfoRole userInfoRole = convertUserToUserInfoRole(userRepository.findByLogin(login));
		//Assert.notNull(name, "The country's name must not be null");
		return userInfoRole;
	}


	public void save(User user) {
		userRepository.save(user);
		//Assert.notNull(name, "The country's name must not be null");
	}

	public List<UserInfo> getUsersList(){
		List<UserInfo> userInfoList = new ArrayList<>();
		for (User user : userRepository.findAll()){
			userInfoList.add(convertUserToUserInfo(user));
		}
		 return userInfoList;
	}

	public UserInfo convertUserToUserInfo(User user){
		UserInfo userInf = new UserInfo();
		userInf.setName(user.getName());
		userInf.setLogin(user.getLogin());
		userInf.setPassword(user.getPassword());
		return userInf;
	}

	public UserInfoRole convertUserToUserInfoRole(User user){
		UserInfoRole userInf = new UserInfoRole();
		userInf.setName(user.getName());
		userInf.setLogin(user.getLogin());
		userInf.setPassword(user.getPassword());

		for(UserRole role : user.userRoleList){
			UserRoleInfo userRoleInfo = new UserRoleInfo(); //todo refactor???
			userRoleInfo.setRole(role.getRoleName());
			userInf.getRoles().add(userRoleInfo);
		}

		return userInf;
	}
}

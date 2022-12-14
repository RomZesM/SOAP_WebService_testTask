package com.demoROM.producingwebservice.services;

import com.demoROM.producingwebservice.models.User;
import com.demoROM.producingwebservice.models.UserRole;
import com.demoROM.producingwebservice.repositories.UserRepository;
import io.spring.guides.gs_producing_web_service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	private UserRoleService userRoleService;
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository, UserRoleService userRoleService) {
		this.userRepository = userRepository;
		this.userRoleService = userRoleService;
	}


	public UserInfoPlusRole findUser(String login) {
		UserInfoPlusRole userInfoRole = convertUserToUserInfoPlusRole(userRepository.findByLogin(login));
		return userInfoRole;
	}


	public void save(AddUserRequest request) {

		User user = new User();
		user.setName(request.getNewUser().getName());
		user.setLogin(request.getNewUser().getLogin());
		user.setPassword(request.getNewUser().getPassword());
		List<UserRole> roleList = new ArrayList<>();
		for(UserRoleInfo role : request.getNewUser().getRoles()){
			roleList.add(userRoleService.findRole(role.getRole())); //todo add null check, create new if 0;
		}
		user.setUserRoleList(roleList);

		userRepository.save(user);
		//Assert.notNull(name, "The country's name must not be null");
	}

	public void update(UpdateUserRequest request) {

		User user = userRepository.findByLogin(request.getUpdateUser().getLogin());

		if(user != null){
			user.setName(request.getUpdateUser().getName());
			user.setLogin(request.getUpdateUser().getLogin()); //todo: do we need to change user login -> primary key??
			user.setPassword(request.getUpdateUser().getPassword());
			List<UserRole> roleList = new ArrayList<>();
			if(request.getUpdateUser().getRoles().size() != 0){
				for(UserRoleInfo role : request.getUpdateUser().getRoles()){
					roleList.add(userRoleService.findRole(role.getRole())); //todo add null check, create new if 0;
				}
				user.setUserRoleList(roleList);
			}



			userRepository.save(user);
		}

		//Assert.notNull(name, "The country's name must not be null");
	}

	public void delete(String login) {
		userRepository.deleteById(login);
			//Assert.notNull(name, "The country's name must not be null"); //todo: do i need this?
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

	public UserInfoPlusRole convertUserToUserInfoPlusRole(User user){
		UserInfoPlusRole userInf = new UserInfoPlusRole();
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

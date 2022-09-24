package com.demoROM.producingwebservice.services;

import com.demoROM.producingwebservice.models.User;
import com.demoROM.producingwebservice.models.UserRole;
import com.demoROM.producingwebservice.repositories.UserRepository;
import io.spring.guides.gs_producing_web_service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	private UserRoleService userRoleService;
	private UserRepository userRepository;
	private UserInfo userInfo;
	private User user;

	@Autowired
	public UserService(UserRepository userRepository, UserRoleService userRoleService) {
		this.userRepository = userRepository;
		this.userRoleService = userRoleService;
	}

	@PostConstruct
	public void testDataInit(){
		List<UserRole> userRoleTestList = new ArrayList<>();
		userRoleTestList.add(new UserRole(2, "user"));
		this.user = new User("Bib", "logogo4", "passs", userRoleTestList);

		this.userInfo = new UserInfo();
		userInfo.setName(user.getName());
		userInfo.setLogin(user.getLogin());
		userInfo.setPassword(user.getPassword());


//		System.out.println("Try dataBase:-------");
//
//		List<User> userList = userRepository.findAll();
//		System.out.println(userList);
//		List<UserRole> roleList = userRoleService.getAllRoles();
//		System.out.println(roleList);
//		userRepository.save(user);


	} //todo del


	public UserInfo findUser(String name) {
		//Assert.notNull(name, "The country's name must not be null");
		return userInfo;
	}

	public User testUser(String name) {
		//Assert.notNull(name, "The country's name must not be null");
		return user;
	}

	public void save(User user) {
		userRepository.save(user);
		//Assert.notNull(name, "The country's name must not be null");

	}
}

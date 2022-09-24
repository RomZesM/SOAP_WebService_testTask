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

	private UserRepository userRepository;
	private UserInfo userInfo;
	private User user;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostConstruct
	public void testDataInit(){
		this.user = new User("Bib", "logogog", "passs", new ArrayList<>(List.of(new UserRole(1, "admin"))));

		this.userInfo = new UserInfo();
		userInfo.setName(user.getName());
		userInfo.setLogin(user.getLogin());
		userInfo.setPassword(user.getPassword());

		System.out.println("Try dataBase:-------");

		List<User> list = userRepository.findAll();
		System.out.println(list.size());
		System.out.println(list);

	} //todo del


	public UserInfo findUser(String name) {
		//Assert.notNull(name, "The country's name must not be null");
		return userInfo;
	}
}

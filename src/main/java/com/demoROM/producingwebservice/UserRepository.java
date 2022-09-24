package com.demoROM.producingwebservice;


import io.spring.guides.gs_producing_web_service.User;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;

@Component
public class UserRepository {
	private User user;
	private UserDTO userDTO;

	@PostConstruct
	public void testDataInit(){
		this.userDTO = new UserDTO("Bib", "logogog", "passs");


		this.user = new User();
		user.setName(userDTO.getName());
		user.setLogin(userDTO.getLogin());
		user.setPassword(userDTO.getPassword());


	} //todo del




	public User findUser(String name) {
		//Assert.notNull(name, "The country's name must not be null");
		return user;
	}

}

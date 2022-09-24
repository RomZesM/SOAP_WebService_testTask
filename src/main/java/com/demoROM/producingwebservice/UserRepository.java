package com.demoROM.producingwebservice;


import io.spring.guides.gs_producing_web_service.User;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;

@Component
public class UserRepository {
	private User user;

	@PostConstruct
	public void testDataInit(){
		this.user = new User();
		user.setName("Bob");
		user.setLogin("BobCat");
		user.setPassword("pa777word");
	} //todo del




	public User findUser(String name) {
		//Assert.notNull(name, "The country's name must not be null");
		System.out.println("Name in user repo: " + name);
		return user;
	}

}

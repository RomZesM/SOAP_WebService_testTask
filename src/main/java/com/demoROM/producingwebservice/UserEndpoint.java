package com.demoROM.producingwebservice;



import com.demoROM.producingwebservice.models.User;
import com.demoROM.producingwebservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetUserRequest;
import io.spring.guides.gs_producing_web_service.GetUserResponse;


@Endpoint
public class UserEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private UserService userService;
	@Autowired
	public UserEndpoint(UserService userService) {
		this.userService = userService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
			GetUserResponse response = new GetUserResponse();

		//------------------------------------------------------------------
		System.out.println("Testing user: ");
		User testUser = userService.testUser("yy");
		System.out.println(testUser);
		userService.save(testUser);

		//------------------------------------------------------------------

		//response.setUser(userRepository.findUser(request.getName()));

		//add some user into list into UserResponce
		response.getUser().add(userService.findUser(request.getName()));
		response.getUser().add(userService.findUser(request.getName()));


		return response;
	}



}
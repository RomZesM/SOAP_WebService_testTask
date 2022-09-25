package com.demoROM.producingwebservice;



import com.demoROM.producingwebservice.models.User;
import com.demoROM.producingwebservice.services.UserService;
import io.spring.guides.gs_producing_web_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;


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
//		System.out.println("Testing user: ");
//		User testUser = userService.testUser("yy");
//		System.out.println(testUser);
//		userService.save(testUser);

		//------------------------------------------------------------------

		System.out.println("Test user: " + userService.findUser(request.getLogin()));
		response.setUser(userService.findUser(request.getLogin()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsersListRequest")
	@ResponsePayload
	public GetUsersListResponse getUsersList(@RequestPayload GetUsersListRequest request) {
		GetUsersListResponse response = new GetUsersListResponse();

		List<UserInfo> usersList = userService.getUsersList();
		for(UserInfo userInfo : usersList){
			response.getUser().add(userInfo);
		}
		return response;
	}


}
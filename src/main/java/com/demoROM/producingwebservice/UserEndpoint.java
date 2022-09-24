package com.demoROM.producingwebservice;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetUserRequest;
import io.spring.guides.gs_producing_web_service.GetUserResponse;
import io.spring.guides.gs_producing_web_service.SuccesResponse;
import io.spring.guides.gs_producing_web_service.User;




@Endpoint
public class UserEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private UserRepository userRepository;

	@Autowired
	public UserEndpoint(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
			GetUserResponse response = new GetUserResponse();


		//response.setUser(userRepository.findUser(request.getName()));

		//add some user into list into UserResponce
		response.getUser().add(userRepository.findUser(request.getName()));
		response.getUser().add(userRepository.findUser(request.getName()));


		return response;
	}



}
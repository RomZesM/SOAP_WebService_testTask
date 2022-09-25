package com.demoROM.producingwebservice.validators;


import io.spring.guides.gs_producing_web_service.AddUserRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestValidator {

	public List<String> validate(AddUserRequest request){
		List<String> errorsList = new ArrayList<>();
		if(request.getNewUser().getLogin().equals("")){
			errorsList.add("LOGIN is empty");
		}
		if(request.getNewUser().getName().equals("")){
			errorsList.add("NAME is empty");
		}
		if(request.getNewUser().getPassword().equals("")){
			errorsList.add("PASSWORD is empty");
		}

		return errorsList;
	}
}

package com.demoROM.producingwebservice.validators;


import io.spring.guides.gs_producing_web_service.AddUserRequest;
import io.spring.guides.gs_producing_web_service.UpdateUserRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestValidator {

	public List<String> validateAddUserRequest(AddUserRequest request){
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
		if(!(request.getNewUser().getPassword().equals(""))){
			if(!request.getNewUser().getPassword().matches("(?=.*[A-Z])(?=.*[0-9]).*$"))
					errorsList.add("PASSWORD must contain at least one number and une uppercase letter");
		}

		return errorsList;
	}

	public List<String> validateUpdateUserRequest(UpdateUserRequest request){
		List<String> errorsList = new ArrayList<>();
		if(request.getUpdateUser().getLogin().equals("")){
			errorsList.add("LOGIN is empty");
		}
		if(request.getUpdateUser().getName().equals("")){
			errorsList.add("NAME is empty");
		}
		if(request.getUpdateUser().getPassword().equals("")){
			errorsList.add("PASSWORD is empty");
		}
		if(!(request.getUpdateUser().getPassword().equals(""))){
			if(!request.getUpdateUser().getPassword().matches("(?=.*[A-Z])(?=.*[0-9]).*$"))
				errorsList.add("PASSWORD must contain at least one number and une uppercase letter");
		}

		return errorsList;
	}
}

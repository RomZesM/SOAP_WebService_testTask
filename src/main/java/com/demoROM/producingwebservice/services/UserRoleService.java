package com.demoROM.producingwebservice.services;

import com.demoROM.producingwebservice.models.UserRole;
import com.demoROM.producingwebservice.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

	private UserRoleRepository userRoleRepository;

	@Autowired
	public UserRoleService(UserRoleRepository userRoleRepository) {
		this.userRoleRepository = userRoleRepository;
	}

	public List<UserRole> getAllRoles() {
		return userRoleRepository.findAll();
	}
}

package com.demoROM.producingwebservice.repositories;

import com.demoROM.producingwebservice.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {


	public UserRole findByRoleName(String rolename);
}

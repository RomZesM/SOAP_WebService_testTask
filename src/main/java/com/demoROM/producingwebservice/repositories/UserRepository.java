package com.demoROM.producingwebservice.repositories;

import com.demoROM.producingwebservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


	public User findByLogin(String login);

}

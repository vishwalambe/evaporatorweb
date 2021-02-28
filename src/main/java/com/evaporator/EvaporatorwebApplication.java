package com.evaporator;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.evaporator.entity.Skill;
import com.evaporator.entity.User;
import com.evaporator.repository.UserRepository;

@SpringBootApplication
public class EvaporatorwebApplication {


	@Autowired
	UserRepository userRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(EvaporatorwebApplication.class, args);
	}	
	

	@PostConstruct
	public void setupDbWithData(){
		User user= new User("Ashish", null);
		user.setSkills(Arrays.asList(new Skill("java"), new Skill("js")));
		user= userRepository.save(user);
	}

}

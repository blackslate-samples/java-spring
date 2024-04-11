package com.solidstone.db;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SqliteApplicationTests {
	
	@Autowired UserService userService;

	@Test
	void contextLoads() {
		
		User user = new User();
		user.setFirstName("Raj");
		user.setLastName("Kishore");
		
		userService.createUser(user);
		
		List users = userService.getAllUsers();
		
		//users.forEach((user) -> System.out.println(user.toString()));
		
	}

}

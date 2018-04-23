package com.aironman.demo;

import com.aironman.demo.domain.model.User;
import com.aironman.demo.domain.repository.UserRepository;
import com.aironman.demo.domain.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {

		userService.initialize();

		List<User> listUsers = userService.listAll();

		for (User user:listUsers)
			System.out.println(user.toString());

		Assert.assertTrue(listUsers.size()>0);
	}

}

package com.aironman.demo;

import com.aironman.demo.domain.model.Group;
import com.aironman.demo.domain.model.User;
import com.aironman.demo.domain.service.GroupService;
import com.aironman.demo.domain.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	UserService userService;

	@Autowired
	GroupService groupService;

	@Test
	public void contextLoads() {

		User user = new User();
		user.setUsername("username");
		user.setName("name");
		user.setEmail("email@email.me");
		user.setPassword("password");
		List<User> listUsers = new ArrayList<>();
		listUsers.add(user);

		Group group = new Group();
		group.setGroupName("groupName");
		group.setUsers(listUsers );

		Group group1 = groupService.create(group);

		Assert.assertNotNull(group1);

		List<Group> listGroup = new ArrayList<>();
		listGroup.add(group);

		user.setGroupList(listGroup);

		User user1 = userService.create(user);

		Assert.assertNotNull(user1);
	}

}

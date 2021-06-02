package net.javaguides.usermanagement.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import net.javaguides.usermanagement.dao.IUserDAO;
import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.User;

public class UserServiceTest {
	private IUserService service;
	private UserDAOMock mockUserDAO;
	@Before
	public void setup() {
		service = UserService.getInstance();
		mockUserDAO = new UserDAOMock();
		service.setUserDAO(mockUserDAO);
	}

	@Test
	public void testSelectUser() { // A=arrange, A= Act,A= Assert
		User result = service.selectUser(1);
		assertEquals(1, result.getId());
	}

//
	@Test
	public void testSelectAllUsers() {
		
	}

//	@Test
//	public void testGetInstance() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testInsertUser() {
		User user = new User();
		user.setEmail("test@gmail.com");
		service.insertUser(user);
		assertEquals(12, user.getId());
	}
}

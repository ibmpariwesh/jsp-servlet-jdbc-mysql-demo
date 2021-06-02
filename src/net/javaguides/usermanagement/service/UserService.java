package net.javaguides.usermanagement.service;

import java.util.List;

import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.User;

public class UserService {
	private UserDAO userDAO = UserDAO.getInstance();

	private UserService() {
	}

	static UserService instance;

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	public void insertUser(User newUser) {
		userDAO.insertUser(newUser);
	}

	public User selectUser(int id) {
		return userDAO.selectUser(id);
	}

	public List<User> selectAllUsers() {
		return userDAO.selectAllUsers();
	}

}

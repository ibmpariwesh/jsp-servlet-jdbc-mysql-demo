package net.javaguides.usermanagement.service;

import java.util.List;

import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.User;

public class UserService implements IUserService {
	private UserDAO userDAO = UserDAO.getInstance();

	private UserService() {
	}

	static IUserService instance;

	public static IUserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	@Override
	public void insertUser(User newUser) {
		userDAO.insertUser(newUser);
	}

	@Override
	public User selectUser(int id) {
		return userDAO.selectUser(id);
	}

	@Override
	public List<User> selectAllUsers() {
		return userDAO.selectAllUsers();
	}

}

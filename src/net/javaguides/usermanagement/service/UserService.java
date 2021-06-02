package net.javaguides.usermanagement.service;

import java.util.List;

import net.javaguides.usermanagement.dao.IUserDAO;
import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.User;

public class UserService implements IUserService {
	private IUserDAO userDAO = UserDAO.getInstance();//dependency

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

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
		if(newUser.getEmail() ==null) {//validations
			throw new IllegalArgumentException();
		}
		userDAO.insertUser(newUser);
	}

	@Override
	public User selectUser(int id) {
//		if(id )
		return userDAO.selectUser(id);
	}

	@Override
	public List<User> selectAllUsers() {
		return userDAO.selectAllUsers();
	}

}

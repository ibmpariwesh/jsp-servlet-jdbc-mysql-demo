package net.javaguides.usermanagement.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.dao.IUserDAO;
import net.javaguides.usermanagement.model.User;

public class UserDAOMock implements IUserDAO {

	@Override
	public void insertUser(User user) {
		user.setId(12);
	}

	@Override
	public User selectUser(int id) { //mock
		User user = new User();
		user.setId(id);
		return user;
	}

	@Override
	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		return users;
	}

	@Override
	public boolean deleteUser(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}

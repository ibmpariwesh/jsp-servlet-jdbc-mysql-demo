package net.javaguides.usermanagement.dao;

import java.sql.SQLException;
import java.util.List;

import net.javaguides.usermanagement.model.User;

public interface IUserDAO {

	void insertUser(User user);

	User selectUser(int id);

	List<User> selectAllUsers();

	boolean deleteUser(int id) throws SQLException;

	boolean updateUser(User user) throws SQLException;

}
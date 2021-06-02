package net.javaguides.usermanagement.service;

import java.util.List;

import net.javaguides.usermanagement.model.User;

public interface IUserService {

	void insertUser(User newUser);

	User selectUser(int id);

	List<User> selectAllUsers();

}
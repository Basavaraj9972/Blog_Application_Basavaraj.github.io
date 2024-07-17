package com.tap.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.tap.model.User;

public interface UserDao {
	public void addUser(User user);
	public User getUser(int userId);
	public void updateUser(User user);
	public void updateLastLogin(LocalDateTime lastLogin,int userId);
	public void deleteUser(int userId);
	public List<User> getAllUser();
	public User getUserNamePassword(String userName,String password);
	public User getPhoneNumber(String phone);
	public void updateUserNamePassword(User user);

}

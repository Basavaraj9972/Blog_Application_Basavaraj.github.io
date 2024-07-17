package com.tap.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDao;
import com.tap.model.User;
public class UserDaoImpl implements UserDao{
	Connection con = null;
	static String SELECT_QUERY = "select  * from `user` where `userId` = ?";
	static String INSERT_QUERY = "insert into `user`(`name`,`email`,`phoneNo`,`userName`,`password`,`role`) values(?,?,?,?,?,?)";
	static String UPDATE_QUERY = "update `user` set `name` =?,`email`=?,`phoneNo`=?,`address` =?,`userName`=? ,`password`=? where `userId` =?";
	static String UPDATE_QUERY_LASTlOGIN = "update `user` set `lastLogindate`=? where `userId` =?";
	static String DELETE_QUERY = "delete from `user` where `userId` = ?";
	static String SELECTALL_QUERY = "select * from `user`";
	static String SELECT_USERNAME_PASSWORD_ROLE = "select `userName`,`password`,`userId`,`role` from `user` where `userName`=? and `password`=?";
	static String SELECT_PHONE_NUMBER ="select `phoneNo` from `user` where `phoneNo`=?";
	static String UPDATE_QUERY_USERNAME_PASWORD = "update `user` set `userName`=? `password`=? where `userId`=?";
	public UserDaoImpl() {
		try {
			String url = "jdbc:mysql://localhost:3306/blogapplication";
			String username = "root";
			String password = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loded of UserApplication ");
			con = DriverManager.getConnection(url, username,password);
			System.out.println("Data base connectivity is established   UserApplication");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addUser(User user) {
		PreparedStatement pstmt =null ;
		try {
			pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhoneNo());
			pstmt.setString(4, user.getUserName());
			pstmt.setString(5, user.getPassword());
			pstmt.setString(6, user.getRole());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public User getUser(int userId) {
		ResultSet res = null;
		PreparedStatement pstmt = null;
		User user=null;
		try {
			pstmt = con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1, userId);
			res = pstmt.executeQuery();
			if (res.next()) {
				String name = res.getString("name");
				String email = res.getString("email");
				String phoneNo = res.getString("phoneNo");
				String address = res.getString("address");
				String userName = res.getString("userName");
				String password = res.getString("password");
				String role = res.getString("role");
				Timestamp createdDateTimstamp = res.getTimestamp("createdDate");
				Timestamp lastLoginTimstamp = res.getTimestamp("lastLogindate");
				LocalDateTime createdDate =createdDateTimstamp.toLocalDateTime();
				LocalDateTime lastLogindate = createdDateTimstamp.toLocalDateTime();
				user = new User(userId,name,email, phoneNo,address, userName, password,role,createdDate,lastLogindate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhoneNo());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getUserName());
			pstmt.setString(6, user.getPassword());
			pstmt.setInt(7, user.getUserId());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteUser(int userId) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, userId);
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<User> getAllUser() {
		Statement stmt;
		ResultSet res = null;
		User user = null;
		ArrayList<User> userList = new ArrayList<User>();
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery(SELECTALL_QUERY);
			while (res.next()) {
				int userId = res.getInt("userId");
				String name = res.getString("name");
				String email = res.getString("email");
				String phoneNo = res.getString("phoneNo");
				String address = res.getString("address");
				String userName = res.getString("userName");
				String password = res.getString("password");
				String role = res.getString("role");
				Timestamp createdDateTimstamp = res.getTimestamp("createdDate");
				Timestamp lastLoginTimstamp = res.getTimestamp("lastLogin");
				LocalDateTime createdDate =createdDateTimstamp.toLocalDateTime();
				LocalDateTime lastLogin = createdDateTimstamp.toLocalDateTime();
				user = new User(userId,name,email, phoneNo,address, userName, password,role,createdDate,lastLogin);
				userList.add(user);
			}
		} catch (SQLException e) {
		}
		return userList;
	}
	@Override
	public User getUserNamePassword(String userName, String password) {
		PreparedStatement pstmt = null;
		User user =null;
	     try {
			pstmt = con.prepareStatement(SELECT_USERNAME_PASSWORD_ROLE);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("userId");
				String userName1 = rs.getString("userName");
				String password1 = rs.getString("password");
				String role = rs.getString("role");
				user = new User(userId,userName1,password1,role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public User getPhoneNumber(String phone) {
		PreparedStatement pstmt = null;
		User user = null;
		try {
			pstmt = con.prepareStatement(SELECT_PHONE_NUMBER);
			pstmt.setString(1, phone);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String phoneNo = rs.getString("phoneNo");
				user = new User(phoneNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public void updateUserNamePassword(User user) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY_USERNAME_PASWORD);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getUserId());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateLastLogin(LocalDateTime lastLogin,int userId) {
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY_LASTlOGIN);
			pstmt.setTimestamp(1,Timestamp.valueOf(lastLogin));
			pstmt.setInt(2,userId);
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

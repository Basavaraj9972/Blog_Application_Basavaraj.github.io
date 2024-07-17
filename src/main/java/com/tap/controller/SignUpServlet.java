package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImp.UserDaoImpl;
import com.tap.model.User;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		String encryptedUserName = encryptedUserName(userName);
		String encrycreptedPassword = encrycreptedPassword(password);
		resp.setContentType("text/html");
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User phoneNumber = null;
		User userNamePassword = null;
		phoneNumber = userDaoImpl.getPhoneNumber(phone);
		userNamePassword = userDaoImpl.getUserNamePassword(encryptedUserName, encrycreptedPassword);
		   if(phoneNumber == null && userNamePassword == null){
			User user = new User(name,email,phone,encryptedUserName,encrycreptedPassword,role);
			userDaoImpl.addUser(user);
			session.setAttribute("response", "user account is created successfully");
			RequestDispatcher rd = req.getRequestDispatcher("SignIn.jsp");
			rd.forward(req, resp);
		}
		if((phoneNumber != null) && (phone.equals(phoneNumber.getPhoneNo())) || (encryptedUserName.equals(userNamePassword.getUserName())) &&(encrycreptedPassword.equals(userNamePassword.getPassword()))) {
			session.setAttribute("response", "User is Already registered ");
			RequestDispatcher rd = req.getRequestDispatcher("SignIn.jsp");
			rd.forward(req, resp);
		}
	}
	public String encrycreptedPassword(String password) {
		String encryptedPassword = "";
		for(int i=0;i<password.length();i++) {
			encryptedPassword = encryptedPassword + (char)(password.codePointAt(i)+43);
		}
		return encryptedPassword;
	}
	public String encryptedUserName(String userName) {
		String encryptedUsername = "";
		for(int i =0;i<userName.length();i++) {
			 encryptedUsername = encryptedUsername + (char)(userName.codePointAt(i)+52);
		}
		return encryptedUsername;
	}
}
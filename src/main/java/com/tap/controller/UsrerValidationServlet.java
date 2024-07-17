package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImp.UserDaoImpl;
import com.tap.model.User;

@WebServlet("/UserValidation")
public class UsrerValidationServlet extends HttpServlet {
	static int count =3;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Current time is "+now);
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		session.setAttribute("userName", userName);
		String decreptedUserName = decryptedUserName(userName);
		String decryptedPassword = decryptedPassword(password);
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User userNamePassword = null;
		userNamePassword = userDaoImpl.getUserNamePassword(decreptedUserName, decryptedPassword);
		if(userNamePassword!= null) {
			System.out.println(userNamePassword.getRole()+" Role");
		}
		if(userNamePassword != null && userNamePassword.getRole().equals("Admin")) {
			userDaoImpl.updateLastLogin(now, userNamePassword.getUserId());
			User user = userDaoImpl.getUser(userNamePassword.getUserId()) ;
			System.out.println("UserId "+ user.getUserId());
			System.out.println("User Name "+ user.getUserName());
			session.setAttribute("user", user);
			
//			session.setAttribute("userId", userNamePassword.getUserId());
//			session.setAttribute("role", userNamePassword.getRole());
//			session.setAttribute("userName", userName);
			session.setAttribute("login_success", "login_success");
			RequestDispatcher rd = req.getRequestDispatcher("Admin.jsp");
			rd.forward(req, resp);
		}
		else if(userNamePassword != null && userNamePassword.getRole().equals("Viewer")) {
			userDaoImpl.updateLastLogin(now, userNamePassword.getUserId());
			User user = userDaoImpl.getUser(userNamePassword.getUserId()) ;
			session.setAttribute("user", user);
			
//			session.setAttribute("userId", userNamePassword.getUserId());
//			session.setAttribute("role", userNamePassword.getRole());
//			session.setAttribute("userName", userName);
			session.setAttribute("login_success", "login_success");
			RequestDispatcher rd = req.getRequestDispatcher("Viewer.jsp");
			rd.forward(req, resp);
		}else if(userNamePassword == null && count>0) {
			resp.setContentType("text/html");
			session.setAttribute("count", count);
			count--;
			RequestDispatcher rd = req.getRequestDispatcher("SignIn.jsp");
			rd.forward(req, resp);
		}
		else {
			resp.sendRedirect("Contact_Admin.jsp");
		}
	}
	public String decryptedPassword(String password) {
		String decryptedPassword = "";
		for(int i=0;i<password.length();i++) {
			decryptedPassword = decryptedPassword + (char)(password.codePointAt(i)+43);
		}
		return decryptedPassword;
	}
	public  String decryptedUserName(String userName) {
		String decryptedUsername = "";
		for(int i =0;i<userName.length();i++) {
			 decryptedUsername = decryptedUsername + (char)(userName.codePointAt(i)+52);
		}
		return decryptedUsername;
	}
}


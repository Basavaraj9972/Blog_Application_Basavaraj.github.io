package com.tap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImp.BlogDaoImpl;

@WebServlet("/DeleteBlogSevlet")
public class DeleteBlogSevlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int blogId = Integer.parseInt(req.getParameter("blogId"));
		BlogDaoImpl blogDaoImpl = new BlogDaoImpl();
		int deleteBlogRecord = blogDaoImpl.deleteBlog(blogId);
		if(deleteBlogRecord>=1) {
			session.setAttribute("deleted_Successfully", "deleted_Successfully");
			RequestDispatcher rd = req.getRequestDispatcher("Admin.jsp");
			rd.forward(req, resp);
		}
		else {
			resp.setContentType("text/html");
			session.setAttribute("Problem_occur_try_Again", "Problem_occur_try_Again");
			RequestDispatcher rd = req.getRequestDispatcher("deleteBlog.jsp");
			rd.forward(req, resp);
		}
	}
}

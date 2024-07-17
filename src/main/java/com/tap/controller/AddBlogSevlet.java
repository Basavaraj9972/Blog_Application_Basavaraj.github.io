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
import com.tap.model.Blog;

@WebServlet("/AddBlogSevlet")
public class AddBlogSevlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String image_video = req.getParameter("image_video");
		int userId = Integer.parseInt(req.getParameter("userId"));
		BlogDaoImpl blogDaoImpl = new BlogDaoImpl();
		Blog blog = new Blog(title,content,image_video,userId);
		int recordUpdated = blogDaoImpl.addBlog(blog);
		if(recordUpdated>0) {
			session.setAttribute("added_Successfully", "added_Successfully");
			RequestDispatcher rd = req.getRequestDispatcher("Admin.jsp");
			rd.forward(req, resp);
		}
		else {
			resp.setContentType("text/html");
			session.setAttribute("Problem_occur_try_Again", "Problem_occur_try_Again");
			RequestDispatcher rd = req.getRequestDispatcher("Add.jsp");
			rd.forward(req, resp);
		}
//		System.out.println("title : "+title);
//		System.out.println("content : "+content);
//		System.out.println("image_video : "+image_video);
//		System.out.println("userId : "+userId);
		
		
	}
}

package com.tap.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImp.BlogDaoImpl;
import com.tap.model.Blog;

@WebServlet("/UpdateBlogSevlet")
public class UpdateBlogSevlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String image_video = req.getParameter("image_video");
		int userId = Integer.parseInt(req.getParameter("userId"));
		int blogId = Integer.parseInt(req.getParameter("blogId"));
		LocalDateTime now = LocalDateTime.now();
		boolean edit = true;
		BlogDaoImpl blogDaoImpl = new BlogDaoImpl();
		Blog blog = new Blog(blogId,title,content,image_video,now,edit,userId);
		int recordUpdated = blogDaoImpl.updateBlog(blog);
		if(recordUpdated>0) {
			session.setAttribute("updated_Successfully", "updated_Successfully");
			RequestDispatcher rd = req.getRequestDispatcher("Admin.jsp");
			rd.forward(req, resp);
		}
		else {
			resp.setContentType("text/html");
			session.setAttribute("Problem_occur_try_Again", "Problem_occur_try_Again");
			RequestDispatcher rd = req.getRequestDispatcher("updateBlog.jsp");
			rd.forward(req, resp);
		}
	}
	
}

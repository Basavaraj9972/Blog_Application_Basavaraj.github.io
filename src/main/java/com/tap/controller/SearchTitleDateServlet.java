package com.tap.controller;

import java.io.IOException;
import java.sql.Timestamp;
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

@WebServlet("/SearchTitleDateServlet")
public class SearchTitleDateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String TitleorDate = req.getParameter("TitleorDate");
		String blogSearchInformation = req.getParameter("blogSearch");
		BlogDaoImpl blogDaoImpl = new BlogDaoImpl();
		HttpSession session = req.getSession();
		if(TitleorDate.equals("date")) {
			Timestamp localDate = Timestamp.valueOf(blogSearchInformation);
//			LocalDateTime localDate = LocalDateTime.parse(blogSearchInformation);
			Blog blogInformation = blogDaoImpl.getBlogByBlogCreatedDate(localDate);
			session.setAttribute("blogInformation", blogInformation);
			RequestDispatcher rd = req.getRequestDispatcher("DisplayBlog.jsp");
			rd.forward(req, resp);
//			System.out.print(localDate);
//			System.out.print(blogSearchInformation);
//			System.out.print(blogByBlogCreatedDate.getTitle());
		}
		else if(TitleorDate.equals("title")) {
			Blog blogInformation = blogDaoImpl.getBlogByBlogTitle(blogSearchInformation);
			session.setAttribute("blogInformation", blogInformation);
			RequestDispatcher rd = req.getRequestDispatcher("DisplayBlog.jsp");
			rd.forward(req, resp);
//			System.out.println(blogByBlogTitle.getTitle()+" Title");
		}
	}
}

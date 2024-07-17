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

import com.tap.dao.BlogDao;
import com.tap.model.Blog;

public class BlogDaoImpl implements BlogDao{
	Connection con = null;
	
	String INSERT_QUERY ="insert into `blog`(`title`,`contents`,`image_video`, `userId`) values(?,?,?,?)";
	String SELECT_QUERY_BLOGID ="select * from `blog` where `blogId` =?";
	String SELECT_QUERY_TITLE ="select * from `blog` where `title` =?";
	String SELECT_QUERY_CREATED_DATE ="select * from `blog` where `createdDate` =?";
	String UPDATE_QUERY ="update `blog` set `title`=?,`contents`=?,`image_video`=?,`updatedDate`=?,`edit`=?,`userId`=? where `blogId`=?";
	String DELETE_QUERY ="delete from `blog` where `blogId`=?";
	String SELECT_ALL_QUERY ="select * from `blog`";
	
	public BlogDaoImpl() {
		try {
			String url = "jdbc:mysql://localhost:3306/blogapplication";
			String username = "root";
			String password = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loded BlogApplication ");
			con = DriverManager.getConnection(url, username,password);
			System.out.println("Data base connectivity is established BlogApplication");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int addBlog(Blog blog) {
		int recordUpdated =0;
		try {
			PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setString(1,blog.getTitle());
			pstmt.setString(2,blog.getContents());
			pstmt.setString(3,blog.getImage_Video());
			pstmt.setInt(4,blog.getUserId());
			recordUpdated = pstmt.executeUpdate();
			System.out.println(recordUpdated);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recordUpdated;
	}

	@Override
	public int updateBlog(Blog blog) {
		int updateRecord =0;
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, blog.getTitle());
			pstmt.setString(2, blog.getContents());
			pstmt.setString(3, blog.getImage_Video());
			pstmt.setTimestamp(4, Timestamp.valueOf(blog.getUpdatedDate()));
			pstmt.setBoolean(5, blog.isEdit());
			pstmt.setInt(6, blog.getUserId());
			pstmt.setInt(7, blog.getBlogId());
			updateRecord = pstmt.executeUpdate();
			System.out.println(updateRecord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateRecord;
	}

	@Override
	public int deleteBlog(int blogId) {
		int  deletedRecords = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, blogId);
			deletedRecords = pstmt.executeUpdate();
			System.out.println(deletedRecords);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deletedRecords;
	}

	@Override
	public List<Blog> getAllUser() {
		ArrayList<Blog> list = new ArrayList<Blog>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
			while(rs.next()) {
				int blogId = rs.getInt("blogId");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String image_Audio = rs.getString("image_video");
				Timestamp createdDateTs = rs.getTimestamp("createdDate");
				Timestamp updatedDateTs = rs.getTimestamp("updatedDate");
				boolean edit = rs.getBoolean("edit");
				int userId = rs.getInt("userId");
				LocalDateTime createdDate = createdDateTs.toLocalDateTime();
				LocalDateTime updatedDate = updatedDateTs.toLocalDateTime();
				Blog blog = new Blog(blogId,title,contents,image_Audio,createdDate,updatedDate,edit,userId);
				list.add(blog);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Blog getBlogByBlogId(int blogId) {
		Blog blog = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY_BLOGID);
			pstmt.setInt(1, blogId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String image_Audio = rs.getString("image_video");
				Timestamp createdDateTs = rs.getTimestamp("createdDate");
				Timestamp updatedDateTs = rs.getTimestamp("updatedDate");
				boolean edit = rs.getBoolean("edit");
				int userId = rs.getInt("userId");
				LocalDateTime createdDate = createdDateTs.toLocalDateTime();
				LocalDateTime updatedDate = updatedDateTs.toLocalDateTime();
				blog = new Blog(blogId,title,contents,image_Audio,createdDate,updatedDate,edit,userId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blog;
	}

	@Override
	public Blog getBlogByBlogTitle(String title) {
		Blog blog = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY_TITLE);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int blogId = rs.getInt("blogId");
				String contents = rs.getString("contents");
				String image_Audio = rs.getString("image_video");
				Timestamp createdDateTs = rs.getTimestamp("createdDate");
				Timestamp updatedDateTs = rs.getTimestamp("updatedDate");
				boolean edit = rs.getBoolean("edit");
				int userId = rs.getInt("userId");
				LocalDateTime createdDate = createdDateTs.toLocalDateTime();
				LocalDateTime updatedDate = updatedDateTs.toLocalDateTime();
				blog = new Blog(blogId,title,contents,image_Audio,createdDate,updatedDate,edit,userId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blog;
	}

	@Override
	public Blog getBlogByBlogCreatedDate(Timestamp createdDate) {
		Blog blog = null;
		Timestamp updatedDateTs = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY_CREATED_DATE);
			pstmt.setTimestamp(1, createdDate);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int blogId = rs.getInt("blogId");
				String title = rs.getString("title");				
				String contents = rs.getString("contents");
				String image_Audio = rs.getString("image_video");
				updatedDateTs = rs.getTimestamp("updatedDate");
				boolean edit = rs.getBoolean("edit");
				int userId = rs.getInt("userId");
				LocalDateTime updatedDate = updatedDateTs.toLocalDateTime();
				blog = new Blog(blogId,title,contents,image_Audio,createdDate.toLocalDateTime(),updatedDate,edit,userId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blog;
	}

}

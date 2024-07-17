package com.tap.dao;

import java.sql.Timestamp;
import java.util.List;

import com.tap.model.Blog;

public interface BlogDao {
	public int addBlog(Blog blog);
	public Blog getBlogByBlogId(int blogId);
	public Blog getBlogByBlogTitle(String title);
	public Blog getBlogByBlogCreatedDate(Timestamp createdDate);
	public int updateBlog(Blog blog);
	public int deleteBlog(int blogId);
	public List<Blog> getAllUser();

}

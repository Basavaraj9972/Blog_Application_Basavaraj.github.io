package com.tap.model;

import java.time.LocalDateTime;

public class Blog {
	private int blogId;
	private String title;
	private String contents;
	private String image_video;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private boolean edit;
	private int userId;
	
	public Blog() {

	}

	public Blog(int blogId, String title, String contents, String image_video, LocalDateTime createdDate,
			LocalDateTime updatedDate, boolean edit, int userId) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.contents = contents;
		this.image_video = image_video;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.edit = edit;
		this.userId = userId;
	}
	
	
	public Blog(int blogId, String title, String contents, String image_video, LocalDateTime updatedDate, boolean edit,
			int userId) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.contents = contents;
		this.image_video = image_video;
		this.updatedDate = updatedDate;
		this.edit = edit;
		this.userId = userId;
	}

	public Blog(String title, String contents, String image_video, int userId) {
		super();
		this.title = title;
		this.contents = contents;
		this.image_video = image_video;
		this.userId = userId;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getImage_Video() {
		return image_video;
	}

	public void setImage_Audio(String image_video) {
		this.image_video = image_video;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", title=" + title + ", contents=" + contents + ", image_Video=" + image_video
				+ ", createdDate=" + createdDate + ", edit=" + edit + ", userId=" + userId + "]";
	}
}

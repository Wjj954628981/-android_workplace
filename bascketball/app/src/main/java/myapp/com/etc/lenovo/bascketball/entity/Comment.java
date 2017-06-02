package myapp.com.etc.lenovo.bascketball.entity;

import java.io.Serializable;

public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//属性私有化
	private int user_id;
	private int news_id;
	private String comment_content;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	@Override
	public String toString() {
		return "Comment [user_id=" + user_id + ", news_id=" + news_id + ", comment_content=" + comment_content + "]";
	}
	
}

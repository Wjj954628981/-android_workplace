package myapp.com.etc.lenovo.bascketball.entity;

import java.io.Serializable;

public class News implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//属性私有化
	private int news_id;
	private String news_content;
	private String news_title;
	private String news_CategoryId;
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public String getNews_CategoryId() {
		return news_CategoryId;
	}
	public void setNews_CategoryId(String news_CategoryId) {
		this.news_CategoryId = news_CategoryId;
	}
	@Override
	public String toString() {
		return "News [news_id=" + news_id + ", news_content=" + news_content + ", news_title=" + news_title
				+ ", news_CategoryId=" + news_CategoryId + "]";
	}
	
}

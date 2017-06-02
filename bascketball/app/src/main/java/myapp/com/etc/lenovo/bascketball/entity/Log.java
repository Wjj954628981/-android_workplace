package myapp.com.etc.lenovo.bascketball.entity;

import java.io.Serializable;

public class Log implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//属性私有化
	private int log_id;
	private int user_id;
	private String coach_name;
	private String log_content;
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCoach_name() {
		return coach_name;
	}
	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}
	public String getLog_content() {
		return log_content;
	}
	public void setLog_content(String log_content) {
		this.log_content = log_content;
	}
	@Override
	public String toString() {
		return "Log [log_id=" + log_id + ", user_id=" + user_id + ", coach_name=" + coach_name + ", log_content="
				+ log_content + "]";
	}
	
}

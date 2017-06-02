package myapp.com.etc.lenovo.bascketball.entity;

import java.io.Serializable;

public class Coach implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//属性私有化
	private int coach_id;
	private int team_id;
	private String coach_name;
	private int age;
	private int coaching_time;
	public int getCoach_id() {
		return coach_id;
	}
	public void setCoach_id(int coach_id) {
		this.coach_id = coach_id;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getCoach_name() {
		return coach_name;
	}
	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCoaching_time() {
		return coaching_time;
	}
	public void setCoaching_time(int coaching_time) {
		this.coaching_time = coaching_time;
	}
	@Override
	public String toString() {
		return "Coach [coach_id=" + coach_id + ", team_id=" + team_id + ", coach_name=" + coach_name + ", age=" + age
				+ ", coaching_time=" + coaching_time + "]";
	}
	
}
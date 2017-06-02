package myapp.com.etc.lenovo.bascketball.entity;

import java.io.Serializable;

public class Follow implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//属性私有化
	private int user_id;
	private int team_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	@Override
	public String toString() {
		return "Follow [user_id=" + user_id + ", team_id=" + team_id + "]";
	}
	
}

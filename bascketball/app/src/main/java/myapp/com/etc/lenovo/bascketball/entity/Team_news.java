package myapp.com.etc.lenovo.bascketball.entity;

import java.io.Serializable;

public class Team_news implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//属性私有化
	private int team_id;
	private int news_id;
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	@Override
	public String toString() {
		return "Team_news [team_id=" + team_id + ", news_id=" + news_id + "]";
	}
}

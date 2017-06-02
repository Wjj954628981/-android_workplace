package myapp.com.etc.lenovo.bascketball.entity;

import java.io.Serializable;

public class Team implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//属性私有化
	private int team_id;
	private int league_id;
	private String team_name;
	private String team_introduce;
	private int play_num;
	private int champion_num;
	private String city;
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public int getLeague_id() {
		return league_id;
	}
	public void setLeague_id(int league_id) {
		this.league_id = league_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getTeam_introduce() {
		return team_introduce;
	}
	public void setTeam_introduce(String team_introduce) {
		this.team_introduce = team_introduce;
	}
	public int getPlay_num() {
		return play_num;
	}
	public void setPlay_num(int play_num) {
		this.play_num = play_num;
	}
	public int getChampion_num() {
		return champion_num;
	}
	public void setChampion_num(int champion_num) {
		this.champion_num = champion_num;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", league_id=" + league_id + ", team_name=" + team_name
				+ ", team_introduce=" + team_introduce + ", play_num=" + play_num + ", champion_num=" + champion_num
				+ ", city=" + city + "]";
	}
	
}

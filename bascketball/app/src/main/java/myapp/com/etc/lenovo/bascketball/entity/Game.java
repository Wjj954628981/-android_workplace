package myapp.com.etc.lenovo.bascketball.entity;

import java.io.Serializable;

public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//属性私有化
	private int game_id;
	private int team_id;
	private int match_id;
	private int game_time;
	private String game_location;
	
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public int getGame_time() {
		return game_time;
	}
	public void setGame_time(int game_time) {
		this.game_time = game_time;
	}
	public String getGame_location() {
		return game_location;
	}
	public void setGame_location(String game_location) {
		this.game_location = game_location;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public int getMatch_id() {
		return match_id;
	}
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	@Override
	public String toString() {
		return "Game [game_id=" + game_id + ", team_id=" + team_id + ", match_id=" + match_id + ", game_time="
				+ game_time + ", game_location=" + game_location + "]";
	}

	
}

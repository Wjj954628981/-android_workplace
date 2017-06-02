package myapp.com.etc.lenovo.bascketball.entity;

import java.io.Serializable;

public class League implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//属性私有化
	private int league_id;
	private String league_name;
	private String league_introduce;
	private String league_location;
	public int getLeague_id() {
		return league_id;
	}
	public void setLeague_id(int league_id) {
		this.league_id = league_id;
	}
	public String getLeague_name() {
		return league_name;
	}
	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}
	public String getLeague_introduce() {
		return league_introduce;
	}
	public void setLeague_introduce(String league_introduce) {
		this.league_introduce = league_introduce;
	}
	public String getLeague_location() {
		return league_location;
	}
	public void setLeague_location(String league_location) {
		this.league_location = league_location;
	}
	@Override
	public String toString() {
		return "League [league_id=" + league_id + ", league_name=" + league_name + ", league_introduce="
				+ league_introduce + ", league_location=" + league_location + "]";
	}
	

}

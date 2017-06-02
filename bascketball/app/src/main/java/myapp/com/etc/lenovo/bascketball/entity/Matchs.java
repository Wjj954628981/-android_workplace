package myapp.com.etc.lenovo.bascketball.entity;

import java.io.Serializable;

public class Matchs implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//属性私有化
	private int match_id;
	private int league_id;
	private int match_CategoryId;
	private String match_name;
	public int getMatch_id() {
		return match_id;
	}
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	public int getLeague_id() {
		return league_id;
	}
	public void setLeague_id(int league_id) {
		this.league_id = league_id;
	}
	public int getMatch_CategoryId() {
		return match_CategoryId;
	}
	public void setMatch_CategoryId(int match_CategoryId) {
		this.match_CategoryId = match_CategoryId;
	}
	public String getMatch_name() {
		return match_name;
	}
	public void setMatch_name(String match_name) {
		this.match_name = match_name;
	}
	@Override
	public String toString() {
		return "Matchs [match_id=" + match_id + ", league_id=" + league_id + ", match_CategoryId=" + match_CategoryId
				+ ", match_name=" + match_name + "]";
	}
	
}

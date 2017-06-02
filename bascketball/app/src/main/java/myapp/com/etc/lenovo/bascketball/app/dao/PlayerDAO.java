package myapp.com.etc.lenovo.bascketball.app.dao;

import java.util.List;

import myapp.com.etc.lenovo.bascketball.entity.Player;

public interface PlayerDAO {
	
	List<Player> queryAll();

	List<Player> query(String player_name);

	List<Player> queryTeam(int team_id); 
}

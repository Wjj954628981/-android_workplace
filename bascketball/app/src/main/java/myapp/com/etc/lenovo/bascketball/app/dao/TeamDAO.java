package myapp.com.etc.lenovo.bascketball.app.dao;

import java.util.List;

import myapp.com.etc.lenovo.bascketball.entity.Team;

public interface TeamDAO {

	List<Team> query(String team_name);

	List<Team> queryLeague(int league_id);

}

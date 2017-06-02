package myapp.com.etc.lenovo.bascketball.app.dao;

import java.util.List;

import myapp.com.etc.lenovo.bascketball.entity.League;

public interface LeagueDAO {

	List<League> query(String league_name);

}

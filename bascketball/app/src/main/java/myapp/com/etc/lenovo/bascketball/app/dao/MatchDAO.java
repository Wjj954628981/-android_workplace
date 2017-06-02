package myapp.com.etc.lenovo.bascketball.app.dao;

import java.util.List;

import myapp.com.etc.lenovo.bascketball.entity.Matchs;

public interface MatchDAO {

	List<Matchs> queryLeague(int league_id);

}

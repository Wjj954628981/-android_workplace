package myapp.com.etc.lenovo.bascketball.app.dao;

import java.util.List;

import myapp.com.etc.lenovo.bascketball.entity.Game;

public interface GameDAO {

	List<Game> queryMatch(int match_id);

}

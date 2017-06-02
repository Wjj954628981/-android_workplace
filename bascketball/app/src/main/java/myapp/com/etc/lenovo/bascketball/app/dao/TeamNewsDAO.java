package myapp.com.etc.lenovo.bascketball.app.dao;

import java.util.List;

import myapp.com.etc.lenovo.bascketball.entity.Team_news;

public interface TeamNewsDAO {

	List<Team_news> query(int team_id);

}

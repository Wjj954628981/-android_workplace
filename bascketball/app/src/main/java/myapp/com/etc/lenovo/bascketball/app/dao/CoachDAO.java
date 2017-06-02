package myapp.com.etc.lenovo.bascketball.app.dao;

import java.util.List;

import myapp.com.etc.lenovo.bascketball.entity.Coach;

public interface CoachDAO {

	List<Coach> query(int team_id);

}

package myapp.com.etc.lenovo.bascketball.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myapp.com.etc.lenovo.bascketball.app.dao.TeamNewsDAO;
import myapp.com.etc.lenovo.bascketball.dbutil.DBManager;
import myapp.com.etc.lenovo.bascketball.entity.Team_news;

public class TeamNewsDAOImpl implements TeamNewsDAO {
	
	private DBManager dbManager = new DBManager();
	@Override
	public List<Team_news> query(int team_id) {
		// TODO Auto-generated method stub
		String sql = "select * from team——news where team_id = ? ";

		ResultSet rs = dbManager.execQuery(sql);
		
		List<Team_news> list = new ArrayList<Team_news>();
		try {
			while(rs.next()){   //找到
				
				//创建并填充实体bean
				Team_news team_news = new Team_news();
				team_news.setNews_id(rs.getInt(1));
				list.add(team_news);		
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		} finally{
			dbManager.closeConnection();
		}
		return null;
	}

}

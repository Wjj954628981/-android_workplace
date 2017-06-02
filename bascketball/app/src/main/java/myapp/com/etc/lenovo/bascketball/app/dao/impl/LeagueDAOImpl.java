package myapp.com.etc.lenovo.bascketball.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myapp.com.etc.lenovo.bascketball.app.dao.LeagueDAO;
import myapp.com.etc.lenovo.bascketball.dbutil.DBManager;
import myapp.com.etc.lenovo.bascketball.entity.League;

public class LeagueDAOImpl implements LeagueDAO {
	
	private DBManager dbManager = new DBManager();
	
	@Override
	public List<League> query(String league_name) {
		// TODO Auto-generated method stub
		String sql = "select * from league where league_name =  ? ";

		ResultSet rs = dbManager.execQuery(sql);
		
		List<League> list = new ArrayList<League>();
		
		try {
			while(rs.next()){   //找到
				League league = new League();
				league.setLeague_name(rs.getString(1));
				league.setLeague_introduce(rs.getString(2));
				league.setLeague_location(rs.getString(3));
				list.add(league);
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

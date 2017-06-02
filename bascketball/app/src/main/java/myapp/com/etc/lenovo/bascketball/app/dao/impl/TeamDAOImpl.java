package myapp.com.etc.lenovo.bascketball.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myapp.com.etc.lenovo.bascketball.app.dao.TeamDAO;
import myapp.com.etc.lenovo.bascketball.dbutil.DBManager;
import myapp.com.etc.lenovo.bascketball.entity.Team;

public class TeamDAOImpl implements TeamDAO {
	
	private DBManager dbManager = new DBManager();
	@Override
	public List<Team> query(String team_name) {
		// TODO Auto-generated method stub
		String sql = "select * from team where team_name = ? ";

		ResultSet rs = dbManager.execQuery(sql);
		
		List<Team> list = new ArrayList<Team>();
		try {
			while(rs.next()){   //找到
				
				//创建并填充实体bean
				Team team = new Team();
				team.setLeague_id(rs.getInt(1));
				team.setTeam_name(rs.getString(2));
				team.setCity(rs.getString(3));
				team.setChampion_num(rs.getInt(4));
				team.setTeam_introduce(rs.getString(5));
				team.setPlay_num(rs.getInt(6));

				list.add(team);		
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		} finally{
			dbManager.closeConnection();
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Team> queryLeague(int league_id) {
		// TODO Auto-generated method stub
		String sql = "select * from team where league_id = ? ";

		ResultSet rs = dbManager.execQuery(sql);
		
		List<Team> list = new ArrayList<Team>();
		try {
			while(rs.next()){   //找到
				
				//创建并填充实体bean
				Team team = new Team();
				team.setLeague_id(rs.getInt(1));
				team.setTeam_name(rs.getString(2));
				team.setCity(rs.getString(3));
				team.setChampion_num(rs.getInt(4));
				team.setTeam_introduce(rs.getString(5));
				team.setPlay_num(rs.getInt(6));

				list.add(team);		
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

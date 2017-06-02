package myapp.com.etc.lenovo.bascketball.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myapp.com.etc.lenovo.bascketball.app.dao.PlayerDAO;
import myapp.com.etc.lenovo.bascketball.dbutil.DBManager;
import myapp.com.etc.lenovo.bascketball.entity.Player;

public class PlayerDAOImpl implements PlayerDAO {
	
	private DBManager dbManager = new DBManager();
	
	@Override
	public List<Player> queryAll() {
		
		String sql = "select * from player";

		ResultSet rs = dbManager.execQuery(sql);
		
		List<Player> list = new ArrayList<Player>();
		try {
			while(rs.next()){   //找到
				
				//创建并填充实体bean
				Player player = new Player();
				player.setPlayer_id(rs.getInt(1));
				player.setPlayer_name(rs.getString(2));
				player.setCoach_name(rs.getString(3));
				player.setAge(rs.getInt(4));
				player.setWeight(rs.getInt(5));
				player.setPosition(rs.getString(6));
				player.setHeight(rs.getInt(7));
				
				list.add(player);		
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
	public List<Player> query(String player_name) {
		// TODO Auto-generated method stub
		String sql = "select * from player where player_name like ? ";

		ResultSet rs = dbManager.execQuery(sql);
		
		List<Player> list = new ArrayList<Player>();
		try {
			while(rs.next()){   //找到
				
				//创建并填充实体bean
				Player player = new Player();
				player.setPlayer_id(rs.getInt(1));
				player.setPlayer_name(rs.getString(2));
				player.setCoach_name(rs.getString(3));
				player.setAge(rs.getInt(4));
				player.setWeight(rs.getInt(5));
				player.setPosition(rs.getString(6));
				player.setHeight(rs.getInt(7));
				
				list.add(player);		
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		} finally{
			dbManager.closeConnection();
		}
		return null;
	}

	@Override
	public List<Player> queryTeam(int team_id) {
		// TODO Auto-generated method stub
		String sql = "select * from player where team_id =  ? ";

		ResultSet rs = dbManager.execQuery(sql);
		
		List<Player> list = new ArrayList<Player>();
		try {
			while(rs.next()){   //找到
				
				//创建并填充实体bean
				Player player = new Player();
				player.setPlayer_id(rs.getInt(1));
				player.setPlayer_name(rs.getString(2));
				player.setCoach_name(rs.getString(3));
				player.setAge(rs.getInt(4));
				player.setWeight(rs.getInt(5));
				player.setPosition(rs.getString(6));
				player.setHeight(rs.getInt(7));
				
				list.add(player);		
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

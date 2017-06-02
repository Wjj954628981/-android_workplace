package myapp.com.etc.lenovo.bascketball.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myapp.com.etc.lenovo.bascketball.app.dao.GameDAO;
import myapp.com.etc.lenovo.bascketball.dbutil.DBManager;
import myapp.com.etc.lenovo.bascketball.entity.Game;

public class GameDAOImpl implements GameDAO {

	private DBManager dbManager = new DBManager();
	
	@Override
	public List<Game> queryMatch(int match_id) {
		// TODO Auto-generated method stub
		String sql = "select * from Game where match_id =  ? ";

		ResultSet rs = dbManager.execQuery(sql);
		
		List<Game> list = new ArrayList<Game>();
		
		try {
			while(rs.next()){   //找到
				
				//创建并填充实体bean
				Game game = new Game();
				game.setTeam_id(rs.getInt(1));
				game.setGame_location(rs.getString(2));
				game.setGame_time(rs.getInt(3));
				list.add(game);		
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

package myapp.com.etc.lenovo.bascketball.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myapp.com.etc.lenovo.bascketball.app.dao.MatchDAO;
import myapp.com.etc.lenovo.bascketball.dbutil.DBManager;
import myapp.com.etc.lenovo.bascketball.entity.Matchs;

public class MatchDAOImpl implements MatchDAO {

	private DBManager dbManager = new DBManager();
	
	@Override
	public List<Matchs> queryLeague(int league_id) {
		// TODO Auto-generated method stub
		String sql = "select * from Matchs where league_id =  ? ";

		ResultSet rs = dbManager.execQuery(sql);
		
		List<Matchs> list = new ArrayList<Matchs>();
		
		try {
			while(rs.next()){   //找到
				
				//创建并填充实体bean
				Matchs matchs = new Matchs();
				matchs.setMatch_id(rs.getInt(1));
				matchs.setMatch_CategoryId(rs.getInt(2));
				matchs.setMatch_name(rs.getString(3));				
				list.add(matchs);		
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

package myapp.com.etc.lenovo.bascketball.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myapp.com.etc.lenovo.bascketball.app.dao.CoachDAO;
import myapp.com.etc.lenovo.bascketball.dbutil.DBManager;
import myapp.com.etc.lenovo.bascketball.entity.Coach;

public class CoachDAOImpl implements CoachDAO {
	private DBManager dbManager = new DBManager();
	@Override
	public List<Coach> query(int team_id) {
		// TODO Auto-generated method stub
		String sql = "select * from coach where team_id =  ? ";

		ResultSet rs = dbManager.execQuery(sql);
		
		List<Coach> list = new ArrayList<Coach>();
		try {
			while(rs.next()){   //找到
				
				//创建并填充实体bean
				Coach coach = new Coach();
				coach.setCoach_name(rs.getString(1));
				coach.setAge(rs.getInt(2));
				coach.setCoaching_time(rs.getInt(3));
				list.add(coach);		
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

}

package myapp.com.etc.lenovo.bascketball.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import myapp.com.etc.lenovo.bascketball.app.dao.UserDAO;
import myapp.com.etc.lenovo.bascketball.dbutil.DBManager;
import myapp.com.etc.lenovo.bascketball.entity.User;

public class UserDAOImpl implements UserDAO {
	private DBManager dbManager = new DBManager();
	@Override
	public User findUser(String user_name, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from user where user_name = ? and password = ?";
		
		ResultSet rs = dbManager.execQuery(sql, user_name, password);
		
		try {
			if(rs.next()){   //找到				
				//创建并填充实体bean
				User user = new User(); 
				user.setUser_id(rs.getInt(1));
				user.setUser_name(rs.getString(2));
				user.setAvatar(rs.getString(3));
				return user;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		} finally{
			dbManager.closeConnection();
		}
		
		return null;
		
	}
	
	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user values(null,?,?,null,null,null,null)";	

		return dbManager.execUpdate(sql,user.getUser_name(), user.getPassword())>0; 
	}
	
	@Override
	public boolean updateUser(int user_id, String user_name, String password, String avatar, String sex, int phone,
			int birthday) {
		// TODO Auto-generated method stub
		String updateUser_name = " update user set user_name = ? where userid = "+ user_id +"" ;
		
		String updatePassword  = " update user set password = ? where userid = "+ user_id+"" ;
		
		String updateAvatar = " update user set avatar = ? where userid = "+ user_id+"" ;
		
		String updateSex = " update user set sex = ? where userid = "+ user_id +"" ;
		
		String updatePhone = " update user set phone = ? where userid = "+ user_id +"" ;
		
		String updateBirthday = " update user set birthday = ? where userid = "+ user_id +"" ;
		
		dbManager.execUpdate( updateUser_name , user_name);
		
		dbManager.execUpdate( updatePassword , password);
		
		dbManager.execUpdate( updateAvatar , avatar);
		
		dbManager.execUpdate( updateSex , sex);
		
		dbManager.execUpdate(updatePhone, phone);
		
		dbManager.execUpdate(updateBirthday, birthday);
		
		return true;
	}

}

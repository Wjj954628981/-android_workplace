package myapp.com.etc.lenovo.bascketball.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myapp.com.etc.lenovo.bascketball.app.dao.NewsDAO;
import myapp.com.etc.lenovo.bascketball.dbutil.DBManager;
import myapp.com.etc.lenovo.bascketball.entity.News;

public class NewsDAOImpl implements NewsDAO {
	
	private DBManager dbManager = new DBManager();
	
	@Override
	public List<News> querylabel(int news_CategoryId) {
		// TODO Auto-generated method stub
		String sql = "select * from news where  news_CategoryId =  ? ";

		ResultSet rs = dbManager.execQuery(sql);
		
		List<News> list = new ArrayList<News>();
		try {
			while(rs.next()){   //找到
				
				//创建并填充实体bean
				News news = new News();
				news.setNews_id(rs.getInt(1));
				news.setNews_content(rs.getString(2));
				news.setNews_title(rs.getString(3));
				
				list.add(news);		
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

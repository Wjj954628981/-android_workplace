package myapp.com.etc.lenovo.bascketball.app.dao;

import java.util.List;

import myapp.com.etc.lenovo.bascketball.entity.News;

public interface NewsDAO {

	List<News> querylabel(int news_CategoryId);

}

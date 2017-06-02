package myapp.com.etc.lenovo.bascketball.app.dao;

import myapp.com.etc.lenovo.bascketball.entity.User;

public interface UserDAO {

	User findUser(String user_name, String password);

	boolean insertUser(User user);

	boolean updateUser(int user_id, String user_name, String password, String avatar, String sex, int phone,
			int birthday);

}

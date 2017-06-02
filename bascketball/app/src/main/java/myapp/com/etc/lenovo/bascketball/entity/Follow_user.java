package myapp.com.etc.lenovo.bascketball.entity;

import java.io.Serializable;

public class Follow_user implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//属性私有化
	private int user_id;
	private int use_user_id;
	public int getUse_user_id() {
		return use_user_id;
	}
	public void setUse_user_id(int use_user_id) {
		this.use_user_id = use_user_id;
	}
	@Override
	public String toString() {
		return "Follow_user [user_id=" + user_id + ", use_user_id=" + use_user_id + "]";
	}
	
}

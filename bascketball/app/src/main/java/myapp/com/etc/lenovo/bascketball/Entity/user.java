package myapp.com.etc.lenovo.bascketball.Entity;

/**
 * Created by lenovo on 2017/4/23.
 */
public class user {
    private int user_id;
    private String user_name;
    private String password;
    private String avatar;
    private String sex;
    private int phone;
    private int birthday;

    public user() {
    }

    public user(int user_id, String user_name, String password, String avatar, String sex, int phone, int birthday) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.avatar = avatar;
        this.sex = sex;
        this.phone = phone;
        this.birthday = birthday;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public int getBirthday() {
        return birthday;
    }

    public int getPhone() {
        return phone;
    }

    public String getSex() {
        return sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }
}

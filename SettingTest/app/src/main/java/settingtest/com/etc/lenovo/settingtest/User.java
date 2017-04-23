package settingtest.com.etc.lenovo.settingtest;

import android.app.Application;

public class User extends Application {
    private String Username;

    public User(){}

    public User(String username) {
        Username = username;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}

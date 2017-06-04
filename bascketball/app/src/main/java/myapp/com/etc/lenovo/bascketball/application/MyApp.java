package myapp.com.etc.lenovo.bascketball.application;

import android.app.Application;

import myapp.com.etc.lenovo.bascketball.entity.User;

/**
 * Created by jason on 2017/6/2.
 */

public class MyApp extends Application {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

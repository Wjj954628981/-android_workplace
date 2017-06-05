package myapp.com.etc.lenovo.bascketball.model;

/**
 * Created by jason on 2017/6/5.
 */

public class MyTeam {
    private String name;//新闻名
    private int imageId;//图片的资源id

    //
    public MyTeam(){};

    //
    public MyTeam(String name,int imageId) {
        this.name = name;
        this.imageId = imageId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

}

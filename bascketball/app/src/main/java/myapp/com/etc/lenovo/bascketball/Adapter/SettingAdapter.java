package myapp.com.etc.lenovo.bascketball.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import myapp.com.etc.lenovo.bascketball.R;
import myapp.com.etc.lenovo.bascketball.model.MyTeam;

/**
 * Created by jason on 2017/6/5.
 */





public class SettingAdapter extends ArrayAdapter<MyTeam> {

    private int resourceId;
    public SettingAdapter(Context context, int textViewResourceId,
                         List<MyTeam> objects) {
        super(context, textViewResourceId, objects);
        // TODO Auto-generated constructor stub
		/*
		 * 重写了父类的构造函数，用于将上下文，ListView子项布局的id和数据都传进来。
		 * */
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        //return super.getView(position, convertView, parent);
		/*
		 * 重写getView方法，这个方法在每个子项被滚动到屏幕内的时候会被调用，在getView方法中
		 * ，首先通过getItem方法得到当前项的实例，然后使用LayoutInflater来为这个子项加载
		 * 我们传入的布局，接着调用View的findViewById方法分别获取到ImageView和TextView的实例，
		 * 并分别调用他们的setImageResource和setText方法来设置显示的图片和文字，最后返回布局
		 * */
        MyTeam myTeam = getItem(position);//获取当前项的Fruit实例
        //初始话ListView的子项布局
        View view= LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView MyTeamImage=(ImageView) view.findViewById(R.id.MT3_img);
        TextView MyTeamName=(TextView) view.findViewById(R.id.MT3_name);
        MyTeamImage.setImageResource(myTeam.getImageId());
        MyTeamName.setText(myTeam.getName());
        return view;
    }




}
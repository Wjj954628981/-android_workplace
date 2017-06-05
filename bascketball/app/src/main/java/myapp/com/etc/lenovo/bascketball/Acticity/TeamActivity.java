package myapp.com.etc.lenovo.bascketball.Acticity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import myapp.com.etc.lenovo.bascketball.Adapter.MyTeamAdapter;
import myapp.com.etc.lenovo.bascketball.R;
import myapp.com.etc.lenovo.bascketball.model.MyTeam;

public class TeamActivity extends AppCompatActivity {

//    private String newstitle[]={"中国男篮两队赛事：红队打斯杯 蓝队战亚洲杯",
//            "苏群：篮球场就是篮球场 广场舞应适可而止",
//            "曝郭艾伦有可能代表76人出战夏季联赛",
//            "尤纳斯:现有阵容像青年队 将减少阿联出场时间",
//            "陈江华出任广东助教 当年也是尤纳斯慧眼识珠",};

    private List<MyTeam> my_team_list=new ArrayList<MyTeam>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        init_MyTeam();
        MyTeamAdapter adapter=new MyTeamAdapter(TeamActivity.this, R.layout.mt_item, my_team_list);
        ListView listView=(ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.team_toolbar);
        toolbar.setTitle("我的球队");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void init_MyTeam(){
        MyTeam news1 = new MyTeam("中国男篮两队赛事：红队打斯杯 蓝队战亚洲杯",R.drawable.p1);
        my_team_list.add(news1);
        MyTeam news2 = new MyTeam("苏群：篮球场就是篮球场 广场舞应适可而止",R.drawable.p2);
        my_team_list.add(news2);
        MyTeam news3 = new MyTeam("曝郭艾伦有可能代表76人出战夏季联赛",R.drawable.p3);
        my_team_list.add(news3);
        MyTeam news4 = new MyTeam("尤纳斯:现有阵容像青年队 将减少阿联出场时间",R.drawable.p4);
        my_team_list.add(news4);
        MyTeam news5 = new MyTeam("陈江华出任广东助教 当年也是尤纳斯慧眼识珠",R.drawable.p5);
        my_team_list.add(news5);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu, menu);
//        return true;
//    }
}

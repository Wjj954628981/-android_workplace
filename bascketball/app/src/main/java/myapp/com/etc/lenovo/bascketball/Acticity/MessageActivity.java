package myapp.com.etc.lenovo.bascketball.Acticity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import myapp.com.etc.lenovo.bascketball.Adapter.MyTeamNewsAdapter;
import myapp.com.etc.lenovo.bascketball.R;
import myapp.com.etc.lenovo.bascketball.model.MyTeam;

public class MessageActivity extends AppCompatActivity {

    private List<MyTeam> news_list=new ArrayList<MyTeam>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        init_MyTeam();
        MyTeamNewsAdapter adapter=new MyTeamNewsAdapter(MessageActivity.this, R.layout.mt2_item, news_list);
        ListView listView=(ListView) findViewById(R.id.listview2);
        listView.setAdapter(adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.message_toolbar);
        toolbar.setTitle("消息");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void init_MyTeam(){
        MyTeam news1 = new MyTeam("您关注的球队有最新消息，请及时查收",R.drawable.message);
        news_list.add(news1);
        MyTeam news2 = new MyTeam("震惊！中国男篮大变天！点击前往",R.drawable.message);
        news_list.add(news2);
        MyTeam news3 = new MyTeam("难以置信！网瘾少年参加选秀！点击前往",R.drawable.message);
        news_list.add(news3);
        MyTeam news4 = new MyTeam("您关注的球队有最新消息，请及时查收",R.drawable.message);
        news_list.add(news4);
        MyTeam news5 = new MyTeam("您关注的球队有最新消息，请及时查收",R.drawable.message);
        news_list.add(news5);
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
}

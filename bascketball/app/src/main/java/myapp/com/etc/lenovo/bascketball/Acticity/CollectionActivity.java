package myapp.com.etc.lenovo.bascketball.Acticity;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import myapp.com.etc.lenovo.bascketball.Adapter.CollectionAdapter;
import myapp.com.etc.lenovo.bascketball.R;
import myapp.com.etc.lenovo.bascketball.model.NewsInfo;

public class CollectionActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private CollectionAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        Toolbar toolbar = (Toolbar) findViewById(R.id.collection_toolbar);
        toolbar.setTitle("我的收藏");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
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

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //设置布局管理器为1列，纵向
        mLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

        mAdapter = new CollectionAdapter(this, buildData());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new CollectionAdapter.OnItemClickListener(){
            public void onItemClick(View view , int position){
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("newsid", ""+position);
                intent.setClass(CollectionActivity.this,NewsDetailActivity.class);
                intent.putExtras(bundle);
                Pair<View, String> pTitle = Pair.create(view.findViewById(R.id.CollectionImg),"Collections");
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(CollectionActivity.this,pTitle);
                ActivityCompat.startActivity(CollectionActivity.this,intent,compat.toBundle());
            }
        });
    }

    private List<NewsInfo> buildData() {

        String[] names = {
                "曝郭艾伦有可能代表76人出战夏季联赛",
                "尤纳斯:现有阵容像青年队 将减少阿联出场时间"
        };
        int[] imgUrs = {R.drawable.p3,R.drawable.p4};

        List<NewsInfo> list = new ArrayList<>();
        for(int i=0;i<2;i++) {
            NewsInfo p = new NewsInfo();
            p.imgUrl = imgUrs[i];
            p.Title = names[i];
            int max=1000;
            int min=500;
            Random random = new Random();

            int s = random.nextInt(max)%(max-min+1) + min;

            p.imgHeight = s;
            list.add(p);
        }
        return list;
    }
}

package cn.studyjams.s2.sj0119.UPlan;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.studyjams.s2.sj0119.UPlan.model.PlanInf;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton btnadd;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private CardAdapter mAdapter;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnadd = (FloatingActionButton)findViewById(R.id.btnAdd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AddPlanActivity.class);
                startActivity(intent);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //设置布局管理器为1列，纵向
        mLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mAdapter = new CardAdapter(this, buildData());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new CardAdapter.OnItemClickListener(){
            public void onItemClick(View view , int position){
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("PlanNum", ""+position);
                intent.setClass(MainActivity.this,PlanDetailActivity.class);
                intent.putExtras(bundle);
                Pair<View, String> pTitle = Pair.create(view.findViewById(R.id.PlanName),"plan");
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,pTitle);
                ActivityCompat.startActivity(MainActivity.this,intent,compat.toBundle());
            }
        });
    }

    private List<PlanInf> buildData() {

        String[] names = {"Plan1",
                "Plan2",
                "Plan3",
        };
        Map<Integer, String> Plandetail1 = new HashMap<Integer, String>();
        Plandetail1.put(1, "Step1 of Plan1");
        Plandetail1.put(2, "Step2 of Plan2");
        Plandetail1.put(3, "Step3 of Plan3");

        Map<Integer, String> Plandetail2 = new HashMap<Integer, String>();
        Plandetail2.put(1, "Step1 of Plan1");
        Plandetail2.put(2, "Step2 of Plan2");
        Plandetail2.put(3, "Step3 of Plan3");

        Map<Integer, String> Plandetail3 = new HashMap<Integer, String>();
        Plandetail3.put(1, "Step1 of Plan1");
        Plandetail3.put(2, "Step2 of Plan2");
        Plandetail3.put(3, "Step3 of Plan3");

        Map[] details = {Plandetail1,
                Plandetail2,
                Plandetail3};

        List<PlanInf> list = new ArrayList<PlanInf>();
        for(int i=0;i<2;i++) {
            PlanInf p = new PlanInf();
            p.PlanName = names[i];
            p.PlanDetail = details[i];
            list.add(p);
        }

        return list;
    }
}

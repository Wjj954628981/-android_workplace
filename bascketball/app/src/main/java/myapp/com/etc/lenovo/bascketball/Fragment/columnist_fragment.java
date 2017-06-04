package myapp.com.etc.lenovo.bascketball.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import myapp.com.etc.lenovo.bascketball.Acticity.NewsDetailActivity;
import myapp.com.etc.lenovo.bascketball.Adapter.CardAdapter;
import myapp.com.etc.lenovo.bascketball.R;
import myapp.com.etc.lenovo.bascketball.model.NewsInfo;

/**
 * Created by lenovo on 2017/4/21.
 */
public class columnist_fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private CardAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_columnist, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.recyclerview);
        //设置布局管理器为1列，纵向
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        mAdapter = new CardAdapter(this.getContext(), buildData());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new CardAdapter.OnItemClickListener(){
            public void onItemClick(View view , int position){
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("newsid", ""+position);
                intent.setClass(getActivity(),NewsDetailActivity.class);
                intent.putExtras(bundle);
                Pair<View, String> pTitle = Pair.create(view.findViewById(R.id.NewsImg),"News");
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),pTitle);
                ActivityCompat.startActivity(getActivity(),intent,compat.toBundle());
            }
        });
    }

    private List<NewsInfo> buildData() {

        String[] names = {"cba专栏","cuba专栏","cba专栏","nba专栏","cuba专栏","nba专栏","新泽西网专栏","吉林东北虎专栏","北京金隅专栏","萨克拉门托国王专栏"
        };
        int[] imgUrs = {R.drawable.p26,R.drawable.p28,R.drawable.p26,R.drawable.p27,R.drawable.p28,R.drawable.p27,R.drawable.p25,R.drawable.p20,R.drawable.p17,R.drawable.p22};

        List<NewsInfo> list = new ArrayList<>();
        for(int i=0;i<10;i++) {
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

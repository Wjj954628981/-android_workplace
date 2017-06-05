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
import myapp.com.etc.lenovo.bascketball.Adapter.FriendsAdapter;
import myapp.com.etc.lenovo.bascketball.R;
import myapp.com.etc.lenovo.bascketball.model.FriendsInfo;
import myapp.com.etc.lenovo.bascketball.model.NewsInfo;
/**
 * Created by lenovo on 2017/4/21.
 */
public class friends_fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FriendsAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friends, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }
    private void init() {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.recyclerview);
        //设置布局管理器为1列，纵向
        mLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

        mAdapter = new FriendsAdapter(this.getContext(), buildData());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
//        mAdapter.setOnItemClickListener(new FriendsAdapter.OnItemClickListener(){
//            public void onItemClick(View view , int position){
//                Intent intent = new Intent();
//                Bundle bundle = new Bundle();
//                bundle.putString("newsid", ""+position);
//                intent.setClass(getActivity(),NewsDetailActivity.class);
//                intent.putExtras(bundle);
//                Pair<View, String> pTitle = Pair.create(view.findViewById(R.id.NewsImg),"News");
//                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),pTitle);
//                ActivityCompat.startActivity(getActivity(),intent,compat.toBundle());
//            }
//        });
    }

    private List<FriendsInfo> buildData() {

        String[] names = {"李志伟",
                "刘天龙",
                "刘帆",
        };
        int[] imgUrs = {R.drawable.lizhiwei,R.drawable.liutianlong,R.drawable.liufan};

        List<FriendsInfo> list = new ArrayList<>();
        for(int i=0;i<3;i++) {
            FriendsInfo p = new FriendsInfo();
            p.imgUrl = imgUrs[i];
            p.Name = names[i];
            list.add(p);
        }
        return list;
    }
}

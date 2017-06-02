package myapp.com.etc.lenovo.bascketball.Fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import myapp.com.etc.lenovo.bascketball.Adapter.MyPagerAdapter;
import myapp.com.etc.lenovo.bascketball.R;

/**
 * Created by lenovo on 2017/4/21.
 */
public class main_fragment extends Fragment {

    private String[] tabTitleArray = {"头条","热门","赛事","圈子","集锦","专栏","NBA","CBA"};
    private List<Fragment> fragmentList = new ArrayList<Fragment>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //tablayout
        TabLayout tablayout = (TabLayout) getView().findViewById(R.id.tablayout);
        for(int i=0;i<tabTitleArray.length;i++){
            tablayout.addTab(tablayout.newTab().setText(tabTitleArray[i]));
        }
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        ViewPager viewPager = (ViewPager) getView().findViewById(R.id.viewpager);

        fragmentList.add(new topline_fragment());
        fragmentList.add(new hots_fragment());
        fragmentList.add(new matchs_fragment());
        fragmentList.add(new circle_fragment());
        fragmentList.add(new tournament_fragment());
        fragmentList.add(new columnist_fragment());
        fragmentList.add(new nba_fragment());
        fragmentList.add(new cba_fragment());

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager(),fragmentList,tabTitleArray);
        viewPager.setAdapter(myPagerAdapter);

        tablayout.setupWithViewPager(viewPager);
    }
}
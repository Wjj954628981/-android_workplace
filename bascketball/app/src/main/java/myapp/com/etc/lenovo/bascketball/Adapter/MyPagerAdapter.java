package myapp.com.etc.lenovo.bascketball.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lenovo on 2017/4/21.
 */
public class MyPagerAdapter extends FragmentPagerAdapter{

    private String[] tabTitleArray;
    private List<Fragment> fragmentList;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] tabTitleArray){
        super(fm);
        this.tabTitleArray = tabTitleArray;
        this.fragmentList = fragmentList;
    }
    @Override
    public int getCount() {
        return tabTitleArray.length;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitleArray[position % tabTitleArray.length];
    }
}

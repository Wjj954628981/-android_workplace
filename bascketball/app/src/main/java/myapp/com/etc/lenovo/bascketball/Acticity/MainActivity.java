package myapp.com.etc.lenovo.bascketball.Acticity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import myapp.com.etc.lenovo.bascketball.Adapter.MyPagerAdapter;
import myapp.com.etc.lenovo.bascketball.R;
import myapp.com.etc.lenovo.bascketball.Fragment.cba_fragment;
import myapp.com.etc.lenovo.bascketball.Fragment.circle_fragment;
import myapp.com.etc.lenovo.bascketball.Fragment.columnist_fragment;
import myapp.com.etc.lenovo.bascketball.Fragment.hots_fragment;
import myapp.com.etc.lenovo.bascketball.Fragment.matchs_fragment;
import myapp.com.etc.lenovo.bascketball.Fragment.nba_fragment;
import myapp.com.etc.lenovo.bascketball.Fragment.topline_fragment;
import myapp.com.etc.lenovo.bascketball.Fragment.tournament_fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String[] tabTitleArray = {"头条","热门","赛事","圈子","集锦","专栏","NBA","CBA"};
    private  List<Fragment> fragmentList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TabLayout tablayout = (TabLayout) findViewById(R.id.tablayout);
        for(int i=0;i<tabTitleArray.length;i++){
            tablayout.addTab(tablayout.newTab().setText(tabTitleArray[i]));
        }
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        fragmentList.add(new topline_fragment());
        fragmentList.add(new hots_fragment());
        fragmentList.add(new matchs_fragment());
        fragmentList.add(new circle_fragment());
        fragmentList.add(new tournament_fragment());
        fragmentList.add(new columnist_fragment());
        fragmentList.add(new nba_fragment());
        fragmentList.add(new cba_fragment());

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),fragmentList,tabTitleArray);
        viewPager.setAdapter(myPagerAdapter);

        tablayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

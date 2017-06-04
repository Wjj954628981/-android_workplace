package myapp.com.etc.lenovo.bascketball.Acticity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
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
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import myapp.com.etc.lenovo.bascketball.Adapter.MyPagerAdapter;
import myapp.com.etc.lenovo.bascketball.Adapter.ViewPagerAdapter;
import myapp.com.etc.lenovo.bascketball.Fragment.foot_fragment;
import myapp.com.etc.lenovo.bascketball.Fragment.friends_fragment;
import myapp.com.etc.lenovo.bascketball.Fragment.main_fragment;
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

    private BottomNavigationView bottomNaviView;
    private MenuItem menuItem;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //顶部工具栏
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //左边侧拉栏点击按钮
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //底部工具栏
        bottomNaviView = (BottomNavigationView) findViewById(R.id.bottom_navi_view);
        bottomNaviView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_first:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_friends:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.menu_foot:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNaviView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNaviView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        //禁止ViewPager滑动
//        viewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Fragment main_fragment = new main_fragment();
        Fragment friends_fragment = new friends_fragment();
        Fragment foot_fragment = new foot_fragment();
        adapter.addFragment(main_fragment);
        adapter.addFragment(friends_fragment);
        adapter.addFragment(foot_fragment);
        viewPager.setAdapter(adapter);
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

        if (id == R.id.nav_team) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, TeamActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_collection) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, CollectionActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_message) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, MessageActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SettingActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

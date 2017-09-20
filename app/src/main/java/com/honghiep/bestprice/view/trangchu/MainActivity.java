package com.honghiep.bestprice.view.trangchu;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.honghiep.bestprice.R;
import com.honghiep.bestprice.adapter.ExpandAdapter;
import com.honghiep.bestprice.adapter.IExpandAdapter;
import com.honghiep.bestprice.adapter.ViewPagerAdapter;
import com.honghiep.bestprice.presenter.trangchu.menuitem.PresenterXulyMenuItem;
import com.honghiep.bestprice.model.news.XulyNews;
import com.honghiep.bestprice.view.manhinhchao.FlashScreenFragment;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements IViewXuLyMenu{
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private Executor executor= Executors.newFixedThreadPool(2);
    private ExpandableListView expandableListView;
    public XulyNews xuLyNews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        expandableListView= (ExpandableListView) findViewById(R.id.epMenu);


        xuLyNews =new XulyNews();

        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();


        new AsyncTask<Void, Void, Void>(){
            PresenterXulyMenuItem presenterXulyMenuItem;
            @Override
            protected void onPreExecute() {
                openLogin();
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                xuLyNews.downloadNews();

                presenterXulyMenuItem=new PresenterXulyMenuItem(MainActivity.this);
                presenterXulyMenuItem.layDanhSachMenu();
//                SystemClock.sleep(3000);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);

                presenterXulyMenuItem.loadDanhSachMenu();
                closeLogin();
                super.onPostExecute(aVoid);
            }
        }.executeOnExecutor(executor);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutrangchu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }
    public void openLogin() {
        FragmentManager manager = getSupportFragmentManager();

        Fragment fragment =
                manager.findFragmentByTag(FlashScreenFragment.class.getName());

        if (fragment != null) {
            if (fragment.isVisible()) {

            } else {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.content, fragment, FlashScreenFragment.class.getName());
                transaction.addToBackStack(FlashScreenFragment.class.getName());
                transaction.commit();
            }
            return;
        }


        fragment = new FlashScreenFragment();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.content, fragment, FlashScreenFragment.class.getName());
        transaction.addToBackStack(FlashScreenFragment.class.getName());
        transaction.commit();
    }
    public void closeLogin() {
        FragmentManager manager = getSupportFragmentManager();

        Fragment fragment =
                manager.findFragmentByTag(FlashScreenFragment.class.getName());

        if (fragment != null) {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.remove(fragment);
                transaction.commit();
        }

    }

    @Override
    public void loadDanhSachMenuItem(IExpandAdapter mInterf) {
        ExpandAdapter expandAdapter = new ExpandAdapter(mInterf);
        expandableListView.setAdapter(expandAdapter);
        expandAdapter.notifyDataSetChanged();
    }
}

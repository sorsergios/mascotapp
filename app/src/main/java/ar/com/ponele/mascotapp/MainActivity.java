package ar.com.ponele.mascotapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import ar.com.ponele.mascotapp.found.ui.FoundListFragment;
import ar.com.ponele.mascotapp.lost.ui.LostListFragment;
import ar.com.ponele.mascotapp.myaccount.MyAccountOptionsFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private static Integer POSITION_TAB_HOME = 0;
    private static Integer POSITION_TAB_LOST = 1;
    private static Integer POSITION_TAB_FOUND = 2;
    private static Integer POSITION_TAB_ACCOUNT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setElevation(0);
        }

        final MainPageAdapter pageAdapter = new MainPageAdapter(this.getSupportFragmentManager());
        this.setupAdapter(pageAdapter);
        mViewPager = (ViewPager) this.findViewById(R.id.mainPager);
        mViewPager.setAdapter(pageAdapter);

        setupTabLayoutParams();
    }

    private void setupAdapter(MainPageAdapter pageAdapter) {
        //FIXME change fragment
        pageAdapter.addFragment(HomeFragment.newInstance(), null);
        pageAdapter.addFragment(LostListFragment.newInstance(), null);
        pageAdapter.addFragment(FoundListFragment.newInstance(), null);
        pageAdapter.addFragment(MyAccountOptionsFragment.newInstance(), null);
    }


    private void setupTabLayoutParams(){
        mTabLayout = (TabLayout) this.findViewById(R.id.mainToolBar);
        // mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(POSITION_TAB_HOME).setIcon(R.drawable.ic_home_black_24dp);
        mTabLayout.getTabAt(POSITION_TAB_LOST).setIcon(R.drawable.ic_lost_black_24dp);
        mTabLayout.getTabAt(POSITION_TAB_FOUND).setIcon(R.drawable.ic_found_black_24dp);
        mTabLayout.getTabAt(POSITION_TAB_ACCOUNT).setIcon(R.drawable.ic_account_black_24dp);
    }

}
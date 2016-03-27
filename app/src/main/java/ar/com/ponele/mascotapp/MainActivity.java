package ar.com.ponele.mascotapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

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
        viewPager = (ViewPager) this.findViewById(R.id.mainPager);
        viewPager.setAdapter(pageAdapter);

        tabLayout = (TabLayout) this.findViewById(R.id.mainToolBar);
        // tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupAdapter(MainPageAdapter pageAdapter) {
        pageAdapter.addFragment(HomeFragment.newInstance(), "HOME");
        pageAdapter.addFragment(HomeFragment.newInstance(), "BUSCADOS");
        pageAdapter.addFragment(HomeFragment.newInstance(), "ENCONTRADOS");
        pageAdapter.addFragment(HomeFragment.newInstance(), "PERFIL");
    }


}
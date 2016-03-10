package ar.com.ponele.mascotapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import ar.com.ponele.mascotapp.adapter.MainPageAdapter;
import ar.com.ponele.mascotapp.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        final MainPageAdapter pageAdapter = new MainPageAdapter(this.getSupportFragmentManager());
        this.setupAdapter(pageAdapter);
        final ViewPager pager = (ViewPager) this.findViewById(R.id.mainPager);
        pager.setAdapter(pageAdapter);

        final TabLayout tabLayout = (TabLayout) this.findViewById(R.id.mainToolBar);
        // tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(pager);
    }

    private void setupAdapter(MainPageAdapter pageAdapter) {
        pageAdapter.addFragment(HomeFragment.newInstance(), "HOME");
        pageAdapter.addFragment(HomeFragment.newInstance(), "BUSCADOS");
        pageAdapter.addFragment(HomeFragment.newInstance(), "ENCONTRADOS");
        pageAdapter.addFragment(HomeFragment.newInstance(), "PERFIL");
    }


}

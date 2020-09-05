package com.owena.gads.leaderoard;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.owena.gads.leaderoard.adapters.LeaderBoardAdapter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

  private static final int LEARNING_LEADERS = 0;
  private static final int IQ_LEADERS = 1;

  // fragments
  private FirstFragment mFirstFragment;
  private SecondFragment mSecondFragment;

  // Widget
  private ViewPager2 mViewPager;
  private Toolbar mToolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mToolbar = findViewById(R.id.custom_toolbar);
    setSupportActionBar(mToolbar);

    mViewPager = findViewById(R.id.view_pager);
//    setupViewPager();

  }

//  private void setupViewPager(){
//    LeaderBoardAdapter adapter = new LeaderBoardAdapter(getSupportFragmentManager());
//
//    mFirstFragment = new FirstFragment();
//    mSecondFragment = new SecondFragment();
//    adapter.addFragment(mFirstFragment);
//    adapter.addFragment(mSecondFragment);
//
//    mViewPager.setAdapter(adapter);
//
//    TabLayout tabLayout = findViewById(R.id.tab_layout);
//    tabLayout.setupWithViewPager(mViewPager);
//
//    tabLayout.getTabAt(LEARNING_LEADERS).setText(getString(R.string.tag_fragment_learning));
//    tabLayout.getTabAt(IQ_LEADERS).setText(getString(R.string.tag_fragment_skill_iq));
//  }


}
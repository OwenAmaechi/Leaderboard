package com.owena.gads.leaderboard;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.owena.gads.leaderboard.adapters.LeaderBoardPagerAdapter;

public class MainActivity extends AppCompatActivity {

  private static final int LEARNING_LEADERS = 0;
  private static final int IQ_LEADERS = 1;

  // fragments
  private LearningLeadersFragment mLearningLeadersFragment;
  private SkillIQLeadersFragment mSkillIQLeadersFragment;

  // Widget
  private ViewPager mViewPager;
  private Toolbar mToolbar;

  private FragmentPagerAdapter mPagerAdapter;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mToolbar = findViewById(R.id.custom_toolbar);
    setSupportActionBar(mToolbar);

    mViewPager = findViewById(R.id.view_pager);
    setupViewPager();
  }

  private void setupViewPager(){
    LeaderBoardPagerAdapter adapter = new LeaderBoardPagerAdapter(getSupportFragmentManager());
    mLearningLeadersFragment = new LearningLeadersFragment();
    mSkillIQLeadersFragment = new SkillIQLeadersFragment();

    adapter.addFragment(mLearningLeadersFragment);
    adapter.addFragment(mSkillIQLeadersFragment);
    mViewPager.setAdapter(adapter);

    TabLayout tabLayout = findViewById(R.id.tab_layout);
    tabLayout.setupWithViewPager(mViewPager);

    tabLayout.getTabAt(LEARNING_LEADERS).setText(getString(R.string.tag_fragment_learning));
    tabLayout.getTabAt(IQ_LEADERS).setText(getString(R.string.tag_fragment_skill_iq));
  }
}
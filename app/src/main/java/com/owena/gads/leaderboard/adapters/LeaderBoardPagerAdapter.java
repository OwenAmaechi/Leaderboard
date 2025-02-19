package com.owena.gads.leaderboard.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardPagerAdapter extends FragmentPagerAdapter {

  private final List<Fragment> mFragmentList = new ArrayList<>();

  public LeaderBoardPagerAdapter(@NonNull FragmentManager fm) {
    super(fm);
  }

  @NonNull
  @Override
  public Fragment getItem(int position) {
    return mFragmentList.get(position);
  }

  @Override
  public int getCount() {
    return mFragmentList.size();
  }

  public void addFragment(Fragment fragment){
    mFragmentList.add(fragment);
  }
}

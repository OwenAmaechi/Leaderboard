package com.owena.gads.leaderoard.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.owena.gads.leaderoard.FirstFragment;
import com.owena.gads.leaderoard.SecondFragment;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardAdapter extends FragmentStateAdapter {

  private final List<Fragment> mFragmentList = new ArrayList<>();

  public LeaderBoardAdapter(@NonNull FragmentActivity fragmentActivity) {
    super(fragmentActivity);
  }

  @NonNull
  @Override
  public Fragment createFragment(int position) {
    switch (position){
      case 0:
        return new FirstFragment();
      case 1:
        return new SecondFragment();
      default:
        return null;
    }
  }

  @Override
  public int getItemCount() {
    return mFragmentList.size();
  }

//  @NonNull
//  @Override
//  public Fragment getItem(int position) {
//    return mFragmentList.get(position);
//  }

//  @Override
//  public int getCount() {
//    return mFragmentList.size();
//  }

  public void addFragment(Fragment fragment){
    mFragmentList.add(fragment);
  }




}

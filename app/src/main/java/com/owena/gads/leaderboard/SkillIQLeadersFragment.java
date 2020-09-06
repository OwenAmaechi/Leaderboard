package com.owena.gads.leaderboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.owena.gads.leaderboard.adapters.SkillIqAdapter;
import com.owena.gads.leaderboard.model.IQ;
import com.owena.gads.leaderboard.service.LeaderBoardService;
import com.owena.gads.leaderboard.service.ServiceBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIQLeadersFragment extends Fragment {
  private static final String TAG = "SkillIQLeadersFragment";

  private RecyclerView mRecyclerView;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
                           @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_iq_skill_layout, container,false);
    mRecyclerView = view.findViewById(R.id.skill_iq_recycler_view);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

    fetchData();
    return view;
  }

  private void fetchData(){
    LeaderBoardService leaderBoardService = ServiceBuilder.buildService(LeaderBoardService.class);
    Call<ArrayList<IQ>> call = leaderBoardService.getSkilliq();

    call.enqueue(new Callback<ArrayList<IQ>>(){

      @Override
      public void onResponse(Call<ArrayList<IQ>> call, Response<ArrayList<IQ>> response) {
        mRecyclerView.setAdapter(new SkillIqAdapter(response.body()));
        Log.d(TAG, response.body().toString());
      }

      @Override
      public void onFailure(Call<ArrayList<IQ>> call, Throwable t) {
        Log.d(TAG, "onFailure: "+t.toString());
      }
    });
  }
}
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

import com.owena.gads.leaderboard.adapters.LearnersAdapter;
import com.owena.gads.leaderboard.model.Learner;
import com.owena.gads.leaderboard.service.LeaderBoardService;
import com.owena.gads.leaderboard.service.ServiceBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeadersFragment extends Fragment {

  private static final String TAG = "LearningLeadersFragment";
  private RecyclerView mRecyclerView;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
                           @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_learning_layout,container, false);
    mRecyclerView = view.findViewById(R.id.learner_recycler_view);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

    fetchData();
    return view;
  }

  private void fetchData(){
    LeaderBoardService leaderBoardService = ServiceBuilder.buildService(LeaderBoardService.class);
    Call<ArrayList<Learner>> call = leaderBoardService.getLearners();

    call.enqueue(new Callback<ArrayList<Learner>>(){

      @Override
      public void onResponse(Call<ArrayList<Learner>> call, Response<ArrayList<Learner>> response) {
        mRecyclerView.setAdapter(new LearnersAdapter(response.body()));
        Log.d(TAG, response.body().toString());
      }

      @Override
      public void onFailure(Call<ArrayList<Learner>> call, Throwable t) {
        Log.d(TAG, "onFailure: "+t.toString());
      }
    });
  }
}
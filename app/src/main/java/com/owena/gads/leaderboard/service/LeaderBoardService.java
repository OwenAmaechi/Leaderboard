package com.owena.gads.leaderboard.service;

import com.owena.gads.leaderboard.model.IQ;
import com.owena.gads.leaderboard.model.Learner;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderBoardService {
  @GET("hours")
  Call<ArrayList<Learner>> getLearners();

  @GET("skilliq")
  Call<ArrayList<IQ>> getSkilliq();
}

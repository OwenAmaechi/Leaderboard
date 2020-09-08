package com.owena.gads.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

  private static final String TAG = "SplashScreenActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    fetchData();

    startActivity(new Intent(this, MainActivity.class));
    finish();
  }

//  private void fetchData(){
//    LeaderBoardService leaderBoardService = ServiceBuilder.buildService(LeaderBoardService.class);
//    Call<ArrayList<Learner>> call = leaderBoardService.getLearners();
//
//    call.enqueue(new Callback<ArrayList<Learner>>(){
//      @Override
//      public void onResponse(Call<ArrayList<Learner>> call, Response<ArrayList<Learner>> response) {
//        Log.d(TAG, response.body().toString());
//      }
//
//      @Override
//      public void onFailure(Call<ArrayList<Learner>> call, Throwable t) {
//        Log.d(TAG, "onFailure: "+ t.toString());
//      }
//    });
//  }
}
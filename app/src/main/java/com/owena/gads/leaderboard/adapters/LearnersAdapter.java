package com.owena.gads.leaderboard.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.owena.gads.leaderboard.R;
import com.owena.gads.leaderboard.model.Learner;

import java.util.ArrayList;

public class LearnersAdapter extends RecyclerView.Adapter<LearnersAdapter.LearnersViewHolder> {

  private static final String TAG = "LearnersAdapter";

  private ArrayList<Learner> mLearners;

  public LearnersAdapter(ArrayList<Learner> learners) {
    mLearners = learners;
  }

  @NonNull
  @Override
  public LearnersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    View view = LayoutInflater.from(context).inflate(R.layout.learning_item_layout, parent,false);

    return new LearnersViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull LearnersViewHolder holder, int position) {
    Learner learner = mLearners.get(position);
    Log.d(TAG, "onBindViewHolder: "+ learner.toString());
    holder.setData(learner);
  }

  @Override
  public int getItemCount() {
    return mLearners.size();
  }

  public class LearnersViewHolder extends RecyclerView.ViewHolder{

    TextView fullName, hours, lCountry;

    public LearnersViewHolder(@NonNull View itemView) {
      super(itemView);

      fullName = itemView.findViewById(R.id.txt_learner_name);
      hours = itemView.findViewById(R.id.txt_learner_score);
      lCountry = itemView.findViewById(R.id.txt_learner_country);

      Log.d(TAG, "LearnersViewHolder: "+ fullName+ " " + hours+" "+lCountry);
    }

    private void setData(Learner learner){
      fullName.setText(learner.getName());
      hours.setText(Integer.toString(learner.getHours())+ " learning hours,");
      lCountry.setText(learner.getCountry());
    }
  }
}

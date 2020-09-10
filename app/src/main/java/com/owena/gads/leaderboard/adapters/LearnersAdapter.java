package com.owena.gads.leaderboard.adapters;

import android.content.ContentProvider;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.owena.gads.leaderboard.R;
import com.owena.gads.leaderboard.model.Learner;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LearnersAdapter extends RecyclerView.Adapter<LearnersAdapter.LearnersViewHolder> {

  private static final String TAG = "LearnersAdapter";

  private ArrayList<Learner> mLearners;
  private Context mContext;

  public LearnersAdapter(ArrayList<Learner> learners) {
    mLearners = learners;
  }

  @NonNull
  @Override
  public LearnersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     mContext = parent.getContext();
    View view = LayoutInflater.from(mContext).inflate(R.layout.learning_item_layout, parent,false);

    return new LearnersViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull LearnersViewHolder holder, int position) {
    Learner learner = mLearners.get(position);

//    Log.d(TAG, "onBindViewHolder: "+ learner.toString());
    Picasso.with(mContext).load(learner.getBadgeUrl()).into(holder.badgeUrl);
    holder.setData(learner);
  }

  @Override
  public int getItemCount() {
    return mLearners.size();
  }

  public class LearnersViewHolder extends RecyclerView.ViewHolder{

    TextView fullName, hours, lCountry;
    ImageView badgeUrl;

    public LearnersViewHolder(@NonNull View itemView) {
      super(itemView);

      fullName = itemView.findViewById(R.id.txt_learner_name);
      hours = itemView.findViewById(R.id.txt_learner_score);
      lCountry = itemView.findViewById(R.id.txt_learner_country);
      badgeUrl = itemView.findViewById(R.id.learner_badge);
    }

    private void setData(Learner learner){
      Log.d(TAG, "setData: "+ learner.getBadgeUrl());
      fullName.setText(learner.getName());
      hours.setText(Integer.toString(learner.getHours())+ " learning hours,");
      lCountry.setText(learner.getCountry());
    }
  }
}

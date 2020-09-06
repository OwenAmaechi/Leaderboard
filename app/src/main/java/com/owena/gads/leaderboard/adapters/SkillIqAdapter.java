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
import com.owena.gads.leaderboard.model.IQ;

import java.util.ArrayList;

public class SkillIqAdapter extends RecyclerView.Adapter<SkillIqAdapter.SkillIqViewHolder> {

  private static final String TAG = "LearnersAdapter";

  private ArrayList<IQ> mIQS;

  public SkillIqAdapter(ArrayList<IQ> iqs) {
    mIQS = iqs;
  }

  @NonNull
  @Override
  public SkillIqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    View view = LayoutInflater.from(context).inflate(R.layout.skill_iq_item_layout, parent,false);

    return new SkillIqViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull SkillIqViewHolder holder, int position) {
    IQ iq = mIQS.get(position);
    Log.d(TAG, "onBindViewHolder: "+ iq.toString());
    holder.setData(iq);
  }

  @Override
  public int getItemCount() {
    return mIQS.size();
  }

  public class SkillIqViewHolder extends RecyclerView.ViewHolder{

    TextView fullName, score, lCountry;

    public SkillIqViewHolder(@NonNull View itemView) {
      super(itemView);

      fullName = itemView.findViewById(R.id.txt_iq_learner_name);
      score = itemView.findViewById(R.id.txt_iq_score);
      lCountry = itemView.findViewById(R.id.txt_country);

      Log.d(TAG, "LearnersViewHolder: "+ fullName+ " " + score+" "+lCountry);
    }

    private void setData(IQ iq){
      fullName.setText(iq.getName());
      score.setText(Integer.toString(iq.getScore())+ " skill IQ Score,");
      lCountry.setText(iq.getCountry());
    }
  }
}

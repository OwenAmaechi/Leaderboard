package com.owena.gads.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ProjectActivity extends AppCompatActivity {
  private static final String TAG = "ProjectActivity";

  // Widget
  private Toolbar mToolbar;
  private ImageView backBtn;
  private Button submitBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_project);

    mToolbar = findViewById(R.id.custom_toolbar);
    backBtn = findViewById(R.id.back_btn);
    submitBtn = findViewById(R.id.btn_submit);
    setSupportActionBar(mToolbar);

    init();
  }

  private void init() {
    backBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
      }
    });

    submitBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(ProjectActivity.this, "Submit Button clicked", Toast.LENGTH_SHORT).show();
      }
    });
  }
}
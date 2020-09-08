package com.owena.gads.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class ProjectActivity extends AppCompatActivity {
  private static final String TAG = "ProjectActivity";

  // Widget
  private Toolbar mToolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_project);

    mToolbar = findViewById(R.id.custom_toolbar);
    setSupportActionBar(mToolbar);
  }
}
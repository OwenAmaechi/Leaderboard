package com.owena.gads.leaderboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.owena.gads.leaderboard.service.SubmitBuilder;
import com.owena.gads.leaderboard.service.SubmitProjectService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectActivity extends AppCompatActivity {
  private static final String TAG = "ProjectActivity";

  // Widget
  private Toolbar mToolbar;
  private ImageView backBtn;
  private Button submitBtn;
  private EditText eFName,eLName,eEmail,eGitHubLink;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_project);

    mToolbar = findViewById(R.id.custom_toolbar);
    backBtn = findViewById(R.id.back_btn);
    submitBtn = findViewById(R.id.btn_submit);
    eFName = findViewById(R.id.first_name);
    eLName = findViewById(R.id.last_name);
    eEmail = findViewById(R.id.email);
    eGitHubLink = findViewById(R.id.project_link);

    setSupportActionBar(mToolbar);

    init();
  }

  private void submitProject(String email, String  fName, String lName, String githubLink){
    SubmitProjectService projectService = SubmitBuilder.buildService(SubmitProjectService.class);
    Call<Void> call = projectService.sendProject(email, fName, lName, githubLink);

    call.enqueue(new Callback<Void>() {
      @Override
      public void onResponse(Call<Void> call, Response<Void> response) {
        if(response.isSuccessful()){
          successDialog();
        }else{
          failureDialog();
        }
        Toast.makeText(ProjectActivity.this, "response status: "+ response.code(), Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onFailure(Call<Void> call, Throwable t) {
        failureDialog();
      }
    });

  }

  private void init() {
    // function to navigate back to the Main Screen
    backBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
      }
    });

    // function to submit the project
    submitBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final AlertDialog alertDialog =
            new MaterialAlertDialogBuilder(ProjectActivity.this,R.style.CustomAlertDialog)
            .setView(R.layout.dialog_submission_layout).setCancelable(false).show();
        final Button yesBtn = alertDialog.findViewById(R.id.btn_yes);
        final ImageView cancelBtn = alertDialog.findViewById(R.id.btn_cancel);

        yesBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            submitProject(eEmail.getText().toString(),
                eFName.getText().toString(),
                eLName.getText().toString(),
                eGitHubLink.getText().toString());

            Log.d(TAG, "onClick: submit project "+eFName.getText().toString()+
                eLName.getText().toString()+
                eGitHubLink.getText().toString());

            alertDialog.dismiss();
          }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Toast.makeText(ProjectActivity.this, "Cancel Button clicked", Toast.LENGTH_SHORT).show();
            alertDialog.dismiss();
          }
        });
      }
    });
  }

  private void successDialog(){
    final AlertDialog alertDialog = new MaterialAlertDialogBuilder(ProjectActivity.this,R.style.CustomAlertDialog)
                                        .setView(R.layout.dialog_success_layout).show();
  }
  private void failureDialog(){
    final AlertDialog alertDialog = new MaterialAlertDialogBuilder(ProjectActivity.this,R.style.CustomAlertDialog)
                                        .setView(R.layout.dialog_failure_layout).show();
  }
}
package com.owena.gads.leaderboard;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SubmissionDialog extends DialogFragment {
  private static final String TAG = "SubmissionDialog";

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setMessage(R.string.submission_message)
        .setPositiveButton(R.string.submission_yes, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getContext(), "Yes sure to submit", Toast.LENGTH_SHORT).show();
          }
        });
    return builder.create();
  }

}

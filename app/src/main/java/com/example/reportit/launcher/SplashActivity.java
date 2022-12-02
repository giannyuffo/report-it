package com.example.reportit.launcher;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.reportit.R;
import com.example.reportit.client.rest.RestClient;
import com.example.reportit.client.rest.handlers.CheckConnectionResponseHandler;

public class SplashActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;

        RestClient.getInstance(getApplicationContext()).checkConnection(new CheckConnectionResponseHandler() {
            @Override
            public void requestDidComplete(boolean response) {
                Intent intent = new Intent(mContext, LauncherActivity.class);
                startActivity(intent);
                //We cannot go back to this activity.
                finish();
            }

            @Override
            public void requestDidFail(int statusCode) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle(getString(R.string.error_login));
                builder.setMessage(getString(R.string.error_message_reportit));
                builder.setPositiveButton(R.string.try_another_time,(dialog, which) ->{
                    dialog.dismiss();
                    Intent intent = new Intent(mContext, SplashActivity.class);
                    startActivity(intent);
                    finish();
                });
                builder.setNegativeButton(R.string.cancel, (dialog, which) ->{
                    dialog.dismiss();
                    finish();
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}
package com.example.reportit.launcher;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.example.reportit.R;
import com.example.reportit.screens.login.auth.login.LoginActivity;
import com.example.reportit.screens.login.main.chat.ChatUserActivity;
import com.example.reportit.screens.login.main.ui.questionaire.QuestionnaireActivity;

public class LauncherActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        Intent intent;
        if(sharedPreferences.getString("token", null) != null && sharedPreferences.getString("", null)!= null){
            if(sharedPreferences.getString("", null).contains(""))
                intent = new Intent(this, ChatUserActivity.class);
            else
                intent = new Intent(this, QuestionnaireActivity.class );
        }else
            intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    private String getLocation(){

        return null;
    }
    //Oculta el teclado cuando se clicka en cualquier parte de la Activity.
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}
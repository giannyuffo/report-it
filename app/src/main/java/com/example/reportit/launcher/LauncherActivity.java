package com.example.reportit.launcher;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.reportit.screens.login.auth.login.LoginActivity;
import com.example.reportit.screens.login.main.chat.ChatUserActivity;
import com.example.reportit.screens.login.main.school.SchoolAdmin;

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
                intent = new Intent(this, SchoolAdmin.class );
        }else
            intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
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
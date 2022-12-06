package com.reportitv01.screens.auth.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.reportitv01.R;
import com.reportitv01.screens.auth.viewmodel.LoginViewModel;
import com.reportitv01.screens.main.user.questionary.QuestionaryActivity;

public class LoginActivity extends AppCompatActivity {
    //Scholarships center information url
    private final String urlNoCode = "https://centroseducativos.gal/";

    private TextInputEditText codeInputText;
    private TextInputLayout codeInputLayout;
    private Button loginButton, nocodeButton;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.loginButton);
        codeInputText = findViewById(R.id.codeInputText);
        nocodeButton = findViewById(R.id.nocodeButton);

        codeInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                loginButton.setEnabled(true);
            }
        });
        codeInputText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                codeInputText.setError(null);
            }
        });
        nocodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage(urlNoCode);
            }
        });
        loginButton.setOnClickListener(view ->{
            startActivity(new Intent(LoginActivity.this, QuestionaryActivity.class));
        });
    }
    //Open a webpage with Scholarships center information
    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }
    //Hidde the keyboard on screen click
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}

package com.example.reportit.screens.login.auth.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.reportit.R;
import com.example.reportit.launcher.LauncherActivity;
import com.example.reportit.screens.login.auth.viewModel.LoginViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText codeInputText;
    private TextInputLayout codeInputLayout;
    private Button loginButton;
    private Button nocodeButton;
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
                if(!loginViewModel.validateCode(codeInputText.getText().toString())){
                    codeInputText.setError("@string/error_code");
                }else{
                    codeInputText.setError(null);
                }
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
                String url ="";
                Intent intent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("Ayuda contra el acoso: 900 018 018"));
                startActivity(intent);
            }
        });

        //Enable Login Button only when valid data is introduced.
        loginViewModel.getFormValid().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean valid) {
                loginButton.setEnabled(valid);
            }
        });
        loginViewModel.getLoginResponseCode().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer loginResponseCode) {
                assert loginResponseCode != null;
                switch(loginResponseCode){
                    case 200:
                        startActivity(new Intent(getApplicationContext(), LauncherActivity.class));
                        finish();
                        break;
                    default:
                        Snackbar.make(codeInputText, "@string/error_login", Snackbar.LENGTH_SHORT).show();
                        loginButton.setEnabled(true);
                        break;
                }
            }
        });

    }

    private boolean checkParams(){
        String code = "";
        return !code.isEmpty();
    }
}

package com.example.reportit.screens.login.auth.repository;

import android.content.Context;

import com.example.reportit.client.rest.RestClient;
import com.example.reportit.client.rest.handlers.LoginResponseHandler;

public class LoginRepository {
    Context mContext;
    public LoginRepository(Context context){mContext = context;}

    public void postLogin(String code, String longitude, String latitude, LoginResponseHandler loginResponseHandler){
        RestClient.getInstance(mContext).postLoginUser(code, longitude, latitude, loginResponseHandler);
    }
}

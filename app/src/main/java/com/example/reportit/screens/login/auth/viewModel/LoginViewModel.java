package com.example.reportit.screens.login.auth.viewModel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.reportit.client.rest.dtos.UserDTO;
import com.example.reportit.client.rest.handlers.LoginResponseHandler;
import com.example.reportit.screens.login.auth.repository.LoginRepository;

public class LoginViewModel extends AndroidViewModel {
    MutableLiveData<Boolean> formValid;
    MutableLiveData<UserDTO> loginResponse;
    MutableLiveData<Integer> loginResponseCode;
    LoginRepository loginRepository;
    Boolean codeValid;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        formValid = new MutableLiveData<Boolean>(false);
        loginRepository = new LoginRepository(getApplication().getApplicationContext());
        loginResponse = new MutableLiveData<UserDTO>();
        loginResponseCode = new MutableLiveData<Integer>();
        codeValid = false;
    }

    public MutableLiveData<Boolean> getFormValid(){return formValid;}

    public MutableLiveData<Integer> getLoginResponseCode(){return loginResponseCode;}

    private void validateFields(){
        assert(formValid.getValue() != null);
        if(formValid.getValue() != codeValid){
            formValid.setValue(codeValid);
        }
    }

    public Boolean validateCode(String code) {
        codeValid = !code.isEmpty();
        validateFields();
        return codeValid;
    }

    public void postLogin(String code, String latitude, String longitude){
        loginRepository.postLogin(code, longitude, latitude, new LoginResponseHandler() {
            @Override
            public void sessionRequestDidComplete(UserDTO dto) {
                //Saving login data on SharedPreferences
                SharedPreferences sharedPreferences = getApplication().getApplicationContext()
                        .getSharedPreferences("user", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("userCode", dto.getUserCode());
                editor.putString("code", dto.getCode());
                editor.putString("longitude", dto.getLongitude());
                editor.putString("latitude", dto.getLatitude());
                editor.putString("token", dto.getToken());
                editor.apply();
                loginResponseCode.setValue(200);
            }

            @Override
            public void requestDidFail(int statusCode) {
                loginResponseCode.setValue(statusCode);
            }
        });
    }

}
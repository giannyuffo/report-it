package com.reportitv01.screens.auth.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;

public class QuestionaryViewModel extends AndroidViewModel {

    HashMap<String,String> reportForm;
    MutableLiveData<Boolean> virtualBackButton;
    MutableLiveData<Fragment> nextFragmentRequest;
    MutableLiveData<String> topBarTitle;

    public QuestionaryViewModel(@NonNull Application application) {
        super(application);
        reportForm = new HashMap<String, String>();
        virtualBackButton = new MutableLiveData<Boolean>(false);
        nextFragmentRequest = new MutableLiveData<Fragment>(null);
        topBarTitle = new MutableLiveData<String>("Reporte");
    }

    public boolean setCenterCode(String code){
        boolean valid;
        if(!code.isEmpty() && code.length() >=4){
            reportForm.put("centerCode", code);
            valid = true;
        }else{
            reportForm.put("centerCode", null);
            valid = false;
        }
        return valid;
    }
    public Boolean setStudent(String student ){
        boolean valid;
        reportForm.put("userType", student);
        valid = true;
        return valid;

    }

    public Boolean setTeacher(String teacher){
        boolean valid;
        reportForm.put("userType", teacher);
        valid = true;
        return valid;
    }

    public Boolean setFamily(String family){
        boolean valid;
        reportForm.put("userType", family);
        valid = true;
        return valid;
    }

    public Boolean setNeigth(String neigth){
        boolean valid;
        reportForm.put("userType", neigth);
        valid = true;
        return valid;
    }

    public void setNextFragmentRequest(Fragment fragment){
        nextFragmentRequest.setValue(fragment);
    }
    public void virtualBackButtonRequest(Boolean value) {
        virtualBackButton.setValue(value);
    }

    public void setTopBarTitle(String topBarTitle) {
        this.topBarTitle.setValue(topBarTitle);
    }


    //Getters

    public HashMap<String, String> getReportForm() {
        return reportForm;
    }

    public MutableLiveData<Boolean> getVirtualBackButtton() {
        return virtualBackButton;
    }

    public MutableLiveData<Fragment> getNextFragmentRequest() {
        return nextFragmentRequest;
    }

    public MutableLiveData<String> getTopBarTitle() {
        return topBarTitle;
    }

}
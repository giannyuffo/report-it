package com.example.reportit.screens.login.main.public_user.questionaire;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reportit.R;
import com.example.reportit.screens.login.auth.viewModel.QuestionaryViewModel;

public class QuestionaryStep1Fragment extends Fragment {

    private QuestionaryViewModel mViewModel;

    public static QuestionaryStep1Fragment newInstance() {
        return new QuestionaryStep1Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_questionary_step1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(QuestionaryViewModel.class);
        // TODO: Use the ViewModel
    }

}
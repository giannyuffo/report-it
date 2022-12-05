package com.reportitv01.screens.main.user.questionary.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import com.reportitv01.R;
import com.reportitv01.screens.auth.viewmodel.QuestionaryViewModel;

public class QuestionaryStep1Fragment extends Fragment {

    private QuestionaryViewModel questionaryViewModel;
    private Button continueButton;
    private Button studentButton;
    private Button teacherButton;
    private Button familyButton;
    private Button neigthButton;



    public static QuestionaryStep1Fragment newInstance() {
        return new QuestionaryStep1Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //ViewModel init and view inflate
        questionaryViewModel = new ViewModelProvider(requireActivity()).get(QuestionaryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_questionary_step1, container, false);

        //XML layout resources
        continueButton = view.findViewById(R.id.continueStep1Button);
        studentButton = view.findViewById(R.id.studentOptionButton);
        teacherButton = view.findViewById(R.id.teacherOptionButton);
        familyButton = view.findViewById(R.id.familyOptionButton);
        neigthButton = view.findViewById(R.id.neigthbOptionButton);

        continueButton.setOnClickListener(nextFragmentRequest ->{

        });
        studentButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setStudent("student");
            questionaryViewModel.setNextFragmentRequest(new QuestionaryStep2Fragment());
        });
        teacherButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setTeacher("teacher");
            questionaryViewModel.setNextFragmentRequest(new QuestionaryStep2Fragment());
        });
        familyButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setFamily("family");
            questionaryViewModel.setNextFragmentRequest(new QuestionaryStep2Fragment());
        });
        neigthButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setNeigth("neigth");
            questionaryViewModel.setNextFragmentRequest(new QuestionaryStep2Fragment());
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getActivity().getApplicationContext().INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

}
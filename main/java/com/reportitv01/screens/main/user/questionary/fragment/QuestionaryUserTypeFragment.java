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

public class QuestionaryUserTypeFragment extends Fragment {

    private QuestionaryViewModel questionaryViewModel;
    private Button continueButton, studentButton,
                   teacherButton, familyButton,
                   neigthButton;

    public static QuestionaryUserTypeFragment newInstance() {
        return new QuestionaryUserTypeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //ViewModel init and view inflate
        questionaryViewModel = new ViewModelProvider(requireActivity()).get(QuestionaryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_questionary_user_type, container, false);

        //XML layout resources
        continueButton = view.findViewById(R.id.continueStep1Button);
        studentButton = view.findViewById(R.id.studentOptionButton);
        teacherButton = view.findViewById(R.id.teacherOptionButton);
        familyButton = view.findViewById(R.id.familyOptionButton);
        neigthButton = view.findViewById(R.id.neigthbOptionButton);

        studentButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setStudent("student");
            questionaryViewModel.setNextFragmentRequest(new QuestionaryMeOtherFragment());
        });
        teacherButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setTeacher("teacher");
            questionaryViewModel.setNextFragmentRequest(new QuestionaryProblemTypeFragment());
        });
        familyButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setFamily("family");
            questionaryViewModel.setNextFragmentRequest(new QuestionaryProblemTypeFragment());
        });
        neigthButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setNeigth("neigth");
            questionaryViewModel.setNextFragmentRequest(new QuestionaryProblemTypeFragment());
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
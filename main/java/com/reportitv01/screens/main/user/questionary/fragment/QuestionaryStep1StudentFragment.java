package com.reportitv01.screens.main.user.questionary.fragment;

import androidx.lifecycle.Observer;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.reportitv01.R;
import com.reportitv01.screens.auth.viewmodel.QuestionaryViewModel;

public class QuestionaryStep1StudentFragment extends Fragment {

    private QuestionaryViewModel questionaryViewModel;
    private Button continueButton;
    private RadioButton meRadioButton;
    private RadioButton otherRadioButton;
    private RadioGroup radioGroup;


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
        meRadioButton = view.findViewById(R.id.me_radio_button);
        otherRadioButton = view.findViewById(R.id.other_radio_button);
        radioGroup = view.findViewById(R.id.radioGroupDestinationReport);

        continueButton.setOnClickListener(nextFragmentRequest ->{

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
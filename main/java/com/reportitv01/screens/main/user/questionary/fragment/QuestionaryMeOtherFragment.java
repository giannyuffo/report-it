package com.reportitv01.screens.main.user.questionary.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
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

public class QuestionaryMeOtherFragment extends Fragment {

    //Suicidal behavior phone
    private final String helpPhone ="024";

    private QuestionaryViewModel questionaryViewModel;
    private Button meButton, otherButton, helpButton;

    public static QuestionaryMeOtherFragment newInstance() {
        return new QuestionaryMeOtherFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //ViewModel init and view inflate
        questionaryViewModel = new ViewModelProvider(requireActivity()).get(QuestionaryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_questionary_me_other, container, false);

        //XML layout resources
        meButton = view.findViewById(R.id.meButton);
        otherButton = view.findViewById(R.id.otherButton);
        helpButton = view.findViewById(R.id.helpButton);

        meButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setNextFragmentRequest(new QuestionaryProblemTypeFragment());
        });
        otherButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setNextFragmentRequest(new QuestionaryProblemTypeFragment());
        });
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber(helpPhone);
            }
        });
        return view;
    }
    //Launch phone dialer.
    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));

        startActivity(intent);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getActivity().getApplicationContext().INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }
}
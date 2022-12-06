package com.reportitv01.screens.main.user.questionary.fragment.bullyin;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.reportitv01.R;
import com.reportitv01.screens.auth.viewmodel.QuestionaryViewModel;
import com.reportitv01.screens.main.user.questionary.fragment.QuestionaryUserTypeFragment;
import com.reportitv01.screens.main.user.send.SendReportActivity;

public class BullyingQuestionaryFragment extends Fragment {
    private QuestionaryViewModel questionaryViewModel;
    private Button sendButton;
    private TextInputEditText whereEditText, whenEditText,
                            whoEditText, whomeEditText,
                            whatEditText;
    private TextInputLayout whereTextLayout, whenTextLayout,
            whoTextLayout, whoGetTextLayout, whatTextLayout;


    public static BullyingQuestionaryFragment newInstance() {
        return new BullyingQuestionaryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ViewModel init and view inflate
        questionaryViewModel = new ViewModelProvider(requireActivity()).get(QuestionaryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_bullying_questionary, container, false);

        //XML elements
        sendButton = view.findViewById(R.id.sendBullyingButton);
        whereEditText = view.findViewById(R.id.whereInputText);
        whenEditText = view.findViewById(R.id.whenInputText);
        whoEditText = view.findViewById(R.id.whoInputText);
        whomeEditText = view.findViewById(R.id.whoGetInputText);
        whatEditText = view.findViewById(R.id.whatInputText);

        whereEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                whenEditText.setVisibility(View.VISIBLE);
                whenEditText.setEnabled(true);
            }
        });
        whenEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                whoEditText.setVisibility(View.VISIBLE);
                whoEditText.setEnabled(true);
            }
        });
        whoEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                whomeEditText.setVisibility(View.VISIBLE);
                whomeEditText.setEnabled(true);
            }
        });
        whomeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                whatEditText.setVisibility(View.VISIBLE);
                whatEditText.setEnabled(true);
            }
        });
        whatEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sendButton.setVisibility(View.VISIBLE);
                sendButton.setEnabled(true);
            }
        });

        sendButton.setOnClickListener(nextFragmentRequest -> {

                Intent intent = new Intent(getContext(), SendReportActivity.class);
                startActivity(intent);

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
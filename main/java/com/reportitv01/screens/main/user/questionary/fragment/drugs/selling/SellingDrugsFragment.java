package com.reportitv01.screens.main.user.questionary.fragment.drugs.selling;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.reportitv01.R;
import com.reportitv01.screens.auth.viewmodel.QuestionaryViewModel;
import com.reportitv01.screens.main.user.questionary.fragment.bullyin.BullyingQuestionaryFragment;

public class SellingDrugsFragment extends Fragment {
    private QuestionaryViewModel questionaryViewModel;
    private Button sendDrugsSellingButton;
    private TextInputEditText whereDrugsInputText,whenDrugsInputText,
            whoDrugsInputText, moreInfoDrugsInputText;

    public static SellingDrugsFragment newInstance() {
        return new SellingDrugsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ViewModel init and view inflate
        questionaryViewModel = new ViewModelProvider(requireActivity()).get(QuestionaryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_selling_drugs, container, false);


        //XML elements
        whereDrugsInputText = view.findViewById(R.id.whereDrugsInputText);
        whenDrugsInputText = view.findViewById(R.id.whenDrugsInputText);
        whoDrugsInputText  = view.findViewById(R.id.whoDrugsInputText);
        moreInfoDrugsInputText = view.findViewById(R.id.moreInfoDrugsInputText);
        sendDrugsSellingButton = view.findViewById(R.id.sendDrugsSellingButton);


        whereDrugsInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                whenDrugsInputText.setVisibility(View.VISIBLE);
                whenDrugsInputText.setEnabled(true);
            }
        });

        whenDrugsInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                whoDrugsInputText.setVisibility(View.VISIBLE);
                whoDrugsInputText.setEnabled(true);
            }
        });

        whoDrugsInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                moreInfoDrugsInputText.setVisibility(View.VISIBLE);
                moreInfoDrugsInputText.setEnabled(true);
            }
        });
        moreInfoDrugsInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sendDrugsSellingButton.setVisibility(View.VISIBLE);
                sendDrugsSellingButton.setEnabled(true);
            }
        });
        sendDrugsSellingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
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
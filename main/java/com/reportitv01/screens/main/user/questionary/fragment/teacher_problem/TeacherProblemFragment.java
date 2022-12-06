package com.reportitv01.screens.main.user.questionary.fragment.teacher_problem;

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
import com.reportitv01.R;
import com.reportitv01.screens.auth.viewmodel.QuestionaryViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeacherProblemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeacherProblemFragment extends Fragment {
    private QuestionaryViewModel questionaryViewModel;
    private Button sendMissingTeacherButton;
    private TextInputEditText whoTeacherInputText, whenTeacherInputText,
            moreInfoTeacherInputText;

    public static TeacherProblemFragment newInstance() {
        return new TeacherProblemFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ViewModel init and view inflate
        questionaryViewModel = new ViewModelProvider(requireActivity()).get(QuestionaryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_bullying_questionary, container, false);

        //XML elements
        whoTeacherInputText = view.findViewById(R.id.whoTeacherInputText);
        whenTeacherInputText = view.findViewById(R.id.whenTeacherInputText);
        moreInfoTeacherInputText = view.findViewById(R.id.moreInfoTeacherInputText);
        sendMissingTeacherButton = view.findViewById(R.id.sendMissingTeacherButton);

        whoTeacherInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                whenTeacherInputText.setVisibility(View.VISIBLE);
                whenTeacherInputText.setEnabled(true);
            }
        });

        whenTeacherInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                moreInfoTeacherInputText.setVisibility(View.VISIBLE);
                moreInfoTeacherInputText.setEnabled(true);
            }
        });

        moreInfoTeacherInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sendMissingTeacherButton.setVisibility(View.VISIBLE);
                sendMissingTeacherButton.setEnabled(true);
            }
        });
        sendMissingTeacherButton.setOnClickListener(new View.OnClickListener() {
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
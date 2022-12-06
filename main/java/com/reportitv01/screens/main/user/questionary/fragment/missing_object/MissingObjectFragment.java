package com.reportitv01.screens.main.user.questionary.fragment.missing_object;

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
import com.reportitv01.screens.main.user.questionary.fragment.bullyin.BullyingQuestionaryFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MissingObjectFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MissingObjectFragment extends Fragment {
    private QuestionaryViewModel questionaryViewModel;
    private TextInputEditText whereObjectInputText, whatObjectInputText,
            moreInfoInputText, whenObjectInputText;
    private Button sendMissingObjectButton;

    public static MissingObjectFragment newInstance() {
        return new MissingObjectFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ViewModel init and view inflate
        questionaryViewModel = new ViewModelProvider(requireActivity()).get(QuestionaryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_missing_object, container, false);

        //XML elements
        whereObjectInputText = view.findViewById(R.id.whereObjectInputText);
        whenObjectInputText = view.findViewById(R.id.whenObjectInputText);
        whatObjectInputText  = view.findViewById(R.id.whatObjectInputText);
        moreInfoInputText  = view.findViewById(R.id.moreInfoInputText);
        sendMissingObjectButton = view.findViewById(R.id.sendMissingObjectButton);

        whereObjectInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                whenObjectInputText.setVisibility(View.VISIBLE);
                whenObjectInputText.setEnabled(true);
            }
        });

        whenObjectInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                whatObjectInputText.setVisibility(View.VISIBLE);
                whatObjectInputText.setEnabled(true);
            }
        });

        whatObjectInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                moreInfoInputText.setVisibility(View.VISIBLE);
                moreInfoInputText.setEnabled(true);
            }
        });
        moreInfoInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sendMissingObjectButton.setVisibility(View.VISIBLE);
                sendMissingObjectButton.setEnabled(true);
            }
        });
        sendMissingObjectButton.setOnClickListener(new View.OnClickListener() {
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
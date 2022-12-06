package com.reportitv01.screens.main.user.questionary.fragment.teacher_problem;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.reportitv01.R;
import com.reportitv01.screens.auth.viewmodel.QuestionaryViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeacherProblemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeacherProblemFragment extends Fragment {
    private QuestionaryViewModel questionaryViewModel;

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

        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getActivity().getApplicationContext().INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }
}
package com.reportitv01.screens.main.user.questionary.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.reportitv01.R;
import com.reportitv01.screens.auth.viewmodel.QuestionaryViewModel;
import com.reportitv01.screens.main.user.questionary.fragment.bullyin.BullyingQuestionaryFragment;
import com.reportitv01.screens.main.user.questionary.fragment.drugs.DrugSellBuyFragment;
import com.reportitv01.screens.main.user.questionary.fragment.economic.EconomicFragment;
import com.reportitv01.screens.main.user.questionary.fragment.fraud.FraudFragment;
import com.reportitv01.screens.main.user.questionary.fragment.missing_object.MissingObjectFragment;
import com.reportitv01.screens.main.user.questionary.fragment.teacher_problem.TeacherProblemFragment;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class QuestionaryProblemTypeFragment extends Fragment {
    private QuestionaryViewModel questionaryViewModel;
    private Button bullyingButton, missingItemButton,
                   drugsButton, economicProblemButton,
                   fraudButton, teacherProblemButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ViewModel init and view inflate
        questionaryViewModel = new ViewModelProvider(requireActivity()).get(QuestionaryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_questionary_problem_type, container, false);

        //XML layout resources
        bullyingButton = view.findViewById(R.id.bullingButton);
        missingItemButton = view.findViewById(R.id.missingItemButton);
        drugsButton = view.findViewById(R.id.drugsButton);
        economicProblemButton = view.findViewById(R.id.economicProblemButton);
        fraudButton = view.findViewById(R.id.fraudButton);
        teacherProblemButton = view.findViewById(R.id.teacherProblemButton);

        bullyingButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setNextFragmentRequest(new BullyingQuestionaryFragment());
        });
        missingItemButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setNextFragmentRequest(new MissingObjectFragment());
        });
        drugsButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setNextFragmentRequest(new DrugSellBuyFragment());
        });
        economicProblemButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setNextFragmentRequest(new EconomicFragment());
        });
        fraudButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setNextFragmentRequest(new FraudFragment());
        });
        teacherProblemButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setNextFragmentRequest(new TeacherProblemFragment());
        });
        return view;
    }
}
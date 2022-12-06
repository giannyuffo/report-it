package com.reportitv01.screens.main.user.questionary.fragment.drugs;

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
import com.reportitv01.screens.main.user.questionary.fragment.QuestionaryProblemTypeFragment;
import com.reportitv01.screens.main.user.questionary.fragment.bullyin.BullyingQuestionaryFragment;
import com.reportitv01.screens.main.user.questionary.fragment.drugs.buying.BuyingDrugsFragment;
import com.reportitv01.screens.main.user.questionary.fragment.drugs.selling.SellingDrugsFragment;

public class DrugSellBuyFragment extends Fragment {
    private QuestionaryViewModel questionaryViewModel;

    private String [] helpEmail = {"info@no-a.es"};
    private final String helpPhone = "+34881541859", subject = "Necesito ayuda.";
    private final String text ="Buenas, escribo para solicitar ayuda. Gracias";

    private Button sellingDrugsButton, takingDrugsButton, helpDrugsButton;

    public static DrugSellBuyFragment newInstance() {
        return new DrugSellBuyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ViewModel init and view inflate
        questionaryViewModel = new ViewModelProvider(requireActivity()).get(QuestionaryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_drug_sell_buy, container, false);


        //XML elements
        sellingDrugsButton = view.findViewById(R.id.sellingDrugsButton);
        takingDrugsButton = view.findViewById(R.id.takingDrugsButton);
        helpDrugsButton  = view.findViewById(R.id.helpDrugsButton);

        takingDrugsButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setNextFragmentRequest(new BuyingDrugsFragment());
        });
        sellingDrugsButton.setOnClickListener(nextFragmentRequest ->{
            questionaryViewModel.setNextFragmentRequest(new SellingDrugsFragment());
        });
        helpDrugsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("Queremos ayudarte");
                dialog.setMessage("Elige cómo contactar de forma totalmente confidencial.");
                dialog.setPositiveButton("Email", (d, which)->{
                    composeEmail(helpEmail, subject, text );
                });
                dialog.setNegativeButton("Télefono", (d, which) -> {
                    dialPhoneNumber(helpPhone);
                }
                );
                dialog.show();
            }
        });

        return view;
    }
    //Launch email
    private void composeEmail(String [] addresses, String subject, String text) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(intent);
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
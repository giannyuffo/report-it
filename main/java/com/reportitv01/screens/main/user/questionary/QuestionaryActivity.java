package com.reportitv01.screens.main.user.questionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.google.android.material.textview.MaterialTextView;
import com.reportitv01.R;
import com.reportitv01.screens.auth.viewmodel.QuestionaryViewModel;
import com.reportitv01.screens.main.user.questionary.fragment.QuestionaryUserTypeFragment;

public class QuestionaryActivity extends AppCompatActivity {
    private QuestionaryViewModel questionaryViewModel;
    private MaterialTextView topBarTitle;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionary);

        backButton = findViewById(R.id.register_back_button);
        topBarTitle = findViewById(R.id.questionary_title);
        questionaryViewModel = new ViewModelProvider(this).get(QuestionaryViewModel.class);

        //Virtual back button works like the mobile one.
        backButton.setOnClickListener(view ->{
            onBackPressed();
        });

        //Loading the first default fragment.
        questionaryViewModel.setNextFragmentRequest(new QuestionaryUserTypeFragment());

        //Wait for a fragment load from ViewMOdel
        questionaryViewModel.getNextFragmentRequest().observe(this, new Observer<Fragment>() {
            @Override
            public void onChanged(Fragment nextFragment) {
                if(nextFragment != null){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .replace(R.id.questionary_framelayout, nextFragment).commit();
                }
            }
        });

        questionaryViewModel.getVirtualBackButtton().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean value) {
                if(value){
                    questionaryViewModel.virtualBackButtonRequest(false);
                    onBackPressed();
                }
            }
        });

        questionaryViewModel.getTopBarTitle().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String text) {
                topBarTitle.setText(text);
            }
        });
    }
    private void showBackDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Volver a pantalla de inicio");
        builder.setMessage("Si aceptas se perderán los datos introducidos.");

        builder.setPositiveButton("Aceptar", (dialogInterface, i) -> {
            finish();
        });
        builder.setNegativeButton("Cancelar", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    //Go bakc to previous fragment. In case of th stack is empty, the user will be asked to continue or not.
    @Override
    public void onBackPressed(){
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            showBackDialog();
        }
    }

    //Hidde the keyboard on screen click
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}
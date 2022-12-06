package com.reportitv01.launcher;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import com.reportitv01.screens.auth.login.LoginActivity;
import com.reportitv01.screens.auth.viewmodel.LoginViewModel;

import java.util.concurrent.atomic.AtomicBoolean;

public class LauncherActivity extends AppCompatActivity {
    protected LoginViewModel loginViewModel;
    protected LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onLocationAcces();


    }
    @Override
    public void onResume() {
        super.onResume();
        if(this.locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Intent intent;
            intent = new Intent(this, LoginActivity.class);
        }else
            onLocationAcces();
    }
    //
    @Override
    protected void onRestart() {
        super.onRestart();
        if(this.locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Intent intent;
            intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else
            onLocationAcces();
    }
    //Finishing the app on back button pressed
    @Override
    public void onBackPressed(){
        finish();
    }
    private void onLocationAcces(){
        AtomicBoolean isGPSEnabled = new AtomicBoolean(false);
        this.locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if(locationManager != null){
            isGPSEnabled.set(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER));
            if(!isGPSEnabled.get()){
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("¿Permites a ReportIt usar tu ubicación?");
                dialog.setMessage("Necesitamos conocer su ubicación para poder utilizar correctamente nuestro servicio.");
                dialog.setPositiveButton("Activar", (d, which)->{
                    Intent intentGPS = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intentGPS);
                    isGPSEnabled.set(true);

                });
                dialog.setNegativeButton("No conceder", (d, which) -> {
                    d.dismiss();
                    finish();}
                );
                dialog.show();
            }
            if(isGPSEnabled.get()){
                Intent intent;
                intent = new Intent(this, LoginActivity.class);

                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),
                        android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(intent, bundle);
                finish();
            }
        }
    }
}

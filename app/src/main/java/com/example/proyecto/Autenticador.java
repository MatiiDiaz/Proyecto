package com.example.proyecto;

import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Autenticador extends AppCompatActivity implements View.OnClickListener{
    Button button_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autenticador);

        button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(this);
    }

    public void onClick(View v){
        if (v.getId() == R.id.button_login) {
            Intent listaLogin = new Intent(Autenticador.this, MainActivity.class);
            startActivity(listaLogin);
        }
    }

}
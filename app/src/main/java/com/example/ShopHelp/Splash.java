package com.example.ShopHelp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Autenticador.class);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 2000);
    }
}

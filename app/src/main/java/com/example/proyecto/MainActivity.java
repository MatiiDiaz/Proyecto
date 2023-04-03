package com.example.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonListaCompras;
    Button buttonLugaresInteres;
    Button buttonListaProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonListaCompras = findViewById(R.id.button2);
        buttonListaCompras.setOnClickListener(this);

        buttonLugaresInteres = findViewById(R.id.button3);
        buttonLugaresInteres.setOnClickListener(this);

        buttonListaProductos = findViewById(R.id.button4);
        buttonListaProductos.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button2:
                Intent listaCompras = new Intent(MainActivity.this,ListadeCompras.class);
                startActivity(listaCompras);
                break;
            case R.id.button3:
                Intent lugaresInteres = new Intent(MainActivity.this,LugaresInteres.class);
                startActivity(lugaresInteres);
                break;
            case R.id.button4:
                Intent listaProductos = new Intent(MainActivity.this,ListadeProductos.class);
                startActivity(listaProductos);
                break;
        }
    }
}
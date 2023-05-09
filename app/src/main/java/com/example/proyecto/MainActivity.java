package com.example.proyecto;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonListaCompras;
    Button buttonLugaresInteres;
    Button buttonListaProductos;
    Button buttonInventario;
    Button buttonRecordatorio;
    Button buttonCerrarSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonListaCompras = findViewById(R.id.button2);
        buttonListaCompras.setOnClickListener(this);

        buttonLugaresInteres = findViewById(R.id.button3);
        buttonLugaresInteres.setOnClickListener(this);

        buttonListaProductos = findViewById(R.id.button4);
        buttonListaProductos.setOnClickListener(this);

        buttonInventario = findViewById(R.id.button5);
        buttonInventario.setOnClickListener(this);

        buttonRecordatorio = findViewById(R.id.button6);
        buttonRecordatorio.setOnClickListener(this);

        buttonCerrarSesion = findViewById(R.id.button7);
        buttonCerrarSesion.setOnClickListener(this);
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
            case R.id.button5:
                Intent listaInventarios = new Intent(MainActivity.this, Inventarios.class);
                startActivity(listaInventarios);
                break;
            case R.id.button6:
                Intent listaRecordatorios = new Intent(MainActivity.this,Recordatorios.class);
                startActivity(listaRecordatorios);
                break;
            case R.id.button7:
                Intent listaCerrarSesion = new Intent(MainActivity.this,Autenticador.class);
                startActivity(listaCerrarSesion);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
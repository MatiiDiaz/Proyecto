package com.example.ShopHelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ShopHelp.R;

import java.util.ArrayList;
import java.util.List;

public class LugaresInteres extends AppCompatActivity implements View.OnClickListener{
    private Button button_añadir_lugares;
    private ListView lvLugares;
    private EditText etNombre;
    private EditText etUrl;
    private List<String> listaLugares = new ArrayList<>();
    private ArrayAdapter<String> Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares_interes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button_añadir_lugares = findViewById(R.id.button_añadir_lugares);
        button_añadir_lugares.setOnClickListener(this);
        lvLugares = findViewById(R.id.listView);
        etNombre = findViewById(R.id.etNombreLugar);
        etUrl = findViewById(R.id.etUrl);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.button_añadir_lugares) {
            String nombre = etNombre.getText().toString().trim();
            String descripcion = etUrl.getText().toString().trim();
            String producto = nombre + "\n" + descripcion;
            listaLugares.add(producto);
            etNombre.getText().clear();
            etUrl.getText().clear();
            Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaLugares);
            lvLugares.setAdapter(Adapter);
            Toast.makeText(this, "El lugar ha sido agregado con exito", Toast.LENGTH_LONG).show();
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
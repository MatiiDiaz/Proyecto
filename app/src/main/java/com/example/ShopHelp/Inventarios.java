package com.example.ShopHelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.ShopHelp.R;

import java.util.ArrayList;
import java.util.List;

public class Inventarios extends AppCompatActivity implements View.OnClickListener{

    private Button button_añadir_inventario;
    private GridView lvInventario;
    private EditText etNombreInventario;
    private EditText etCantidad;
    private EditText etDescripcionInventario;
    private List<String> listaInventario = new ArrayList<>();
    private ArrayAdapter<String> Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button_añadir_inventario = findViewById(R.id.button_añadir_inventario);
        button_añadir_inventario.setOnClickListener(this);
        lvInventario = findViewById(R.id.gvInventario);
        etNombreInventario = findViewById(R.id.etNombreInventario);
        etCantidad = findViewById(R.id.etCantidad);
        etDescripcionInventario = findViewById(R.id.etDescripcionInventario);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_añadir_inventario) {
            String nombre = etNombreInventario.getText().toString().trim();
            String precio = etCantidad.getText().toString().trim();
            String descripcion = etDescripcionInventario.getText().toString().trim();
            String inventario = nombre + "\nCantidad: " + precio + "\n" + descripcion;
            listaInventario.add(inventario);
            etNombreInventario.getText().clear();
            etCantidad.getText().clear();
            etDescripcionInventario.getText().clear();
            Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaInventario);
            lvInventario.setAdapter(Adapter);
            Toast.makeText(this, "El producto ha sido agregado con exito al inventario", Toast.LENGTH_LONG).show();
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
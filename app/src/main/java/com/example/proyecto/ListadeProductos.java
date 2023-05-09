package com.example.proyecto;

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

import java.util.ArrayList;
import java.util.List;

public class ListadeProductos extends AppCompatActivity implements View.OnClickListener{

    private Button button_añadir;
    private ListView lvProductos;
    private EditText etNombre;
    private EditText etPrecio;
    private EditText etDescripcion;
    private List<String> listaProductos = new ArrayList<>();
    private ArrayAdapter<String> Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listade_productos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button_añadir = findViewById(R.id.button_añadir);
        button_añadir.setOnClickListener(this);
        lvProductos = findViewById(R.id.listView);
        etNombre = findViewById(R.id.etNombreProducto);
        etPrecio = findViewById(R.id.etPrecio);
        etDescripcion = findViewById(R.id.etDescripcion);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_añadir) {
            String nombre = etNombre.getText().toString().trim();
            String precio = etPrecio.getText().toString().trim();
            String descripcion = etDescripcion.getText().toString().trim();
            String producto = nombre + "\n" + precio + "\n" + descripcion;
            listaProductos.add(producto);
            etNombre.getText().clear();
            etPrecio.getText().clear();
            etDescripcion.getText().clear();
            Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaProductos);
            lvProductos.setAdapter(Adapter);
            Toast.makeText(this, "El producto ha sido agregado con exito", Toast.LENGTH_LONG).show();
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
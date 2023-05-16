package com.example.ShopHelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ShopHelp.R;
import com.example.ShopHelp.database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class ListadeCompras extends AppCompatActivity implements View.OnClickListener{

    private Button button_añadir_compra;
    private ListView lvCompras;
    private EditText etNombreCompra;
    private EditText etTotalPagado;
    private EditText etDescripcionCompra;
    private List<String> listaCompras = new ArrayList<>();
    private ArrayAdapter<String> Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listade_compras);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button_añadir_compra = findViewById(R.id.button_añadir_compra);
        button_añadir_compra.setOnClickListener(this);
        lvCompras = findViewById(R.id.listView);
        etNombreCompra = findViewById(R.id.etNombreCompra);
        etTotalPagado = findViewById(R.id.etTotalPagado);
        etDescripcionCompra = findViewById(R.id.etDescripcionCompra);

    }

    public void onClick(View v) {
        DBHelper dbHelper = new DBHelper(ListadeCompras.this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        if (v.getId() == R.id.button_añadir_compra) {
            String nombre = etNombreCompra.getText().toString().trim();
            String pagado = etTotalPagado.getText().toString().trim();
            String descripcion = etDescripcionCompra.getText().toString().trim();
            String producto = nombre + "\n" + pagado + "\n" + descripcion;
            listaCompras.add(producto);
            etNombreCompra.getText().clear();
            etTotalPagado.getText().clear();
            etDescripcionCompra.getText().clear();
            Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCompras);
            lvCompras.setAdapter(Adapter);
            Toast.makeText(this, "La compra ha sido agregada con exito", Toast.LENGTH_LONG).show();
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
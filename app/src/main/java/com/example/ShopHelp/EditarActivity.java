package com.example.ShopHelp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ShopHelp.database.DBInventario;
import com.example.ShopHelp.entity.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditarActivity extends AppCompatActivity{
    EditText etNombre, etPrecio, etMarca, etCantidad;
    Button button_add;
    Product product;
    String id = "0";
    boolean correcto = false;
    FloatingActionButton fabEditar, fabEliminar;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        etNombre = findViewById(R.id.etNombre);
        etPrecio = findViewById(R.id.etPrecio);
        etMarca = findViewById(R.id.etMarca);
        etCantidad = findViewById(R.id.etCantidad);
        button_add = findViewById(R.id.button_add);
        fabEditar = findViewById(R.id.fabEditar);
        fabEliminar = findViewById(R.id.fabEliminar);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                id = String.valueOf(Integer.parseInt(null));
            } else {
                id = extras.getString("ID");
            }
        } else {
            id = (String) savedInstanceState.getSerializable("ID");
        }

        DBInventario dbInventario = new DBInventario(EditarActivity.this);
        product = dbInventario.verProductos(id);
        fabEditar.setVisibility(View.INVISIBLE);
        fabEliminar.setVisibility(View.INVISIBLE);

        if(product != null){
            etNombre.setText(product.getName_producto());
            etPrecio.setText(product.getAmount_producto());
            etMarca.setText(product.getMarca_producto());
            etCantidad.setText(product.getQuantity_producto());
        }
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etNombre.getText().toString().equals("") && !etPrecio.getText().toString().equals("") && !etMarca.getText().toString().equals("") && !etCantidad.getText().toString().equals("")){
                    correcto = dbInventario.editarProducto(id, etNombre.getText().toString(), etPrecio.getText().toString(), etMarca.getText().toString(), etCantidad.getText().toString());
                    if (correcto){
                        Toast.makeText(EditarActivity.this, "Producto modificado", Toast.LENGTH_LONG).show();
                        verRegistro();
                    } else {
                        Toast.makeText(EditarActivity.this, "Error al intentar modificar", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(EditarActivity.this, "No pueden haber campos vacíos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void verRegistro(){
        Intent intent = new Intent(this, VerActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }
}

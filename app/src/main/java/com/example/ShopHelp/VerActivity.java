package com.example.ShopHelp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ShopHelp.database.DBInventario;
import com.example.ShopHelp.entity.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VerActivity extends AppCompatActivity {

    EditText etNombre, etPrecio, etMarca, etCantidad;
    Button button_add;
    Product product;
    String id = "0";
    FloatingActionButton fabEditar, fabEliminar;

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

        DBInventario dbInventario = new DBInventario(VerActivity.this);
        product = dbInventario.verProductos(id);

        if(product != null){
            etNombre.setText(product.getName_producto());
            etPrecio.setText(product.getAmount_producto());
            etMarca.setText(product.getMarca_producto());
            etCantidad.setText(product.getQuantity_producto());
            button_add.setVisibility(View.INVISIBLE);
            etNombre.setInputType(InputType.TYPE_NULL);
            etPrecio.setInputType(InputType.TYPE_NULL);
            etMarca.setInputType(InputType.TYPE_NULL);
            etCantidad.setInputType(InputType.TYPE_NULL);
        }
        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerActivity.this, EditarActivity.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });
        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(VerActivity.this);
                builder.setMessage("¿Está seguro de que desea eliminar este producto?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (dbInventario.eliminarProducto(id)){
                            lista();
                        }

                    }
                })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });
    }
    private void lista(){
        Intent intent = new Intent(this, Inventarios.class);
        startActivity(intent);
    }
}
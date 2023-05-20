package com.example.ShopHelp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.ShopHelp.entity.Product;

import java.util.ArrayList;

public class DBInventario extends DBHelper {

    Context context;
    public DBInventario(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarProducto(String nombre, String precio, String marca, String cantidad) {
        long id = 0;
        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase database = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("name_producto", nombre);
            values.put("amount_producto", precio);
            values.put("marca_producto", marca);
            values.put("quantity_producto", cantidad);

            id = database.insert(TABLE_PRODUCTOS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }
    public ArrayList<Product> mostrarProductos(){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ArrayList<Product> listaProductos = new ArrayList<>();
        Product producto = null;
        Cursor cursorProducto = null;

        cursorProducto = database.rawQuery("SELECT * FROM "+TABLE_PRODUCTOS, null);

        if (cursorProducto.moveToFirst()){
            do {
                producto = new Product();
                producto.setId_producto(cursorProducto.getString(0));
                producto.setName_producto(cursorProducto.getString(1));
                producto.setAmount_producto(cursorProducto.getString(2));
                producto.setMarca_producto(cursorProducto.getString(3));
                producto.setQuantity_producto(cursorProducto.getString(4));
                listaProductos.add(producto);
            } while (cursorProducto.moveToNext());
        }
        cursorProducto.close();
        return listaProductos;
    }

    public Product verProductos(String id){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Product producto = null;
        Cursor cursorProducto;

        cursorProducto = database.rawQuery("SELECT * FROM "+TABLE_PRODUCTOS+" WHERE id_producto = "+id+" LIMIT 1", null);

        if (cursorProducto.moveToFirst()){
                producto = new Product();
                producto.setId_producto(cursorProducto.getString(0));
                producto.setName_producto(cursorProducto.getString(1));
                producto.setAmount_producto(cursorProducto.getString(2));
                producto.setMarca_producto(cursorProducto.getString(3));
                producto.setQuantity_producto(cursorProducto.getString(4));
        }
        cursorProducto.close();
        return producto;
    }

    public boolean editarProducto(String id, String nombre, String precio, String marca, String cantidad) {
        boolean correcto = false;
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        try {
            database.execSQL("UPDATE "+TABLE_PRODUCTOS+" SET name_producto = '"+nombre+"', amount_producto = '"+precio+"', marca_producto = '"+marca+"', quantity_producto = '"+cantidad+"' WHERE id_producto ='"+id+"' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            database.close();
        }
        return correcto;
    }

    public boolean eliminarProducto(String id) {
        boolean correcto = false;
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        try {
            database.execSQL("DELETE FROM "+TABLE_PRODUCTOS+" WHERE id_producto = '"+id+"'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            database.close();
        }
        return correcto;
    }
}


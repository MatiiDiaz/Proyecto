package com.example.ShopHelp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

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
}

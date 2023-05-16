package com.example.ShopHelp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "shopHelp.db";
    public static final String TABLE_PRODUCTOS = "productList";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_PRODUCTOS+"(" +
                "id_producto INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name_producto TEXT NOT NULL," +
                "amount_producto INTEGER NOT NULL," +
                "marca_producto TEXT NOT NULL," +
                "quantity_producto INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_PRODUCTOS);
    }
}

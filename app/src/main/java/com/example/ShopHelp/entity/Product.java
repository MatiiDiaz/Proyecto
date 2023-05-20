package com.example.ShopHelp.entity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ShopHelp.R;

import java.util.Date;

public class Product {
    //private int id_producto, amount_producto, quantity_producto;
    private String id_producto, amount_producto, quantity_producto, name_producto, marca_producto;

    public Product() {

    }

    public Product(String id_producto, String amount_producto, String quantity_producto, String name_producto, String marca_producto) {
        this.id_producto = id_producto;
        this.amount_producto = amount_producto;
        this.quantity_producto = quantity_producto;
        this.name_producto = name_producto;
        this.marca_producto = marca_producto;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getAmount_producto() {
        return amount_producto;
    }

    public void setAmount_producto(String amount_producto) {
        this.amount_producto = amount_producto;
    }

    public String getQuantity_producto() {
        return quantity_producto;
    }

    public void setQuantity_producto(String quantity_producto) {
        this.quantity_producto = quantity_producto;
    }

    public String getName_producto() {
        return name_producto;
    }

    public void setName_producto(String name_producto) {
        this.name_producto = name_producto;
    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }
}

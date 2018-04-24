package com.revata.labproductosapp.app.labproductsapprevata.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.revata.labproductosapp.app.labproductsapprevata.R;
import com.revata.labproductosapp.app.labproductsapprevata.activities.MenuActivity;
import com.revata.labproductosapp.app.labproductsapprevata.repositories.ProductRepository;

public class RegisterProductActivity extends AppCompatActivity {

    TextView nombre,precio,categoria,descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);
        nombre      = findViewById(R.id.nameproduct);
        categoria   = findViewById(R.id.categoria);
        precio      = findViewById(R.id.precio);
        descripcion = findViewById(R.id.descripcion);
    }

    public void registrarProducto(View view){
        String name = nombre.getText().toString();
        Double price = Double.parseDouble(precio.getText().toString());
        String category = categoria.getText().toString();
        String description = descripcion.getText().toString();

        ProductRepository.create(name,category,price,description);

        Toast.makeText(this,"Producto registrado",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MenuActivity.class);

        startActivity(intent);
        finish();
    }
}

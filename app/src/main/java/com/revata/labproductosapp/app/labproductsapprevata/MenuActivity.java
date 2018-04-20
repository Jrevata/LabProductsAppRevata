package com.revata.labproductosapp.app.labproductsapprevata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity {

    private TextView usuario_nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        usuario_nombre = findViewById(R.id.usuario_nombre);
        String valor = getIntent().getExtras().getString("username");
        usuario_nombre.setText(valor);
    }
}

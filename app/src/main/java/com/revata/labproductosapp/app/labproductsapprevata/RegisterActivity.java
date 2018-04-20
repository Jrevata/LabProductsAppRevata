package com.revata.labproductosapp.app.labproductsapprevata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.revata.labproductosapp.app.labproductsapprevata.activities.LogInActivity;
import com.revata.labproductosapp.app.labproductsapprevata.models.User;
import com.revata.labproductosapp.app.labproductsapprevata.repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private EditText nombre;
    private EditText apellidos;
    private EditText correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user = findViewById(R.id.usuario);
        password = findViewById(R.id.password);
        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
        correo = findViewById(R.id.correo);



    }

    public void Registrar(View view){

        String usuario = user.getText().toString();
        String name = nombre.getText().toString();
        String apellido = apellidos.getText().toString();
        String email = correo.getText().toString();
        String contra =  password.getText().toString();

        UserRepository.create(usuario, name, apellido,email,contra);
        Toast.makeText(this,"Registrado",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, LogInActivity.class);

        startActivity(intent);
        finish();


    }
}

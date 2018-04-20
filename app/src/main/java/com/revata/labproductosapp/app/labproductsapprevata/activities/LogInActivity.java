package com.revata.labproductosapp.app.labproductsapprevata.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.revata.labproductosapp.app.labproductsapprevata.MenuActivity;
import com.revata.labproductosapp.app.labproductsapprevata.R;
import com.revata.labproductosapp.app.labproductsapprevata.RegisterActivity;
import com.revata.labproductosapp.app.labproductsapprevata.models.User;
import com.revata.labproductosapp.app.labproductsapprevata.repositories.UserRepository;

public class LogInActivity extends AppCompatActivity {


    private EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        username = findViewById(R.id.usuario);
        password = findViewById(R.id.password);
    }



    public void Registrar(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void logIn(View view){

        String user = username.getText().toString();
        String contra = password.getText().toString();
        User userconf = UserRepository.logIn(user,contra);

        if(userconf!=null){
            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra("username", userconf.getNombre());
            startActivity(intent);

        }else
            Toast.makeText(this,"Usuario o Contraseña invalidos",Toast.LENGTH_LONG).show();
    }

}

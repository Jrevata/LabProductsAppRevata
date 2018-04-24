package com.revata.labproductosapp.app.labproductsapprevata.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.revata.labproductosapp.app.labproductsapprevata.R;
import com.revata.labproductosapp.app.labproductsapprevata.fragments.ArchiveFragment;
import com.revata.labproductosapp.app.labproductsapprevata.fragments.FavoriteFragment;
import com.revata.labproductosapp.app.labproductsapprevata.fragments.ProductsFragment;

public class MenuActivity extends AppCompatActivity {

    private TextView usuario_nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        usuario_nombre = findViewById(R.id.usuario_nombre);

        usuario_nombre.setText("Bienvenido " + LogInActivity.nombre);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = new ProductsFragment();
        fragmentManager.beginTransaction().replace(R.id.content, fragment).addToBackStack("tag").commit();


        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:

                        FragmentManager fragmentManager = getSupportFragmentManager();
                        Fragment fragment = new ProductsFragment();
                        fragmentManager.beginTransaction().replace(R.id.content, fragment).addToBackStack("tag").commit();
                        break;
                    case R.id.menu_favorite:
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        Fragment fragment1 = new FavoriteFragment();
                        fragmentManager1.beginTransaction().replace(R.id.content, fragment1).addToBackStack("tag").commit();
                        break;
 
                    case R.id.menu_archive:
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        Fragment fragment2 = new ArchiveFragment();
                        fragmentManager2.beginTransaction().replace(R.id.content, fragment2).addToBackStack("tag").commit();
                        break;

                }
                return true;
            }
        });


    }

    public void callRegisterForm(View view){
        Intent intent = new Intent(this,RegisterProductActivity.class);
        startActivity(intent);
    }
}

package com.revata.labproductosapp.app.labproductsapprevata.repositories;

import com.orm.SugarRecord;
import com.revata.labproductosapp.app.labproductsapprevata.models.User;

import java.util.List;

/**
 * Created by Alumno on 20/04/2018.
 */

public class UserRepository {

    public static List<User> list(){
        List<User> users= SugarRecord.listAll(User.class);
        return users;
    }


    public static User logIn(String username, String contrasena){
        List<User> users= SugarRecord.listAll(User.class);
        User user = null;

        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsuario().equals(username) && users.get(i).getPassword().equals(contrasena))
                user=users.get(i);
        }

        return user;

    }

    public static void create(String usuario, String nombre, String apellidos,String email, String password){
        User user = new User(usuario,nombre,apellidos,email,password);
        SugarRecord.save(user);
    }




}

package com.revata.labproductosapp.app.labproductsapprevata.models;

import com.orm.dsl.Table;

/**
 * Created by Alumno on 20/04/2018.
 */

@Table
public class User {

    private String usuario;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;

    public User(){}

    public User(String usuario, String nombre, String apellidos, String email, String password) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

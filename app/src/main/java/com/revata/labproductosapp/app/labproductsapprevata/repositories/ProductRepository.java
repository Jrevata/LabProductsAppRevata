package com.revata.labproductosapp.app.labproductsapprevata.repositories;

import com.orm.SugarRecord;
import com.revata.labproductosapp.app.labproductsapprevata.models.Product;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORDAN on 23/04/2018.
 */

public class ProductRepository {

    public static void create(String nombre, String categoria, Double precio, String descripcion){
        Product product = new Product(nombre,categoria,precio,descripcion);
        SugarRecord.save(product);
    }

    public static List<Product> listAll(){
        List<Product> products= SugarRecord.listAll(Product.class);
        return products;
    }

    public static List<Product> listAllIf(){
        List<Product> products = listAll();
        List<Product> products1 = new ArrayList<>();

        for (int i = 0; i < products.size();i++) {
            if(!products.get(i).getArchivado()) {
                products1.add(products.get(i));
            }
        }

        return products1;
    }

    public static List<Product> listAllFavorites(){
        List<Product> products = listAll();
        List<Product> products1 = new ArrayList<>();

        for (Product producto: products) {
            if(producto.getFavorito()) {
                products1.add(producto);
            }
        }

        return products1;
    }

    public static List<Product> listAllArchives(){
        List<Product> products = listAll();
        List<Product> products1 = new ArrayList<>();

        for (Product producto: products) {
            if(producto.getArchivado()) {
                products1.add(producto);
            }
        }

        return products1;
    }

    public static void updateFavorite(String nombre){


        List<Product> products = listAll();
        Product products1 = new Product();

        for (Product producto: products) {
            if(producto.getNombre().equals(nombre)) {
                products1 = producto;
            }
        }
        products1.setFavorito(true);
        SugarRecord.save(products1);

    }

    public static void updateArchive(String nombre){


        List<Product> products = listAll();
        Product products1 = new Product();

        for (Product producto: products) {
            if(producto.getNombre().equals(nombre)) {
                products1 = producto;
            }
        }
        products1.setArchivado(true);
        products1.setFavorito(false);
        SugarRecord.save(products1);

    }
}

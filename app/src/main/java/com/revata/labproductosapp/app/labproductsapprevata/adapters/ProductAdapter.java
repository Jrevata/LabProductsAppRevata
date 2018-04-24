package com.revata.labproductosapp.app.labproductsapprevata.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.revata.labproductosapp.app.labproductsapprevata.R;
import com.revata.labproductosapp.app.labproductsapprevata.models.Product;
import com.revata.labproductosapp.app.labproductsapprevata.repositories.ProductRepository;

import java.util.List;

/**
 * Created by JORDAN on 24/04/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> products;

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtnombre, txtprecio, txtdescripcion;
        Button btnFavorite,btnArchive;

        public ViewHolder(View itemView) {
            super(itemView);
            txtnombre = itemView.findViewById(R.id.txtnameproduct);
            txtprecio = itemView.findViewById(R.id.txtprecio);
            txtdescripcion = itemView.findViewById(R.id.txtdescripcion);
            btnFavorite = itemView.findViewById(R.id.btnFavorite);
            btnArchive = itemView.findViewById(R.id.btnArchive);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Product product = products.get(position);

        holder.txtnombre.setText(product.getNombre());
        holder.txtprecio.setText(product.getPrecio().toString());
        holder.txtdescripcion.setText(product.getDescripcion());

        holder.btnArchive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductRepository.updateArchive(product.getNombre());
                Toast.makeText(holder.itemView.getContext(),"Añadido a Archivados",Toast.LENGTH_LONG).show();
            }
        });

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductRepository.updateFavorite(product.getNombre());
                Toast.makeText(holder.itemView.getContext(),"Añadido a Favoritos",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
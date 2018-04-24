package com.revata.labproductosapp.app.labproductsapprevata.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.revata.labproductosapp.app.labproductsapprevata.R;
import com.revata.labproductosapp.app.labproductsapprevata.adapters.ProductAdapter;
import com.revata.labproductosapp.app.labproductsapprevata.models.Product;
import com.revata.labproductosapp.app.labproductsapprevata.repositories.ProductRepository;

import java.util.List;

/**
 * Created by JORDAN on 24/04/2018.
 */

public class ArchiveFragment extends Fragment {

    private static final String TAG = ArchiveFragment.class.getSimpleName();
    private RecyclerView recyclerView;

    public ArchiveFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        List<Product> products = ProductRepository.listAllArchives();
        ProductAdapter adapter = new ProductAdapter();
        adapter.setProducts(products);
        recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onCreateView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onCreateView");
    }

}

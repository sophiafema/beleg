package com.sophiafema.belegrecyclerview.lists;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sophiafema.belegrecyclerview.CreateActivity;
import com.sophiafema.belegrecyclerview.data.Product;
import com.sophiafema.belegrecyclerview.R;
import com.sophiafema.belegrecyclerview.view.ProduktViewModel;

import java.util.List;

public class EinkaufslisteActivity extends AppCompatActivity {

    List<Product> listOfProducts;

    RecyclerView rec;
    LayoutInflater inf;
    EinkaufslisteProduktAdapter adp;

    private ProduktViewModel mProductViewModel;

    private FloatingActionButton fab;

    public static final int NEW_PRODUCT_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.einkaufsliste_main);


        mProductViewModel = ViewModelProviders.of(this).get(ProduktViewModel.class);
        mProductViewModel.getAllProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                // Update the cached copy of the words in the adapter.
                adp.setProducts(products);
            }
        });

        //RECYCLERVIEW
        rec = findViewById(R.id.rec_einkaufsliste);
        inf = getLayoutInflater();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rec.setLayoutManager(layoutManager);

        //divider
        rec.addItemDecoration(new DividerItemDecoration(rec.getContext(), DividerItemDecoration.VERTICAL));



        //adapter
        adp = new EinkaufslisteProduktAdapter(this);
        rec.setAdapter(adp);

        fab = findViewById(R.id.fab_add_einkaufsliste);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EinkaufslisteActivity.this, CreateActivity.class);
                startActivityForResult(intent, NEW_PRODUCT_ACTIVITY_REQUEST_CODE);
            }
        });

        //DELETE ALL BTN
        Button deleteAll = findViewById(R.id.btn_deleteAll_einkaufsliste);
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EinkaufslisteActivity.this, "Clear all data", Toast.LENGTH_SHORT).show();
                //Delete existing data
                mProductViewModel.deleteAll();
            }
        });


        //SWIPE TO DELETE ONE ITEM
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                        int position = viewHolder.getAdapterPosition();
                        Product product = adp.getProductAtPosition(position);
                        Toast.makeText(EinkaufslisteActivity.this, "Deleting" + product.getProduktname(), Toast.LENGTH_SHORT).show();

                        //delete word
                        mProductViewModel.deleteProduct(product);
                    }
                }
        );
        itemTouchHelper.attachToRecyclerView(rec);


    }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_PRODUCT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Product p = new Product(data.getStringExtra(CreateActivity.EXTRA_REPLY), "", false);
            mProductViewModel.insertProduct(p);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }



}

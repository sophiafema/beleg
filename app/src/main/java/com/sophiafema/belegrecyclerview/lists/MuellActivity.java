package com.sophiafema.belegrecyclerview.lists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.sophiafema.belegrecyclerview.data.Product;
import com.sophiafema.belegrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class MuellActivity extends AppCompatActivity {

    List<Product> listOfProducts;

    RecyclerView rec;
    LayoutInflater inf;
    MuellProduktAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.muell_main);

        //anders --> aus bestand datenbank
        listOfProducts = new ArrayList<>();
        for(int i = 0; i<17; i++)
        {
            String pn = "produkt #" + i;
            listOfProducts.add(new Product(pn, "", false));
        }

        //RECYCLERVIEW
        rec = findViewById(R.id.rec_muell);
        inf = getLayoutInflater();
        rec.setLayoutManager(new LinearLayoutManager(this));
        //vertikale trennung der items
        rec.addItemDecoration(new DividerItemDecoration(rec.getContext(), DividerItemDecoration.VERTICAL));
        //adapter
        adp = new MuellProduktAdapter(listOfProducts);
        rec.setAdapter(adp);
    }
}

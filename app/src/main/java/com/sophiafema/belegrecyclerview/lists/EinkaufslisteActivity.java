package com.sophiafema.belegrecyclerview.lists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.sophiafema.belegrecyclerview.Produkt;
import com.sophiafema.belegrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class EinkaufslisteActivity extends AppCompatActivity {

    List<Produkt> listOfProducts;

    RecyclerView rec;
    LayoutInflater inf;
    EinkaufslisteProduktAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.einkaufsliste_main);

        //anders --> aus einkaufsliste datenbank
        listOfProducts = new ArrayList<>();
        for(int i = 0; i<17; i++)
        {
            String pn = "produkt #" + i;
            listOfProducts.add(new Produkt(pn, "", false));
        }

        //RECYCLERVIEW
        rec = findViewById(R.id.rec_einkaufsliste);
        inf = getLayoutInflater();
        rec.setLayoutManager(new LinearLayoutManager(this));
        //vertikale trennung der items
        rec.addItemDecoration(new DividerItemDecoration(rec.getContext(), DividerItemDecoration.VERTICAL));
        //adapter
        adp = new EinkaufslisteProduktAdapter(listOfProducts);
        rec.setAdapter(adp);


    }
}

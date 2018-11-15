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

public class BestandActivity extends AppCompatActivity {

    List<Produkt> listOfProducts;

    RecyclerView rec;
    LayoutInflater inf;
    BestandProduktAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.bestand_main);

        //anders --> aus bestand datenbank
        listOfProducts = new ArrayList<>();
        for(int i = 0; i<17; i++)
        {
            String pn = "produkt #" + i;
            listOfProducts.add(new Produkt(pn, "", false));
        }

        //RECYCLERVIEW
        rec = findViewById(R.id.rec_bestand);
        inf = getLayoutInflater();
        rec.setLayoutManager(new LinearLayoutManager(this));
        //vertikale trennung der items
        rec.addItemDecoration(new DividerItemDecoration(rec.getContext(), DividerItemDecoration.VERTICAL));
        //adapter
        adp = new BestandProduktAdapter(listOfProducts);
        rec.setAdapter(adp);
    }
}

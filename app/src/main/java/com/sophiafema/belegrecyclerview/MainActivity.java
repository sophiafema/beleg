package com.sophiafema.belegrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Produkt> listOfProducts;

    RecyclerView rec;
    LayoutInflater inf;
    ProduktAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //anders
        listOfProducts = new ArrayList<>();
        for(int i = 0; i<7; i++)
        {
            String pn = "produkt #" + i;
            listOfProducts.add(new Produkt(pn, "", false));
        }

        rec = findViewById(R.id.rec_einkaufsliste);
        inf = getLayoutInflater();
        rec.setLayoutManager(new LinearLayoutManager(this));
        adp = new ProduktAdapter(listOfProducts);
        rec.setAdapter(adp);


    }
}

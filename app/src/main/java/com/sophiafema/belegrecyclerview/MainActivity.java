package com.sophiafema.belegrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    RecyclerView rec;
    LayoutInflater inf;
    CustomAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rec = findViewById(R.id.rec_einkaufsliste);
        inf = getLayoutInflater();
        rec.setLayoutManager(new LinearLayoutManager(this));
        adp = new CustomAdapter();
        rec.setAdapter(adp);


    }

    class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>
    {

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public class CustomViewHolder {
        }
    }
}

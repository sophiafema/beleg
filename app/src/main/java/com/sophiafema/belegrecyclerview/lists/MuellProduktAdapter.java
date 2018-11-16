package com.sophiafema.belegrecyclerview.lists;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sophiafema.belegrecyclerview.data.Product;
import com.sophiafema.belegrecyclerview.R;

import java.util.List;

public class MuellProduktAdapter extends RecyclerView.Adapter<MuellProduktAdapter.MuellViewHolder> {

    protected List<Product> produkte;
    public MuellProduktAdapter(List<Product> produkte) {
        this.produkte = produkte;
    }

    /**
     * Item layout festlegen --> Layout entw. bestand oder einkaufslliste
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public MuellViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.muell_item, viewGroup, false);
        return new MuellViewHolder(v);
    }

    /**
     * Item layouts mit werten füllen
     * Items stellen bezeichnung aus klasse ProduktViewHolder
     * @param customViewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull MuellViewHolder customViewHolder, int i) {
        Product p = produkte.get(i);
        customViewHolder.produktname.setText(p.getProduktname());
    }

    @Override
    public int getItemCount() {
        return produkte.size();
    }

    public class MuellViewHolder extends RecyclerView.ViewHolder {
        //Wichtige Angaben in ListItem definieren
        private TextView produktname;
        private ImageButton menubtn;

        public MuellViewHolder(@NonNull View itemView) {
            super(itemView);
            //je nach layout
            this.produktname = itemView.findViewById(R.id.txt_produktname_muell);
        }
    }

}

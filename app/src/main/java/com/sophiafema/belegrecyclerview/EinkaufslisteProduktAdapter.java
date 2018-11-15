package com.sophiafema.belegrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EinkaufslisteProduktAdapter extends RecyclerView.Adapter<EinkaufslisteProduktAdapter.ProduktViewHolder>
{
    protected List<Produkt> produkte;
    public EinkaufslisteProduktAdapter(List<Produkt> produkte) {
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
    public ProduktViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bestand_item, viewGroup, false);
        return new ProduktViewHolder(v);
    }

    /**
     * Item layouts mit werten füllen
     * Items stellen bezeichnung aus klasse ProduktViewHolder
     * @param customViewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull ProduktViewHolder customViewHolder, int i) {
        Produkt p = produkte.get(i);
        customViewHolder.produktname.setText(p.getProduktname());

    }

    @Override
    public int getItemCount() {
        return produkte.size();
    }

    public class ProduktViewHolder extends RecyclerView.ViewHolder {
        //Wichtige Angaben in ListItem definieren
        private TextView produktname;

        public ProduktViewHolder(@NonNull View itemView) {
            super(itemView);
            //je nach layout
            this.produktname = itemView.findViewById(R.id.txt_produktname_bestand);
        }
    }
}

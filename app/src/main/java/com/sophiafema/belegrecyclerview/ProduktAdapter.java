package com.sophiafema.belegrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>
{
    protected List<Produkt> produkte;
    public CustomAdapter(List<Produkt> produkte) {
        this.produkte = produkte;
    }

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
        return produkte.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}

package com.sophiafema.belegrecyclerview.lists;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sophiafema.belegrecyclerview.data.Product;
import com.sophiafema.belegrecyclerview.R;

import java.util.List;

public class EinkaufslisteProduktAdapter extends RecyclerView.Adapter<EinkaufslisteProduktAdapter.ProduktViewHolder>
{
    protected List<Product> mProducts;
    private final LayoutInflater mInflater;

    public EinkaufslisteProduktAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

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
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.einkaufsliste_item, viewGroup, false);
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
        /*Product p = mProducts.get(i);
        customViewHolder.produktname.setText(p.getProduktname());*/

        if(mProducts != null)
        {
            Product current = mProducts.get(i);
            customViewHolder.produktname.setText(current.getProduktname());
        }
        else
            customViewHolder.produktname.setText("No Product");
    }

    void setProducts (List<Product> products)
    {
        mProducts = products;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mProducts != null)
            return mProducts.size();
        else
            return 0;
    }

    public class ProduktViewHolder extends RecyclerView.ViewHolder {
        //Wichtige Angaben in ListItem definieren
        private TextView produktname;

        public ProduktViewHolder(@NonNull View itemView) {
            super(itemView);
            //je nach layout
            this.produktname = itemView.findViewById(R.id.txt_produktname_einkaufsliste);
        }
    }


    //swipe to delete
    public Product getProductAtPosition(int position)
    {
        return mProducts.get(position);
    }
}

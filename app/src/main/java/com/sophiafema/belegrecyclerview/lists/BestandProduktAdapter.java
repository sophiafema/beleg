package com.sophiafema.belegrecyclerview.lists;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.sophiafema.belegrecyclerview.data.Product;
import com.sophiafema.belegrecyclerview.R;

import java.util.List;

public class BestandProduktAdapter extends RecyclerView.Adapter<BestandProduktAdapter.ProduktViewHolder>
{
    protected List<Product> produkte;
    public BestandProduktAdapter(List<Product> produkte) {
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
        final int position = i;
        Product p = produkte.get(i);
        customViewHolder.produktname.setText(p.getProduktname());
        customViewHolder.menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v, position);
            }
        });
    }

   private void showPopupMenu(View view, int position)
   {
       PopupMenu popupMenu = new PopupMenu(view.getContext(),view );
       MenuInflater inflater = popupMenu.getMenuInflater();
       inflater.inflate(R.menu.bestand_options_menu, popupMenu.getMenu());
       popupMenu.setOnMenuItemClickListener(new BestandPopupMenuClickListener(position));
       popupMenu.show();

   }

    @Override
    public int getItemCount() {
        return produkte.size();
    }

    public class ProduktViewHolder extends RecyclerView.ViewHolder {
        //Wichtige Angaben in ListItem definieren
        private TextView produktname;
        private ImageButton menubtn;

        public ProduktViewHolder(@NonNull View itemView) {
            super(itemView);
            //je nach layout
            this.produktname = itemView.findViewById(R.id.txt_produktname_bestand);
            this.menubtn = itemView.findViewById(R.id.imgbtn_options_bestand);
        }
    }
}

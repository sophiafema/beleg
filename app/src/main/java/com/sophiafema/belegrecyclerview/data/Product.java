package com.sophiafema.belegrecyclerview.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (tableName = "product_table")
public class Product {

    @PrimaryKey (autoGenerate = true)
    private int id;

    @ColumnInfo (name = "produkt_name")
    private String produktname;
    @ColumnInfo (name = "menge")
    private String menge;
    @ColumnInfo (name = "favorit")
    boolean favorit;

    boolean inBestand;
    boolean inEinkaufsliste;
    boolean inMuell;

    int anzInBestand;
    int anzInEinkaufsliste;
    int anzInMuell;

    public Product(@NonNull String produktname, String menge, boolean favorit) {
        this.produktname = produktname;
        this.menge = menge;
        this.favorit = favorit;


    }

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduktname() {
        return produktname;
    }

    public void setProduktname(String produktname) {
        this.produktname = produktname;
    }

    public String getMenge() {
        return menge;
    }

    public void setMenge(String menge) {
        this.menge = menge;
    }

    public boolean isFavorit() {
        return favorit;
    }

    public void setFavorit(boolean favorit) {
        this.favorit = favorit;
    }
}

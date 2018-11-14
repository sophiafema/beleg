package com.sophiafema.belegrecyclerview;

public class Produkt {

    private String produktname;
    private String menge;
    boolean favorit;

    public Produkt(String produktname, String menge, boolean favorit) {
        this.produktname = produktname;
        this.menge = menge;
        this.favorit = favorit;
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

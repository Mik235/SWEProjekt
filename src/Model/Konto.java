package Model;

import java.text.DecimalFormat;

public abstract class Konto {
    private int kontoNr;
    private double kontoStand;
    private String kontoTyp;

    public Konto(int kontoNr, double kontoStand, String kontoTyp) {
        this.kontoNr = kontoNr;
        this.kontoStand = kontoStand;
        this.kontoTyp = kontoTyp;
    }
    
    
    public void buchen(double p_buchen){
        kontoStand += p_buchen;
    }

    public int getKontoNr() {
        return kontoNr;
    }

    public void setKontoNr(int kontoNr) {
        this.kontoNr = kontoNr;
    }

    public double getKontoStand() {
        return kontoStand;
    }

    public void setKontoStand(double kontoStand) {
        this.kontoStand = kontoStand;
    }

    public String getKontoTyp() {
        return kontoTyp;
    }

    public void setKontoTyp(String kontoTyp) {
        this.kontoTyp = kontoTyp;
    }
}

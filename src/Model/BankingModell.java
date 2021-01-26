package Model;

import java.util.ArrayList;

public class BankingModell {
    ArrayList<KontomitLog> konten = new ArrayList<>();

    public BankingModell() {

    }
    public void addkonto(int typ){
        if(typ==0){
           konten.add(new KontomitLog(new SparkKonto(konten.size(),0,"Sparkonto")));
        }
        else if (typ==1){
            konten.add(new KontomitLog(new GiroKonto(konten.size(),0,"Girokonto")));
        }
    }
}

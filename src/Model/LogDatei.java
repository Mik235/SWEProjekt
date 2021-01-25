package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class LogDatei implements Serializable {
    ArrayList<Eventt2> eventt2s =new ArrayList<>();
    public LogDatei() {

    }
    public void addEintrag(String sachbekürz, int kontonr, double kontostandvdb, double buchungsbetrag, double kontostandndb){
        eventt2s.add(new Eventt2(eventt2s.size(),sachbekürz,kontonr,kontostandvdb,buchungsbetrag,kontostandndb));

    }

    public ArrayList<Eventt2> getEvents() {
        return eventt2s;
    }
}

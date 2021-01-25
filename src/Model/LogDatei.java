package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class LogDatei implements Serializable {
    ArrayList<event> events=new ArrayList<>();
    public LogDatei() {

    }
    public void addEintrag(String sachbekürz, int kontonr, double kontostandvdb, double buchungsbetrag, double kontostandndb){
        events.add(new event(events.size(),sachbekürz,kontonr,kontostandvdb,buchungsbetrag,kontostandndb));

    }

    public ArrayList<event> getEvents() {
        return events;
    }
}

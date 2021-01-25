package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class LogDatei implements Serializable {
    ArrayList<Event> Events =new ArrayList<>();
    public LogDatei() {

    }
    public void addEintrag(String sachbekürz, int kontonr, double kontostandvdb, double buchungsbetrag, double kontostandndb){
        Events.add(new Event(Events.size(),sachbekürz,kontonr,kontostandvdb,buchungsbetrag,kontostandndb));

    }

    public ArrayList<Event> getEvents() {
        return Events;
    }
}

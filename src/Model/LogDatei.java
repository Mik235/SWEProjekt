package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class LogDatei implements Serializable {
    ArrayList<Event> events =new ArrayList<>();
    public LogDatei() {

    }
    public void addEintrag(String sachbekuerz, int kontonr, double kontostandvdb, double buchungsbetrag, double kontostandndb){
        events.add(new Event(events.size(),sachbekuerz,kontonr,kontostandvdb,buchungsbetrag,kontostandndb));

    }

    public ArrayList<Event> getEvents() {
        return events;
    }
}

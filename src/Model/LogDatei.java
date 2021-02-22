package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LogDatei implements Serializable {
    String txtkurzel;

    ArrayList<Event> events =new ArrayList<>();
    public LogDatei() {

    }
    public void addEintrag(String sachbekuerz, int kontonr, double kontostandvdb, double buchungsbetrag, double kontostandndb){
        events.add(new Event(events.size(),sachbekuerz,kontonr,kontostandvdb,buchungsbetrag,kontostandndb));

        LocalDate now = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");
    }

    private String txtKuerzelholen() {
       return txtkurzel;
    }


    public ArrayList<Event> getEvents() {
        return events;
    }
}

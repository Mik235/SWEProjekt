package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class LogDatei implements Serializable {
    ArrayList<Event> events =new ArrayList<>();
    public LogDatei() {

    }
    public void addEintrag(String sachbekuerz, int kontonr, double kontostandvdb, double buchungsbetrag, double kontostandndb){
        events.add(new Event(events.size(),sachbekuerz,kontonr,kontostandvdb,buchungsbetrag,kontostandndb));

        String einfuegen = sachbekuerz + "" + kontonr + " "+ kontostandvdb + " " + buchungsbetrag + " " + kontostandndb;
        txtschreiben(einfuegen);
    }

    private void txtschreiben(String einfuegen) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("logDatei.txt", true))) {
            bw.write(String.valueOf(einfuegen + "\n"));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Event> getEvents() {
        return events;
    }
}

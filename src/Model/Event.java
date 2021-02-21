package Model;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {
    int datiZeilnr;
    String sachbekuerz;
    int Kontonr;
    double Kontostandvdb;
    double Buchungsbetrag;
    double Kontostandndb;
    Date Buchungsdatum;

    public Event(int datiZeilnr, String sachbekuerz, int kontonr, double kontostandvdb, double buchungsbetrag, double kontostandndb) {
        this.datiZeilnr = datiZeilnr;
        this.sachbekuerz = sachbekuerz;
        Kontonr = kontonr;
        Kontostandvdb = kontostandvdb;
        Buchungsbetrag = buchungsbetrag;
        Kontostandndb = kontostandndb;
        Buchungsdatum=new Date();
    }

    @Override
    public String toString() {
        return "Event{" +
                "datiZeilnr=" + datiZeilnr +
                ", sachbekuerz='" + sachbekuerz + '\'' +
                ", Kontonr=" + Kontonr +
                ", Kontostandvdb=" + Kontostandvdb +
                ", Buchungsbetrag=" + Buchungsbetrag +
                ", Kontostandndb=" + Kontostandndb +
                ", Buchungsdatum=" + Buchungsdatum +
                '}';
    }

    public int getDatiZeilnr() {
        return datiZeilnr;
    }

    public String getSachbekuerz() {
        return sachbekuerz;
    }

    public int getKontonr() {
        return Kontonr;
    }

    public double getKontostandvdb() {
        return Kontostandvdb;
    }

    public double getBuchungsbetrag() {
        return Buchungsbetrag;
    }

    public double getKontostandndb() {
        return Kontostandndb;
    }

    public Date getBuchungsdatum() {
        return Buchungsdatum;
    }
}

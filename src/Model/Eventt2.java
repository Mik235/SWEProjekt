package Model;

import java.io.Serializable;
import java.util.Date;

public class Eventt2 implements Serializable {
    int datiZeilnr;
    String sachbekürz;
    int Kontonr;
    double Kontostandvdb;
    double Buchungsbetrag;
    double Kontostandndb;
    Date Buchungsdatum;

    public Eventt2(int datiZeilnr, String sachbekürz, int kontonr, double kontostandvdb, double buchungsbetrag, double kontostandndb) {
        this.datiZeilnr = datiZeilnr;
        this.sachbekürz = sachbekürz;
        Kontonr = kontonr;
        Kontostandvdb = kontostandvdb;
        Buchungsbetrag = buchungsbetrag;
        Kontostandndb = kontostandndb;
        Buchungsdatum=new Date();
    }

    public int getDatiZeilnr() {
        return datiZeilnr;
    }

    public String getSachbekürz() {
        return sachbekürz;
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

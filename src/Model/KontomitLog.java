package Model;

import java.io.Serializable;

public class KontomitLog implements Serializable {

    LogDatei log;
    Konto k;

    public KontomitLog(Konto in) {
        log=new LogDatei();
        k=in;

    }
    public void buchen(double betrag,String sachbea){
        log.addEintrag(sachbea,k.getKontoNr(),k.getKontoStand(),betrag,(k.getKontoStand()+betrag));
        k.setKontoStand(k.getKontoStand()+betrag);
    }
}

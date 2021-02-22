package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class BankingModell {
    ArrayList<KontomitLog> konten = new ArrayList<KontomitLog>();
    FileController writer= new FileController();
    int selkonto=0;
    Random rdm = new Random();
    boolean exists =false;

    /**
     * BankinModell erstellt neues Konto
     *
     *
     */
    public BankingModell() {

        konten.add(new KontomitLog(new SparkKonto(0,0,"Sparkonto")));
    }

    /**
     *
     * @param typ übergibt welcher Kontotyp erstellt werden soll
     *            0 = Sparkonto
     *            1 = Girokonto
     * @param knr übergibt die erstellte Kontonummer
     */
    public void addkonto(int typ,int knr){
        if(typ==0){
           konten.add(new KontomitLog(new SparkKonto(knr,0,"Sparkonto")));
        }
        else if (typ==1){
            konten.add(new KontomitLog(new GiroKonto(knr,0,"Girokonto")));
        }
    }

    /**
     * searchcreate checked ob ein Konto erstellt werden soll oder nicht.
     * Im Fall, dass ein Konto erstellt werden soll wird anschließend der Typ abegefragt.
     *Anschließend wird für das jeweilige Konto eine zufällige Kontonummer erstellt.
     * Bei falsch eingabe werden die jeweilige Fehlermeldung angezeigt
     * @param in Um ein neues Konto zu erstellen muss "neues Konto" geschrieben werden
     * @return Wenn die Konto erstellung erfolgreich war wird die erstellte Kontonummer als String returned.
     */

    public String searchorcreate(String in){
        if(in.equals("neues Konto")){
            String intmp= JOptionPane.showInputDialog(null,"Was für ein Konto soll erstellt werden? Sparbuch oder Girokonto.");
            if(intmp.equals("Sparbuch")){
                int neueKOntoNummer =rdm.nextInt();
                if(neueKOntoNummer<0){
                    neueKOntoNummer=neueKOntoNummer*-1;
                }
                while (true){
                    if(ksuchen(neueKOntoNummer)!=null){
                        neueKOntoNummer=rdm.nextInt();
                        if(neueKOntoNummer<0){
                            neueKOntoNummer=neueKOntoNummer*-1;
                        }
                    }
                    else break;
                }
                addkonto(0,neueKOntoNummer);
                return Integer.toString(neueKOntoNummer);
            }
                else if(intmp.equals("Girokonto")){
                int neueKOntoNummer =rdm.nextInt();
                if(neueKOntoNummer<0){
                    neueKOntoNummer=neueKOntoNummer*-1;
                }
                while (true){
                    if(ksuchen(neueKOntoNummer)!=null){
                        neueKOntoNummer=rdm.nextInt();
                        if(neueKOntoNummer<0){
                            neueKOntoNummer=neueKOntoNummer*-1;
                        }
                    }
                    else break;
                }
                    addkonto(1,neueKOntoNummer);
                return Integer.toString(neueKOntoNummer);
            }
                else {
                    JOptionPane.showMessageDialog(null,"Kein valider Kontotyp eingegeben");
            }

        }
        else {
            int tmp=0;
            try {
                tmp=Integer.parseInt(in);
                if(ksuchen(tmp)==null){
                    return "Keine Valide/Verfügbare Kontonummer";
                }
                selkonto = (int) ksuchen(tmp);
                exists=true;


            } catch (NumberFormatException e) {
                e.printStackTrace();
                return "keine Zahl obwohl zahl gefordert";
            }
        }
        return "";
    }

    /**
     * Gibt die Erstellte Arraylist vom Typ KontomitLog
     * @return Es werden die eingetragenen Konten returned
     */
    public ArrayList<KontomitLog> getKonten() {
        return konten;
    }

    /**
     * ksuchen sucht die übergebene Kontonummer in der Liste aller Konten
     * @param kontonummer die gesuchte Kotnonummer
     * @return das gefundene Konto
     */
    public  Number  ksuchen (int kontonummer ){
        for (int i = 0; i < konten.size(); i++) {
            if(konten.get(i).getK().getKontoNr()==kontonummer){
                System.out.println(i);
                return i;
            }

        }
        exists=false;
        return null;
    }

    /**
     * safedata speichert die Daten Binär in einer .dat Datei
     */
    public void safedata() {
        writer.safeDataBinaer(konten);
    }

    /**
     * Liest die Binären Daten aus der Datei aus
     */
    public void readData(){
       konten= writer.readBinaer();
    }

    /**
     * Prüft ob Konto existiert
     * @return gibt True zurück wenn Konto existiert sonst false
     */
    public boolean isExists() {
        return exists;
    }

    public int getSelkonto() {
        return selkonto;
    }
    public String newKonto(){
        String intmp= JOptionPane.showInputDialog(null,"Was für ein Konto soll erstellt werden? Sparbuch oder Girokonto.");
        if(intmp.equals("Sparbuch")){
            int neueKOntoNummer =rdm.nextInt();
            if(neueKOntoNummer<0){
                neueKOntoNummer=neueKOntoNummer*-1;
            }
            while (true){
                if(ksuchen(neueKOntoNummer)!=null){
                    neueKOntoNummer=rdm.nextInt();
                    if(neueKOntoNummer<0){
                        neueKOntoNummer=neueKOntoNummer*-1;
                    }
                }
                else break;
            }
            addkonto(0,neueKOntoNummer);
            return Integer.toString(neueKOntoNummer);
        }
        else if(intmp.equals("Girokonto")){
            int neueKOntoNummer =rdm.nextInt();
            if(neueKOntoNummer<0){
                neueKOntoNummer=neueKOntoNummer*-1;
            }
            while (true){
                if(ksuchen(neueKOntoNummer)!=null){
                    neueKOntoNummer=rdm.nextInt();
                    if(neueKOntoNummer<0){
                        neueKOntoNummer=neueKOntoNummer*-1;
                    }
                }
                else break;
            }
            addkonto(1,neueKOntoNummer);
            return Integer.toString(neueKOntoNummer);
        }
        else {
            JOptionPane.showMessageDialog(null,"Kein valider Kontotyp eingegeben");
        }
        return "";
    }
    /**
     * buchen bucht die angegebene Menge entweder ab oder zu
     * Anschließend wird der Vorgang in der Arraylist und in der Log Datei gespeichert
     * @param input Geld Summe
     * @param sachbe Welcher Sachbearbeiter die Buchung bearbeitet hat
     */
    public void buchen(String input,String sachbe){
        Double tmp=0.0;
        try {
            tmp =Double.parseDouble(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"NUR ZAHLEN EINGEBEN!");
            e.printStackTrace();

        }

        konten.get(selkonto).buchen(tmp,sachbe);
        writer.append(konten.get(selkonto).getLog().getEvents(),Integer.toString(konten.get(selkonto).getK().getKontoNr()));
    }
}

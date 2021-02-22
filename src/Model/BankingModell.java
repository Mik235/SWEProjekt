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
    
    public BankingModell() {
        konten.add(new KontomitLog(new SparkKonto(0,0,"Sparkonto")));
    }
    public void addkonto(int typ,int knr){
        //Konten anlegen
        if(typ==0){
           konten.add(new KontomitLog(new SparkKonto(knr,0,"Sparkonto")));
        }
        else if (typ==1){
            konten.add(new KontomitLog(new GiroKonto(knr,0,"Girokonto")));
        }
    }

    public String searchorcreate(String in){

        if(in.equals("neues Konto")){
            //Neues Konto anlegen
            String intmp= JOptionPane.showInputDialog(null,"Was für ein Konto soll erstellt werden? Sparbuch oder Girokonto.");
            if(intmp.equals("Sparbuch")){
                //Mit Kontotyp Sparbuch anlegen
                int neueKOntoNummer =rdm.nextInt();
                if(neueKOntoNummer<0){
                    //Automatische Vergabe der Kontonr
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
                    //Konto mit dem Typ Girokonto anlegen
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
            //Es soll kein neues Konto angelegt werden, Kontonr wird geprüft
            int tmp=0;
            try {
                tmp=Integer.parseInt(in);
                if(ksuchen(tmp)==null){
                    //Kontonr existiert nicht
                    return "Keine Valide/Verfügbare Kontonummer";
                }
                selkonto = (int) ksuchen(tmp);
                System.out.println(selkonto);
                exists=true;

            } catch (NumberFormatException e) {
                e.printStackTrace();
                return "keine Zahl obwohl zahl gefordert";
            }
        }
        return "";
    }
    public ArrayList<KontomitLog> getKonten() {
        return konten;
    }
    public  Number  ksuchen (int kontonummer ){
        //Kontonr in existierenden Konten suchen
        System.out.println(konten.size());
        for (int i = 0; i < konten.size(); i++) {
            if(konten.get(i).getK().getKontoNr()==kontonummer){
                System.out.println(i);
                return i;
            }

        }
        System.out.println("NO");
        exists=false;
        return null;
    }

    public void safedata() {
        writer.safeDataBinaer(konten);
    }
    public void readData(){
       konten= writer.readBinaer();
    }

    public boolean isExists() {
        return exists;
    }

    public int getSelkonto() {
        return selkonto;
    }
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

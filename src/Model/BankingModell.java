package Model;

import javax.swing.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class BankingModell {
    ArrayList<KontomitLog> konten = new ArrayList<KontomitLog>();
    FileController writer= new FileController();
    int selkonto=0;
    Random rdm = new Random();

    public BankingModell() {

    }
    public void addkonto(int typ,int knr){
        if(typ==0){
           konten.add(new KontomitLog(new SparkKonto(knr,0,"Sparkonto")));
        }
        else if (typ==1){
            konten.add(new KontomitLog(new GiroKonto(knr,0,"Girokonto")));
        }
    }
   
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
                System.out.println(selkonto);

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
        for (int i = 0; i < konten.size(); i++) {
            if(konten.get(i).getK().getKontoNr()==kontonummer){
                System.out.println(i);
                return i;
            }

        }
        System.out.println("NO");
        return null;
    }

    public void safedata() {
        writer.safeDataBinaer(konten);
    }
    public void readData(){
       konten= writer.readBinaer();
    }
}

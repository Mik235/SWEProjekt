package Model;

import javax.swing.*;
import java.io.FileWriter;
import java.util.ArrayList;

public class BankingModell {
    ArrayList<KontomitLog> konten = new ArrayList<KontomitLog>();
    FileController writer= new FileController();
    int selkonto=0;

    public BankingModell() {
        konten.add(new KontomitLog(new SparkKonto(0,0,"Sparkonto")));
    }
    public void addkonto(int typ){
        if(typ==0){
            System.out.println("bis hier komme ich");
            System.out.println(konten.size());
           konten.add(new KontomitLog(new SparkKonto(konten.size(),0,"Sparkonto")));
        }
        else if (typ==1){
            konten.add(new KontomitLog(new GiroKonto(konten.size(),0,"Girokonto")));
        }
    }
    public void searchorcreate(String in){
        if(in.equals("neues Konto")){
            String intmp= JOptionPane.showInputDialog(null,"Was für ein Konto soll erstellt werden? Sparbuch oder Girokonto.");
            if(intmp.equals("Sparbuch")){
                addkonto(0);
            }
                else if(intmp.equals("Girokonto")){

                    addkonto(1);
            }
                else {
                    JOptionPane.showMessageDialog(null,"Kein valider Kontotyp eingegeben");
            }

        }
        else {
            int tmp;
            try {
                tmp=Integer.parseInt(in);
                selkonto = (int) ksuchen(tmp);

            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("keine Zahl obwohl zahl gefordert");
            }
        }

    }
    public ArrayList<KontomitLog> getKonten() {
        return konten;
    }
    public  Number  ksuchen (int kontonummer ){
        for (int i = 0; i < konten.size(); i++) {
            if(konten.get(i).getK().getKontoNr()==kontonummer){
                return i;
            }

        }

        return null;
    }

    public void safedata() {
        writer.safeDataBinaer(konten);
    }
    public void readData(){
       konten= writer.readBinaer();
    }
}

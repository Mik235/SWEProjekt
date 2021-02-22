package Model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class FileController implements Serializable {

    //Speichert die Daten Binär
    public void safeDataBinaer(ArrayList<KontomitLog> safe) {
        try {
            FileOutputStream outt = new FileOutputStream("src/konten.dat");
            ObjectOutputStream oo = new ObjectOutputStream(outt);

            try {
                oo.writeObject(safe);



            } catch (IOException e) {
                e.printStackTrace();
            }

            oo.close();
            outt.close();


        }catch (IOException e){
            e.printStackTrace();

        }
    }
    //Liest die Binär dateien aus
    public ArrayList<KontomitLog> readBinaer(){
        try {
            FileInputStream outt = new FileInputStream("src/konten.dat");
            ObjectInputStream oi = new ObjectInputStream(outt);


                ArrayList<KontomitLog> konto = (ArrayList<KontomitLog>) oi.readObject();
                return konto;


        }catch (IOException  | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
    //Schreibt die Dateien in eine .txt Datei
    public <T> void append( ArrayList<T> contentToAppend,String kontonr) {
        Date tmp=new Date();
        String tmp_aus= tmp.toString();
        tmp_aus=tmp_aus.replace(':','_');
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/"+tmp_aus+" Kontonr_"+kontonr+".log", true), StandardCharsets.UTF_8))) {
            for (T s : contentToAppend) {
                bw.write(s.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}

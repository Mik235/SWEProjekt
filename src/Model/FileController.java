package Model;

import java.io.*;
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


        }catch (IOException e){
            e.printStackTrace();

        }
    }
    //Liest die Binär dateien aus
    public void readBinaer(){
        try {
            FileInputStream outt = new FileInputStream("src/konten.dat");
            ObjectInputStream oi = new ObjectInputStream(outt);


                ArrayList<KontomitLog> konto = (ArrayList<KontomitLog>) oi.readObject();
                System.out.println(konto);
            

        }catch (IOException  | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    

    //Schreibt die Dateien in eine .txt Datei
    public void wrtxt(ArrayList<String>wr){
        Date tmp=new Date();
        String tmp_aus= tmp.toString();
        File dataout2=new File("src/"+tmp_aus+".txt");
        try {
            BufferedWriter wrrrrrr=new BufferedWriter(new FileWriter(dataout2));
            for (int i = 0; i < wr.size(); i++) {
                wrrrrrr.append(wr.get(i).toString());
            }
            wrrrrrr.close();
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("3");
        }
    }
}

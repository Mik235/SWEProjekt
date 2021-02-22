package Model;

import java.io.Serializable;

public class SparkKonto extends Konto implements Serializable
{

    public SparkKonto(int kontoNr, double kontoStand, String kontoTyp) {
        super(kontoNr, kontoStand, kontoTyp);
    }

    /**
     * buchen bucht die übergebene Summe auf das Konto
     * @param p_buchen Summe der gewünschten Buchung auf das Konto
     */
    @Override
    public void buchen(double p_buchen) {
       if (kontoStand + p_buchen <0){
           System.out.println("Warning");
       }else {
           kontoStand += p_buchen;
       }

    }
}

package Model;

public class SparkKonto extends Konto
{

    public SparkKonto(int kontoNr, double kontoStand, String kontoTyp) {
        super(kontoNr, kontoStand, kontoTyp);
    }

    @Override
    public void buchen(double p_buchen) {
       if (kontoStand + p_buchen <0){
           System.out.println("Warning");
       }else {
           kontoStand += p_buchen;
       }

    }
}

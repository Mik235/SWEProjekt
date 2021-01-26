package Model;

public class GiroKonto extends Konto {
    public GiroKonto(int kontoNr, double kontoStand, String kontoTyp) {
        super(kontoNr, kontoStand, kontoTyp);
    }

    @Override
    public void buchen(double p_buchen) {
        super.buchen(p_buchen);
    }
}

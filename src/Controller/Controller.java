package Controller;

import Model.BankingModell;
import Model.KontomitLog;
import View.View;

import javax.swing.*;
import java.awt.event.*;

public class Controller implements ActionListener, WindowListener, MouseListener {
    View v;
    BankingModell m;

    public Controller () {
        v=new View();
        m=new BankingModell();
        v.addlis(this);
        m.readData();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("rdy")){
            System.out.println("Es wurde ok gedrückt");
            System.out.println(v.getTkontonr().getText());
            v.getTstatus().setText(m.searchorcreate(v.getTkontonr().getText()));

            if(m.isExists()==true){
                v.getBok().setText("Weiter");
                v.getTsachk().setEditable(true);
                v.getTkontost().setText(Double.toString(m.getKonten().get(m.getSelkonto()).getK().getKontoStand()));
                if(v.getTsachk().getText().isEmpty()==false){
                    v.getTbetrag().setEditable(true);
                    v.getBok().setText("Buchen");
                    if(v.getTbetrag().getText().isEmpty()==false){
                        System.out.println("yeet");
                        m.buchen(v.getTbetrag().getText(),v.getTsachk().getText());
                        v.getTkontost().setText(Double.toString(m.getKonten().get(m.getSelkonto()).getK().getKontoStand()));
                        v.getTsachk().setText("");
                        v.getTbetrag().setText("");
                        v.getTbetrag().setEditable(false);
                    }
                    else {
                        v.getTstatus().setText("Bitte einen validen Betrag eingeben");
                    }
                }
                else {
                    v.getTbetrag().setEditable(false);
                    v.getBok().setText("Weiter");
                }
            }
            else if (m.isExists()==false){
                v.getBok().setText("Suchen");
                v.getTsachk().setEditable(false);
            }
            v.getTsachk();


        }
        if(e.getActionCommand().equals("Abbrechen")){
            System.out.println("Abbrechen");
            m.safedata();
            System.exit(0);
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        m.safedata();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        m.safedata();
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        m.safedata();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource().equals(v.getTkontonr())){
            v.getTstatus().setText("");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

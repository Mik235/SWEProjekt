package Controller;

import Model.BankingModell;
import Model.KontomitLog;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controller implements ActionListener, WindowListener {
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
}

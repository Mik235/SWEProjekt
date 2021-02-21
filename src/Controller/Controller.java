package Controller;

import Model.BankingModell;
import Model.KontomitLog;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    View v;
    BankingModell m;

    public Controller () {
        v=new View();
        m=new BankingModell();
        v.addlis(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("rdy")){
            System.out.println("Es wurde ok gedrückt");


        }
        if(e.getActionCommand().equals("Abbrechen")){
            System.out.println("Abbrechen");
        }
    }
}

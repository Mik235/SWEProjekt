package Controller;

import Model.Bankingm;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    View v;
    Bankingm m;

    public Controller () {
        v=new View();
        m=new Bankingm();

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

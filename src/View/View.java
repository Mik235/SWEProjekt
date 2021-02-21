package View;

import Controller.Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class View extends JFrame{
	//Erstellung der Labels und TextFields als public, um aus den anderen Klassen darauf zugreifen zu können.
	Container cp = getContentPane();
	
	JLabel ueberschrift = new JLabel("ABC Bank - die Bank an Ihrer Seite");
	
	JLabel lkontonr = new JLabel("Kontonummer: ");
	JTextField tkontonr = new JTextField(20);
	
	JLabel lsachbk = new JLabel("Sachbearbeiterkuerzel: ");
	JTextField tsachk = new JTextField(5);
	
	JLabel lkontost = new JLabel("Kontostand: ");
	JTextField tkontost = new JTextField(10);
	
	JLabel lbetrag = new JLabel("Ein-/Auszahlungsbetrag: ");
	JTextField tbetrag = new JTextField(5);
	
	JButton bok = new JButton("OK");
	JButton babbrechen = new JButton("Abbrechen");
	
	JTextField tstatus = new JTextField(30);
	
	
	public View(){
		//Einstellung der Schriftart der Überschrift
		ueberschrift.setFont(new Font("Arial", Font.CENTER_BASELINE, 22));
		ueberschrift.setForeground(Color.darkGray);

		//Anlegen von Paneln, um die Oberfläche zu sortieren
		JPanel pbutton = new JPanel();
		JPanel pstatus = new JPanel();
		
		JPanel plinks = new JPanel(new GridLayout(0,1, 0,10));
		JPanel prechts = new JPanel(new GridLayout(0,1));

		JPanel palles = new JPanel();
		
		bok.setActionCommand("rdy");
		
		plinks.add(lkontonr);
		prechts.add(tkontonr);
		
		plinks.add(lsachbk);
		prechts.add(tsachk);
		
		plinks.add(lkontost);
		prechts.add(tkontost);
		
		plinks.add(lbetrag);
		prechts.add(tbetrag);
		
		pbutton.add(bok);
		pbutton.add(babbrechen);
		
		
		pstatus.add(tstatus, BorderLayout.PAGE_END);
		

		setEditablefalse();

		
		palles.add(ueberschrift);
		
		palles.add(plinks);
		palles.add(prechts);
		palles.add(pbutton, BorderLayout.WEST);
		
		palles.add(pstatus);
		
		
		cp.add(palles);
		setSize(new Dimension(500,247));
		setMaximumSize(new Dimension(500,247));
		setDefaultCloseOperation(EXIT_ON_CLOSE);    
		setVisible(true);
		setResizable(false);
	}
	

	private void setEditablefalse() {
		//Alle Textfelder, außer der Kontonr auf nicht Editierbar setzen
		// TODO Auto-generated method stub
		tsachk.setEditable(false);
		tkontost.setEditable(false);
		tbetrag.setEditable(false);
		tstatus.setEditable(false);
	}
	public void addlis(Controller c){

		bok.addActionListener(c);
		babbrechen.addActionListener(c);
		tsachk.addActionListener(c);
		tkontonr.addActionListener(c);
		tkontonr.addMouseListener(c);
	}

//Getter + Setter
	public Container getCp() {
		return cp;
	}


	public void setCp(Container cp) {
		this.cp = cp;
	}


	public JLabel getLkontonr() {
		return lkontonr;
	}


	public void setLkontonr(JLabel lkontonr) {
		this.lkontonr = lkontonr;
	}


	public JTextField getTkontonr() {
		return tkontonr;
	}


	public void setTkontonr(JTextField tkontonr) {
		this.tkontonr = tkontonr;
	}


	public JLabel getLsachbk() {
		return lsachbk;
	}


	public void setLsachbk(JLabel lsachbk) {
		this.lsachbk = lsachbk;
	}


	public JTextField getTsachk() {
		return tsachk;
	}


	public void setTsachk(JTextField tsachk) {
		this.tsachk = tsachk;
	}


	public JLabel getLkontost() {
		return lkontost;
	}


	public void setLkontost(JLabel lkontost) {
		this.lkontost = lkontost;
	}


	public JTextField getTkontost() {
		return tkontost;
	}


	public void setTkontost(JTextField tkontost) {
		this.tkontost = tkontost;
	}


	public JLabel getLbetrag() {
		return lbetrag;
	}


	public void setLbetrag(JLabel lbetrag) {
		this.lbetrag = lbetrag;
	}


	public JTextField getTbetrag() {
		return tbetrag;
	}


	public void setTbetrag(JTextField tbetrag) {
		this.tbetrag = tbetrag;
	}


	public JButton getBok() {
		return bok;
	}


	public void setBok(JButton bok) {
		this.bok = bok;
	}


	public JButton getBabbrechen() {
		return babbrechen;
	}


	public void setBabbrechen(JButton babbrechen) {
		this.babbrechen = babbrechen;
	}


	public JTextField getTstatus() {
		return tstatus;
	}


	public void setTstatus(JTextField tstatus) {
		this.tstatus = tstatus;
	}
}

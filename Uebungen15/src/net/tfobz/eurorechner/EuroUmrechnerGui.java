package net.tfobz.eurorechner;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class EuroUmrechnerGui extends JFrame
{
	private JLabel[] jLabels = null;
	private JTextField[] jTextFields = null;
	private EuroUmrechner umrechner = null;
	
	public static void main(String[] args) {
		EuroUmrechnerGui fenster = new EuroUmrechnerGui();
		fenster.setVisible(true);
	}
	
	public EuroUmrechnerGui() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int framewidth = 500, frameheight = 450;
		Dimension Screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(Screen.width/2 - framewidth, (int) (Screen.height - 1.5*frameheight), framewidth, frameheight);
		this.setTitle("EuroUmrechner");
		this.setResizable(false);
		
		this.getContentPane().setLayout(null);
		
		umrechner = new EuroUmrechner();
		jLabels = new JLabel[13];
		jTextFields = new JTextField[13];
		EingabeListener el = new EingabeListener();	
		
		for(int i = 0; i < 13; i++) {
			jLabels[i] = new JLabel();
			jTextFields[i] = new JTextField();
			
			jLabels[i].setText(umrechner.WAEHRUNGEN[i] + ":");
			
			if (i == 0) {
				jLabels[i].setBounds(30, 15, framewidth/2 -60, 40);
				jTextFields[i].setBounds(framewidth/2 - 10, 25, framewidth/2 - 30,20);
				
			} else {				
				jLabels[i].setBounds(30, i * 25 + 40, framewidth/2 -60, 40);
				jTextFields[i].setBounds(framewidth/2 - 10, i * 25 + 50, framewidth/2 - 30,20);
			}
			jLabels[i].setHorizontalAlignment(SwingConstants.RIGHT);
			
			jTextFields[i].addKeyListener(el);
			
			this.getContentPane().add(jLabels[i]);
			this.getContentPane().add(jTextFields[i]);
		}
		
	}
		
	public class EingabeListener extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			JTextField feld = (JTextField) e.getSource();
			
			for(int i = 0; i < 13; i++) {
				if(jTextFields[i].equals(feld)) {
					umrechner.setWaehrung(i);
				}
			}
			
			try {
				umrechner.setBetrag(Double.parseDouble(feld.getText()));
			} catch (NumberFormatException ex) {
				
			}
			
			for(int i = 0; i < 13; i++) {
				if(!jTextFields[i].equals(feld)) {
					jTextFields[i].setText(String.format("%.2f", umrechner.getBetrag(i)));
				}
			}
		}
		
	}
}

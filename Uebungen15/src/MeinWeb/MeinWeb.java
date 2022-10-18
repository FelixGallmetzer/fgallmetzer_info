package MeinWeb;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MeinWeb extends JFrame
{

	private JTextField searchBar = null;
	private JLabel adresse = null;
	private JButton bestaetigen = null;
	private JScrollPane leiste = null;
	private JEditorPane website = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeinWeb web = new MeinWeb();
		web.setVisible(true);
	}
	
	public MeinWeb() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension Screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.getContentPane().setLayout(null);
		
		adresse = new JLabel();
		adresse.setBounds(10, 0, 60, 40);
		adresse.setText("Adresse:");
		this.getContentPane().add(adresse);
		
		searchBar = new JTextField();
		searchBar.setBounds(70, 0, Screen.width-150, 40);
		this.getContentPane().add(searchBar);
		
		bestaetigen = new JButton();
		bestaetigen.setBounds(Screen.width-70, 0, 60, 40);
		bestaetigen.setText("➔");
//		bestaetigen.setFont(new Font("Arial", Font.PLAIN, 20));
		bestaetigen.addActionListener(
				new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						loadWebsite();
					}
					
				});
		this.getContentPane().add(bestaetigen);
		
		website = new JEditorPane();
		website.setEditable(true);
		website.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
		website.addHyperlinkListener(new HyperlinkListener() {
			
			public void hyperlinkUpdate(HyperlinkEvent e) {
				searchBar.setText(e.getURL().toString());
				loadWebsite();
			}
		});
		leiste = new JScrollPane(website);
		leiste.setBounds(0,40,Screen.width,950);
		this.getContentPane().add(leiste);
	}
	
	public void loadWebsite() {
		try {
			if (searchBar.getText().substring(0,8) == "https://") {
				website.setPage(searchBar.getText());
			} else if(searchBar.getText().substring(0,7) == "http://") {
				website.setPage(searchBar.getText());
			} else {
				searchBar.setText("https://" + searchBar.getText());
				website.setPage(searchBar.getText());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTitle("Mein Web - " + searchBar.getText());
	}

}

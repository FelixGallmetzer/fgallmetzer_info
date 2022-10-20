package MeinWeb;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import java.util.*;
import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
		int framewidth = 700, frameheight = 800;
		Dimension Screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(Screen.width/2 - framewidth, (int) (Screen.height - 1.2*frameheight), framewidth, frameheight);
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("Mein Web");
		this.setResizable(false);
		
		this.getContentPane().setLayout(null);
		
		adresse = new JLabel();
		adresse.setBounds(10, 0, 60, 40);
		adresse.setText("Adresse:");
		adresse.setDisplayedMnemonic('S');
		adresse.addFocusListener(
				new FocusListener() {

					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						searchBar.selectAll();
					}

					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
		this.getContentPane().add(adresse);
		
		searchBar = new JTextField();
		adresse.setLabelFor(searchBar);
		searchBar.setText("https://tfobz.net");
		searchBar.setBounds(70, 0, framewidth-150, 40);
		EingabeListener el = new EingabeListener();
		searchBar.addKeyListener(el);
		this.getContentPane().add(searchBar);
		bestaetigen = new JButton();
		bestaetigen.setBounds(framewidth-70, 0, 60, 40);
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
		website.setEditable(false);
		website.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
		website.addHyperlinkListener(new HyperlinkListener() {
			
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					searchBar.setText(e.getURL().toString());
					loadWebsite();
				}
			}
		});
		leiste = new JScrollPane(website);
		leiste.setBounds(0,40,framewidth-6,frameheight-76);
		this.getContentPane().add(leiste);
		loadWebsite();
	}
	
	public void loadWebsite() {
		try {
			if (searchBar.getText().length() < 7 || searchBar.getText().substring(0,8).equals("https://") || searchBar.getText().substring(0,7).equals("http://")) {
				website.setPage(searchBar.getText());
			} else {
				searchBar.setText("https://" + searchBar.getText());
				website.setPage(searchBar.getText());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Kann dem Hyperlink nicht folgen", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		this.setTitle("Mein Web - " + searchBar.getText());
	}
	
	
	public class EingabeListener extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				loadWebsite();
			}
		}
	}

}



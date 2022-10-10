import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//Ein JFrame in welchem man den Umfang Radius und Fläche eines Kreises berechnen kann
public class KreisGUI extends JFrame
{

	private JLabel l1 = null;
	private JLabel l2 = null;
	private JLabel l3 = null;
	private JTextField t1 = null;
	private JTextField t2 = null;
	private JTextField t3 = null;
	private JButton b = null;
	private Kreis k = null;

	
	public KreisGUI() {
		setTitle("Kreisberechnung");
		setBounds(10,10,300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l1 = new JLabel("Radius:");
		l1.setBounds(20,10,50,30);
		l2 = new JLabel("Umfang:");
		l2.setBounds(20,30,50,30);
		l3 = new JLabel("Fläche:");
		l3.setBounds(20,50,50,30);
		t1 = new JTextField();
		t1.setBounds(80,10,150,25);
		t2 = new JTextField();
		t2.setBounds(80,30,150,25);
		t3 = new JTextField();
		t3.setBounds(80,50,150,25);
		b = new JButton();
		b.setText("Berechne");
		b.setBounds(20,100,210,25);
		k = new Kreis();
		k.setRadius(0);
		t1.setText(String.valueOf(k.getRadius()));
		t2.setText(String.valueOf(k.getUmfang()));
		t3.setText(String.valueOf(k.getFlaeche()));
		
		Container contentPane = 
				getContentPane();
			contentPane.setLayout(null);
			contentPane.add(l1);
			contentPane.add(l2);
			contentPane.add(l3);
			contentPane.add(t1);
			contentPane.add(t2);
			contentPane.add(t3);
			contentPane.add(b);
			
			setVisible(true);
			
			b.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {								
								double r = (Double.parseDouble(t1.getText()));
								double u = (Double.parseDouble(t2.getText()));
								double f =(Double.parseDouble(t3.getText()));
								boolean c = true;
								
								if(!(k.getRadius()-0.1 < r && r < k.getRadius()+0.1) && c) {
									k.setRadius(r);
									c = false;
								}
								
								if(!(k.getUmfang()-0.1 < u && u < k.getUmfang()+0.1) && c) {
									k.setUmfang(u);
									c = false;
								}
								
								if(!(k.getFlaeche()-0.1 < f && f < k.getFlaeche()+0.1) && c) {
									k.setFlaeche(f);
								}
								
								t1.setText(String.valueOf(k.getRadius()));
								t2.setText(String.valueOf(k.getUmfang()));
								t3.setText(String.valueOf(k.getFlaeche()));

							} catch (NumberFormatException e) {
								k.setRadius(0);
								t1.setText(String.valueOf(k.getRadius()));
								t2.setText(String.valueOf(k.getUmfang()));
								t3.setText(String.valueOf(k.getFlaeche()));
							}
						}
					}
				);
	}
}

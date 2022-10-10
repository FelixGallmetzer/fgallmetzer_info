import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;

public class CosSinFenster extends JFrame
{
	/**
	* Festlegen der Weltkoordinaten
	*/
	private final double WELT_X0 = -10.0;
	private final double WELT_Y0 = -1.0;
	private final double WELT_X1 = 10.0;
	private final double WELT_Y1 = 1.0;
	/**
	* Umwandlung Welt-X-Koordinaten in Bildschirmkoordinaten. Da die Methoden
	* getHeight und getWidth auch die Ränder und insbesondere die Titelleiste in die
	* Höhe und Breite des Fensters einrechnen, müssen mit Insets diese Ränder
	* weggezählt werden
	* @param xwert die umzuwandelnde Welt-X-Koordinate
	* @return die Bildschirmkoordinate
	*/
	private int umrechnungX(double xwert) {
	Insets i = getInsets();
	return i.left + (int) ((xwert - WELT_X0) * (getWidth() - i.left - i.right)
	/ (WELT_X1 - WELT_X0));
	}
	private int umrechnungY(double ywert) {
	Insets i = getInsets();
	return i.top + (int) (getHeight() - i.top - i.bottom -
	(ywert - WELT_Y0) * (getHeight() - i.top - i.bottom) / (WELT_Y1 - WELT_Y0));
	}
	
	public CosSinFenster() {
		setTitle("Cosinus-, Sinusberechnung");
		setBounds(10,10,600,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		int width = getWidth();
		int height = getHeight();
		g.setColor(Color.black);
		g.drawLine(umrechnungX(0), umrechnungY(-1), umrechnungX(0), umrechnungY(1));
		g.drawLine(umrechnungX(-10), umrechnungY(0), umrechnungX(10), umrechnungY(0));
		for (double i = -10; i < 10; i += 0.001) {
			g.drawLine(umrechnungX(i), umrechnungY(Math.cos(i)), umrechnungX(i), umrechnungY(Math.cos(i)));
			g.drawLine(umrechnungX(i), umrechnungY(Math.sin(i)), umrechnungX(i), umrechnungY(Math.sin(i)));
		}
	}

}

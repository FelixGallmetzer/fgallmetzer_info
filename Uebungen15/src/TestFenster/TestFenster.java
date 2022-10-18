package TestFenster;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class TestFenster extends JFrame
{
	public static void main(String[] args) {
		TestFenster f = new TestFenster();
		f.setVisible(true);
	}
	
	public TestFenster() {
		Dimension ScreenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int fensterwidth = 200, fensterheight = 100;
		this.setBounds(ScreenDimension.width/2 - fensterwidth/2, ScreenDimension.height/2 - fensterheight/2, fensterwidth, fensterheight);
	}
	
}

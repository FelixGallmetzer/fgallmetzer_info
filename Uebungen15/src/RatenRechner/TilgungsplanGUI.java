package RatenRechner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.html.HTMLEditorKit;


public class TilgungsplanGUI extends JDialog {
	//Author Felix (mit hilfe von Gabriel)
	//Objekte werden geladen
	
	private JEditorPane editorpane = new JEditorPane();
	private JScrollPane scrollpane = null;
	private JButton button = new JButton();
	private JFileChooser speichern = new JFileChooser();

	public TilgungsplanGUI(JFrame ratenrechner) {
		super(ratenrechner);
		
		this.setModal(true);
		this.setResizable(false);
		this.setSize(500, 700);
		this.setTitle("Tilgungsplan");
		
		//button zum speichern wird hinzugefügt
		this.getContentPane().setLayout(null);
		button = new JButton();
		button.setBounds(280, 600, 200, 30);
		button.setText("Speichern");
		button.setHorizontalAlignment(JButton.CENTER);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				speichern.setFileFilter(new FileNameExtensionFilter("HTML", "html"));
				if (speichern.showSaveDialog(rootPane) == JFileChooser.APPROVE_OPTION) {
					File selectedFile = speichern.getSelectedFile();
					if (selectedFile.exists()) {
						if (JOptionPane.showConfirmDialog(speichern,
								"Eine Datei mit dem gleichen Namen ist bereits vorhanden. überschreiben?", "Meldung",
								JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
							return;
					}
					selectedFile.getName();
					try {
						String filesaver = editorpane.getText();
						FileWriter writer = new FileWriter(selectedFile + ".html");
						BufferedWriter bwriter = new BufferedWriter(writer);
						bwriter.write("<span>" + filesaver + "</span>");
						bwriter.close();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Beim schreiben der Datei ist ein Fehler aufgetreten!",
								"Fehler", JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		});
		editorpane.setEditable(false);
		editorpane.setEditorKit(new HTMLEditorKit());
		
		//dem Editorpane wird ein Scrollpane zugefügt
		scrollpane = new JScrollPane(editorpane);
		scrollpane.setBounds(20, 20, 460, 420);
		this.getContentPane().add(scrollpane);
		this.getContentPane().add(button);
		
		//dem Editorpane wird der TilgungsPlan zugefügt
		try {
			editorpane.setText(RatenRechner.getTilgungsplan());
		} catch (RatenRechnerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

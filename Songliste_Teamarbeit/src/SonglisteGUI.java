import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SonglisteGUI extends JFrame
{

	private JTextField t_titel = null;
	private JTextField t_interpret = null;
	private JTextField t_album = null;
	private JTextField t_jahr = null;
	private JLabel l_titel = null;
	private JLabel l_interpret = null;
	private JLabel l_album = null;
	private JLabel l_jahr = null;
	private JButton b_erster = null;
	private JButton b_voriger = null;
	private JButton b_naechster = null;
	private JButton b_letzter = null;
	private JButton b_neu = null;
	private JButton b_loeschen = null;
	private JButton b_allesloeschen = null;
	SongListe songs = new SongListe(1000);

	public SonglisteGUI() {
		setTitle("Songliste");
		setBounds(10, 10, 430, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		t_titel = new JTextField();
		t_titel.setBounds(120, 10, 280, 25);
		t_interpret = new JTextField();
		t_interpret.setBounds(120, 40, 280, 25);
		t_album = new JTextField();
		t_album.setBounds(120, 70, 280, 25);
		t_jahr = new JTextField();
		t_jahr.setBounds(120, 100, 280, 25);

		l_titel = new JLabel("Titel:");
		l_titel.setBounds(10, 10, 100, 25);
		l_interpret = new JLabel("Interpret:");
		l_interpret.setBounds(10, 40, 100, 25);
		l_album = new JLabel("Album:");
		l_album.setBounds(10, 70, 100, 25);
		l_jahr = new JLabel("Jahr:");
		l_jahr.setBounds(10, 100, 100, 25);

		b_erster = new JButton();
		b_erster.setText("Erster");
		b_erster.setBounds(10, 140, 90, 25);
		b_voriger = new JButton();
		b_voriger.setText("Voriger");
		b_voriger.setBounds(110, 140, 90, 25);
		b_naechster = new JButton();
		b_naechster.setText("Naechster");
		b_naechster.setBounds(210, 140, 90, 25);
		b_letzter = new JButton();
		b_letzter.setText("Letzter");
		b_letzter.setBounds(310, 140, 90, 25);
		b_neu = new JButton();
		b_neu.setText("Neu");
		b_neu.setBounds(40, 180, 100, 25);
		b_loeschen = new JButton();
		b_loeschen.setText("Loeschen");
		b_loeschen.setBounds(150, 180, 100, 25);
		b_allesloeschen = new JButton();
		b_allesloeschen.setText("Alles Loeschen");
		b_allesloeschen.setBounds(260, 180, 100, 25);

		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.add(t_titel);
		contentPane.add(t_interpret);
		contentPane.add(t_album);
		contentPane.add(t_jahr);
		contentPane.add(l_titel);
		contentPane.add(l_interpret);
		contentPane.add(l_album);
		contentPane.add(l_jahr);
		contentPane.add(b_erster);
		contentPane.add(b_voriger);
		contentPane.add(b_naechster);
		contentPane.add(b_letzter);
		contentPane.add(b_neu);
		contentPane.add(b_loeschen);
		contentPane.add(b_allesloeschen);
		songs.setPfad(
				"C:\\Users\\Felix\\Downloads\\Rohdateien\\tracklist.csv");
		songs.lesenSongs();
		setVisible(true);
		songAnzeigen(songs.getErster());
		/**
		 * Springt zum ersten Song
		 */
		b_erster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speichern();
				if (songs.getNummerAktuell() > 0) {
					Song erster = songs.getErster();
					songAnzeigen(erster);
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "Am Anfang angekommen");
				}
			}
		});
		/**
		 * Springt zum vorigen Song
		 */
		b_voriger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speichern();
				if (songs.getNummerAktuell() > 0) {
					Song voriger = songs.getVoriger();
					songAnzeigen(voriger);
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "Am Anfang angekommen");
				}
			}
		});
		/**
		 * Springt zum naechsten Song
		 */
		b_naechster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speichern();
				if (songs.getNummerAktuell() < songs.getAnzahl() - 1) {
					Song naechster = songs.getNaechster();
					songAnzeigen(naechster);
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "Am Ende angekommen");
				}
			}
		});
		/**
		 * Springt zum letzten Song
		 */
		b_letzter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speichern();
				if (songs.getNummerAktuell() < songs.getAnzahl() - 1) {
					Song letzter = songs.getLetzter();
					songAnzeigen(letzter);
				} else {
					JOptionPane.showMessageDialog(getContentPane(), "Am Ende angekommen");
				}
			}
		});
		/**
		 * Lässt einen neuen Song anlegen und speichert diesen am Ende der Liste ein
		 */
		b_neu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speichern();
				Song s = new Song();
				songs.anfuegenNeuen(s);
				songAnzeigen(songs.getLetzter());

			}
		});
		/**
		 * Loescht den aktuellen Song
		 */
		b_loeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				songs.loeschenAktuellen();
				songAnzeigen(songs.getAktueller());
			}
		});
		/**
		 * Loescht die gesamten gespeicherten Tracks
		 */
		b_allesloeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(getContentPane(), "Wirklich alle Tracks loeschen?", "Track Loeschen",
						JOptionPane.YES_NO_OPTION) == (JOptionPane.YES_OPTION)) {
					songs.loeschenAlle();
					songAnzeigen(null);
				}
			}
		});

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				speichern();
				songs.schreibenSongs();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	/*
	 * (mit hilfe von Raphael) zeigt den Song in der GUI an.
	 * 
	 * @param s - song der angezeigt werden soll
	 */
	public void songAnzeigen(Song s) {
		if (s != null) {
			t_titel.setText(s.getTitel());
			t_interpret.setText(s.getInterpret());
			t_album.setText(s.getAlbum());
			t_jahr.setText(String.valueOf(s.getErscheinungsjahr()));
		} else {
			t_titel.setText("");
			t_interpret.setText("");
			t_album.setText("");
			t_jahr.setText("");
		}
	}

	/*
	 * speichert Änderungen in einem Song ab.
	 */
	public void speichern() {
		try {
			Song speichern = new Song();
			speichern
					.setSong(t_titel.getText() + ";" + t_album.getText() + ";" + t_interpret.getText() + ";" + t_jahr.getText());
			songs.aendernAktuellen(speichern);

		} catch (NumberFormatException e) {

		}
	}
}
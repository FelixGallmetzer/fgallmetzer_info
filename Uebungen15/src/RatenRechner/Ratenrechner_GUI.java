package RatenRechner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class Ratenrechner_GUI extends JFrame
//Author Felix
{

	//Variablen
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private RatenRechner rechner = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ratenrechner_GUI frame = new Ratenrechner_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ratenrechner_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		rechner = new RatenRechner();
		
		JLabel lblRatenrechner = new JLabel("Ratenrechner");
		lblRatenrechner.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JRadioButton rdbtnVorschssig = new JRadioButton("Vorschüssig");
		rdbtnVorschssig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rechner.setNachschuessig(false);
			}
		});
		buttonGroup.add(rdbtnVorschssig);
		
		JRadioButton rdbtnNachschssig = new JRadioButton("Nachschüssig");
		rdbtnNachschssig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rechner.setNachschuessig(true);
			}
		});
		buttonGroup.add(rdbtnNachschssig);
		
		JLabel lblBarwert = new JLabel("Barwert:");
		
		JLabel lblJahreszinssatz = new JLabel("Jahreszinssatz:");
		
		JLabel lblLaufzeitInJahren = new JLabel("Laufzeit in Jahren:");
		
		JLabel lblRatenProJahr = new JLabel("Raten pro Jahr:");
		
		JLabel lblRate = new JLabel("Rate:");
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					rechner.setBarwert((String)textField.getText());
				} catch (RatenRechnerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					rechner.setJahreszinssatz((String) textField_1.getText());
				} catch (RatenRechnerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					rechner.setLaufZeitInJahren((String)textField_2.getText());
				} catch (RatenRechnerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					rechner.setRate((String)textField_3.getText());
				} catch (RatenRechnerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setColumns(10);
		
		JComboBox ratenprojahrcombobox = new JComboBox();
		ratenprojahrcombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rechner.setRatenProJahr(ratenprojahrcombobox.getSelectedItem().toString());
				} catch (RatenRechnerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnBerechneBarwert = new JButton("Berechne Barwert");
		btnBerechneBarwert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rechner.setBarwert(rechner.getBarwert());
					textField.setText(rechner.getBarwert());
				} catch (RatenRechnerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnLaufzeit = new JButton("Berechne Laufzeit");
		btnLaufzeit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rechner.setLaufZeitInJahren(rechner.getLaufzeitInJahren());
					textField_2.setText(rechner.getLaufzeitInJahren());
				} catch (RatenRechnerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnBerechneRate = new JButton("Berechne Rate");
		btnBerechneRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rechner.setRate(rechner.getRate());
					textField_3.setText(rechner.getRate());
				} catch (RatenRechnerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnZeigeTilgungsplan = new JButton("Zeige TilgungsPlan");
		btnZeigeTilgungsplan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rechner.getTilgungsplan();
				} catch (RatenRechnerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TilgungsplanGUI tilgungsplan = new TilgungsplanGUI(Ratenrechner_GUI.this);
				tilgungsplan.setVisible(true);
				tilgungsplan.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(141)
							.addComponent(lblRatenrechner, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(103)
							.addComponent(rdbtnVorschssig)
							.addGap(18)
							.addComponent(rdbtnNachschssig))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblBarwert)
								.addComponent(lblJahreszinssatz))
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnBerechneBarwert))
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblRatenProJahr)
								.addComponent(lblLaufzeitInJahren)
								.addComponent(lblRate))
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_3)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(ratenprojahrcombobox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLaufzeit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBerechneRate, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
					.addContainerGap(43, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(271, Short.MAX_VALUE)
					.addComponent(btnZeigeTilgungsplan)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRatenrechner, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNachschssig)
						.addComponent(rdbtnVorschssig))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBarwert)
						.addComponent(btnBerechneBarwert)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJahreszinssatz)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLaufzeitInJahren)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLaufzeit))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRatenProJahr)
						.addComponent(ratenprojahrcombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRate)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBerechneRate))
					.addGap(44)
					.addComponent(btnZeigeTilgungsplan, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		ratenprojahrcombobox.addItem("1");
		ratenprojahrcombobox.addItem("4");
		ratenprojahrcombobox.addItem("6");
		ratenprojahrcombobox.addItem("12");
		contentPane.setLayout(gl_contentPane);
	}
}

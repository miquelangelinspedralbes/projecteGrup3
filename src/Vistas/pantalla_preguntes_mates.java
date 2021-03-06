package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import BDD.Selects;
import BDD.conexionBD;
import SaberYGanar.Mates;
import SaberYGanar.Partida;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class pantalla_preguntes_mates extends JFrame {

	private JPanel contentPane;
	static Selects selec = new Selects();
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public pantalla_preguntes_mates(int numRandom, String nombre) {
		Mates math = new Mates(numRandom);
		
		setTitle("pregunta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 425);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{358, 0};
		gbl_contentPane.rowHeights = new int[]{45, 53, 117, 0, 33, 51, 22, 43, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel Lbl_mates_title = new JLabel(nombre);
		Lbl_mates_title.setForeground(Color.RED);
		Lbl_mates_title.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_Lbl_mates_title = new GridBagConstraints();
		gbc_Lbl_mates_title.insets = new Insets(0, 0, 5, 0);
		gbc_Lbl_mates_title.gridx = 0;
		gbc_Lbl_mates_title.gridy = 0;
		contentPane.add(Lbl_mates_title, gbc_Lbl_mates_title);
		
		JLabel lblRespondeALa = new JLabel("Respon a la pregunta de mates: ");
		lblRespondeALa.setFont(new Font("Dialog", Font.BOLD, 20));
		lblRespondeALa.setForeground(Color.RED);
		GridBagConstraints gbc_lblRespondeALa = new GridBagConstraints();
		gbc_lblRespondeALa.fill = GridBagConstraints.VERTICAL;
		gbc_lblRespondeALa.insets = new Insets(0, 0, 5, 0);
		gbc_lblRespondeALa.gridx = 0;
		gbc_lblRespondeALa.gridy = 1;
		contentPane.add(lblRespondeALa, gbc_lblRespondeALa);
		
		JTextPane txtpnPreguntaSobreMatematiques = new JTextPane();
		txtpnPreguntaSobreMatematiques.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtpnPreguntaSobreMatematiques.setBackground(Color.DARK_GRAY);
		txtpnPreguntaSobreMatematiques.setForeground(Color.WHITE);
		txtpnPreguntaSobreMatematiques.setText("Calcula el resultat del seguent problema:\n\n " + selec.selecEcuacioMates(numRandom) + "\n\n");
		GridBagConstraints gbc_txtpnPreguntaSobreMatematiques = new GridBagConstraints();
		gbc_txtpnPreguntaSobreMatematiques.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnPreguntaSobreMatematiques.fill = GridBagConstraints.BOTH;
		gbc_txtpnPreguntaSobreMatematiques.gridx = 0;
		gbc_txtpnPreguntaSobreMatematiques.gridy = 2;
		contentPane.add(txtpnPreguntaSobreMatematiques, gbc_txtpnPreguntaSobreMatematiques);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 3;
		contentPane.add(separator_1, gbc_separator_1);
		
		JLabel lblrespostaMates = new JLabel("  Introdueix el resultat: ");
		lblrespostaMates.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblrespostaMates = new GridBagConstraints();
		gbc_lblrespostaMates.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblrespostaMates.insets = new Insets(0, 0, 5, 0);
		gbc_lblrespostaMates.gridx = 0;
		gbc_lblrespostaMates.gridy = 4;
		contentPane.add(lblrespostaMates, gbc_lblrespostaMates);
		
		
		JButton btnEnviarRespostaMates = new JButton("Respon");
		btnEnviarRespostaMates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String respuesta = textField.getText();
				int resultado = Integer.parseInt(respuesta);
					
				dispose();
				if(resultado == math.getResultado()) {
					pregunta_correcte pc = new pregunta_correcte();
					pc.setVisible(true);
					pc.setLocationRelativeTo(null);
				}else {
					pregunta_incorrecte pi = new pregunta_incorrecte(String.valueOf(math.getResultado()));
					pi.setVisible(true);
					pi.setLocationRelativeTo(null);
				}		
			}
		});
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 5;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		btnEnviarRespostaMates.setBackground(Color.WHITE);
		btnEnviarRespostaMates.setForeground(Color.RED);
		GridBagConstraints gbc_btnEnviarRespostaMates = new GridBagConstraints();
		gbc_btnEnviarRespostaMates.fill = GridBagConstraints.BOTH;
		gbc_btnEnviarRespostaMates.gridx = 0;
		gbc_btnEnviarRespostaMates.gridy = 7;
		contentPane.add(btnEnviarRespostaMates, gbc_btnEnviarRespostaMates);
		
		addWindowListener((WindowListener) new WindowAdapter() {
			   public void windowClosing(WindowEvent e) {
				   Partida p = new Partida();
				   p.rollBack();
			   }
			 });
	}

}

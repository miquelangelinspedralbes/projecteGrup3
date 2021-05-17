package Vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BDD.Selects;
import BDD.conexionBD;
import SaberYGanar.Letras;
import SaberYGanar.Partida;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class pantalla_preguntes_lletres extends JFrame {

	private JPanel contentPane;
	static conexionBD bd = new conexionBD();
	static Connection conexion = bd.obtenerConexion();
	private JTextField textField;
	static Selects selec = new Selects();

	/**
	 * Create the frame.
	 */
	public pantalla_preguntes_lletres(int numRandom, String nombre) {
		Letras letras = new Letras(numRandom);
		setTitle("pregunta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 511);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{358, 0};
		gbl_contentPane.rowHeights = new int[]{50, 53, 39, 141, 45, -12, 33, 47, 43, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel Lbl_lletres_title = new JLabel(nombre);
		Lbl_lletres_title.setForeground(Color.RED);
		Lbl_lletres_title.setFont(new Font("Loma", Font.BOLD, 19));
		GridBagConstraints gbc_Lbl_lletres_title = new GridBagConstraints();
		gbc_Lbl_lletres_title.insets = new Insets(0, 0, 5, 0);
		gbc_Lbl_lletres_title.gridx = 0;
		gbc_Lbl_lletres_title.gridy = 0;
		contentPane.add(Lbl_lletres_title, gbc_Lbl_lletres_title);
		
		JLabel lblRespondeALa = new JLabel("Respón a la pregunta de lletres:");
		lblRespondeALa.setFont(new Font("Dialog", Font.BOLD, 20));
		lblRespondeALa.setForeground(Color.RED);
		GridBagConstraints gbc_lblRespondeALa = new GridBagConstraints();
		gbc_lblRespondeALa.insets = new Insets(0, 0, 5, 0);
		gbc_lblRespondeALa.gridx = 0;
		gbc_lblRespondeALa.gridy = 1;
		contentPane.add(lblRespondeALa, gbc_lblRespondeALa);
		
		JLabel lblNewLabel = new JLabel("Endevina la paraula correcte:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(pantalla_preguntes_lletres.class.getResource("/img/antonio.png")));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JTextPane txtpnPreguntaLletres = new JTextPane();
		txtpnPreguntaLletres.setBackground(Color.DARK_GRAY);
		txtpnPreguntaLletres.setForeground(Color.WHITE);
		txtpnPreguntaLletres.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtpnPreguntaLletres.setText(selec.selecOcultaLetras(numRandom));
		GridBagConstraints gbc_txtpnPreguntaLletres = new GridBagConstraints();
		gbc_txtpnPreguntaLletres.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnPreguntaLletres.fill = GridBagConstraints.VERTICAL;
		gbc_txtpnPreguntaLletres.gridx = 0;
		gbc_txtpnPreguntaLletres.gridy = 4;
		contentPane.add(txtpnPreguntaLletres, gbc_txtpnPreguntaLletres);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 5;
		contentPane.add(separator_1, gbc_separator_1);
		
		JLabel lblrespostaLletres = new JLabel("  Introdueix la paraula : ");
		lblrespostaLletres.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblrespostaLletres = new GridBagConstraints();
		gbc_lblrespostaLletres.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblrespostaLletres.insets = new Insets(0, 0, 5, 0);
		gbc_lblrespostaLletres.gridx = 0;
		gbc_lblrespostaLletres.gridy = 6;
		contentPane.add(lblrespostaLletres, gbc_lblrespostaLletres);
		
	
		JButton btnEnviarRespostaLletres = new JButton("Respón");
		btnEnviarRespostaLletres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String respuesta = textField.getText();
					
				dispose();
				if(respuesta.equals(letras.getPalabraEntera())) {
					pregunta_correcte pc = new pregunta_correcte();
					pc.setVisible(true);
					pc.setLocationRelativeTo(null);
				}else {
					pregunta_incorrecte pi = new pregunta_incorrecte(letras.getPalabraEntera());
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
		gbc_textField.gridy = 7;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		btnEnviarRespostaLletres.setBackground(Color.WHITE);
		btnEnviarRespostaLletres.setForeground(Color.RED);
		GridBagConstraints gbc_btnEnviarRespostaLletres = new GridBagConstraints();
		gbc_btnEnviarRespostaLletres.fill = GridBagConstraints.BOTH;
		gbc_btnEnviarRespostaLletres.gridx = 0;
		gbc_btnEnviarRespostaLletres.gridy = 8;
		contentPane.add(btnEnviarRespostaLletres, gbc_btnEnviarRespostaLletres);
		
		addWindowListener((WindowListener) new WindowAdapter() {
			   public void windowClosing(WindowEvent e) {
				   Partida p = new Partida();
				   p.rollBack();
			   }
			 });
	}

}

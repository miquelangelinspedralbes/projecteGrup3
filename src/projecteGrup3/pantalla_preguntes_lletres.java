package projecteGrup3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class pantalla_preguntes_lletres extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public pantalla_preguntes_lletres(String palabra) {
		setTitle("pregunta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 373);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{358, 0};
		gbl_contentPane.rowHeights = new int[]{33, 17, 135, 0, 33, 51, 43, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel Lbl_lletres_title = new JLabel("¡ Pregunta de lletres !");
		Lbl_lletres_title.setForeground(Color.RED);
		Lbl_lletres_title.setFont(new Font("Loma", Font.BOLD, 19));
		GridBagConstraints gbc_Lbl_lletres_title = new GridBagConstraints();
		gbc_Lbl_lletres_title.insets = new Insets(0, 0, 5, 0);
		gbc_Lbl_lletres_title.gridx = 0;
		gbc_Lbl_lletres_title.gridy = 0;
		contentPane.add(Lbl_lletres_title, gbc_Lbl_lletres_title);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		contentPane.add(separator, gbc_separator);
		
		JTextPane txtpnPreguntaLletres = new JTextPane();
		txtpnPreguntaLletres.setText("pregunta sobre Lletres, endevina la paraula correcte:\n\nma" + palabra + "\n\n");
		GridBagConstraints gbc_txtpnPreguntaLletres = new GridBagConstraints();
		gbc_txtpnPreguntaLletres.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnPreguntaLletres.fill = GridBagConstraints.BOTH;
		gbc_txtpnPreguntaLletres.gridx = 0;
		gbc_txtpnPreguntaLletres.gridy = 2;
		contentPane.add(txtpnPreguntaLletres, gbc_txtpnPreguntaLletres);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 3;
		contentPane.add(separator_1, gbc_separator_1);
		
		JLabel lblrespostaLletres = new JLabel("  Introdueix la paraula correcte aqui: ");
		lblrespostaLletres.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblrespostaLletres = new GridBagConstraints();
		gbc_lblrespostaLletres.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblrespostaLletres.insets = new Insets(0, 0, 5, 0);
		gbc_lblrespostaLletres.gridx = 0;
		gbc_lblrespostaLletres.gridy = 4;
		contentPane.add(lblrespostaLletres, gbc_lblrespostaLletres);
		
		JTextArea textAreaLletres = new JTextArea();
		GridBagConstraints gbc_textAreaLletres = new GridBagConstraints();
		gbc_textAreaLletres.insets = new Insets(0, 0, 5, 0);
		gbc_textAreaLletres.fill = GridBagConstraints.BOTH;
		gbc_textAreaLletres.gridx = 0;
		gbc_textAreaLletres.gridy = 5;
		contentPane.add(textAreaLletres, gbc_textAreaLletres);
		
		JButton btnEnviarRespostaLletres = new JButton("Respon");
		btnEnviarRespostaLletres.setBackground(Color.WHITE);
		btnEnviarRespostaLletres.setForeground(Color.RED);
		GridBagConstraints gbc_btnEnviarRespostaLletres = new GridBagConstraints();
		gbc_btnEnviarRespostaLletres.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEnviarRespostaLletres.gridx = 0;
		gbc_btnEnviarRespostaLletres.gridy = 6;
		contentPane.add(btnEnviarRespostaLletres, gbc_btnEnviarRespostaLletres);
	}

}

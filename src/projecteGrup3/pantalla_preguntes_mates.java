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

public class pantalla_preguntes_mates extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public pantalla_preguntes_mates(String ecuacion) {
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
		
		JLabel Lbl_mates_title = new JLabel("¡ Pregunta de matemátiques !");
		Lbl_mates_title.setForeground(Color.RED);
		Lbl_mates_title.setFont(new Font("Loma", Font.BOLD, 19));
		GridBagConstraints gbc_Lbl_mates_title = new GridBagConstraints();
		gbc_Lbl_mates_title.insets = new Insets(0, 0, 5, 0);
		gbc_Lbl_mates_title.gridx = 0;
		gbc_Lbl_mates_title.gridy = 0;
		contentPane.add(Lbl_mates_title, gbc_Lbl_mates_title);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		contentPane.add(separator, gbc_separator);
		
		JTextPane txtpnPreguntaSobreMatematiques = new JTextPane();
		txtpnPreguntaSobreMatematiques.setText("pregunta sobre matematiques, calcula el resultat del segúent problema:\n\n " + ecuacion + "\n\n");
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
		
		JLabel lblrespostaMates = new JLabel("  Introdueix el resultat correcte aqui: ");
		lblrespostaMates.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblrespostaMates = new GridBagConstraints();
		gbc_lblrespostaMates.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblrespostaMates.insets = new Insets(0, 0, 5, 0);
		gbc_lblrespostaMates.gridx = 0;
		gbc_lblrespostaMates.gridy = 4;
		contentPane.add(lblrespostaMates, gbc_lblrespostaMates);
		
		JTextArea textAreaMates = new JTextArea();
		GridBagConstraints gbc_textAreaMates = new GridBagConstraints();
		gbc_textAreaMates.insets = new Insets(0, 0, 5, 0);
		gbc_textAreaMates.fill = GridBagConstraints.BOTH;
		gbc_textAreaMates.gridx = 0;
		gbc_textAreaMates.gridy = 5;
		contentPane.add(textAreaMates, gbc_textAreaMates);
		
		JButton btnEnviarRespostaMates = new JButton("Respon");
		btnEnviarRespostaMates.setBackground(Color.WHITE);
		btnEnviarRespostaMates.setForeground(Color.RED);
		GridBagConstraints gbc_btnEnviarRespostaMates = new GridBagConstraints();
		gbc_btnEnviarRespostaMates.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEnviarRespostaMates.anchor = GridBagConstraints.SOUTH;
		gbc_btnEnviarRespostaMates.gridx = 0;
		gbc_btnEnviarRespostaMates.gridy = 6;
		contentPane.add(btnEnviarRespostaMates, gbc_btnEnviarRespostaMates);
	}

}

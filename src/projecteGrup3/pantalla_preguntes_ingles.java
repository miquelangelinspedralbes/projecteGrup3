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
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

public class pantalla_preguntes_ingles extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantalla_preguntes_ingles frame = new pantalla_preguntes_ingles();
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
	public pantalla_preguntes_ingles() {
		setTitle("pregunta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 414);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{358, 0};
		gbl_contentPane.rowHeights = new int[]{33, 17, 135, 0, 33, 90, 43, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel Lbl_ingles_title = new JLabel("¡ Pregunta d'anglés !");
		Lbl_ingles_title.setForeground(Color.RED);
		Lbl_ingles_title.setFont(new Font("Loma", Font.BOLD, 19));
		GridBagConstraints gbc_Lbl_ingles_title = new GridBagConstraints();
		gbc_Lbl_ingles_title.fill = GridBagConstraints.VERTICAL;
		gbc_Lbl_ingles_title.insets = new Insets(0, 0, 5, 0);
		gbc_Lbl_ingles_title.gridx = 0;
		gbc_Lbl_ingles_title.gridy = 0;
		contentPane.add(Lbl_ingles_title, gbc_Lbl_ingles_title);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		contentPane.add(separator, gbc_separator);
		
		JTextPane txtpnPreguntaIngles = new JTextPane();
		txtpnPreguntaIngles.setText("pregunta d'anglés, tria la resposta correcte:\n\nWhich of the following European languages is classified as a \"language isolate\"?");
		GridBagConstraints gbc_txtpnPreguntaIngles = new GridBagConstraints();
		gbc_txtpnPreguntaIngles.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnPreguntaIngles.fill = GridBagConstraints.BOTH;
		gbc_txtpnPreguntaIngles.gridx = 0;
		gbc_txtpnPreguntaIngles.gridy = 2;
		contentPane.add(txtpnPreguntaIngles, gbc_txtpnPreguntaIngles);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 3;
		contentPane.add(separator_1, gbc_separator_1);
		
		JLabel lblrespostaIngles = new JLabel("  Selecciona l'opció correcte: ");
		lblrespostaIngles.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblrespostaIngles = new GridBagConstraints();
		gbc_lblrespostaIngles.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblrespostaIngles.insets = new Insets(0, 0, 5, 0);
		gbc_lblrespostaIngles.gridx = 0;
		gbc_lblrespostaIngles.gridy = 4;
		contentPane.add(lblrespostaIngles, gbc_lblrespostaIngles);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Basque");
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setBackground(Color.DARK_GRAY);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Galician");
		rdbtnNewRadioButton_1.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Maltese");
		rdbtnNewRadioButton_3.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_3.setForeground(Color.WHITE);
		panel.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Hungarian");
		rdbtnNewRadioButton_2.setForeground(Color.WHITE);
		rdbtnNewRadioButton_2.setBackground(Color.DARK_GRAY);
		panel.add(rdbtnNewRadioButton_2);
		
		ButtonGroup group =new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
		
		JButton btnEnviarRespostaIngles = new JButton("Respon");
		btnEnviarRespostaIngles.setBackground(Color.WHITE);
		btnEnviarRespostaIngles.setForeground(Color.RED);
		GridBagConstraints gbc_btnEnviarRespostaIngles = new GridBagConstraints();
		gbc_btnEnviarRespostaIngles.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEnviarRespostaIngles.gridx = 0;
		gbc_btnEnviarRespostaIngles.gridy = 6;
		contentPane.add(btnEnviarRespostaIngles, gbc_btnEnviarRespostaIngles);
	}

}

package Vistas;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BDD.Selects;
import SaberYGanar.Ingles;
import SaberYGanar.Partida;

import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class pantalla_preguntes_ingles extends JFrame {

	private JPanel contentPane;
	static Selects selec = new Selects();
	/**
	 * Create the frame.
	 */
	public pantalla_preguntes_ingles(int numRandom, String nombre) {
		Ingles ingles = new Ingles(numRandom);
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
		
		JLabel Lbl_ingles_title = new JLabel("Responde a la pregunta de ingles: " + nombre);
		Lbl_ingles_title.setForeground(Color.RED);
		Lbl_ingles_title.setFont(new Font("Dialog", Font.BOLD, 15));
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
		txtpnPreguntaIngles.setText("pregunta d'anglés, tria la resposta correcte:\n\n" + ingles.getEnunciado());
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
		
		JLabel lblrespostaIngles = new JLabel("  Selecciona la opcion correcta: ");
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
		
		String[] respuesta = ingles.getRespuestas().split("\\|");
		int orden = (int) (Math.random()*6);
		JRadioButton rdbtnNewRadioButton = null;
		JRadioButton rdbtnNewRadioButton_1 = null;
		JRadioButton rdbtnNewRadioButton_3 = null;
		JRadioButton rdbtnNewRadioButton_2 = null;
		if(orden == 0) {	
			rdbtnNewRadioButton = new JRadioButton(respuesta[1]);
			rdbtnNewRadioButton_1 = new JRadioButton(respuesta[2]);
			rdbtnNewRadioButton_3 = new JRadioButton(respuesta[3]);
			rdbtnNewRadioButton_2 = new JRadioButton(respuesta[4]);
		}else if(orden == 1) {
			rdbtnNewRadioButton = new JRadioButton(respuesta[2]);
			rdbtnNewRadioButton_1 = new JRadioButton(respuesta[3]);
			rdbtnNewRadioButton_3 = new JRadioButton(respuesta[4]);
			rdbtnNewRadioButton_2 = new JRadioButton(respuesta[1]);
		}else if(orden == 2) {
			rdbtnNewRadioButton = new JRadioButton(respuesta[3]);
			rdbtnNewRadioButton_1 = new JRadioButton(respuesta[4]);
			rdbtnNewRadioButton_3 = new JRadioButton(respuesta[1]);
			rdbtnNewRadioButton_2 = new JRadioButton(respuesta[2]);
		}else if(orden == 3) {
			rdbtnNewRadioButton = new JRadioButton(respuesta[4]);
			rdbtnNewRadioButton_1 = new JRadioButton(respuesta[1]);
			rdbtnNewRadioButton_3 = new JRadioButton(respuesta[2]);
			rdbtnNewRadioButton_2 = new JRadioButton(respuesta[3]);
		}else {
			rdbtnNewRadioButton = new JRadioButton(respuesta[2]);
			rdbtnNewRadioButton_1 = new JRadioButton(respuesta[3]);
			rdbtnNewRadioButton_3 = new JRadioButton(respuesta[1]);
			rdbtnNewRadioButton_2 = new JRadioButton(respuesta[4]);
		}
		
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setBackground(Color.DARK_GRAY);
		panel.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		panel.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_3.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_3.setForeground(Color.WHITE);
		panel.add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_2.setForeground(Color.WHITE);
		rdbtnNewRadioButton_2.setBackground(Color.DARK_GRAY);
		panel.add(rdbtnNewRadioButton_2);
		
		ButtonGroup group =new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
			
		
		JButton btnEnviarRespostaIngles = new JButton("Respon");
		btnEnviarRespostaIngles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String respuesta = null;
					
				if(e.getSource()==btnEnviarRespostaIngles) { 
					Enumeration<AbstractButton> allRadioButton=group.getElements();
					while(allRadioButton.hasMoreElements()) {
						JRadioButton temp=(JRadioButton)allRadioButton.nextElement();
						if(temp.isSelected()) {
							respuesta = temp.getText();
						}
					}
				}
				
				dispose();
				if(respuesta.equals(ingles.getRespuestaCorrecta())) {
					pregunta_correcte pc = new pregunta_correcte();
					pc.setVisible(true);
				}else {
					pregunta_incorrecte pi = new pregunta_incorrecte(ingles.getRespuestaCorrecta());
					pi.setVisible(true);
				}
			}
			
		});
		btnEnviarRespostaIngles.setBackground(Color.WHITE);
		btnEnviarRespostaIngles.setForeground(Color.RED);
		GridBagConstraints gbc_btnEnviarRespostaIngles = new GridBagConstraints();
		gbc_btnEnviarRespostaIngles.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEnviarRespostaIngles.gridx = 0;
		gbc_btnEnviarRespostaIngles.gridy = 6;
		contentPane.add(btnEnviarRespostaIngles, gbc_btnEnviarRespostaIngles);
		
		addWindowListener((WindowListener) new WindowAdapter() {
			   public void windowClosing(WindowEvent e) {
				   Partida p = new Partida();
				   p.rollBack();
			   }
			 });
	}

}

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
import java.awt.GridLayout;

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
		setBounds(100, 100, 426, 448);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{358, 0};
		gbl_contentPane.rowHeights = new int[]{33, 54, 105, 0, 41, 117, 43, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel Lbl_ingles_title = new JLabel(nombre);
		Lbl_ingles_title.setForeground(Color.RED);
		Lbl_ingles_title.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_Lbl_ingles_title = new GridBagConstraints();
		gbc_Lbl_ingles_title.fill = GridBagConstraints.VERTICAL;
		gbc_Lbl_ingles_title.insets = new Insets(0, 0, 5, 0);
		gbc_Lbl_ingles_title.gridx = 0;
		gbc_Lbl_ingles_title.gridy = 0;
		contentPane.add(Lbl_ingles_title, gbc_Lbl_ingles_title);
		
		JLabel lblRespondeALa = new JLabel("Respon a la pregunta d'Angles: ");
		lblRespondeALa.setFont(new Font("Dialog", Font.BOLD, 22));
		lblRespondeALa.setForeground(Color.RED);
		GridBagConstraints gbc_lblRespondeALa = new GridBagConstraints();
		gbc_lblRespondeALa.insets = new Insets(0, 0, 5, 0);
		gbc_lblRespondeALa.gridx = 0;
		gbc_lblRespondeALa.gridy = 1;
		contentPane.add(lblRespondeALa, gbc_lblRespondeALa);
		
		JTextPane txtpnPreguntaIngles = new JTextPane();
		txtpnPreguntaIngles.setBackground(Color.DARK_GRAY);
		txtpnPreguntaIngles.setForeground(Color.WHITE);
		txtpnPreguntaIngles.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtpnPreguntaIngles.setText("Tria la resposta correcte:\n\n" + selec.selecEnunciadoIngles(numRandom));
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
		
		JLabel lblrespostaIngles = new JLabel("  Selecciona l'opcio correcte: ");
		lblrespostaIngles.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblrespostaIngles = new GridBagConstraints();
		gbc_lblrespostaIngles.anchor = GridBagConstraints.WEST;
		gbc_lblrespostaIngles.insets = new Insets(0, 0, 5, 0);
		gbc_lblrespostaIngles.gridx = 0;
		gbc_lblrespostaIngles.gridy = 4;
		contentPane.add(lblrespostaIngles, gbc_lblrespostaIngles);
		
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
		
		ButtonGroup group =new ButtonGroup();
			
		
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
					pc.setLocationRelativeTo(null);
				}else {
					pregunta_incorrecte pi = new pregunta_incorrecte(ingles.getRespuestaCorrecta());
					pi.setVisible(true);
					pi.setLocationRelativeTo(null);
				}
			}
			
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{60, 140, 0, 145, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 1;
		panel.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		rdbtnNewRadioButton.setForeground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setBackground(Color.DARK_GRAY);
		group.add(rdbtnNewRadioButton);
		
		
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_3.gridx = 3;
		gbc_rdbtnNewRadioButton_3.gridy = 1;
		panel.add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_3.setForeground(Color.LIGHT_GRAY);
		group.add(rdbtnNewRadioButton_3);
		
		
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 2;
		panel.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_1.setForeground(Color.LIGHT_GRAY);
		group.add(rdbtnNewRadioButton_1);
		
		
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.gridx = 3;
		gbc_rdbtnNewRadioButton_2.gridy = 2;
		panel.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setForeground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_2.setBackground(Color.DARK_GRAY);
		group.add(rdbtnNewRadioButton_2);
		btnEnviarRespostaIngles.setBackground(Color.WHITE);
		btnEnviarRespostaIngles.setForeground(Color.RED);
		GridBagConstraints gbc_btnEnviarRespostaIngles = new GridBagConstraints();
		gbc_btnEnviarRespostaIngles.fill = GridBagConstraints.BOTH;
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

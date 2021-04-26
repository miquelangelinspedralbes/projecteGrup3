package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BDD.Selects;
import BDD.conexionBD;
import SaberYGanar.Partida;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ranquing extends JFrame {

	private JPanel contentPane;
	public Integer totaljugadors;
	static conexionBD bd = new conexionBD();
	static Connection conexion = bd.obtenerConexion();
	Selects selec = new Selects();
	/**
	 * Create the frame.
	 */
	public ranquing(int numJugadores, int idUltimaPartida, String nombre1, String nombre2, String nombre3, String nombre4, String nombre5, String nombre6) {
		totaljugadors = numJugadores;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 362);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{340, 0};
		gbl_contentPane.rowHeights = new int[]{46, 17, 32, 32, 32, 32, 32, 32, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Ránquing");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("Siguiente ronda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Partida p = new Partida();
				p.pasarRondas();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JPanel posicio1 = new JPanel();
		posicio1.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_posicio1 = new GridBagConstraints();
		gbc_posicio1.insets = new Insets(0, 0, 5, 0);
		gbc_posicio1.fill = GridBagConstraints.BOTH;
		gbc_posicio1.gridx = 0;
		gbc_posicio1.gridy = 2;
		contentPane.add(posicio1, gbc_posicio1);
		
		JLabel lblNewLabel_9 = new JLabel("1");
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_9.setForeground(Color.WHITE);
		posicio1.add(lblNewLabel_9);
		
		JSeparator separator = new JSeparator();
		posicio1.add(separator);
		
		JLabel nomjug1 = new JLabel("New label");
		nomjug1.setForeground(Color.WHITE);
		posicio1.add(nomjug1);
		
		JSeparator separator_1 = new JSeparator();
		posicio1.add(separator_1);
		
		JLabel puntosjug1 = new JLabel("1000");
		puntosjug1.setForeground(Color.GRAY);
		posicio1.add(puntosjug1);
		
		JPanel posicio2 = new JPanel();
		posicio2.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_posicio2 = new GridBagConstraints();
		gbc_posicio2.insets = new Insets(0, 0, 5, 0);
		gbc_posicio2.fill = GridBagConstraints.BOTH;
		gbc_posicio2.gridx = 0;
		gbc_posicio2.gridy = 3;
		contentPane.add(posicio2, gbc_posicio2);
		
		JLabel lblNewLabel_8 = new JLabel("2");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		posicio2.add(lblNewLabel_8);
		
		JSeparator separator_2 = new JSeparator();
		posicio2.add(separator_2);
		
		JLabel nomjug2 = new JLabel("New label");
		nomjug2.setForeground(Color.RED);
		posicio2.add(nomjug2);
		
		JSeparator separator_3 = new JSeparator();
		posicio2.add(separator_3);
		
		JLabel puntosjug2 = new JLabel("800");
		puntosjug2.setForeground(Color.GRAY);
		posicio2.add(puntosjug2);
		
		JPanel posicio3 = new JPanel();
		posicio3.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_posicio3 = new GridBagConstraints();
		gbc_posicio3.insets = new Insets(0, 0, 5, 0);
		gbc_posicio3.fill = GridBagConstraints.BOTH;
		gbc_posicio3.gridx = 0;
		gbc_posicio3.gridy = 4;
		contentPane.add(posicio3, gbc_posicio3);
		
		JLabel lblNewLabel_7 = new JLabel("3");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_7.setForeground(Color.WHITE);
		posicio3.add(lblNewLabel_7);
		
		JSeparator separator_4 = new JSeparator();
		posicio3.add(separator_4);
		
		JLabel nomjug3 = new JLabel("New label");
		nomjug3.setForeground(Color.WHITE);
		posicio3.add(nomjug3);
		
		JSeparator separator_5 = new JSeparator();
		posicio3.add(separator_5);
		
		JLabel puntosjug3 = new JLabel("500");
		puntosjug3.setForeground(Color.GRAY);
		posicio3.add(puntosjug3);
		
		JPanel posicio4 = new JPanel();
		posicio4.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_posicio4 = new GridBagConstraints();
		gbc_posicio4.insets = new Insets(0, 0, 5, 0);
		gbc_posicio4.fill = GridBagConstraints.BOTH;
		gbc_posicio4.gridx = 0;
		gbc_posicio4.gridy = 5;
		contentPane.add(posicio4, gbc_posicio4);
		
		JLabel lblNewLabel_5 = new JLabel("4");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_5.setForeground(Color.RED);
		posicio4.add(lblNewLabel_5);
		
		JSeparator separator_6 = new JSeparator();
		posicio4.add(separator_6);
		
		JLabel nomjug4 = new JLabel("New label");
		nomjug4.setForeground(Color.RED);
		posicio4.add(nomjug4);
		
		JSeparator separator_7 = new JSeparator();
		posicio4.add(separator_7);
		
		JLabel puntosjug4 = new JLabel("300");
		puntosjug4.setForeground(Color.GRAY);
		posicio4.add(puntosjug4);
		
		JPanel posicio5 = new JPanel();
		posicio5.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_posicio5 = new GridBagConstraints();
		gbc_posicio5.insets = new Insets(0, 0, 5, 0);
		gbc_posicio5.fill = GridBagConstraints.BOTH;
		gbc_posicio5.gridx = 0;
		gbc_posicio5.gridy = 6;
		contentPane.add(posicio5, gbc_posicio5);
		
		JLabel lblNewLabel_3 = new JLabel("5");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		posicio5.add(lblNewLabel_3);
		
		JSeparator separator_8 = new JSeparator();
		posicio5.add(separator_8);
		
		JLabel nomjug5 = new JLabel("New label");
		nomjug5.setForeground(Color.WHITE);
		posicio5.add(nomjug5);
		
		JSeparator separator_9 = new JSeparator();
		posicio5.add(separator_9);
		
		JLabel puntosjug5 = new JLabel("200");
		puntosjug5.setForeground(Color.GRAY);
		posicio5.add(puntosjug5);
		
		JPanel posicio6 = new JPanel();
		posicio6.setForeground(Color.GRAY);
		posicio6.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_posicio6 = new GridBagConstraints();
		gbc_posicio6.fill = GridBagConstraints.BOTH;
		gbc_posicio6.gridx = 0;
		gbc_posicio6.gridy = 7;
		contentPane.add(posicio6, gbc_posicio6);
		posicio6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("6");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.RED);
		posicio6.add(lblNewLabel_1);
		
		JSeparator separator_10 = new JSeparator();
		posicio6.add(separator_10);
		
		JLabel nomjug6 = new JLabel("New label");
		nomjug6.setForeground(Color.RED);
		posicio6.add(nomjug6);
		
		JSeparator separator_11 = new JSeparator();
		posicio6.add(separator_11);
		
		JLabel puntosjug6 = new JLabel("100");
		puntosjug6.setForeground(Color.GRAY);
		posicio6.add(puntosjug6);
		
		if (totaljugadors.equals(1) ) {
			posicio1.setVisible(true);
			nomjug1.setText(nombre1);
			puntosjug1.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre1)));
			
			posicio2.setVisible(false);
			posicio3.setVisible(false);
			posicio4.setVisible(false);
			posicio5.setVisible(false);
			posicio6.setVisible(false);
		}else if (totaljugadors.equals(2) ) {
			posicio1.setVisible(true);
			nomjug1.setText(nombre1);
			puntosjug1.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre1)));
			posicio2.setVisible(true);
			nomjug2.setText(nombre2);
			puntosjug2.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre2)));
			posicio3.setVisible(false);
			posicio4.setVisible(false);
			posicio5.setVisible(false);
			posicio6.setVisible(false);
		}else if (totaljugadors.equals(3) ) {
			posicio1.setVisible(true);
			nomjug1.setText(nombre1);
			puntosjug1.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre1)));
			posicio2.setVisible(true);
			nomjug2.setText(nombre2);
			puntosjug2.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre2)));
			posicio3.setVisible(true);
			nomjug3.setText(nombre3);
			puntosjug3.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre3)));
			posicio4.setVisible(false);
			posicio5.setVisible(false);
			posicio6.setVisible(false);
		}else if (totaljugadors.equals(4) ) {
			posicio1.setVisible(true);
			nomjug1.setText(nombre1);
			puntosjug1.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre1)));
			posicio2.setVisible(true);
			nomjug2.setText(nombre2);
			puntosjug2.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre2)));
			posicio3.setVisible(true);
			nomjug3.setText(nombre3);
			puntosjug3.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre3)));
			posicio4.setVisible(true);
			nomjug4.setText(nombre4);
			puntosjug4.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre4)));
			posicio5.setVisible(false);
			posicio6.setVisible(false);
		}else if (totaljugadors.equals(5) ) {
			posicio1.setVisible(true);
			nomjug1.setText(nombre1);
			puntosjug1.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre1)));
			posicio2.setVisible(true);
			nomjug2.setText(nombre2);
			puntosjug2.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre2)));
			posicio3.setVisible(true);
			nomjug3.setText(nombre3);
			puntosjug3.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre3)));
			posicio4.setVisible(true);
			nomjug4.setText(nombre4);
			puntosjug4.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre4)));
			posicio5.setVisible(true);
			nomjug5.setText(nombre5);
			puntosjug5.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre5)));
			posicio6.setVisible(false);
			puntosjug6.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre6)));
		}else {
			posicio1.setVisible(true);
			nomjug1.setText(nombre1);
			puntosjug1.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre1)));
			posicio2.setVisible(true);
			nomjug2.setText(nombre2);
			puntosjug2.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre2)));
			posicio3.setVisible(true);
			nomjug3.setText(nombre3);
			puntosjug3.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre3)));
			posicio4.setVisible(true);
			nomjug4.setText(nombre4);
			puntosjug4.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre4)));
			posicio5.setVisible(true);
			nomjug5.setText(nombre5);
			puntosjug5.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre5)));
			posicio6.setVisible(true);
			nomjug6.setText(nombre6);
			puntosjug6.setText(String.valueOf(selec.sumPuntos(idUltimaPartida, nombre6)));
		}
		
		
	}

}

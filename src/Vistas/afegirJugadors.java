package Vistas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SaberYGanar.conexionBD;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

public class afegirJugadors extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtCognom;
	
	static conexionBD bd = new conexionBD();
	static Connection conex = bd.obtenerConexion();
	PreparedStatement stmt = null;
	/**
	 * Create the frame.
	 */
	public afegirJugadors() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label labelNom = new Label("Nom:");
		labelNom.setForeground(Color.WHITE);
		labelNom.setBounds(24, 103, 60, 21);
		contentPane.add(labelNom);
		
		Label labelCognom = new Label("Cognom:");
		labelCognom.setForeground(Color.WHITE);
		labelCognom.setBounds(24, 130, 69, 34);
		contentPane.add(labelCognom);
		
		txtNom = new JTextField();
		txtNom.setBounds(132, 104, 127, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtCognom = new JTextField();
		txtCognom.setColumns(10);
		txtCognom.setBounds(132, 144, 127, 20);
		contentPane.add(txtCognom);
		
		JLabel lblAfegirJugador = new JLabel("Afegir jugador");
		lblAfegirJugador.setForeground(Color.RED);
		lblAfegirJugador.setFont(new Font("Dialog", Font.BOLD, 19));
		lblAfegirJugador.setBounds(69, 27, 146, 25);
		contentPane.add(lblAfegirJugador);
		
		JButton btnSubmit = new JButton("Afegir");
		btnSubmit.setBounds(24, 194, 89, 23);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);
		
		
		JButton btnTornar = new JButton("Cancelar");
		btnTornar.setBounds(170, 194, 89, 23);
		btnTornar.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        new pantalla_jugadors().setVisible(true);
		        dispose();
		    }
		});
		contentPane.add(btnTornar);
	}
	
	public void actionPerformed(ActionEvent e){
		String nom;
		nom = txtNom.getText() + " " + txtCognom.getText();
		System.out.println(nom);
		try {
			stmt = conex.prepareStatement("INSERT INTO JUGADORES VALUES (?)");
			stmt.setString(1, nom);
			stmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(contentPane, "Jugador insertado correctamente.");
		new pantalla_jugadors().setVisible(true);
        dispose();
		
	}

}

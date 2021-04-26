package Vistas;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BDD.Inserts;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;

public class afegirJugadors extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNom;
	static Inserts inser = new Inserts();


	public afegirJugadors() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label labelNom = new Label("Nom:");
		labelNom.setForeground(Color.WHITE);
		labelNom.setBounds(22, 53, 60, 21);
		contentPane.add(labelNom);
		
		txtNom = new JTextField();
		txtNom.setBounds(132, 54, 127, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblAfegirJugador = new JLabel("Afegir jugador");
		lblAfegirJugador.setForeground(Color.RED);
		lblAfegirJugador.setFont(new Font("Dialog", Font.BOLD, 19));
		lblAfegirJugador.setBounds(74, 11, 146, 25);
		contentPane.add(lblAfegirJugador);
		
		JButton btnSubmit = new JButton("Afegir");
		btnSubmit.setBounds(22, 96, 89, 23);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);
		
		
		JButton btnTornar = new JButton("Cancelar");
		btnTornar.setBounds(170, 96, 89, 23);
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
		inser.insertJugadors(txtNom.getText());
		JOptionPane.showMessageDialog(contentPane, "Jugador insertado correctamente.");
		new pantalla_jugadors().setVisible(true);
        dispose();
		
	}

}

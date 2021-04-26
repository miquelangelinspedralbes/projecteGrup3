package Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BDD.Deletes;

public class eliminarJugadors extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNom;
	Deletes delet = new Deletes();

	public eliminarJugadors() {
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
		txtNom.setBounds(136, 54, 127, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblEliminarJugador = new JLabel("Eliminar jugador");
		lblEliminarJugador.setForeground(Color.RED);
		lblEliminarJugador.setFont(new Font("Dialog", Font.BOLD, 19));
		lblEliminarJugador.setBounds(67, 11, 160, 25);
		contentPane.add(lblEliminarJugador);
		
		JButton btnSubmit = new JButton("Eliminar");
		btnSubmit.setBounds(22, 96, 89, 23);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);
		
		
		JButton btnTornar = new JButton("Cancelar");
		btnTornar.setBounds(174, 96, 89, 23);
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
		int deleted = delet.eliminarJugador(txtNom.getText());
		System.out.println(deleted);
		if(deleted!=0)
			JOptionPane.showMessageDialog(contentPane, "Jugador eliminado correctamente.");
		else
			JOptionPane.showMessageDialog(contentPane, "Jugador no encontrado.");
		new pantalla_jugadors().setVisible(true);
		dispose();
		
	}


}

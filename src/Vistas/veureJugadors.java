package Vistas;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import SaberYGanar.conexionBD;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

public class veureJugadors extends JFrame{
	
	private JPanel contentPane;
	static List<JLabel> objJugadors = new ArrayList<JLabel>();;
	JTextField jtf;
	public static JPanel jpan;
	public JLabel jlabels;

	static conexionBD bd = new conexionBD();
	static Connection conex = bd.obtenerConexion();
	public veureJugadors() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 11, 230, 300);
		getContentPane().setBackground(Color.DARK_GRAY);
		jpan = new JPanel();
		
		getContentPane().setLayout(null);
		
		
		jpan.setBounds(10, 11, 200, 189);
		jpan.setOpaque(true);
		jpan.setBackground(Color.DARK_GRAY);
		
		
		Statement stmt;
		int cont;
		try {
			stmt = conex.createStatement();
			ResultSet set2 = stmt.executeQuery("SELECT COUNT(nombre) FROM JUGADORES");
			set2.next();
			cont = set2.getInt(1);
			
			ResultSet set = stmt.executeQuery("SELECT nombre FROM JUGADORES");
			for(int i=0;set.next();i++) {
				String nombre = set.getString(1);
				jlabels = new JLabel("Nombre: " + nombre);
				jlabels.setForeground(Color.WHITE);
				objJugadors.add(jlabels);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		for (int i = 0; i < objJugadors.size(); i++) {
			jpan.add(objJugadors.get(i));
		}
		getContentPane().add(jpan);
		
		
		JButton btnTornar = new JButton("Tornar");
		btnTornar.setBounds(117, 227, 93, 25);
		btnTornar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	new pantalla_jugadors().setVisible(true);
		    	objJugadors.removeAll(objJugadors);
		    	dispose();
		    }
		});
		getContentPane().add(btnTornar);
	}
}

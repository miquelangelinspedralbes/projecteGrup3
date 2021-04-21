package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.ScrollPane;

public class pantalla_jugadors extends JFrame {
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public pantalla_jugadors() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 344, 429);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblJugadors = new JLabel("Jugadors");
		lblJugadors.setForeground(Color.RED);
		lblJugadors.setFont(new Font("Dialog", Font.BOLD, 19));
		lblJugadors.setBounds(114, 11, 99, 25);
		contentPane.add(lblJugadors);
		
		JButton btnTornar = new JButton("Tornar");
		btnTornar.setBounds(227, 356, 93, 25);
		btnTornar.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        new pantalla_principal().setVisible(true); 
		        dispose();
		    }
		});
		contentPane.add(btnTornar);
		
		Panel panelGrid1 = new Panel();
		panelGrid1.setBounds(23, 75, 282, 233);
		contentPane.add(panelGrid1);
		panelGrid1.setLayout(new GridLayout(5, 1, 0, 0));
		
		JButton btnVeureJugadors = new JButton("Veure jugadors");
		btnVeureJugadors.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        new veureJugadors().setVisible(true);
		        dispose();
		    }
		});
		panelGrid1.add(btnVeureJugadors);
		
		Component vG1 = Box.createVerticalGlue();
		panelGrid1.add(vG1);
		
		JButton btnAfegirJugadors = new JButton("Afegir jugador");
		btnAfegirJugadors.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        new afegirJugadors().setVisible(true);
		        dispose();
		    }
		});
		panelGrid1.add(btnAfegirJugadors);
		
		Component vG2 = Box.createVerticalGlue();
		panelGrid1.add(vG2);
		
		JButton btnEliminarJugadors = new JButton("Eliminar jugador");
		btnEliminarJugadors.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        new eliminarJugadors().setVisible(true);
		        dispose();
		    }
		});
		panelGrid1.add(btnEliminarJugadors);
	}
}

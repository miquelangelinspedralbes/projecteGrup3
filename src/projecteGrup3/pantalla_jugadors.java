package projecteGrup3;

import java.awt.BorderLayout;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantalla_jugadors frame = new pantalla_jugadors();
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
		btnTornar.setBounds(249, 356, 71, 25);
		contentPane.add(btnTornar);
		
		Panel panelGrid1 = new Panel();
		panelGrid1.setBounds(23, 75, 282, 233);
		contentPane.add(panelGrid1);
		panelGrid1.setLayout(new GridLayout(5, 1, 0, 0));
		
		JButton btnVeureJugadors = new JButton("Veure jugadors");
		panelGrid1.add(btnVeureJugadors);
		
		Component vG1 = Box.createVerticalGlue();
		panelGrid1.add(vG1);
		
		JButton btnAfegirJugador = new JButton("Afegir jugador");
		panelGrid1.add(btnAfegirJugador);
		
		Component vG2 = Box.createVerticalGlue();
		panelGrid1.add(vG2);
		
		JButton btnEliminarJugador = new JButton("Eliminar jugador");
		panelGrid1.add(btnEliminarJugador);
	}
}

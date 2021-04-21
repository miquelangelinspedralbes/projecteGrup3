package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SaberYGanar.Partida;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pregunta_incorrecte extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public pregunta_incorrecte(String respuesta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 328);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{440, 0};
		gbl_contentPane.rowHeights = new int[]{32, 56, 44, 38, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnNewButton = new JButton("Siguiente ronda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Partida p = new Partida();
				p.sumarPuntos(false);}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(pregunta_incorrecte.class.getResource("/img/output-onlinepngtools.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pregunta Incorrecta  !");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel_1.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblSoluci = new JLabel("SOLUCION :");
		lblSoluci.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSoluci.setForeground(new Color(50, 205, 50));
		GridBagConstraints gbc_lblSoluci = new GridBagConstraints();
		gbc_lblSoluci.anchor = GridBagConstraints.SOUTH;
		gbc_lblSoluci.insets = new Insets(0, 0, 5, 0);
		gbc_lblSoluci.gridx = 0;
		gbc_lblSoluci.gridy = 3;
		contentPane.add(lblSoluci, gbc_lblSoluci);
		
		JLabel solucion = new JLabel(respuesta);
		solucion.setForeground(Color.WHITE);
		GridBagConstraints gbc_solucion = new GridBagConstraints();
		gbc_solucion.gridx = 0;
		gbc_solucion.gridy = 4;
		contentPane.add(solucion, gbc_solucion);
	}
}

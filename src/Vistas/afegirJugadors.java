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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class afegirJugadors extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNom;
	static Inserts inser = new Inserts();


	public afegirJugadors() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{147, 0};
		gbl_contentPane.rowHeights = new int[]{54, 94, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblAfegirJugador = new JLabel("Afegir jugador");
		lblAfegirJugador.setForeground(Color.RED);
		lblAfegirJugador.setFont(new Font("Dialog", Font.BOLD, 24));
		GridBagConstraints gbc_lblAfegirJugador = new GridBagConstraints();
		gbc_lblAfegirJugador.fill = GridBagConstraints.VERTICAL;
		gbc_lblAfegirJugador.insets = new Insets(0, 0, 5, 0);
		gbc_lblAfegirJugador.gridx = 0;
		gbc_lblAfegirJugador.gridy = 0;
		contentPane.add(lblAfegirJugador, gbc_lblAfegirJugador);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{157, 168, 0};
		gbl_panel.rowHeights = new int[]{48, 47, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Label labelNom = new Label("Nom del jugador:");
		labelNom.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_labelNom = new GridBagConstraints();
		gbc_labelNom.anchor = GridBagConstraints.SOUTHEAST;
		gbc_labelNom.insets = new Insets(0, 0, 5, 5);
		gbc_labelNom.gridx = 0;
		gbc_labelNom.gridy = 0;
		panel.add(labelNom, gbc_labelNom);
		labelNom.setForeground(Color.WHITE);
		
		txtNom = new JTextField();
		GridBagConstraints gbc_txtNom = new GridBagConstraints();
		gbc_txtNom.anchor = GridBagConstraints.SOUTH;
		gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNom.insets = new Insets(0, 0, 5, 0);
		gbc_txtNom.gridx = 1;
		gbc_txtNom.gridy = 0;
		panel.add(txtNom, gbc_txtNom);
		txtNom.setColumns(10);
		
		JButton btnSubmit = new JButton("Afegir");
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setForeground(Color.RED);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSubmit.anchor = GridBagConstraints.SOUTH;
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 0;
		gbc_btnSubmit.gridy = 1;
		panel.add(btnSubmit, gbc_btnSubmit);
		
		
		JButton btnTornar = new JButton("Cancelar");
		btnTornar.setBackground(Color.WHITE);
		btnTornar.setForeground(Color.RED);
		GridBagConstraints gbc_btnTornar = new GridBagConstraints();
		gbc_btnTornar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTornar.anchor = GridBagConstraints.SOUTH;
		gbc_btnTornar.gridx = 1;
		gbc_btnTornar.gridy = 1;
		panel.add(btnTornar, gbc_btnTornar);
		btnTornar.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        new pantalla_jugadors().setVisible(true);
		        dispose();
		    }
		});
		btnSubmit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		inser.insertJugadors(txtNom.getText());
		JOptionPane.showMessageDialog(contentPane, "Jugador insertado correctamente.");
		new pantalla_jugadors().setVisible(true);
        dispose();
		
	}

}

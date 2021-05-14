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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class eliminarJugadors extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNom;
	Deletes delet = new Deletes();

	public eliminarJugadors() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{254, 0};
		gbl_contentPane.rowHeights = new int[]{54, 106, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEliminarJugador = new JLabel("Eliminar jugador");
		lblEliminarJugador.setForeground(Color.RED);
		lblEliminarJugador.setFont(new Font("Dialog", Font.BOLD, 24));
		GridBagConstraints gbc_lblEliminarJugador = new GridBagConstraints();
		gbc_lblEliminarJugador.fill = GridBagConstraints.VERTICAL;
		gbc_lblEliminarJugador.insets = new Insets(0, 0, 5, 0);
		gbc_lblEliminarJugador.gridx = 0;
		gbc_lblEliminarJugador.gridy = 0;
		contentPane.add(lblEliminarJugador, gbc_lblEliminarJugador);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{157, 168, 0};
		gbl_panel.rowHeights = new int[]{46, 51, 0};
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
		gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNom.anchor = GridBagConstraints.SOUTH;
		gbc_txtNom.insets = new Insets(0, 0, 5, 0);
		gbc_txtNom.gridx = 1;
		gbc_txtNom.gridy = 0;
		panel.add(txtNom, gbc_txtNom);
		txtNom.setColumns(10);
		
		JButton btnSubmit = new JButton("Eliminar");
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
		btnTornar.setForeground(Color.RED);
		btnTornar.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnTornar = new GridBagConstraints();
		gbc_btnTornar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTornar.anchor = GridBagConstraints.SOUTH;
		gbc_btnTornar.gridx = 1;
		gbc_btnTornar.gridy = 1;
		panel.add(btnTornar, gbc_btnTornar);
		btnTornar.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		    	pantalla_jugadors pj = new pantalla_jugadors();
		        pj.setVisible(true);
		        pj.setLocationRelativeTo(null);
		        dispose();
		    }
		});
		btnSubmit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		int deleted = delet.eliminarJugador(txtNom.getText());
		System.out.println(deleted);
		if(deleted!=0)
			JOptionPane.showMessageDialog(contentPane, "Jugador eliminado correctamente.");
		else
			JOptionPane.showMessageDialog(contentPane, "Jugador no encontrado.");
		pantalla_jugadors pj = new pantalla_jugadors();
        pj.setVisible(true);
        pj.setLocationRelativeTo(null);
		dispose();
		
	}


}

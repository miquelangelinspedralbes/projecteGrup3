package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

public class informes extends JFrame{

	private JPanel contentPane;

	public informes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{330, 0};
		gbl_contentPane.rowHeights = new int[]{112, 98, 94, 43, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblInforme = new JLabel("Informes");
		lblInforme.setForeground(Color.RED);
		lblInforme.setFont(new Font("Dialog", Font.BOLD, 32));
		GridBagConstraints gbc_lblInforme = new GridBagConstraints();
		gbc_lblInforme.fill = GridBagConstraints.VERTICAL;
		gbc_lblInforme.insets = new Insets(0, 0, 5, 0);
		gbc_lblInforme.gridx = 0;
		gbc_lblInforme.gridy = 0;
		contentPane.add(lblInforme, gbc_lblInforme);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnReport1 = new JButton("");
		btnReport1.setBorder(null);
		btnReport1.setIcon(new ImageIcon(informes.class.getResource("/img/podium(1).png")));
		GridBagConstraints gbc_btnReport1 = new GridBagConstraints();
		gbc_btnReport1.insets = new Insets(0, 0, 5, 0);
		gbc_btnReport1.gridx = 1;
		gbc_btnReport1.gridy = 0;
		panel.add(btnReport1, gbc_btnReport1);
		btnReport1.setForeground(Color.WHITE);
		btnReport1.setBackground(Color.DARK_GRAY);
		
		JLabel lblRanquingJugadores = new JLabel("Ranquing Jugadores");
		lblRanquingJugadores.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblRanquingJugadores = new GridBagConstraints();
		gbc_lblRanquingJugadores.gridx = 1;
		gbc_lblRanquingJugadores.gridy = 1;
		panel.add(lblRanquingJugadores, gbc_lblRanquingJugadores);
		btnReport1.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		    	try {
	    	        File arxiu = new File("bin/Reports/ranquingJugadores.pdf");
	    	        if(arxiu.exists()) {
	    	        	if(Desktop.isDesktopSupported()) {
	    	        		Desktop.getDesktop().open(arxiu);
	    	        	}
	    	        }else {
	    	        	System.out.println("El archivo no ha sido encontrado");
	    	        }
	    	    } catch (IOException ex) {
	    	    	ex.printStackTrace();
	    	    }
		    }
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setForeground(Color.RED);
		btnSalir.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		    pantalla_principal pp = new pantalla_principal();
		    pp.setVisible(true);
		    pp.setLocationRelativeTo(null);
		        dispose();
		    }
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{100, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnReport2 = new JButton("");
		btnReport2.setBorder(null);
		btnReport2.setIcon(new ImageIcon(informes.class.getResource("/img/magnifying-glass32.png")));
		btnReport2.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_btnReport2 = new GridBagConstraints();
		gbc_btnReport2.insets = new Insets(0, 0, 5, 0);
		gbc_btnReport2.gridx = 1;
		gbc_btnReport2.gridy = 0;
		panel_1.add(btnReport2, gbc_btnReport2);
		
		JLabel lblRanquingPreguntas = new JLabel("Ranquing preguntas");
		lblRanquingPreguntas.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblRanquingPreguntas = new GridBagConstraints();
		gbc_lblRanquingPreguntas.gridx = 1;
		gbc_lblRanquingPreguntas.gridy = 1;
		panel_1.add(lblRanquingPreguntas, gbc_lblRanquingPreguntas);
		btnReport2.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		    	    try {
		    	        File arxiu = new File("bin/Reports/ranquingPreguntas.pdf");
		    	        if(arxiu.exists()) {
		    	        	if(Desktop.isDesktopSupported()) {
		    	        		Desktop.getDesktop().open(arxiu);
		    	        	}
		    	        }else {
		    	        	System.out.println("El archivo no ha sido encontrado");
		    	        }
		    	    } catch (IOException ex) {
		    	    	ex.printStackTrace();
		    	    }
		    }
		});
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.fill = GridBagConstraints.BOTH;
		gbc_btnSalir.gridx = 0;
		gbc_btnSalir.gridy = 3;
		contentPane.add(btnSalir, gbc_btnSalir);
		
	}

}

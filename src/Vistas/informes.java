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

public class informes extends JFrame{

	private JPanel contentPane;

	public informes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblInforme = new JLabel("Informes");
		lblInforme.setForeground(Color.RED);
		lblInforme.setFont(new Font("Dialog", Font.BOLD, 22));
		lblInforme.setBounds(125, 21, 100, 36);
		contentPane.add(lblInforme);
		
		JButton btnReport1 = new JButton("Ranquing jugadores");
		btnReport1.setBounds(51, 107, 233, 72);
		btnReport1.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		    	try {
	    	        File arxiu = new File("bin/reports/ranquingJugadores.pdf");
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
		contentPane.add(btnReport1);
		
		JButton btnReport2 = new JButton("Ranquing preguntas");
		btnReport2.setBounds(51, 230, 233, 72);
		btnReport2.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		    	    try {
		    	        File arxiu = new File("bin/reports/ranquingPreguntas.pdf");
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
		contentPane.add(btnReport2);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(230, 357, 89, 23);
		btnSalir.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        new pantalla_principal().setVisible(true);
		        dispose();
		    }
		});
		contentPane.add(btnSalir);
		
	}

}

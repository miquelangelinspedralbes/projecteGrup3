package Vistas;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class historic extends JFrame {

	private JPanel contentPane;
	String text = null;
	
	

	public historic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 292);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		text = readFile();
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{345, 0};
		gbl_contentPane.rowHeights = new int[]{48, 153, 40, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblhistoric = new JLabel("Hist\u00F2ric");
		lblhistoric.setForeground(Color.RED);
		lblhistoric.setFont(new Font("Dialog", Font.BOLD, 25));
		GridBagConstraints gbc_lblhistoric = new GridBagConstraints();
		gbc_lblhistoric.fill = GridBagConstraints.VERTICAL;
		gbc_lblhistoric.insets = new Insets(0, 0, 5, 0);
		gbc_lblhistoric.gridx = 0;
		gbc_lblhistoric.gridy = 0;
		contentPane.add(lblhistoric, gbc_lblhistoric);
		
		JTextArea textArea = new JTextArea();
		textArea.setMargin(new Insets(30, 80, 0, 0));
		textArea.setEditable(false);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setForeground(Color.WHITE);
		textArea.append(text);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		contentPane.add(textArea, gbc_textArea);
		
		JButton btnTornar = new JButton("");
		btnTornar.setIcon(new ImageIcon(historic.class.getResource("/img/return24.png")));
		btnTornar.setForeground(Color.RED);
		btnTornar.setBackground(Color.WHITE);
		btnTornar.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		    pantalla_principal pp = new pantalla_principal();
		    pp.setVisible(true);
		    pp.setLocationRelativeTo(null);
		        dispose();
		    }
		});
		GridBagConstraints gbc_btnTornar = new GridBagConstraints();
		gbc_btnTornar.fill = GridBagConstraints.BOTH;
		gbc_btnTornar.gridx = 0;
		gbc_btnTornar.gridy = 2;
		contentPane.add(btnTornar, gbc_btnTornar);

	}
	
	public String readFile() {
		String text = null;
		boolean semafor = false;
	    try {
	        BufferedReader in = new BufferedReader(new FileReader(new File("historic.txt")));
	        String line;
	        try {
	            while((line = in.readLine())!= null) {
	                if(!semafor) {
	                	text = line + "\n";
	                	semafor = true;
	                }else {
	                	text = text + line + "\n";
	                }
	            }
	            in.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    return text;
	}
}

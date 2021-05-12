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

public class historic extends JFrame {

	private JPanel contentPane;
	String text = null;

	public historic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(0, 80, 345, 193);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setForeground(Color.WHITE);
		text = readFile();
		textArea.append(text);
		contentPane.add(textArea);
		
		JLabel lblhistoric = new JLabel("Hist\u00F2ric");
		lblhistoric.setForeground(Color.RED);
		lblhistoric.setFont(new Font("Dialog", Font.BOLD, 19));
		lblhistoric.setBounds(134, 22, 80, 25);
		contentPane.add(lblhistoric);

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

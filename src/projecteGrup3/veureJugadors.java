package projecteGrup3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.GridLayout;

public class veureJugadors extends JFrame implements CaretListener{

	private JPanel contentPane;
	private List<JLabel> objJugadors;
	JTextField jtf;
	JPanel jpan;

	public static void main(String[] args) {
		veureJugadors v = new veureJugadors();
		v.setTitle("Llista de jugadors");
		v.setSize(455,300);
		v.setVisible(true);
	}

	public veureJugadors() {
		getContentPane().setBackground(Color.DARK_GRAY);
		jtf = new JTextField();
		jpan = new JPanel();
		
		getContentPane().setLayout(null);
		
		jtf.setBounds(25,11,50,30);
		jtf.addCaretListener(this);
		jpan.setBounds(10, 52, 418, 200);
		jpan.setOpaque(true);
		jpan.setBackground(Color.CYAN);
		
		getContentPane().add(jtf);
		getContentPane().add(jpan);
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		String str = jtf.getText();
		if(!str.equals("")) {
			int num = Integer.parseInt(str);
			JLabel jlabels[] = new JLabel[num];
			for(int i = 0; i < jlabels.length; i++) {
				jlabels[i] = new JLabel("Label" + i);
				jpan.add(jlabels[i]);
			}
		}
		jpan.validate();
		jpan.repaint();
	}
	
	
	
}

package projecteGrup3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SaberYGanar.Partida;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingConstants;

public class selecRonda extends JFrame implements Runnable{

	protected static JButton btnNewButton;
	protected static JButton btnNewButton_1;
	protected static JButton btnNewButton_2;
	private JPanel contentPane;
	static int contador = (int) (Math.random()*3);
	static int vueltas = (int) (Math.random()*5+4);
	static int i = 0;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	Partida p = new Partida();
	
	/**
	 * Create the frame.
	 */
	public selecRonda() {
		setBackground(Color.DARK_GRAY);
		this.setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 334);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setRolloverIcon(null);
		btnNewButton.setIcon(new ImageIcon(selecRonda.class.getResource("/img/cubespq.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(0, 116, 165, 134);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon(selecRonda.class.getResource("/img/maths(1).png")));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBounds(161, 51, 165, 134);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setIcon(new ImageIcon(selecRonda.class.getResource("/img/english-language(1).png")));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBounds(298, 130, 176, 123);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("Selector de ronda");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(122, 11, 203, 39);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(36, 245, 393, 39);
		contentPane.add(lblNewLabel_1);
	}
	
	public void run() {
		int vel = 1 *1000;
		
		TimerTask tarea = null;
		Timer tiempo = new Timer();
		contador = (int) (Math.random()*3);
		vueltas = (int) (Math.random()*5+4);
		
		tarea = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					switch (contador) {
						case 0: {
							contador = 1;
							btnNewButton.setIcon(new ImageIcon(selecRonda.class.getResource("/img/cubes.png")));
							Thread.sleep(1000);
							btnNewButton.setIcon(new ImageIcon(selecRonda.class.getResource("/img/cubespq.png")));
							i++;
							break;
						}
						
						case 1: {
							contador = 2;
							btnNewButton_1.setIcon(new ImageIcon(selecRonda.class.getResource("/img/maths.png")));
							Thread.sleep(1000);
							btnNewButton_1.setIcon(new ImageIcon(selecRonda.class.getResource("/img/maths(1).png")));
							i++;
							break;
						}//case 2	
						case 2: {
							contador = 0;
							btnNewButton_2.setIcon(new ImageIcon(selecRonda.class.getResource("/img/english-language.png")));
							Thread.sleep(1000);
							btnNewButton_2.setIcon(new ImageIcon(selecRonda.class.getResource("/img/english-language(1).png")));
							i++;
							break;
						}
					}
					if (i == vueltas) {
						tiempo.cancel();
						if(contador == 0) {
							btnNewButton_2.setIcon(new ImageIcon(selecRonda.class.getResource("/img/english-language.png")));
							lblNewLabel_1.setText("Ingles");
							contador = 2;
						}else if(contador == 1) {
							btnNewButton.setIcon(new ImageIcon(selecRonda.class.getResource("/img/cubes.png")));
							lblNewLabel_1.setText("Letras");
							contador = 0;
						}else {
							btnNewButton_1.setIcon(new ImageIcon(selecRonda.class.getResource("/img/maths.png")));
							lblNewLabel_1.setText("Matematicas");
							contador = 1;
						}
						Thread.sleep(1500);
						i = 0;
						dispose();
						Partida p = new Partida();
						p.ronda(contador);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		};
		tiempo.scheduleAtFixedRate(tarea, vel, vel);
	}
}

package projecteGrup3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	/**
	 * Create the frame.
	 */
	public selecRonda(int numRonda) {
		this.setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 334);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.setRolloverIcon(null);
		btnNewButton.setPressedIcon(new ImageIcon(selecRonda.class.getResource("/img/abz.png")));
		btnNewButton.setIcon(new ImageIcon(selecRonda.class.getResource("/img/abzPeque\u00F1a.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(0, 116, 165, 134);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setPressedIcon(new ImageIcon(selecRonda.class.getResource("/img/mathematics_87612.png")));
		btnNewButton_1.setSelectedIcon(new ImageIcon(selecRonda.class.getResource("/img/mathematics_87612.png")));
		btnNewButton_1.setIcon(new ImageIcon(selecRonda.class.getResource("/img/mathemaPeque\u00F1a.png")));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBounds(161, 51, 165, 134);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setPressedIcon(new ImageIcon(selecRonda.class.getResource("/img/EnglishLanguage_Flag1_26107.png")));
		btnNewButton_2.setIcon(new ImageIcon(selecRonda.class.getResource("/img/EnglishPeque\u00F1a.png")));
		btnNewButton_2.setSelectedIcon(new ImageIcon(selecRonda.class.getResource("/img/EnglishLanguage_Flag1_26107.png")));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBounds(298, 130, 176, 123);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("Ronda numero: " + numRonda);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(122, 11, 203, 39);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(36, 245, 393, 39);
		contentPane.add(lblNewLabel_1);
	}
	
	public void run() {
		int vel = 1 *1000;
		
		TimerTask tarea = null;
		Timer tiempo = new Timer();
		
		tarea = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					switch (contador) {
						case 0: {
							contador = 1;
							btnNewButton.setIcon(new ImageIcon(selecRonda.class.getResource("/img/abz.png")));
							Thread.sleep(1000);
							btnNewButton.setIcon(new ImageIcon(selecRonda.class.getResource("/img/abzPeque\u00F1a.png")));
							i++;
							break;
						}
						
						case 1: {
							contador = 2;
							btnNewButton_1.setIcon(new ImageIcon(selecRonda.class.getResource("/img/mathematics_87612.png")));
							Thread.sleep(1000);
							btnNewButton_1.setIcon(new ImageIcon(selecRonda.class.getResource("/img/mathemaPeque\u00F1a.png")));
							i++;
							break;
						}//case 2	
						case 2: {
							contador = 0;
							btnNewButton_2.setIcon(new ImageIcon(selecRonda.class.getResource("/img/EnglishLanguage_Flag1_26107.png")));
							Thread.sleep(1000);
							btnNewButton_2.setIcon(new ImageIcon(selecRonda.class.getResource("/img/EnglishPeque\u00F1a.png")));
							i++;
							break;
						}
					}
					if (i == vueltas) {
						tiempo.cancel();
						if(contador == 0) {
							btnNewButton_2.setIcon(new ImageIcon(selecRonda.class.getResource("/img/EnglishLanguage_Flag1_26107.png")));
							lblNewLabel_1.setText("Ingles");
						}else if(contador == 1) {
							btnNewButton.setIcon(new ImageIcon(selecRonda.class.getResource("/img/abz.png")));
							lblNewLabel_1.setText("Letras");
						}else {
							btnNewButton_1.setIcon(new ImageIcon(selecRonda.class.getResource("/img/mathematics_87612.png")));
							lblNewLabel_1.setText("Matematicas");
						}
						Thread.sleep(3000);
						i = 0;
						dispose();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		};
		tiempo.scheduleAtFixedRate(tarea, vel, vel);
	}
}

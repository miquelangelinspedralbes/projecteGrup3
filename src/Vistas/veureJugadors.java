package Vistas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import BDD.Selects;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class veureJugadors extends JFrame{
	
	private JPanel contentPane;
	static List<JLabel> objJugadors = new ArrayList<JLabel>();;
	JTextField jtf;
	JPanel panel;
	public static JPanel jpan;
	public JLabel jlabels;
	public JLabel jlabels2;
	JTextArea display;
	JScrollPane scroll;
	Selects selec = new Selects();

	public veureJugadors() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 11, 230, 300);
		getContentPane().setBackground(Color.DARK_GRAY);
		jpan = new JPanel();
		
		getContentPane().setLayout(null);
		
		
		jpan.setBounds(21, 11, 182, 189);
		jpan.setOpaque(true);
		jpan.setBackground(Color.DARK_GRAY);

		ArrayList<String>nombre = selec.selectNombresJugadors();
		
			for(int i=0; i < nombre.size(); i++) {
				jlabels = new JLabel(nombre.get(i));
				jlabels.setSize(182,25);
				objJugadors.add(jlabels);
			}
		String nombres = null;
		for (int i = 0; i < objJugadors.size(); i++) {
			nombres = nombres + objJugadors.get(i).getText() + "\n";
		}
		nombres = nombres.replaceAll("null", "");
		
		JButton btnTornar = new JButton("Tornar");
		btnTornar.setBounds(117, 227, 93, 25);
		btnTornar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	new pantalla_jugadors().setVisible(true);
		    	objJugadors.removeAll(objJugadors);
		    	dispose();
		    }
		});
		getContentPane().add(btnTornar);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 216, 216);
		panel.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel);
		panel.setLayout(null);
		display = new JTextArea(6, 3);
		System.out.println(nombres);
		display.append(nombres);
		display.setForeground(Color.BLACK);
        display.setEditable(false);
        scroll = new JScrollPane(display);
        scroll.setBounds(2, 0, 214, 216);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroll);
	}
}

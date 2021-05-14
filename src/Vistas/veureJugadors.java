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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.ImageIcon;

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
	private JLabel lblJugadors;

	public veureJugadors() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 11, 396, 364);
		getContentPane().setBackground(Color.DARK_GRAY);
		jpan = new JPanel();
		
		
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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{392, 0};
		gridBagLayout.rowHeights = new int[]{66, 216, 41, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		lblJugadors = new JLabel("Jugadors");
		lblJugadors.setForeground(Color.RED);
		lblJugadors.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_lblJugadors = new GridBagConstraints();
		gbc_lblJugadors.insets = new Insets(0, 0, 5, 0);
		gbc_lblJugadors.gridx = 0;
		gbc_lblJugadors.gridy = 0;
		getContentPane().add(lblJugadors, gbc_lblJugadors);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(null);
		display = new JTextArea(6, 3);
		display.setEditable(false);
		display.setBackground(Color.DARK_GRAY);
		display.append(nombres);
		display.setForeground(Color.WHITE);
		scroll = new JScrollPane(display);
		scroll.setBounds(2, 0, 390, 221);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scroll);
		
		JButton btnTornar = new JButton("");
		btnTornar.setIcon(new ImageIcon(veureJugadors.class.getResource("/img/return24.png")));
		btnTornar.setBackground(Color.WHITE);
		btnTornar.setForeground(Color.RED);
		btnTornar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	 pantalla_jugadors pj = new pantalla_jugadors();
		    	 pj.setVisible(true);
			     pj.setLocationRelativeTo(null);
		    	objJugadors.removeAll(objJugadors);
		    	dispose();
		    }
		});
		GridBagConstraints gbc_btnTornar = new GridBagConstraints();
		gbc_btnTornar.fill = GridBagConstraints.BOTH;
		gbc_btnTornar.gridx = 0;
		gbc_btnTornar.gridy = 2;
		getContentPane().add(btnTornar, gbc_btnTornar);
		System.out.println(nombres);
	}
}

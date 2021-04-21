package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SaberYGanar.Partida;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class pantalla_jugar_selecciojugadors extends JFrame implements ActionListener {

	private JPanel contentPane;

	String[] tipuspartida = {"Partida Curta", "Partida Normal", "Partida Llarga"};
	String partida = "Partida Curta";
	Integer contadorjugadors = 1;
	
	JPanel jugador2;
	JPanel jugador3;
	JPanel jugador4;
	JPanel jugador5;
	JPanel jugador6;
	
	private JTextField namejugador1;
	private JTextField namejugador2;
	private JTextField namejugador3;
	private JTextField namejugador4;
	private JTextField namejugador5;
	private JTextField namejugador6;
	/**
	 * Create the frame.
	 */
	public pantalla_jugar_selecciojugadors() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 636);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel title = new JPanel();
		title.setBackground(Color.DARK_GRAY);
		contentPane.add(title, BorderLayout.NORTH);
		GridBagLayout gbl_title = new GridBagLayout();
		gbl_title.columnWidths = new int[]{437, 0};
		gbl_title.rowHeights = new int[]{56, 24, 24, 22, 0};
		gbl_title.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_title.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		title.setLayout(gbl_title);
		
		JLabel titlbl = new JLabel("Selector de Jugadors");
		titlbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		titlbl.setFont(new Font("Dialog", Font.BOLD, 28));
		titlbl.setHorizontalTextPosition(SwingConstants.CENTER);
		titlbl.setHorizontalAlignment(SwingConstants.CENTER);
		titlbl.setForeground(Color.RED);
		GridBagConstraints gbc_titlbl = new GridBagConstraints();
		gbc_titlbl.insets = new Insets(0, 0, 5, 0);
		gbc_titlbl.gridx = 0;
		gbc_titlbl.gridy = 0;
		title.add(titlbl, gbc_titlbl);
		
		JPanel selectors = new JPanel();
		selectors.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_selectors = new GridBagConstraints();
		gbc_selectors.insets = new Insets(0, 0, 5, 0);
		gbc_selectors.fill = GridBagConstraints.BOTH;
		gbc_selectors.gridx = 0;
		gbc_selectors.gridy = 1;
		title.add(selectors, gbc_selectors);
		
		JLabel tipuspartidalbl = new JLabel("Tipus de partida: ");
		tipuspartidalbl.setForeground(Color.WHITE);
		selectors.add(tipuspartidalbl);
		
		JSeparator separator = new JSeparator();
		selectors.add(separator);
		
		JComboBox comboBox = new JComboBox(tipuspartida);
		comboBox.setFont(new Font("Dialog", Font.BOLD, 10));
		comboBox.setBackground(Color.WHITE);
		comboBox.setMaximumRowCount(3);
		selectors.add(comboBox);
		comboBox.addActionListener(this);
		
		comboBox.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
            	partida = event.getItem().toString();
            }
        });
		
		JPanel buttons = new JPanel();
		buttons.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_buttons = new GridBagConstraints();
		gbc_buttons.insets = new Insets(0, 0, 5, 0);
		gbc_buttons.fill = GridBagConstraints.BOTH;
		gbc_buttons.gridx = 0;
		gbc_buttons.gridy = 2;
		title.add(buttons, gbc_buttons);
		
		JLabel jugadorstotalslbl = new JLabel("Jugadors totals: ");
		jugadorstotalslbl.setForeground(Color.WHITE);
		buttons.add(jugadorstotalslbl);
		
		JSeparator separator_1 = new JSeparator();
		buttons.add(separator_1);
		
		JLabel totaljugadors = new JLabel(contadorjugadors.toString());
		totaljugadors.setForeground(Color.RED);
		buttons.add(totaljugadors);
		
		JSeparator separator_2 = new JSeparator();
		buttons.add(separator_2);
		
		
		
		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.gridx = 0;
		gbc_separator_3.gridy = 3;
		title.add(separator_3, gbc_separator_3);
		
		JPanel body = new JPanel();
		body.setForeground(Color.WHITE);
		body.setBackground(Color.DARK_GRAY);
		contentPane.add(body, BorderLayout.CENTER);
		GridBagLayout gbl_body = new GridBagLayout();
		gbl_body.columnWidths = new int[]{54, 324, 0};
		gbl_body.rowHeights = new int[]{46, 46, 46, 48, 50, 44, 0};
		gbl_body.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_body.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		body.setLayout(gbl_body);
		
		JPanel jugador1 = new JPanel();
		jugador1.setBackground(Color.WHITE);
		GridBagConstraints gbc_jugador1 = new GridBagConstraints();
		gbc_jugador1.fill = GridBagConstraints.BOTH;
		gbc_jugador1.insets = new Insets(0, 0, 5, 0);
		gbc_jugador1.gridx = 1;
		gbc_jugador1.gridy = 0;
		body.add(jugador1, gbc_jugador1);
		GridBagLayout gbl_jugador1 = new GridBagLayout();
		gbl_jugador1.columnWidths = new int[]{0, 241, 0};
		gbl_jugador1.rowHeights = new int[]{40, 0};
		gbl_jugador1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_jugador1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		jugador1.setLayout(gbl_jugador1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(pantalla_jugar_selecciojugadors.class.getResource("/img/icons8-scream-60.png")));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		jugador1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		namejugador1 = new JTextField();
		namejugador1.setText("enter name");
		namejugador1.setToolTipText("player name");
		GridBagConstraints gbc_txtEnterName = new GridBagConstraints();
		gbc_txtEnterName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterName.gridx = 1;
		gbc_txtEnterName.gridy = 0;
		jugador1.add(namejugador1, gbc_txtEnterName);
		namejugador1.setColumns(10);
		
		JPanel jugador2 = new JPanel();
		jugador2.setBackground(Color.WHITE);
		jugador2.setVisible(false);
		GridBagConstraints gbc_jugador2 = new GridBagConstraints();
		gbc_jugador2.fill = GridBagConstraints.BOTH;
		gbc_jugador2.insets = new Insets(0, 0, 5, 0);
		gbc_jugador2.gridx = 1;
		gbc_jugador2.gridy = 1;
		body.add(jugador2, gbc_jugador2);
		GridBagLayout gbl_jugador2 = new GridBagLayout();
		gbl_jugador2.columnWidths = new int[]{0, 241, 0};
		gbl_jugador2.rowHeights = new int[]{41, 0};
		gbl_jugador2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_jugador2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		jugador2.setLayout(gbl_jugador2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(pantalla_jugar_selecciojugadors.class.getResource("/img/icons8-anonymous-mask-60.png")));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		jugador2.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		namejugador2 = new JTextField();
		namejugador2.setToolTipText("player name");
		namejugador2.setText("enter name");
		GridBagConstraints gbc_txtEnterName_1 = new GridBagConstraints();
		gbc_txtEnterName_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterName_1.gridx = 1;
		gbc_txtEnterName_1.gridy = 0;
		jugador2.add(namejugador2, gbc_txtEnterName_1);
		namejugador2.setColumns(10);
		
		JPanel jugador3 = new JPanel();
		jugador3.setBackground(Color.WHITE);
		jugador3.setVisible(false);
		GridBagConstraints gbc_jugador3 = new GridBagConstraints();
		gbc_jugador3.fill = GridBagConstraints.BOTH;
		gbc_jugador3.insets = new Insets(0, 0, 5, 0);
		gbc_jugador3.gridx = 1;
		gbc_jugador3.gridy = 2;
		body.add(jugador3, gbc_jugador3);
		GridBagLayout gbl_jugador3 = new GridBagLayout();
		gbl_jugador3.columnWidths = new int[]{0, 0, 0};
		gbl_jugador3.rowHeights = new int[]{40, 0};
		gbl_jugador3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_jugador3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		jugador3.setLayout(gbl_jugador3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(pantalla_jugar_selecciojugadors.class.getResource("/img/icons8-futurama-nibbler-60.png")));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		jugador3.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		namejugador3 = new JTextField();
		namejugador3.setText("enter name");
		namejugador3.setToolTipText("player name");
		GridBagConstraints gbc_txtEnterName_2 = new GridBagConstraints();
		gbc_txtEnterName_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterName_2.gridx = 1;
		gbc_txtEnterName_2.gridy = 0;
		jugador3.add(namejugador3, gbc_txtEnterName_2);
		namejugador3.setColumns(10);
		
		JPanel jugador4 = new JPanel();
		jugador4.setBackground(Color.WHITE);
		jugador4.setVisible(false);
		GridBagConstraints gbc_jugador4 = new GridBagConstraints();
		gbc_jugador4.fill = GridBagConstraints.BOTH;
		gbc_jugador4.insets = new Insets(0, 0, 5, 0);
		gbc_jugador4.gridx = 1;
		gbc_jugador4.gridy = 3;
		body.add(jugador4, gbc_jugador4);
		GridBagLayout gbl_jugador4 = new GridBagLayout();
		gbl_jugador4.columnWidths = new int[]{0, 0, 0};
		gbl_jugador4.rowHeights = new int[]{43, 0};
		gbl_jugador4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_jugador4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		jugador4.setLayout(gbl_jugador4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(pantalla_jugar_selecciojugadors.class.getResource("/img/icons8-stormtrooper-60.png")));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 0;
		jugador4.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		namejugador4 = new JTextField();
		namejugador4.setToolTipText("player name");
		namejugador4.setText("enter name");
		GridBagConstraints gbc_txtEnterName_3 = new GridBagConstraints();
		gbc_txtEnterName_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterName_3.gridx = 1;
		gbc_txtEnterName_3.gridy = 0;
		jugador4.add(namejugador4, gbc_txtEnterName_3);
		namejugador4.setColumns(10);
		
		JPanel jugador5 = new JPanel();
		jugador5.setBackground(Color.WHITE);
		jugador5.setVisible(false);
		GridBagConstraints gbc_jugador5 = new GridBagConstraints();
		gbc_jugador5.fill = GridBagConstraints.BOTH;
		gbc_jugador5.insets = new Insets(0, 0, 5, 0);
		gbc_jugador5.gridx = 1;
		gbc_jugador5.gridy = 4;
		body.add(jugador5, gbc_jugador5);
		GridBagLayout gbl_jugador5 = new GridBagLayout();
		gbl_jugador5.columnWidths = new int[]{0, 0, 0};
		gbl_jugador5.rowHeights = new int[]{46, 0};
		gbl_jugador5.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_jugador5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		jugador5.setLayout(gbl_jugador5);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(pantalla_jugar_selecciojugadors.class.getResource("/img/icons8-walter-white-60.png")));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 0;
		jugador5.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		namejugador5 = new JTextField();
		namejugador5.setText("enter name");
		namejugador5.setToolTipText("player name");
		GridBagConstraints gbc_txtEnterName_4 = new GridBagConstraints();
		gbc_txtEnterName_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterName_4.gridx = 1;
		gbc_txtEnterName_4.gridy = 0;
		jugador5.add(namejugador5, gbc_txtEnterName_4);
		namejugador5.setColumns(10);
		
		JPanel jugador6 = new JPanel();
		jugador6.setBackground(Color.WHITE);
		jugador6.setVisible(false);
		GridBagConstraints gbc_jugador6 = new GridBagConstraints();
		gbc_jugador6.fill = GridBagConstraints.BOTH;
		gbc_jugador6.gridx = 1;
		gbc_jugador6.gridy = 5;
		body.add(jugador6, gbc_jugador6);
		GridBagLayout gbl_jugador6 = new GridBagLayout();
		gbl_jugador6.columnWidths = new int[]{0, 0, 0};
		gbl_jugador6.rowHeights = new int[]{47, 0};
		gbl_jugador6.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_jugador6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		jugador6.setLayout(gbl_jugador6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(pantalla_jugar_selecciojugadors.class.getResource("/img/icons8-the-jigsaw-killer-60.png")));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 0;
		jugador6.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		namejugador6 = new JTextField();
		namejugador6.setText("enter name");
		namejugador6.setToolTipText("player name");
		GridBagConstraints gbc_txtEnterName_5 = new GridBagConstraints();
		gbc_txtEnterName_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterName_5.gridx = 1;
		gbc_txtEnterName_5.gridy = 0;
		jugador6.add(namejugador6, gbc_txtEnterName_5);
		namejugador6.setColumns(10);
		
		JPanel footer = new JPanel();
		footer.setBackground(Color.DARK_GRAY);
		contentPane.add(footer, BorderLayout.SOUTH);
		GridBagLayout gbl_footer = new GridBagLayout();
		gbl_footer.columnWidths = new int[]{439, 0};
		gbl_footer.rowHeights = new int[]{43, 0};
		gbl_footer.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_footer.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		footer.setLayout(gbl_footer);
		
		JButton jugarbtn = new JButton("¡ a jugar !");
		jugarbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ronda = 3;
				String[] nombreJugadores = new String[contadorjugadors];
				if (partida.equals("Partida Curta")) {
					ronda = 3;
				} else if (partida.equals("Partida Normal")) {
					ronda = 6;
				} else {
					ronda = 9;
				}
				for (int i = 0; i < contadorjugadors; i++) {
					if (i == 0) {
						nombreJugadores[i] = namejugador1.getText();
					} else if (i == 1) {
						nombreJugadores[i] = namejugador2.getText();
					} else if (i == 2) {
						nombreJugadores[i] = namejugador3.getText();
					} else if (i == 3) {
						nombreJugadores[i] = namejugador4.getText();
					} else if (i == 4) {
						nombreJugadores[i] = namejugador5.getText();
					} else{
						nombreJugadores[i] = namejugador6.getText();
					}
				}
				dispose();
				Partida p = new Partida(ronda, contadorjugadors, nombreJugadores);	
			}
		});
		jugarbtn.setForeground(Color.RED);
		jugarbtn.setIcon(new ImageIcon(pantalla_jugar_selecciojugadors.class.getResource("/img/play-button(1).png")));
		jugarbtn.setBackground(Color.WHITE);
		GridBagConstraints gbc_jugarbtn = new GridBagConstraints();
		gbc_jugarbtn.fill = GridBagConstraints.BOTH;
		gbc_jugarbtn.gridx = 0;
		gbc_jugarbtn.gridy = 0;
		footer.add(jugarbtn, gbc_jugarbtn);
		
		JButton sumabtn = new JButton("+");
		sumabtn.setBackground(Color.WHITE);
		sumabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contadorjugadors.equals(1) ) {
					contadorjugadors ++;
					jugador2.setVisible(true);
				}else if (contadorjugadors.equals(2) ) {
					contadorjugadors ++;
					jugador3.setVisible(true);
				}else if (contadorjugadors.equals(3) ) {
					contadorjugadors ++;
					jugador4.setVisible(true);
				}else if (contadorjugadors.equals(4) ) {
					contadorjugadors ++;
					jugador5.setVisible(true);
				}else if (contadorjugadors.equals(5) ) {
					contadorjugadors ++;
					jugador6.setVisible(true);
				}
				totaljugadors.setText(contadorjugadors.toString());
				repaint();
				
			}
		});
		buttons.add(sumabtn);
		
		JButton restabtn = new JButton("-");
		restabtn.setBackground(Color.WHITE);
		restabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contadorjugadors.equals(6) ) {
					contadorjugadors --;
					jugador6.setVisible(false);
				}else if (contadorjugadors.equals(5) ) {
					contadorjugadors --;
					jugador5.setVisible(false);
				}else if (contadorjugadors.equals(4) ) {
					contadorjugadors --;
					jugador4.setVisible(false);
				}else if (contadorjugadors.equals(3) ) {
					contadorjugadors --;
					jugador3.setVisible(false);
				}else if (contadorjugadors.equals(2) ) {
					contadorjugadors --;
					jugador2.setVisible(false);
				}
				totaljugadors.setText(contadorjugadors.toString());
				repaint();
			}
		});
		buttons.add(restabtn);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

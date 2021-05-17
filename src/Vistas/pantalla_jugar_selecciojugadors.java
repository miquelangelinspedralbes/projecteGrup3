package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import SaberYGanar.Partida;

public class pantalla_jugar_selecciojugadors extends JFrame implements ActionListener {

	private JPanel contentPane;

	String[] tipuspartida = {"Partida Curta", "Partida Normal", "Partida Llarga"};
	String partida = "Partida Curta";
	Integer contadorjugadors = 1;
	Integer contadorCPU = 0;
	Boolean CPUclick[] = {true, true, true, true, true};//array de boolean para comprovar que no se añadan por accidente jugadores de la cpu
	
	
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
	

	JButton btnJugador2;
	JButton btnJugador3;
	JButton btnJugador4;
	JButton btnJugador5;
	JButton btnJugador6;
	
	
	JButton btnCPU2;
	JButton btnCPU3;
	JButton btnCPU4;
	JButton btnCPU5;
	JButton btnCPU6;

	/**
	 * Create the frame.
	 */
	public pantalla_jugar_selecciojugadors(){
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 653);
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
		gbl_body.columnWidths = new int[]{54, 339, 0};
		gbl_body.rowHeights = new int[]{46, 46, 46, 48, 50, 44, 0};
		gbl_body.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_body.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		body.setLayout(gbl_body);
		
		JPanel jugador1 = new JPanel();
		jugador1.setBackground(Color.WHITE);
		GridBagConstraints gbc_jugador1 = new GridBagConstraints();
		gbc_jugador1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jugador1.insets = new Insets(0, 0, 5, 0);
		gbc_jugador1.gridx = 1;
		gbc_jugador1.gridy = 0;
		body.add(jugador1, gbc_jugador1);
		GridBagLayout gbl_jugador1 = new GridBagLayout();
		gbl_jugador1.columnWidths = new int[]{0, 181, 94, 0};
		gbl_jugador1.rowHeights = new int[]{40, 0};
		gbl_jugador1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_jugador1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
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
		gbc_txtEnterName.insets = new Insets(0, 0, 0, 5);
		gbc_txtEnterName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterName.gridx = 1;
		gbc_txtEnterName.gridy = 0;
		jugador1.add(namejugador1, gbc_txtEnterName);
		namejugador1.setColumns(10);
		
		JPanel panelj1 = new JPanel();
		panelj1.setBackground(Color.DARK_GRAY);
		panelj1.setForeground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		jugador1.add(panelj1, gbc_panel);
		panelj1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(35dlu;default)"),},
			new RowSpec[] {
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(18dlu;default)"),}));
		
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
		gbl_jugador2.columnWidths = new int[]{0, 181, 75, 0};
		gbl_jugador2.rowHeights = new int[]{41, 0};
		gbl_jugador2.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_jugador2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
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
		gbc_txtEnterName_1.insets = new Insets(0, 0, 0, 5);
		gbc_txtEnterName_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterName_1.gridx = 1;
		gbc_txtEnterName_1.gridy = 0;
		jugador2.add(namejugador2, gbc_txtEnterName_1);
		namejugador2.setColumns(10);
		
		JPanel panelj2 = new JPanel();
		panelj2.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 0;
		jugador2.add(panelj2, gbc_panel_1);
		panelj2.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(18dlu;default)"),}));
		
		JButton btnJugador2 = new JButton("Jugador");
		btnJugador2.setName("btnJugador2");
		btnJugador2.setForeground(Color.WHITE);
		btnJugador2.setFont(new Font("Dialog", Font.BOLD, 10));
		btnJugador2.setBackground(Color.GRAY);
		btnJugador2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personajejugador(btnJugador2.getName());
			}
		});
		panelj2.add(btnJugador2, "2, 1, fill, center");
		
		JButton btnCPU2 = new JButton("CPU");
		btnCPU2.setName("btnCPU2");
		btnCPU2.setForeground(Color.WHITE);
		btnCPU2.setFont(new Font("Dialog", Font.BOLD, 10));
		btnCPU2.setBackground(Color.GRAY);
		btnCPU2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personajeCPU(btnCPU2.getName());
			}
		});
		panelj2.add(btnCPU2, "2, 2, fill, top");
		
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
		gbl_jugador3.columnWidths = new int[]{0, 181, 75, 0};
		gbl_jugador3.rowHeights = new int[]{40, 0};
		gbl_jugador3.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_jugador3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
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
		gbc_txtEnterName_2.insets = new Insets(0, 0, 0, 5);
		gbc_txtEnterName_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterName_2.gridx = 1;
		gbc_txtEnterName_2.gridy = 0;
		jugador3.add(namejugador3, gbc_txtEnterName_2);
		namejugador3.setColumns(10);
		
		JPanel panelj3 = new JPanel();
		panelj3.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 0;
		jugador3.add(panelj3, gbc_panel_2);
		panelj3.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(18dlu;default)"),}));
		
		JButton btnJugador3 = new JButton("Jugador");
		btnJugador3.setName("btnJugador3");
		btnJugador3.setForeground(Color.WHITE);
		btnJugador3.setFont(new Font("Dialog", Font.BOLD, 10));
		btnJugador3.setBackground(Color.GRAY);
		btnJugador3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personajejugador(btnJugador3.getName());
			}
		});
		panelj3.add(btnJugador3, "2, 1, fill, center");
		
		JButton btnCPU3 = new JButton("CPU");
		btnCPU3.setName("btnCPU3");
		btnCPU3.setForeground(Color.WHITE);
		btnCPU3.setFont(new Font("Dialog", Font.BOLD, 10));
		btnCPU3.setBackground(Color.GRAY);
		btnCPU3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personajeCPU(btnCPU3.getName());
			}
		});
		panelj3.add(btnCPU3, "2, 2, fill, top");
		
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
		gbl_jugador4.columnWidths = new int[]{0, 181, 75, 0};
		gbl_jugador4.rowHeights = new int[]{43, 0};
		gbl_jugador4.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_jugador4.rowWeights = new double[]{1.0, Double.MIN_VALUE};
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
		gbc_txtEnterName_3.insets = new Insets(0, 0, 0, 5);
		gbc_txtEnterName_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterName_3.gridx = 1;
		gbc_txtEnterName_3.gridy = 0;
		jugador4.add(namejugador4, gbc_txtEnterName_3);
		namejugador4.setColumns(10);
		
		JPanel panelj4 = new JPanel();
		panelj4.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 0;
		jugador4.add(panelj4, gbc_panel_3);
		panelj4.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(18dlu;default)"),}));
		
		JButton btnJugador4 = new JButton("Jugador");
		btnJugador4.setName("btnJugador4");
		btnJugador4.setForeground(Color.WHITE);
		btnJugador4.setFont(new Font("Dialog", Font.BOLD, 10));
		btnJugador4.setBackground(Color.GRAY);
		btnJugador4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personajejugador(btnJugador4.getName());
			}
		});
		panelj4.add(btnJugador4, "2, 1, fill, center");
		
		JButton btnCPU4 = new JButton("CPU");
		btnCPU4.setName("btnCPU4");
		btnCPU4.setForeground(Color.WHITE);
		btnCPU4.setFont(new Font("Dialog", Font.BOLD, 10));
		btnCPU4.setBackground(Color.GRAY);
		btnCPU4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personajeCPU(btnCPU4.getName());
			}
		});
		panelj4.add(btnCPU4, "2, 2, fill, top");
		
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
		gbl_jugador5.columnWidths = new int[]{0, 181, 75, 0};
		gbl_jugador5.rowHeights = new int[]{46, 0};
		gbl_jugador5.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_jugador5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
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
		gbc_txtEnterName_4.insets = new Insets(0, 0, 0, 5);
		gbc_txtEnterName_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterName_4.gridx = 1;
		gbc_txtEnterName_4.gridy = 0;
		jugador5.add(namejugador5, gbc_txtEnterName_4);
		namejugador5.setColumns(10);
		
		JPanel panelj5 = new JPanel();
		panelj5.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 0;
		jugador5.add(panelj5, gbc_panel_4);
		panelj5.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(18dlu;default)"),}));
		
		JButton btnJugador5 = new JButton("Jugador");
		btnJugador5.setName("btnJugador5");
		btnJugador5.setForeground(Color.WHITE);
		btnJugador5.setFont(new Font("Dialog", Font.BOLD, 10));
		btnJugador5.setBackground(Color.GRAY);
		btnJugador5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personajejugador(btnJugador5.getName());
			}
		});
		panelj5.add(btnJugador5, "2, 1, fill, center");
		
		JButton btnCPU5 = new JButton("CPU");
		btnCPU5.setName("btnCPU5");
		btnCPU5.setForeground(Color.WHITE);
		btnCPU5.setFont(new Font("Dialog", Font.BOLD, 10));
		btnCPU5.setBackground(Color.GRAY);
		btnCPU5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personajeCPU(btnCPU5.getName());
			}
		});
		panelj5.add(btnCPU5, "2, 2, fill, top");
		
		JPanel jugador6 = new JPanel();
		jugador6.setBackground(Color.WHITE);
		jugador6.setVisible(false);
		GridBagConstraints gbc_jugador6 = new GridBagConstraints();
		gbc_jugador6.fill = GridBagConstraints.BOTH;
		gbc_jugador6.gridx = 1;
		gbc_jugador6.gridy = 5;
		body.add(jugador6, gbc_jugador6);
		GridBagLayout gbl_jugador6 = new GridBagLayout();
		gbl_jugador6.columnWidths = new int[]{0, 181, 75, 0};
		gbl_jugador6.rowHeights = new int[]{47, 0};
		gbl_jugador6.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_jugador6.rowWeights = new double[]{1.0, Double.MIN_VALUE};
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
		gbc_txtEnterName_5.insets = new Insets(0, 0, 0, 5);
		gbc_txtEnterName_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterName_5.gridx = 1;
		gbc_txtEnterName_5.gridy = 0;
		jugador6.add(namejugador6, gbc_txtEnterName_5);
		namejugador6.setColumns(10);
		
		JPanel panelj6 = new JPanel();
		panelj6.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 2;
		gbc_panel_5.gridy = 0;
		jugador6.add(panelj6, gbc_panel_5);
		panelj6.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("max(20dlu;default)"),
				RowSpec.decode("max(18dlu;default)"),}));
		
		JButton btnJugador6 = new JButton("Jugador");
		btnJugador6.setName("btnJugador6");
		btnJugador6.setForeground(Color.WHITE);
		btnJugador6.setFont(new Font("Dialog", Font.BOLD, 10));
		btnJugador6.setBackground(Color.GRAY);
		btnJugador6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personajejugador(btnJugador6.getName());
			}
		});
		panelj6.add(btnJugador6, "2, 1, fill, center");
		
		JButton btnCPU6 = new JButton("CPU");
		btnCPU6.setName("btnCPU6");
		btnCPU6.setForeground(Color.WHITE);
		btnCPU6.setFont(new Font("Dialog", Font.BOLD, 10));
		btnCPU6.setBackground(Color.GRAY);
		btnCPU6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personajeCPU(btnCPU6.getName());
			}
		});
		panelj6.add(btnCPU6, "2, 2, fill, top");
		
		JPanel footer = new JPanel();
		footer.setBackground(Color.DARK_GRAY);
		contentPane.add(footer, BorderLayout.SOUTH);
		GridBagLayout gbl_footer = new GridBagLayout();
		gbl_footer.columnWidths = new int[]{439, 0};
		gbl_footer.rowHeights = new int[]{43, 0};
		gbl_footer.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_footer.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		footer.setLayout(gbl_footer);
		
		JButton jugarbtn = new JButton("");
		jugarbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ronda = 3;
				ArrayList<String> nombre = new ArrayList<String>();
				if (partida.equals("Partida Curta")) {
					ronda = 3;
				} else if (partida.equals("Partida Normal")) {
					ronda = 6;
				} else {
					ronda = 9;
				}
				for (int i = 0; i < contadorjugadors; i++) {
					if (i == 0) {
						nombre.add(namejugador1.getText());
					} else if (i == 1) {
						if(!namejugador2.getText().contains("CPU"))
							nombre.add(namejugador2.getText());
					} else if (i == 2) {
						if(!namejugador3.getText().contains("CPU"))
							nombre.add(namejugador3.getText());
					} else if (i == 3) {
						if(!namejugador4.getText().contains("CPU"))
							nombre.add(namejugador4.getText());
					} else if (i == 4) {
						if(!namejugador5.getText().contains("CPU"))
							nombre.add(namejugador5.getText());
					} else{
						if(!namejugador6.getText().contains("CPU"))
							nombre.add(namejugador6.getText());
					}
				}
				String[] nombreJugadores = new String[nombre.size()];
				nombreJugadores = nombre.toArray(nombreJugadores);
				for(int i = 0; i<nombreJugadores.length;i++) {
					System.out.println(nombreJugadores[i]);
				}
				dispose();
				Partida p = new Partida(ronda, contadorjugadors, nombreJugadores, contadorCPU);	
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

	public void personajejugador(String btnname) {
		if (btnname.equals("btnjugador2") || CPUclick[0].equals(false)) {
			CPUclick[0] = true;
			contadorCPU--;
			namejugador2.setEditable(true);
			namejugador2.setText("enter name");
			repaint();
			
		}else if (btnname.equals("btnjugador3") || CPUclick[1].equals(false)) {
			CPUclick[1] = true;
			contadorCPU--;
			namejugador3.setEditable(true);
			namejugador3.setText("enter name");
			repaint();
			
		}else if (btnname.equals("btnjugador4") || CPUclick[2].equals(false)) {
			CPUclick[2] = true;
			contadorCPU--;
			namejugador4.setEditable(true);
			namejugador4.setText("enter name");
			repaint();
			
		}else if (btnname.equals("btnjugador5") || CPUclick[3].equals(false)) {
			CPUclick[3] = true;
			contadorCPU--;
			namejugador5.setEditable(true);
			namejugador5.setText("enter name");
			repaint();
			
		}else if (btnname.equals("btnjugador6") || CPUclick[4].equals(false)) {
			CPUclick[4] = true;
			contadorCPU--;
			namejugador6.setEditable(true);
			namejugador6.setText("enter name");			
			repaint();
			
		}
		
	}
	
	
	public void personajeCPU(String btnname) {
		if (btnname.equals("btnCPU2") && CPUclick[0].equals(true)) {
			CPUclick[0] = false;
			contadorCPU++;
			namejugador2.setText("CPU" + contadorCPU.toString());
			namejugador2.setEditable(false);
			repaint();
			
		}else if (btnname.equals("btnCPU3") && CPUclick[1].equals(true)) {
			contadorCPU++;
			namejugador3.setText("CPU" + contadorCPU.toString());
			namejugador3.setEditable(false);
			CPUclick[1] = false;
			repaint();
			
		}else if (btnname.equals("btnCPU4") && CPUclick[2].equals(true)) {
			contadorCPU++;
			namejugador4.setText("CPU" + contadorCPU.toString());	
			namejugador4.setEditable(false);
			CPUclick[2] = false;
			repaint();
			
		}else if (btnname.equals("btnCPU5") && CPUclick[3].equals(true)) {
			contadorCPU++;
			namejugador5.setText("CPU" + contadorCPU.toString());
			namejugador5.setEditable(false);
			CPUclick[3] = false;
			repaint();
			
		}else if (btnname.equals("btnCPU6") && CPUclick[4].equals(true)) {
			contadorCPU++;
			namejugador6.setText("CPU" + contadorCPU.toString());	
			namejugador6.setEditable(false);
			CPUclick[4] = false;
			repaint();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

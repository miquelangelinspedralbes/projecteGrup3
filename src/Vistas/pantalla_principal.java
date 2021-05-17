package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BDD.BaseDeDatosOrientadaObjetos;
import BDD.conexionBD;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

public class pantalla_principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantalla_principal frame = new pantalla_principal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pantalla_principal() {
		
		setTitle("principal_grup3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{180, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIgnoreRepaint(true);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setIcon(new ImageIcon(pantalla_principal.class.getResource("/img/\u251C\u043Dndice.jpeg")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{224, 218, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{32, 130, 0};
		gbl_panel_1.rowHeights = new int[]{32, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(pantalla_principal.class.getResource("/img/play-button(1).png")));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Jugar partida");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pantalla_jugar_selecciojugadors pSelec = new pantalla_jugar_selecciojugadors();
				pSelec.setVisible(true);
				pSelec.setLocationRelativeTo(null);

			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setSize(new Dimension(20, 200));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.WEST;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{32, 130, 0};
		gbl_panel_2.rowHeights = new int[]{32, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(pantalla_principal.class.getResource("/img/file.png")));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 0;
		panel_2.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		JButton btnInforme = new JButton("Informes");
		btnInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 informes informe = new informes();
				informe.setVisible(true);
				informe.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnInforme.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		panel_2.add(btnInforme, gbc_btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.EAST;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{32, 130, 0};
		gbl_panel_3.rowHeights = new int[]{32, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(pantalla_principal.class.getResource("/img/folder.png")));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Historico");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				historic h = new historic();
				h.setVisible(true);
				h.setLocationRelativeTo(null);
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 0;
		panel_3.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.WEST;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		panel.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{32, 130, 0};
		gbl_panel_4.rowHeights = new int[]{32, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(pantalla_principal.class.getResource("/img/user.png")));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_4.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("Jugadors");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla_jugadors pj = new pantalla_jugadors();
				pj.setVisible(true);
				pj.setLocationRelativeTo(null);
			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 0;
		panel_4.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.anchor = GridBagConstraints.EAST;
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 2;
		panel.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{32, 130, 0};
		gbl_panel_5.rowHeights = new int[]{32, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(pantalla_principal.class.getResource("/img/settings.png")));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_5.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("Opcions");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPane, "Volcado de preguntas a base de datos orientada a objetos");
				BaseDeDatosOrientadaObjetos objetos = new BaseDeDatosOrientadaObjetos();
				objetos.volcado();
			}
		});
		btnNewButton_4.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 0;
		panel_5.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.anchor = GridBagConstraints.WEST;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 2;
		panel.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{32, 130, 0};
		gbl_panel_6.rowHeights = new int[]{32, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(pantalla_principal.class.getResource("/img/error(1).png")));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		panel_6.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JButton btnNewButton_5 = new JButton("Sortir");
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 0;
		panel_6.add(btnNewButton_5, gbc_btnNewButton_5);
	}

}

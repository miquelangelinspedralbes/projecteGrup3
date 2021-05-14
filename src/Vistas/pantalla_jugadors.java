package Vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import SaberYGanar.Partida;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.ImageIcon;

public class pantalla_jugadors extends JFrame {
	private JPanel contentPane;

	public pantalla_jugadors() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 348, 363);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{255, 0};
		gbl_contentPane.rowHeights = new int[]{70, 58, 85, 70, 37, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		JLabel lblJugadors = new JLabel("Jugadors");
		lblJugadors.setForeground(Color.RED);
		lblJugadors.setFont(new Font("Dialog", Font.BOLD, 26));
		GridBagConstraints gbc_lblJugadors = new GridBagConstraints();
		gbc_lblJugadors.fill = GridBagConstraints.VERTICAL;
		gbc_lblJugadors.insets = new Insets(0, 0, 5, 0);
		gbc_lblJugadors.gridx = 0;
		gbc_lblJugadors.gridy = 0;
		contentPane.add(lblJugadors, gbc_lblJugadors);
		
		JButton btnTornar = new JButton("");
		btnTornar.setIcon(new ImageIcon(pantalla_jugadors.class.getResource("/img/return24.png")));
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("98px"),
				ColumnSpec.decode("149px"),},
			new RowSpec[] {
				RowSpec.decode("37px"),
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton btnVeureJugadors_1 = new JButton("");
		btnVeureJugadors_1.setBorder(null);
		btnVeureJugadors_1.setIcon(new ImageIcon(pantalla_jugadors.class.getResource("/img/magnifying-glass32.png")));
		btnVeureJugadors_1.setBackground(Color.DARK_GRAY);
		btnVeureJugadors_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 veureJugadors vj = new veureJugadors();
				 vj.setVisible(true);
			     vj.setLocationRelativeTo(null);
		        dispose();
			}
		});
		panel.add(btnVeureJugadors_1, "2, 1, fill, fill");
		
		JLabel lblNewLabel = new JLabel("veure");
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel, "2, 2, center, fill");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("98px"),
				ColumnSpec.decode("149px"),},
			new RowSpec[] {
				RowSpec.decode("36px"),
				RowSpec.decode("max(12dlu;default)"),}));
		
		JButton btnAfegirJugadors = new JButton("");
		btnAfegirJugadors.setBorder(null);
		btnAfegirJugadors.setForeground(Color.DARK_GRAY);
		btnAfegirJugadors.setIcon(new ImageIcon(pantalla_jugadors.class.getResource("/img/plus-symbol-button32.png")));
		btnAfegirJugadors.setBackground(Color.DARK_GRAY);
		panel_1.add(btnAfegirJugadors, "2, 1, fill, fill");
		
		JLabel lblNewLabel_1 = new JLabel("afegir");
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel_1, "2, 2, center, fill");
		btnAfegirJugadors.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        afegirJugadors aj = new afegirJugadors();
		        aj.setVisible(true);
		        aj.setLocationRelativeTo(null);
		        dispose();
		    }
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.NORTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		contentPane.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("98px"),
				ColumnSpec.decode("149px"),},
			new RowSpec[] {
				RowSpec.decode("40px"),
				RowSpec.decode("max(12dlu;default)"),}));
		
		JButton btnEliminarJugadors = new JButton("");
		btnEliminarJugadors.setBorder(null);
		btnEliminarJugadors.setIcon(new ImageIcon(pantalla_jugadors.class.getResource("/img/remove32.png")));
		btnEliminarJugadors.setBackground(Color.DARK_GRAY);
		panel_2.add(btnEliminarJugadors, "2, 1, fill, fill");
		
		JLabel lblNewLabel_2 = new JLabel("eliminar");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.WHITE);
		panel_2.add(lblNewLabel_2, "2, 2, center, center");
		btnEliminarJugadors.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        eliminarJugadors ej = new eliminarJugadors();
		        ej.setVisible(true);
		        ej.setLocationRelativeTo(null);
		        dispose();
		    }
		});
		GridBagConstraints gbc_btnTornar = new GridBagConstraints();
		gbc_btnTornar.fill = GridBagConstraints.BOTH;
		gbc_btnTornar.gridx = 0;
		gbc_btnTornar.gridy = 4;
		contentPane.add(btnTornar, gbc_btnTornar);
	}
}

package Gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.ComponentOrientation;
import java.awt.Component;
import javax.swing.JLabel;
import java.util.Date;
import java.text.SimpleDateFormat;
public class SistemaGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private final JPanel panel_1 = new JPanel();
	private JButton btnVehiculos;
	private JButton btnClientes;
	private JButton btnMantenimiento;
	private JTabbedPane principal;
	public String p1 = "0";
	public String p2 = "0";
	public String p3 = "0";
	private JButton btnProductos;
	private JLabel lblNewLabel;
	private JLabel lblFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		FlatAtomOneLightIJTheme.setup();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaGUI frame = new SistemaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SistemaGUI() {
		
		Date fechaActual = new Date();
        
        SimpleDateFormat formato = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy");
        
        String fechaEnPalabras = formato.format(fechaActual);
        
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1323, 898);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("ToggleButton.highlight"));
		panel.setBounds(260, 0, 1053, 107);
		panel.setBackground(new Color(25, 118, 211));

		contentPane.add(panel);
		panel.setLayout(null);
		
		lblFecha = new JLabel("New label");
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setFont(new Font("Roboto", Font.PLAIN, 30));
		lblFecha.setBounds(258, 33, 701, 46);
		panel.add(lblFecha);
		panel_1.setBackground(new Color(51, 0, 153));
		panel_1.setBounds(0, 0, 260, 859);
		contentPane.add(panel_1);
		
		btnVehiculos = new JButton("Vehiculos");
		btnVehiculos.setForeground(new Color(255, 255, 255));
		btnVehiculos.setFont(new Font("Roboto Black", Font.PLAIN, 19));
		btnVehiculos.setIcon(new ImageIcon(SistemaGUI.class.getResource("/Images/coche.png")));
		btnVehiculos.setBorder(null);
		btnVehiculos.addActionListener(this);
		btnVehiculos.setBounds(0, 158, 260, 50);
		btnVehiculos.setBackground(new Color(22,101,193));

		panel_1.setLayout(null);
		panel_1.add(btnVehiculos);
		
		btnClientes = new JButton("Clientes");
		btnClientes.setAlignmentY(Component.TOP_ALIGNMENT);
		btnClientes.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnClientes.setVerticalTextPosition(SwingConstants.TOP);
		btnClientes.setMargin(new Insets(2, 63, 2, 14));
		btnClientes.setFont(new Font("Roboto Black", Font.BOLD, 19));
		btnClientes.setIcon(new ImageIcon(SistemaGUI.class.getResource("/Images/usuario1.png")));
		btnClientes.setForeground(new Color(255, 255, 255));
		btnClientes.setBorder(null);
		btnClientes.addActionListener(this);
		btnClientes.setBounds(0, 108, 260, 50);
		btnClientes.setBackground(new Color(22,101,193));

		panel_1.add(btnClientes);
		
		btnMantenimiento = new JButton("Mantenimientos");
		btnMantenimiento.setIcon(new ImageIcon(SistemaGUI.class.getResource("/Images/herramientas.png")));
		btnMantenimiento.setForeground(new Color(255, 255, 255));
		btnMantenimiento.setFont(new Font("Roboto Black", Font.PLAIN, 19));
		btnMantenimiento.setBorder(null);
		btnMantenimiento.setBackground(new Color(22,101,193));
		btnMantenimiento.addActionListener(this);
		btnMantenimiento.setBounds(0, 208, 260, 50);
		panel_1.add(btnMantenimiento);
		
		principal = new JTabbedPane(JTabbedPane.TOP);
		principal.setBounds(300, 11, 1054, 832);
		contentPane.add(principal);
		
		
		panel_1.setBackground(new Color(14,71,161));
		
		btnProductos = new JButton("Productos");
		btnProductos.setIcon(new ImageIcon(SistemaGUI.class.getResource("/Images/caja-abierta-llena.png")));
		btnProductos.setForeground(Color.WHITE);
		btnProductos.setFont(new Font("Roboto Black", Font.PLAIN, 19));
		btnProductos.setBorder(null);
		btnProductos.setBackground(new Color(22, 101, 193));
		btnProductos.setBounds(0, 256, 260, 50);
		panel_1.add(btnProductos);
		
		lblNewLabel = new JLabel("Mecanica");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(SistemaGUI.class.getResource("/Images/favicon.png")));
		lblNewLabel.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel.setBounds(31, 24, 190, 68);
		panel_1.add(lblNewLabel);

        lblFecha.setText("Hoy es " + fechaEnPalabras);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMantenimiento) {
			actionPerformedBtnMantenimiento(e);
		}
		if (e.getSource() == btnClientes) {
			actionPerformedBtnClientes(e);
		}
		if (e.getSource() == btnVehiculos) {
			actionPerformedBtnVehiculos(e);
		}
	}
	protected void actionPerformedBtnVehiculos(ActionEvent e) {
		p1="0";
		VehiculoGUI v=new VehiculoGUI();
		if(p1.equals( "0")) {
		principal.addTab("Vehiculo ", v);
		principal.setSelectedComponent(v);
		}else {
			principal.setSelectedComponent(v);
		}
		p1 = "1";

		
	}
	
	
	
	protected void actionPerformedBtnClientes(ActionEvent e) {
		p2="0";

		ClienteGUI c=new ClienteGUI();
		if(p2.equals( "0")) {
		principal.addTab("Vehiculo ", c);
		principal.setSelectedComponent(c);
		}else {
			principal.setSelectedComponent(c);

		}
		p2 = "1";
		
	}
	protected void actionPerformedBtnMantenimiento(ActionEvent e) {
		p3="0";
		ServicioGUI s=new ServicioGUI();
		if(p3.equals( "0")) {
		principal.addTab("Servicio ", s);
		principal.setSelectedComponent(s);
		}else {
			principal.setSelectedComponent(s);
		}
		p3 = "1";
		
	}
}

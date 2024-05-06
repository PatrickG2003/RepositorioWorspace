package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;

import Modelo.Usuario;
import Modelo.UsuarioDao;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class LoginGUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCorreo;
	private JButton btnLogin;
	private JPasswordField txtPass;

	Usuario u = new Usuario();
	UsuarioDao udao=new UsuarioDao();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel label;
	private JSeparator separator;
	private JLabel lblNewLabel_5;
	private JSeparator separator_1;
	private JPanel panel_1;
	private JLabel lblNewLabel_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		FlatAtomOneLightIJTheme.setup();

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		
		
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGUI.class.getResource("/Images/logo.png")));
		setForeground(new Color(240, 248, 255));
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crea un JPanel para agregar al JFrame
        JPanel panel = new JPanel();
        // Establece el diseño del panel
        panel.setLayout(new BorderLayout());
        // Establece el color de fondo del panel
        panel.setBackground(Color.WHITE);
        
        // Agrega el panel al JFrame
        getContentPane().add(panel);
        
        // Cambia el color del borde del JFrame
        panel.setBorder(new LineBorder(Color.RED, 5));
		
		
		
		
		
		
		
		
		setBackground(UIManager.getColor("ToggleButton.highlight"));
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 559, 531);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ToggleButton.highlight"));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCorreo = new JTextField();
		txtCorreo.setForeground(new Color(128, 128, 128));
		txtCorreo.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtCorreo.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtCorreo.setBorder(null);
		txtCorreo.setBounds(26, 254, 262, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		btnLogin = new JButton("ENTRAR");
		btnLogin.setBorder(null);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.setFont(new Font("Roboto", Font.PLAIN, 16));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addActionListener(this);
		btnLogin.setBounds(26, 412, 132, 42);
		contentPane.add(btnLogin);
		
		txtPass = new JPasswordField();
		txtPass.setForeground(new Color(128, 128, 128));
		txtPass.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtPass.setBorder(null);
		txtPass.setBounds(26, 340, 262, 20);
		contentPane.add(txtPass);
	
		  this.setLocationRelativeTo(null);
	        txtCorreo.setText("steve@gmail.com");
	        txtPass.setText("admin");
	        
	        lblNewLabel = new JLabel("Correo");
	        lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
	        lblNewLabel.setBounds(26, 214, 70, 29);
	        contentPane.add(lblNewLabel);
	        
	        separator = new JSeparator();
	        separator.setForeground(UIManager.getColor("ToggleButton.light"));
	        separator.setBackground(new Color(128, 128, 128));
	        separator.setBounds(26, 274, 271, 12);
	        contentPane.add(separator);
	        
	        
	        label = new JLabel("New label");
	        label.setHorizontalAlignment(SwingConstants.CENTER);
	        label.setForeground(UIManager.getColor("TextPane.selectionForeground"));
	        label.setFont(new Font("Roboto", Font.BOLD, 24));
	        label.setBounds(327, 204, 222, 17);
	        contentPane.add(label);
	        
	        lblNewLabel_4 = new JLabel("");
	        lblNewLabel_4.setIcon(new ImageIcon(LoginGUI.class.getResource("/Images/logo.png")));
	        lblNewLabel_4.setBounds(365, 39, 161, 166);
	        contentPane.add(lblNewLabel_4);
	        lblNewLabel_1 = new JLabel("Password");
	        lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 18));
	        lblNewLabel_1.setBounds(26, 315, 86, 14);
	        contentPane.add(lblNewLabel_1);
	        
	        lblNewLabel_2 = new JLabel("New label");
	        lblNewLabel_2.setIcon(new ImageIcon(LoginGUI.class.getResource("/Images/city.png")));
	        lblNewLabel_2.setBounds(337, 22, 222, 524);
	        contentPane.add(lblNewLabel_2);
	        
	        lblNewLabel_3 = new JLabel("New label");
	        lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 24));
	        lblNewLabel_3.setIcon(new ImageIcon(LoginGUI.class.getResource("/Images/favicon.png")));
	        lblNewLabel_3.setBounds(26, 35, 190, 68);
	        contentPane.add(lblNewLabel_3);
	        
	        lblNewLabel_5 = new JLabel("INICIAR SESION");
	        lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
	        lblNewLabel_5.setFont(new Font("Roboto", Font.BOLD, 26));
	        lblNewLabel_5.setBounds(27, 143, 261, 42);
	        contentPane.add(lblNewLabel_5);
	        
	        separator_1 = new JSeparator();
	        separator_1.setForeground(UIManager.getColor("ToggleButton.light"));
	        separator_1.setBackground(new Color(128, 128, 128));
	        separator_1.setBounds(26, 362, 271, 12);
	        contentPane.add(separator_1);
	        
	        panel_1 = new JPanel();
	        panel_1.addMouseMotionListener(this);
	        panel_1.addMouseListener(this);
	        panel_1.setBackground(new Color(0, 153, 204));
	        panel_1.setBounds(0, 0, 559, 34);
	        contentPane.add(panel_1);
	        panel_1.setLayout(null);
	        
	        lblNewLabel_6 = new JLabel("X");
	        lblNewLabel_6.addMouseListener(this);
	        lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_6.setFont(new Font("Roboto", Font.BOLD, 11));
	        lblNewLabel_6.setBounds(0, 0, 37, 34);
	        panel_1.add(lblNewLabel_6);
	        
	    
	     
	        
	        
	}
	 
	 
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			actionPerformedBtnLogin(e);
		}
	}
	protected void actionPerformedBtnLogin(ActionEvent e) {
		
		validar();
		
	}
	
	 public void validar(){
	        String correo = txtCorreo.getText();
	        String pass = String.valueOf(txtPass.getPassword());
	        if (!"".equals(correo) || !"".equals(pass)) {
	            
	            u = udao.log(correo, pass);
	            if (u.getCorreo()!= null && u.getPass() != null) {
	                SistemaGUI sis = new SistemaGUI();
	                sis.setVisible(true);
	                dispose();
	            }else{
	                JOptionPane.showMessageDialog(null, "Correo o la Contraseña incorrecta");
	            }
	        }
	    }
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblNewLabel_6) {
			mouseClickedLblNewLabel_6(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		
		lblNewLabel_6.setBackground(Color.BLACK);
		
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == panel_1) {
			mousePressedPanel_1(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLblNewLabel_6(MouseEvent e) {
		
		System.exit(0);
		
	}
	int Xmouse,Ymouse;

	protected void mousePressedPanel_1(MouseEvent e) {
		
		Xmouse =e.getX();
		Ymouse= e.getY();
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == panel_1) {
			mouseDraggedPanel_1(e);
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	protected void mouseDraggedPanel_1(MouseEvent e) {
		int x =e.getXOnScreen();
		int y =e.getYOnScreen();
		this.setLocation(x - Xmouse, y-Ymouse);
	}
}

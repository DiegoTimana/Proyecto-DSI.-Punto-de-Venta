package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class VentanaLogin extends JFrame {

	public JPanel contentPane;
	public JPasswordField passwordField;
	public JTextField textFieldUsuario;
	public JButton btnIngresar;
	final VentanaGerente windowgerente = new VentanaGerente();
	
	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo1 = new JLabel("DEMAS");
		titulo1.setFont(new Font("Tahoma", Font.BOLD, 26));
		titulo1.setHorizontalAlignment(SwingConstants.CENTER);
		titulo1.setBounds(0, 11, 444, 28);
		contentPane.add(titulo1);
		
		JLabel titulo2 = new JLabel("LOGIN");
		titulo2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		titulo2.setBounds(0, 50, 444, 28);
		titulo2.setBackground(new Color( 94, 157, 200));
		titulo2.setOpaque(true);
		contentPane.add(titulo2);
		
		JLabel imagen1 = new JLabel("");
		imagen1.setHorizontalAlignment(SwingConstants.CENTER);
		imagen1.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/loginImage.png")));
		imagen1.setBounds(0, 89, 434, 128);
		contentPane.add(imagen1);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(41, 249, 72, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(41, 289, 72, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(e.getKeyChar()==61 || e.getKeyChar()==59) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "No se permiten los caracteres = ;");
				}
				
				if(passwordField.getPassword().length>=10) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar 10 caracteres o menos");
				}
				
			}
		});
		passwordField.setBounds(123, 288, 203, 20);
		contentPane.add(passwordField);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
				}
				
				
				if(textFieldUsuario.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(rootPane, "Ingresar 15 numeros o menos");
				}
				
			}
		});
		textFieldUsuario.setBounds(123, 248, 203, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIngresar.setBounds(166, 335, 106, 28);
		contentPane.add(btnIngresar);
	}
}

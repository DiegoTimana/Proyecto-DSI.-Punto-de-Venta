package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaPerfil extends JFrame{

	public JPanel contentPane;
	public JTextField textFieldNombre;
	public JTextField textFieldCedula;
	public JTextField textFieldCargo;
	public JTextField textFieldSede;
	public JPasswordField passwordField;
	public JButton btnActualizar;
	public JButton btnVolverAtrs;

	/**
	 * Create the frame.
	 */
	public VentanaPerfil() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 528, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("DEMAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTitulo.setBounds(0, 11, 514, 26);
		contentPane.add(lblTitulo);
		
		JLabel lblSede = new JLabel("Sede:");
		lblSede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSede.setBounds(32, 166, 69, 20);
		contentPane.add(lblSede);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(32, 141, 69, 20);
		contentPane.add(lblCargo);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCedula.setBounds(32, 116, 69, 20);
		contentPane.add(lblCedula);
		
		JLabel lblTituloVentana = new JLabel("Perfil");
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloVentana.setBounds(0, 48, 514, 26);
		lblTituloVentana.setBackground(new Color( 94, 157, 200));
		lblTituloVentana.setOpaque(true);
		contentPane.add(lblTituloVentana);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(32, 91, 69, 20);
		contentPane.add(lblNombre);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(32, 191, 69, 20);
		contentPane.add(lblPassword);
		
		/////TEXT FIELDS (los text fields de esta ventana no son editables, solo se muestra la informacion que ya se encuentra en la bd)
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(111, 91, 268, 20);
		textFieldNombre.setEditable(false);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(111, 116, 268, 20);
		textFieldCedula.setEditable(false);
		contentPane.add(textFieldCedula);
		textFieldCedula.setColumns(10);
		
		textFieldCargo = new JTextField();
		textFieldCargo.setBounds(111, 141, 268, 20);
		textFieldCargo.setEditable(false);
		contentPane.add(textFieldCargo);
		textFieldCargo.setColumns(10);
		
		textFieldSede = new JTextField();
		textFieldSede.setBounds(111, 166, 268, 20);
		textFieldSede.setEditable(false);
		contentPane.add(textFieldSede);
		textFieldSede.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 191, 268, 20);
		passwordField.setEditable(false);
		contentPane.add(passwordField);
		
		
		//Boton de actualizar->cambio de coontraseña
		btnActualizar = new JButton("Cambiar Password");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActualizar.setBounds(221, 239, 158, 30);
		contentPane.add(btnActualizar);
		
		btnVolverAtrs = new JButton("Regresar");
		btnVolverAtrs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolverAtrs.setBounds(111, 239, 100, 30);
		contentPane.add(btnVolverAtrs);
		
		JLabel lblImagen = new JLabel("New label");
		lblImagen.setIcon(new ImageIcon(VentanaPerfil.class.getResource("/imagenes/imagenPerfil.png")));
		lblImagen.setBounds(420, 122, 64, 64);
		contentPane.add(lblImagen);
		
	}
}

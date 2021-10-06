package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class VentanaGestionUsuarios extends JFrame {

	public JPanel contentPane;
	public JTextField textFieldFechaNacimientoUsuario;
	public JTextField textFieldApellidosUsuario;
	public JTextField textFieldNombreUsuario;
	public JTextField textFieldIdUsuario;
	public JTextField textFieldTelefonoUsuario;
	public JTextField textFieldDireccionUsuario;
	public JTextField textFieldEmailUsuario;
	public JTextField textFieldFechaVinculacionUsuario;
	public JTextField textFieldSedeUsuario;
	public JTextField textFieldPasswordUsuario;
	public JComboBox<String> comboBoxGeneroUsuario;
	public JComboBox<String> comboBoxEstadoUsuario;
	public JComboBox<String> comboBoxCargoUsuario;
	
	public JButton btnGuardarUsuario;
	public JButton btnModificarUsuario;
	public JButton btnEliminarUsuario;
	public JButton btnLimpiarUsuario;
	public JButton btnBuscarUsuario;
	public JButton btnRegresar;
	private JLabel lblImagen;
	public JButton btnVolver;
	public JButton btnRegistrar; 
	public JButton btnGuardarCambios;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaGestionUsuarios() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 604, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo1 = new JLabel("DEMAS");
		lblTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo1.setBackground(Color.LIGHT_GRAY);
		lblTitulo1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTitulo1.setBounds(0, 11, 571, 32);
		contentPane.add(lblTitulo1);
		
		JLabel lblTitulo2 = new JLabel("Gestion de Usuarios");
		lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo2.setBounds(0, 54, 586, 25);
		lblTitulo2.setBackground(new Color( 94, 157, 200));
		lblTitulo2.setOpaque(true);

		contentPane.add(lblTitulo2);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(43, 101, 143, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(43, 130, 108, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Apellidos");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(43, 159, 143, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(43, 188, 143, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(43, 217, 143, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(43, 246, 143, 20);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Email:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(43, 275, 143, 20);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Genero:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(43, 304, 143, 20);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Fecha de Vinculaci\u00F3n:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(43, 333, 143, 20);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Cargo");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(43, 362, 143, 20);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Estado:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(43, 391, 143, 20);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Sede:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(43, 420, 143, 20);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Password:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(43, 449, 143, 20);
		contentPane.add(lblNewLabel_14);
		
		textFieldFechaNacimientoUsuario = new JTextField();
		textFieldFechaNacimientoUsuario.setEditable(false);
		textFieldFechaNacimientoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldFechaNacimientoUsuario.setBounds(196, 188, 221, 20);
		contentPane.add(textFieldFechaNacimientoUsuario);
		textFieldFechaNacimientoUsuario.setColumns(10);
		
		textFieldApellidosUsuario = new JTextField();
		textFieldApellidosUsuario.setEditable(false);
		textFieldApellidosUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldApellidosUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				
				if(Character.isDigit(validar)) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
				}
			}
		});
		textFieldApellidosUsuario.setBounds(196, 159, 221, 20);
		contentPane.add(textFieldApellidosUsuario);
		textFieldApellidosUsuario.setColumns(10);
		
		textFieldNombreUsuario = new JTextField();
		textFieldNombreUsuario.setEditable(false);
		textFieldNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNombreUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				
				if(Character.isDigit(validar)) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
				}
			}
		});
		textFieldNombreUsuario.setBounds(196, 130, 221, 20);
		contentPane.add(textFieldNombreUsuario);
		textFieldNombreUsuario.setColumns(10);
		
		textFieldIdUsuario = new JTextField();
		textFieldIdUsuario.setEditable(false);
		textFieldIdUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldIdUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
				}
			}
		});
		textFieldIdUsuario.setBounds(196, 101, 221, 20);
		contentPane.add(textFieldIdUsuario);
		textFieldIdUsuario.setColumns(10);
		
		textFieldTelefonoUsuario = new JTextField();
		textFieldTelefonoUsuario.setEditable(false);
		textFieldTelefonoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTelefonoUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
				}
			}
		});
		textFieldTelefonoUsuario.setBounds(196, 217, 221, 20);
		contentPane.add(textFieldTelefonoUsuario);
		textFieldTelefonoUsuario.setColumns(10);
		
		textFieldDireccionUsuario = new JTextField();
		textFieldDireccionUsuario.setEditable(false);
		textFieldDireccionUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldDireccionUsuario.setBounds(196, 246, 221, 20);
		contentPane.add(textFieldDireccionUsuario);
		textFieldDireccionUsuario.setColumns(10);
		
		textFieldEmailUsuario = new JTextField();
		textFieldEmailUsuario.setEditable(false);
		textFieldEmailUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEmailUsuario.setBounds(196, 275, 221, 20);
		contentPane.add(textFieldEmailUsuario);
		textFieldEmailUsuario.setColumns(10);
		
		textFieldFechaVinculacionUsuario = new JTextField();
		textFieldFechaVinculacionUsuario.setEditable(false);
		textFieldFechaVinculacionUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldFechaVinculacionUsuario.setBounds(196, 333, 221, 20);
		contentPane.add(textFieldFechaVinculacionUsuario);
		textFieldFechaVinculacionUsuario.setColumns(10);
		
		textFieldSedeUsuario = new JTextField();
		textFieldSedeUsuario.setEditable(false);
		textFieldSedeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSedeUsuario.setBounds(196, 420, 221, 20);
		contentPane.add(textFieldSedeUsuario);
		textFieldSedeUsuario.setColumns(10);
		
		textFieldPasswordUsuario = new JTextField();
		textFieldPasswordUsuario.setEditable(false);
		textFieldPasswordUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldPasswordUsuario.setBounds(196, 449, 221, 20);
		contentPane.add(textFieldPasswordUsuario);
		textFieldPasswordUsuario.setColumns(10);
		
		btnGuardarUsuario = new JButton("Registrar");
		btnGuardarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardarUsuario.setBounds(450, 245, 97, 20);
		contentPane.add(btnGuardarUsuario);
		
		btnModificarUsuario = new JButton("Actualizar");
		btnModificarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarUsuario.setBounds(450, 275, 97, 20);
		contentPane.add(btnModificarUsuario);
		
		btnEliminarUsuario = new JButton("Eliminar");
		btnEliminarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarUsuario.setBounds(450, 304, 97, 20);
		contentPane.add(btnEliminarUsuario);
		
		btnLimpiarUsuario = new JButton("Limpiar");
		btnLimpiarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiarUsuario.setBounds(450, 362, 97, 22);
		contentPane.add(btnLimpiarUsuario);
		
		btnBuscarUsuario = new JButton("Buscar");
		btnBuscarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarUsuario.setBounds(450, 217, 97, 20);
		contentPane.add(btnBuscarUsuario);
		
		comboBoxGeneroUsuario = new JComboBox<String>();
		comboBoxGeneroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxGeneroUsuario.setModel(new DefaultComboBoxModel<String>(new String[] {"", "masculino", "femenino"}));
		comboBoxGeneroUsuario.setBounds(196, 303, 221, 22);
		contentPane.add(comboBoxGeneroUsuario);
		
		
		comboBoxEstadoUsuario = new JComboBox<String>();
		comboBoxEstadoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxEstadoUsuario.setModel(new DefaultComboBoxModel<String>(new String[] {"", "activo", "inactivo"}));
		comboBoxEstadoUsuario.setBounds(196, 390, 221, 22);
		contentPane.add(comboBoxEstadoUsuario);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegresar.setBounds(450, 393, 97, 22);
		contentPane.add(btnRegresar);
		
		comboBoxCargoUsuario = new JComboBox<String>();
		comboBoxCargoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxCargoUsuario.setModel(new DefaultComboBoxModel<String>(new String[] {"", "secretaria", "operador de oficina", "contador", "gerente", "auxiliar de operacion"}));
		comboBoxCargoUsuario.setBounds(196, 361, 221, 22);
		contentPane.add(comboBoxCargoUsuario);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VentanaGestionUsuarios.class.getResource("/imagenes/imagenGestionUsuarios.png")));
		lblImagen.setBounds(467, 90, 64, 64);
		contentPane.add(lblImagen);
		
		btnRegistrar = new JButton("Guardar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(450, 334, 97, 20);
		contentPane.add(btnRegistrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(450, 421, 97, 20);
		contentPane.add(btnVolver);
		
		btnGuardarCambios = new JButton("Actualizar");
		btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardarCambios.setBounds(450, 189, 97, 20);
		contentPane.add(btnGuardarCambios);
	}
}

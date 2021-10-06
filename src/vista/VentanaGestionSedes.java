package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class VentanaGestionSedes extends JFrame {

	public JPanel contentPane;
	public JTextField textFieldNombreSede;
	public JTextField textFieldDireccionSede;
	public JTextField textFieldTelefonoSede;
	public JTextField textFieldIdSede;
	public JButton btnGuardarSede;
	public JButton btnModificarSede; 
	public JButton btnEliminarSede;
	public JButton btnLimpiarSede; 
	public JButton btnBuscarSede; 
	public JComboBox<String> estado;
	public JButton btnRegresar;
	public JButton btnRegistrar;
	public JButton btnActualizar;
	public JButton btnVolver;

	/**
	 * Create the frame.
	 */
	public VentanaGestionSedes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 604, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEMAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 598, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion de Sedes");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(0, 50, 598, 25);
		lblNewLabel_1.setBackground(new Color( 94, 157, 200));
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);
		
		JLabel labelIdSede = new JLabel("ID Sedes:");
		labelIdSede.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelIdSede.setBounds(41, 96, 73, 14);
		contentPane.add(labelIdSede);
		
		JLabel labelNombreSede = new JLabel("Nombre:");
		labelNombreSede.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelNombreSede.setBounds(41, 130, 73, 14);
		contentPane.add(labelNombreSede);
		
		JLabel labelDireccionSede = new JLabel("Direcci\u00F3n:");
		labelDireccionSede.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelDireccionSede.setBounds(41, 164, 73, 14);
		contentPane.add(labelDireccionSede);
		
		JLabel labelTelefonoSede = new JLabel("Telefono:");
		labelTelefonoSede.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelTelefonoSede.setBounds(41, 198, 73, 14);
		contentPane.add(labelTelefonoSede);
		
		JLabel labelEstadoSede = new JLabel("Estado:");
		labelEstadoSede.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelEstadoSede.setBounds(41, 232, 73, 14);
		contentPane.add(labelEstadoSede);
		
		textFieldIdSede = new JTextField();
		textFieldIdSede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldIdSede.setEditable(false);
		textFieldIdSede.setBounds(141, 93, 289, 20);
		contentPane.add(textFieldIdSede);
		textFieldIdSede.setColumns(10);
		
		textFieldNombreSede = new JTextField();
		textFieldNombreSede.setEditable(false);
		textFieldNombreSede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNombreSede.setBounds(141, 127, 289, 20);
		contentPane.add(textFieldNombreSede);
		textFieldNombreSede.setColumns(10);
		
		textFieldDireccionSede = new JTextField();
		textFieldDireccionSede.setEditable(false);
		textFieldDireccionSede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldDireccionSede.setBounds(141, 161, 289, 20);
		contentPane.add(textFieldDireccionSede);
		textFieldDireccionSede.setColumns(10);
		
		textFieldTelefonoSede = new JTextField();
		textFieldTelefonoSede.setEditable(false);
		textFieldTelefonoSede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTelefonoSede.setBounds(141, 195, 289, 20);
		contentPane.add(textFieldTelefonoSede);
		textFieldTelefonoSede.setColumns(10);
		
		btnGuardarSede = new JButton("Guardar");
		btnGuardarSede.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnGuardarSede.setBounds(184, 277, 111, 23);
		contentPane.add(btnGuardarSede);
		
		btnModificarSede = new JButton("Actualizar");
		btnModificarSede.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnModificarSede.setBounds(319, 277, 111, 23);
		contentPane.add(btnModificarSede);
		
		btnEliminarSede = new JButton("Eliminar");
		btnEliminarSede.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnEliminarSede.setBounds(462, 277, 111, 23);
		contentPane.add(btnEliminarSede);
		
		btnLimpiarSede = new JButton("Limpiar");
		btnLimpiarSede.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnLimpiarSede.setBounds(184, 311, 111, 23);
		contentPane.add(btnLimpiarSede);
		
		btnBuscarSede = new JButton("Buscar");
		btnBuscarSede.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnBuscarSede.setBounds(41, 277, 113, 23);
		contentPane.add(btnBuscarSede);
		
		estado = new JComboBox<String>();
		estado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		estado.setModel(new DefaultComboBoxModel<String>(new String[] {"", "activo", "inactivo"}));
		estado.setBounds(141, 228, 289, 22);
		contentPane.add(estado);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnRegresar.setBounds(319, 311, 111, 23);
		contentPane.add(btnRegresar);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(VentanaGestionSedes.class.getResource("/imagenes/imagenSedes.png")));
		lblNewLabel_3.setBounds(497, 86, 64, 64);
		contentPane.add(lblNewLabel_3);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnVolver.setBounds(462, 228, 113, 23);
		contentPane.add(btnVolver);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnActualizar.setBounds(462, 195, 111, 23);
		contentPane.add(btnActualizar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnRegistrar.setBounds(462, 162, 111, 23);
		contentPane.add(btnRegistrar);
	}
}

package vista;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class VentanaPos extends JFrame {

	public JPanel contentPane;
	public JTextField textFieldNombreCliente;
	public JTextField textFieldApellidosCliente;
	public JTextField textFieldIdCliente;
	public JTextField textFieldDireccionCliente;
	public JTextField textFieldTelefonoCliente;
	public JButton btnActualizarCliente;
	public JButton btnBuscarCliente;
	public JButton btnAdicionarCliente;
	public JButton btnRegresar;
	public JButton btnLimpiarCasillasCliente;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	public JTextField textFieldFechaSistema;
	public JTextField textFieldiDUsuario;
	public JTextField textFieldSedeUsuario;
	public JButton btnCancelar;
	public JButton btnGuardarCliente;
	public JButton btnAdicionarPaquete;
	private JLabel lblNewLabel_7;
	public JButton btnGuardarUsuarioParaVenta;
	private JLabel lblSalir_1;
	/**
	 * Create the frame.
	 */
	public VentanaPos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEMAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(0, 11, 658, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Terminal de Venta - Informaci\u00F3n Cliente");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(0, 53, 658, 23);
		lblNewLabel_1.setBackground(new Color( 94, 157, 200));
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);
		
		textFieldNombreCliente = new JTextField();
		textFieldNombreCliente.setEditable(false);
		textFieldNombreCliente.setBounds(127, 205, 321, 20);
		contentPane.add(textFieldNombreCliente);
		textFieldNombreCliente.setColumns(10);
		
		textFieldApellidosCliente = new JTextField();
		textFieldApellidosCliente.setEditable(false);
		textFieldApellidosCliente.setBounds(127, 236, 321, 20);
		contentPane.add(textFieldApellidosCliente);
		textFieldApellidosCliente.setColumns(10);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setEditable(false);
		textFieldIdCliente.setBounds(127, 174, 321, 20);
		contentPane.add(textFieldIdCliente);
		textFieldIdCliente.setColumns(10);
		
		textFieldDireccionCliente = new JTextField();
		textFieldDireccionCliente.setEditable(false);
		textFieldDireccionCliente.setBounds(127, 269, 321, 20);
		contentPane.add(textFieldDireccionCliente);
		textFieldDireccionCliente.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(47, 203, 70, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(47, 234, 70, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(47, 267, 70, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefono:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(47, 298, 70, 20);
		contentPane.add(lblNewLabel_5);
		
		textFieldTelefonoCliente = new JTextField();
		textFieldTelefonoCliente.setEditable(false);
		textFieldTelefonoCliente.setBounds(127, 302, 321, 20);
		contentPane.add(textFieldTelefonoCliente);
		textFieldTelefonoCliente.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Informaci\u00F3n Venta");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(47, 393, 170, 23);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("ID:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(47, 172, 70, 20);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Informaci\u00F3n Cliente");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_12.setBounds(47, 140, 577, 18);
		contentPane.add(lblNewLabel_12);
		
		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarCliente.setBounds(491, 172, 133, 20);
		contentPane.add(btnBuscarCliente);
		
		btnAdicionarCliente = new JButton("Adicionar Cliente");
		btnAdicionarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionarCliente.setBounds(491, 203, 133, 20);
		contentPane.add(btnAdicionarCliente);
		
		btnActualizarCliente = new JButton("Actualizar");
		btnActualizarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizarCliente.setBounds(491, 234, 133, 20);
		contentPane.add(btnActualizarCliente);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegresar.setBounds(491, 502, 133, 20);
		contentPane.add(btnRegresar);
		
		btnLimpiarCasillasCliente = new JButton("Limpiar");
		btnLimpiarCasillasCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiarCasillasCliente.setBounds(491, 267, 133, 20);
		contentPane.add(btnLimpiarCasillasCliente);
		
		lblNewLabel_17 = new JLabel("ID Usuario:");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_17.setBounds(47, 87, 70, 20);
		contentPane.add(lblNewLabel_17);
		
		textFieldiDUsuario = new JTextField();
		textFieldiDUsuario.setEditable(false);
		textFieldiDUsuario.setBounds(127, 87, 127, 20);
		contentPane.add(textFieldiDUsuario);
		textFieldiDUsuario.setColumns(10);
		
		lblNewLabel_18 = new JLabel("Fecha:");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_18.setBounds(301, 87, 48, 20);
		contentPane.add(lblNewLabel_18);
		
		textFieldFechaSistema = new JTextField();
		textFieldFechaSistema.setEditable(false);
		textFieldFechaSistema.setBounds(362, 89, 86, 20);
		contentPane.add(textFieldFechaSistema);
		textFieldFechaSistema.setColumns(10);
		
		lblNewLabel_19 = new JLabel("Sede:");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_19.setBounds(487, 87, 41, 20);
		contentPane.add(lblNewLabel_19);
		
		textFieldSedeUsuario = new JTextField();
		textFieldSedeUsuario.setEditable(false);
		textFieldSedeUsuario.setBounds(538, 87, 86, 20);
		contentPane.add(textFieldSedeUsuario);
		textFieldSedeUsuario.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(491, 299, 133, 20);
		contentPane.add(btnCancelar);
		
		btnGuardarCliente = new JButton("Guardar");
		btnGuardarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardarCliente.setBounds(491, 173, 133, 20);
		contentPane.add(btnGuardarCliente);
		
		btnAdicionarPaquete = new JButton("Adicionar Paquetes");
		btnAdicionarPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionarPaquete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionarPaquete.setBounds(47, 502, 170, 20);
		contentPane.add(btnAdicionarPaquete);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(VentanaPos.class.getResource("/imagenes/imagenCaja.png")));
		lblNewLabel_7.setBounds(87, 427, 64, 64);
		contentPane.add(lblNewLabel_7);
		
		btnGuardarUsuarioParaVenta = new JButton("Guardar");
		btnGuardarUsuarioParaVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardarUsuarioParaVenta.setBounds(47, 346, 170, 20);
		contentPane.add(btnGuardarUsuarioParaVenta);
		
		lblSalir_1 = new JLabel("");
		lblSalir_1.setIcon(new ImageIcon(VentanaPos.class.getResource("/imagenes/imagenRegresar.png")));
		lblSalir_1.setBounds(527, 427, 64, 64);
		contentPane.add(lblSalir_1);
	}
	
	
}

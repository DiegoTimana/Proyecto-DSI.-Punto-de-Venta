package vista;


import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Reporte;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPaquetes extends JFrame {

	public JPanel contentPane;
	public JTextField textFieldFecha;
	public JTextField textFieldValorDeclarado;
	public JTextField textFieldDireccionOrigen;
	public JTextField textFieldDireccionEntrega;
	public JTextField textFieldDireccionCodigoPostal;
	public JTextField textFieldPeso;
	public JTextField textFieldSeguro;
	public JTextField textFieldContenido;
	public JTextField textFieldImpuestoEnvio;
	public JTextField textFieldValorEnvio;
	public JTable table;
	public JTextField textFieldTotalEnvio;
	public JTextField textFieldValorTotalEnvios;
	public JButton btnAdicionarPaquete;
	public JButton btnRegresar;
	public JButton btnEliminar;
	public JButton btnActualizarPaquete;
	public JTextField textFieldTotaIImpuestos;
	public JLabel lblNewLabel_10_1_2;
	public JLabel lblNewLabel_10_1_3;
	public JTextField textFieldTotalSeguros;
	public JLabel lblNewLabel_10_1_4;
	public JTextField textFieldTotalVenta;
	public JButton btnCalcularEnvio;
	public JButton btnCalcularSeguro;
	public JButton btnCalcularImpuestos;
	public JButton btnCalcularTotal;
	public DefaultTableModel modelo;
	public JTextField textFieldDistancia;
	public JButton btnObtenerTotales;
	public JButton btnLimpiar;
	private JLabel lblNewLabel_11;
	
	public JButton btnRegistrarVenta;
	public JButton btnGenerarRecibo;
	public JButton btnValidarPagoTarjeta;
	public JButton btnValidarPagoEfectivo;




	/**
	 * Create the frame.
	 */
	public VentanaPaquetes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1329, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEMAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 1323, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Terminal de Venta - Informaci\u00F3n Paquetes y Metodos de Pago");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(0, 47, 1323, 25);
		lblNewLabel_1.setBackground(new Color( 94, 157, 200));
		lblNewLabel_1.setOpaque(true);
		contentPane.add(lblNewLabel_1);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setEditable(false);
		textFieldFecha.setBounds(176, 85, 210, 20);
		contentPane.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		textFieldValorDeclarado = new JTextField();
		textFieldValorDeclarado.setBounds(176, 116, 210, 20);
		contentPane.add(textFieldValorDeclarado);
		textFieldValorDeclarado.setColumns(10);
		
		textFieldDireccionOrigen = new JTextField();
		textFieldDireccionOrigen.setBounds(176, 147, 210, 20);
		contentPane.add(textFieldDireccionOrigen);
		textFieldDireccionOrigen.setColumns(10);
		
		textFieldDireccionEntrega = new JTextField();
		textFieldDireccionEntrega.setBounds(176, 178, 210, 20);
		contentPane.add(textFieldDireccionEntrega);
		textFieldDireccionEntrega.setColumns(10);
		
		textFieldDireccionCodigoPostal = new JTextField();
		textFieldDireccionCodigoPostal.setBounds(176, 209, 210, 20);
		contentPane.add(textFieldDireccionCodigoPostal);
		textFieldDireccionCodigoPostal.setColumns(10);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setBounds(176, 240, 210, 20);
		contentPane.add(textFieldPeso);
		textFieldPeso.setColumns(10);
		
		textFieldSeguro = new JTextField();
		textFieldSeguro.setEditable(false);
		textFieldSeguro.setBounds(176, 364, 210, 20);
		contentPane.add(textFieldSeguro);
		textFieldSeguro.setColumns(10);
		
		textFieldContenido = new JTextField();
		textFieldContenido.setBounds(176, 271, 210, 20);
		contentPane.add(textFieldContenido);
		textFieldContenido.setColumns(10);
		
		textFieldImpuestoEnvio = new JTextField();
		textFieldImpuestoEnvio.setEditable(false);
		textFieldImpuestoEnvio.setBounds(176, 397, 210, 20);
		contentPane.add(textFieldImpuestoEnvio);
		textFieldImpuestoEnvio.setColumns(10);
		
		textFieldValorEnvio = new JTextField();
		textFieldValorEnvio.setEditable(false);
		textFieldValorEnvio.setBounds(176, 333, 210, 20);
		contentPane.add(textFieldValorEnvio);
		textFieldValorEnvio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(30, 83, 126, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Valor Declarado:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(30, 114, 126, 20);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion Origen:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(30, 145, 126, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion Entrega:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(30, 176, 126, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contenido:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(30, 269, 126, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Peso:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(30, 238, 126, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Seguro:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(30, 364, 126, 20);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Codigo Postal:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(30, 207, 126, 20);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Impuestos Envio:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(30, 395, 126, 20);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Valor Envio:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(30, 331, 126, 20);
		contentPane.add(lblNewLabel_10);
		
		btnActualizarPaquete = new JButton("Actualizar");
		btnActualizarPaquete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizarPaquete.setBounds(145, 466, 103, 23);
		contentPane.add(btnActualizarPaquete);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(396, 466, 89, 23);
		contentPane.add(btnEliminar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegresar.setBounds(1160, 607, 133, 23);
		contentPane.add(btnRegresar);
		
		btnAdicionarPaquete = new JButton("Adicionar");
		btnAdicionarPaquete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionarPaquete.setBounds(30, 466, 95, 23);
		contentPane.add(btnAdicionarPaquete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(522, 83, 771, 404);
		contentPane.add(scrollPane);
		
		
		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable();
		
		String [] titulo = new String [] {"Fecha", "Valor Declarado", "Direccion Origen", "Direccion Entrega", "Codigo Postal", "Peso", "Contenido","Distancia", "Valor Envio", "Seguro", "Impuestos Envio", "Valor Total Envio"};
		modelo.setColumnIdentifiers(titulo);
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		textFieldTotalEnvio = new JTextField();
		textFieldTotalEnvio.setEditable(false);
		textFieldTotalEnvio.setColumns(10);
		textFieldTotalEnvio.setBounds(176, 428, 210, 20);
		contentPane.add(textFieldTotalEnvio);
		
		textFieldValorTotalEnvios = new JTextField();
		textFieldValorTotalEnvios.setEditable(false);
		textFieldValorTotalEnvios.setColumns(10);
		textFieldValorTotalEnvios.setBounds(153, 545, 95, 20);
		contentPane.add(textFieldValorTotalEnvios);
		
		JLabel lblNewLabel_10_1 = new JLabel("Valor Total Envio:");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10_1.setBounds(30, 426, 126, 20);
		contentPane.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("Total Envios:");
		lblNewLabel_10_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10_1_1.setBounds(30, 543, 89, 20);
		contentPane.add(lblNewLabel_10_1_1);
		
		textFieldTotaIImpuestos = new JTextField();
		textFieldTotaIImpuestos.setEditable(false);
		textFieldTotaIImpuestos.setColumns(10);
		textFieldTotaIImpuestos.setBounds(390, 574, 95, 20);
		contentPane.add(textFieldTotaIImpuestos);
		
		lblNewLabel_10_1_2 = new JLabel("Total Seguros:");
		lblNewLabel_10_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10_1_2.setBounds(269, 543, 98, 20);
		contentPane.add(lblNewLabel_10_1_2);
		
		lblNewLabel_10_1_3 = new JLabel("Total Impuestos:");
		lblNewLabel_10_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10_1_3.setBounds(269, 574, 111, 20);
		contentPane.add(lblNewLabel_10_1_3);
		
		textFieldTotalSeguros = new JTextField();
		textFieldTotalSeguros.setEditable(false);
		textFieldTotalSeguros.setColumns(10);
		textFieldTotalSeguros.setBounds(390, 545, 95, 20);
		contentPane.add(textFieldTotalSeguros);
		
		lblNewLabel_10_1_4 = new JLabel("Total Venta:");
		lblNewLabel_10_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10_1_4.setBounds(30, 574, 89, 20);
		contentPane.add(lblNewLabel_10_1_4);
		
		textFieldTotalVenta = new JTextField();
		textFieldTotalVenta.setEditable(false);
		textFieldTotalVenta.setColumns(10);
		textFieldTotalVenta.setBounds(153, 576, 95, 20);
		contentPane.add(textFieldTotalVenta);
		
		btnCalcularEnvio = new JButton("Calcular");
		btnCalcularEnvio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalcularEnvio.setBounds(396, 332, 89, 23);
		contentPane.add(btnCalcularEnvio);
		
		btnCalcularSeguro = new JButton("Calcular");
		btnCalcularSeguro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalcularSeguro.setBounds(396, 363, 89, 23);
		contentPane.add(btnCalcularSeguro);
		
		btnCalcularImpuestos = new JButton("Calcular");
		btnCalcularImpuestos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalcularImpuestos.setBounds(396, 396, 89, 23);
		contentPane.add(btnCalcularImpuestos);
		
		btnCalcularTotal = new JButton("Calcular");
		btnCalcularTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalcularTotal.setBounds(396, 427, 89, 23);
		contentPane.add(btnCalcularTotal);
		
		JLabel lblNewLabel_5_1 = new JLabel("Distancia:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_1.setBounds(30, 300, 126, 20);
		contentPane.add(lblNewLabel_5_1);
		
		textFieldDistancia = new JTextField();
		textFieldDistancia.setBounds(176, 302, 210, 20);
		contentPane.add(textFieldDistancia);
		textFieldDistancia.setColumns(10);
		
		btnObtenerTotales = new JButton("Totales");
		btnObtenerTotales.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnObtenerTotales.setBounds(27, 605, 98, 23);
		contentPane.add(btnObtenerTotales);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setBounds(275, 466, 95, 23);
		contentPane.add(btnLimpiar);
		
		JLabel lblNewLabel_16 = new JLabel("Forma de Pago");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_16.setBounds(555, 509, 160, 23);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_10_2 = new JLabel("");
		lblNewLabel_10_2.setIcon(new ImageIcon(VentanaPaquetes.class.getResource("/imagenes/imagenEfectivo.png")));
		lblNewLabel_10_2.setBounds(576, 545, 48, 48);
		contentPane.add(lblNewLabel_10_2);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setIcon(new ImageIcon(VentanaPaquetes.class.getResource("/imagenes/imagenTarjeta.png")));
		lblNewLabel_8_1.setBounds(576, 591, 48, 48);
		contentPane.add(lblNewLabel_8_1);
		
		btnValidarPagoTarjeta = new JButton("Validar Pago");
		btnValidarPagoTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnValidarPagoTarjeta.setBounds(631, 607, 156, 23);
		contentPane.add(btnValidarPagoTarjeta);
		
		JLabel lblNewLabel_6_1 = new JLabel("Finalizar Venta");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_1.setBounds(890, 509, 127, 23);
		contentPane.add(lblNewLabel_6_1);
		
		btnRegistrarVenta = new JButton("Registrar Venta");
		btnRegistrarVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarVenta.setBounds(973, 559, 133, 23);
		contentPane.add(btnRegistrarVenta);
		
		
		btnGenerarRecibo = new JButton("Generar Recibo");
		
		
		
		btnGenerarRecibo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGenerarRecibo.setBounds(973, 607, 133, 23);
		contentPane.add(btnGenerarRecibo);
		
		JLabel lblNewLabel_16_1 = new JLabel("Totalizar Valores");
		lblNewLabel_16_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_16_1.setBounds(10, 509, 160, 23);
		contentPane.add(lblNewLabel_16_1);
		
		JLabel lblSalir_1 = new JLabel("");
		lblSalir_1.setIcon(new ImageIcon(VentanaPaquetes.class.getResource("/imagenes/imagenRegresar.png")));
		lblSalir_1.setBounds(1185, 545, 64, 64);
		contentPane.add(lblSalir_1);
		
		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(VentanaPaquetes.class.getResource("/imagenes/ImagenGeneraRecibo.png")));
		lblNewLabel_11.setBounds(890, 559, 64, 64);
		contentPane.add(lblNewLabel_11);
		
		btnValidarPagoEfectivo = new JButton("Validar Pago");
		btnValidarPagoEfectivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnValidarPagoEfectivo.setBounds(634, 559, 153, 23);
		contentPane.add(btnValidarPagoEfectivo);
	}
}

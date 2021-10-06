package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaValidacionTarjeta extends JFrame {

	public JPanel contentPane;
	public JTextField textFieldNumeroTarjeta;
	public JTextField textFieldDigitosVerificacion;
	public JTextField textFieldFechaVencimiento;
	public JTextField textFieldMontoPagar;
	public JRadioButton rdbtnMasterCard;	
	public JRadioButton rdbtnVisa;
	public JRadioButton rdbtnAmericanExpress;
	public JRadioButton rdbtnCredito;
	public JRadioButton rdbtnDebito;
	public JTextField textFieldNombre;
	public JButton btnRegresar;
	public JButton btnValidarPagoTarjeta;

	/**
	 * Create the frame.
	 */
	public VentanaValidacionTarjeta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEMAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(0, 11, 434, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Validacion Tarjeta");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(new Color(94, 157, 200));
		lblNewLabel_1.setBounds(0, 47, 434, 25);
		contentPane.add(lblNewLabel_1);
		
		rdbtnMasterCard = new JRadioButton("MasterCard");
		rdbtnMasterCard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMasterCard.setBounds(32, 92, 98, 23);
		contentPane.add(rdbtnMasterCard);
		
		rdbtnVisa = new JRadioButton("Visa");
		rdbtnVisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnVisa.setBounds(173, 92, 60, 23);
		contentPane.add(rdbtnVisa);
		
		rdbtnAmericanExpress = new JRadioButton("American Express");
		rdbtnAmericanExpress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnAmericanExpress.setBounds(276, 92, 152, 23);
		contentPane.add(rdbtnAmericanExpress);
		
		JLabel lblNewLabel_2 = new JLabel("Numero Tarjeta:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(32, 234, 149, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Digitos de Verificaci\u00F3n:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(32, 262, 149, 17);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Fecha de Vencimiento:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(32, 290, 149, 17);
		contentPane.add(lblNewLabel_2_2);
		
		textFieldNumeroTarjeta = new JTextField();
		textFieldNumeroTarjeta.setBounds(216, 234, 194, 20);
		contentPane.add(textFieldNumeroTarjeta);
		textFieldNumeroTarjeta.setColumns(10);
		
		textFieldDigitosVerificacion = new JTextField();
		textFieldDigitosVerificacion.setBounds(216, 262, 194, 20);
		contentPane.add(textFieldDigitosVerificacion);
		textFieldDigitosVerificacion.setColumns(10);
		
		textFieldFechaVencimiento = new JTextField();
		textFieldFechaVencimiento.setBounds(216, 290, 194, 20);
		contentPane.add(textFieldFechaVencimiento);
		textFieldFechaVencimiento.setColumns(10);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Monto a Pagar:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(32, 318, 149, 17);
		contentPane.add(lblNewLabel_2_2_1);
		
		textFieldMontoPagar = new JTextField();
		textFieldMontoPagar.setBounds(216, 321, 194, 20);
		contentPane.add(textFieldMontoPagar);
		textFieldMontoPagar.setColumns(10);
		
		rdbtnCredito = new JRadioButton("Credito");
		rdbtnCredito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnCredito.setBounds(32, 164, 109, 23);
		contentPane.add(rdbtnCredito);
		
		rdbtnDebito = new JRadioButton("Debito");
		rdbtnDebito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDebito.setBounds(173, 164, 109, 23);
		contentPane.add(rdbtnDebito);
		
		JLabel lblNewLabel_2_3 = new JLabel("Tipo de Tarjeta:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(32, 140, 149, 17);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Nombre:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(32, 203, 149, 17);
		contentPane.add(lblNewLabel_2_4);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(216, 203, 194, 20);
		contentPane.add(textFieldNombre);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegresar.setBounds(243, 366, 130, 23);
		contentPane.add(btnRegresar);
		
		btnValidarPagoTarjeta = new JButton("Validar");
		btnValidarPagoTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnValidarPagoTarjeta.setBounds(76, 366, 130, 23);
		contentPane.add(btnValidarPagoTarjeta);
	}
}

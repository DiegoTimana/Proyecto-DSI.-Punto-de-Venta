package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaInformes extends JFrame {

	private JPanel contentPane;
	public JButton btnRegresar; 
	public JButton btnGrExcel;
	public JComboBox comboBox;


	/**
	 * Create the frame.
	 */
	public VentanaInformes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("DEMAS");
		lblTitulo.setBounds(5, 5, 578, 32);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 26));
		contentPane.add(lblTitulo);
		
		JLabel lblDescripcion = new JLabel("Por favor seleccione el tipo de informe que desea:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescripcion.setBounds(10, 86, 341, 32);
		contentPane.add(lblDescripcion);
		
		btnGrExcel = new JButton("Generar Reporte en Excel");
		btnGrExcel.setBackground(Color.GREEN);
		btnGrExcel.setForeground(Color.BLACK);
		btnGrExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGrExcel.setBounds(193, 160, 185, 46);
		contentPane.add(btnGrExcel);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegresar.setBounds(224, 252, 115, 23);
		contentPane.add(btnRegresar);
		
		JLabel lblNewLabel = new JLabel("Informes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 48, 583, 23);
		lblNewLabel.setBackground(new Color( 94, 157, 200));
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "De Usuarios", "De Env\u00EDos", "De Env\u00EDos por Sede", "De Ventas por Vendedor", "De Clientes"}));
		comboBox.setBounds(347, 93, 228, 23);
		contentPane.add(comboBox);
	}
}

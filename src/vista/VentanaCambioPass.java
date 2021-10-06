package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCambioPass extends JFrame {

	public JPanel contentPane;
	public JTextField textFieldUsuario;
	public JTextField textFieldPssActual;
	public JTextField textFieldPssNueva;
	public JTextField textFieldConfirmarPss;
	public JButton btnConfirmar;
	public JButton btnVolverAtrs;
	private JLabel lblNewLabel;
	private JLabel lblImagen;


	/**
	 * Create the frame.
	 */
	public VentanaCambioPass() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 504, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cambio de Contrase\u00F1a");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setBounds(0, 47, 498, 25);
		lblTitulo.setBackground(new Color( 94, 157, 200));
		lblTitulo.setOpaque(true);
		contentPane.add(lblTitulo);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(23, 101, 113, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblPssActual = new JLabel("Contrase\u00F1a Actual:");
		lblPssActual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPssActual.setBounds(23, 141, 142, 20);
		contentPane.add(lblPssActual);
		
		JLabel lblPssNueva = new JLabel("Nueva Contrase\u00F1a:");
		lblPssNueva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPssNueva.setBounds(23, 182, 130, 20);
		contentPane.add(lblPssNueva);
		
		JLabel lblConfirmarPss = new JLabel("Confirmar Contrase\u00F1a:");
		lblConfirmarPss.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmarPss.setBounds(23, 226, 152, 20);
		contentPane.add(lblConfirmarPss);
		
		
		//TEXT FIELDS el campo usuario no es editable, solo se muestra. las contraseñas hay que validarlas
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(191, 103, 184, 20);
		textFieldUsuario.setEditable(false);
		contentPane.add(textFieldUsuario);
		
		textFieldPssActual = new JTextField();
		textFieldPssActual.setColumns(10);
		textFieldPssActual.setBounds(191, 143, 184, 20);
		contentPane.add(textFieldPssActual);
		
		textFieldPssNueva = new JTextField();
		textFieldPssNueva.setColumns(10);
		textFieldPssNueva.setBounds(191, 184, 184, 20);
		contentPane.add(textFieldPssNueva);
		
		textFieldConfirmarPss = new JTextField();
		textFieldConfirmarPss.setColumns(10);
		textFieldConfirmarPss.setBounds(191, 228, 184, 20);
		contentPane.add(textFieldConfirmarPss);
		
		//BOTON CONFIRMAR 
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirmar.setBounds(120, 277, 120, 30);
		contentPane.add(btnConfirmar);
		
		//BOTON REGRESAR
		btnVolverAtrs = new JButton("Regresar");
		btnVolverAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVolverAtrs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolverAtrs.setBounds(277, 277, 120, 30);
		contentPane.add(btnVolverAtrs);
		
		lblNewLabel = new JLabel("DEMAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(0, 11, 498, 25);
		contentPane.add(lblNewLabel);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VentanaCambioPass.class.getResource("/imagenes/imagenContrase\u00F1a.png")));
		lblImagen.setBounds(408, 138, 64, 64);
		contentPane.add(lblImagen);
	}
}

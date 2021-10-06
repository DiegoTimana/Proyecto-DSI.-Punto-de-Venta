package vista;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class VentanaGerente extends JFrame {

	public JPanel contentPane;
	public JButton btnPerfil;
	public JButton btnGestionSedes;
	public JButton btnGestionUsuarios;
	public JButton btnPos;
	public JButton btnInformes;
	public JButton btnSalir;
	public JLabel lblimgperfil;
	public JLabel lblGestionSedes;
	public JLabel lblGestionUsuarios;
	public JLabel lblimgpos;
	public JLabel lblInformes;



	/**
	 * Create the frame.
	 */
	public VentanaGerente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 610, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("DEMAS");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 11, 594, 32);
		contentPane.add(lblTitulo);
		
		lblimgperfil = new JLabel("");
		lblimgperfil.setIcon(new ImageIcon(VentanaGerente.class.getResource("/imagenes/imagenPerfil.png")));
		lblimgperfil.setBounds(41, 120, 64, 64);
		contentPane.add(lblimgperfil);
		
		lblGestionSedes = new JLabel("");
		lblGestionSedes.setIcon(new ImageIcon(VentanaGerente.class.getResource("/imagenes/imagenSedes.png")));
		lblGestionSedes.setBounds(318, 120, 64, 64);
		contentPane.add(lblGestionSedes);
		
		lblGestionUsuarios = new JLabel("");
		lblGestionUsuarios.setIcon(new ImageIcon(VentanaGerente.class.getResource("/imagenes/imagenGestionUsuarios.png")));
		lblGestionUsuarios.setBounds(41, 219, 64, 64);
		contentPane.add(lblGestionUsuarios);
		
		lblimgpos = new JLabel("");
		lblimgpos.setIcon(new ImageIcon(VentanaGerente.class.getResource("/imagenes/imagenVentas.png")));
		lblimgpos.setBounds(318, 219, 64, 64);
		contentPane.add(lblimgpos);
		
		lblInformes = new JLabel("");
		lblInformes.setIcon(new ImageIcon(VentanaGerente.class.getResource("/imagenes/imagenReportes.png")));
		lblInformes.setBounds(41, 326, 64, 64);
		contentPane.add(lblInformes);
		
		////BOTON PERFIL
		btnPerfil = new JButton("Perfil");
		btnPerfil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPerfil.setBounds(136, 130, 141, 42);
		contentPane.add(btnPerfil);
		
		
		/// BOTON GESTION DE SEDES
		btnGestionSedes = new JButton("Gestion Sedes");
		btnGestionSedes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestionSedes.setBounds(421, 130, 141, 42);
		contentPane.add(btnGestionSedes);
		
		
		/// BOTON GESTION DE USUARIOS
		btnGestionUsuarios = new JButton("Gestion Usuarios");
		btnGestionUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestionUsuarios.setBounds(136, 230, 141, 42);
		contentPane.add(btnGestionUsuarios);
		
		
		/// BOTON POS
		btnPos = new JButton("POS");
		btnPos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPos.setBounds(421, 230, 141, 42);
		contentPane.add(btnPos);
		
		
		/// BOTON INFORMES
		btnInformes = new JButton("Informes");
		btnInformes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInformes.setBounds(136, 337, 141, 42);
		contentPane.add(btnInformes);
		
		JLabel lblSalir = new JLabel("");
		lblSalir.setIcon(new ImageIcon(VentanaGerente.class.getResource("/imagenes/imagenSalir.png")));
		lblSalir.setBounds(315, 326, 64, 64);
		contentPane.add(lblSalir);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(421, 337, 141, 42);
		contentPane.add(btnSalir);
		
		JLabel titulo2 = new JLabel("MENU");
		titulo2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		titulo2.setBounds(0, 54, 594, 25);
		titulo2.setBackground(new Color( 94, 157, 200));
		titulo2.setOpaque(true);
		contentPane.add(titulo2);
	}
}

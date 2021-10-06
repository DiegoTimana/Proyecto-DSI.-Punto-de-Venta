package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Sede;
import modelo.Usuario;
import vista.VentanaGerente;
import vista.VentanaGestionSedes;
import vista.VentanaGestionUsuarios;
import vista.VentanaInformes;
import vista.VentanaPerfil;
import vista.VentanaPos;

	public class ControladorMenuOpciones implements ActionListener{
	
	VentanaGerente ventanaGerente;
	VentanaPerfil ventanaPerfil;
	VentanaGestionSedes ventanaGestionSedes;
	VentanaGestionUsuarios ventanaGestionUsuarios;
	VentanaPos ventanaPos;
	VentanaInformes ventanaInformes;
	Usuario usuario;
	Sede sede;
	ControladorPerfil controladorPerfil;
	ControladorGestionSedes controladorGestionSedes;
	ControladorGestionUsuarios controladorGestionUsuarios;
	ControladorPOS controladorPOS;
	ControladorInformes controladorInformes;
	
	public ControladorMenuOpciones(VentanaGerente ventanaGerente, Usuario usuario) {
		this.ventanaGerente = ventanaGerente;
		this.usuario = usuario;
		this.ventanaGerente.btnPerfil.addActionListener(this);
		this.ventanaGerente.btnGestionSedes.addActionListener(this);
		this.ventanaGerente.btnGestionUsuarios.addActionListener(this);
		this.ventanaGerente.btnPos.addActionListener(this);
		this.ventanaGerente.btnInformes.addActionListener(this);
		this.ventanaGerente.btnSalir.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaGerente.btnPerfil) {
			ventanaGerente.setVisible(false);
			iniciarVentanaPerfil();
			controladorPerfil = new ControladorPerfil(ventanaPerfil, ventanaGerente, usuario);
			controladorPerfil.colocarDatos();
		}
		
		if(e.getSource() == ventanaGerente.btnGestionSedes) {
			ventanaGerente.setVisible(false);
			iniciarVentanaGestionSedes();
			controladorGestionSedes = new ControladorGestionSedes(ventanaGestionSedes, ventanaGerente);
			
			
		}
		
		if(e.getSource() == ventanaGerente.btnGestionUsuarios) {
			ventanaGerente.setVisible(false);
			iniciarVentanaGestionUsuarios();
			controladorGestionUsuarios = new ControladorGestionUsuarios(ventanaGestionUsuarios,ventanaGerente);
		}
		
		if(e.getSource() == ventanaGerente.btnPos) {
			ventanaGerente.setVisible(false);
			iniciarVentanaPos();
			controladorPOS = new ControladorPOS(ventanaPos, ventanaGerente, usuario);
			
		}
		
		if(e.getSource() == ventanaGerente.btnInformes) {
			ventanaGerente.setVisible(false);
			iniciarVentanaInformes();
			controladorInformes = new ControladorInformes(ventanaGerente, ventanaInformes);
		}
		
		if(e.getSource() == ventanaGerente.btnSalir) {
			ventanaGerente.setVisible(false);
			ventanaGerente.dispose();
		}
		
	}
	
	public void iniciarVentanaPerfil() {
		ventanaPerfil = new VentanaPerfil();
		ventanaPerfil.setTitle("Perfil");
		ventanaPerfil.setLocationRelativeTo(null);
		ventanaPerfil.setVisible(true);
	}
	
	
	public void iniciarVentanaGestionUsuarios() {
		ventanaGestionUsuarios = new VentanaGestionUsuarios();
		ventanaGestionUsuarios.setTitle("Gestion Usuarios");
		ventanaGestionUsuarios.setLocationRelativeTo(null);
		ventanaGestionUsuarios.setVisible(true);
	}
	
	public void iniciarVentanaGestionSedes() {
		ventanaGestionSedes = new VentanaGestionSedes();
		ventanaGestionSedes.setTitle("Gestion Sedes");
		ventanaGestionSedes.setLocationRelativeTo(null);
		ventanaGestionSedes.setVisible(true);
	}
	
	public void iniciarVentanaPos() {
		ventanaPos = new VentanaPos();
		ventanaPos.setTitle("Pos");
		ventanaPos.setLocationRelativeTo(null);
		ventanaPos.setVisible(true);
	}
	
	public void iniciarVentanaInformes() {
		ventanaInformes = new VentanaInformes();
		ventanaInformes.setTitle("Informes");
		ventanaInformes.setLocationRelativeTo(null);
		ventanaInformes.setVisible(true);
	}
	
	
	
	

}

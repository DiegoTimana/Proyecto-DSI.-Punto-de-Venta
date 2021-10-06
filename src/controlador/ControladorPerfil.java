package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Usuario;
import vista.VentanaCambioPass;
import vista.VentanaGerente;
import vista.VentanaPerfil;

public class ControladorPerfil implements ActionListener {
	
	VentanaPerfil ventanaPerfil;
	Usuario usuario;
	ControladorCambioPassword controladorCambioPassword;
	VentanaCambioPass ventanaCambioPass;
	VentanaGerente ventanaGerente;


	public ControladorPerfil(VentanaPerfil ventanaPerfil, VentanaGerente ventanaGerente , Usuario usuario) {
		this.ventanaPerfil = ventanaPerfil;
		this.ventanaPerfil.btnActualizar.addActionListener(this);
		this.ventanaPerfil.btnVolverAtrs.addActionListener(this);
		this.ventanaGerente= ventanaGerente;
		this.usuario = usuario;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaPerfil.btnVolverAtrs) {
			ventanaPerfil.dispose();
			ventanaGerente.setVisible(true);
			
		}
		
		
		if(e.getSource() == ventanaPerfil.btnActualizar) {
			iniciarVentanaCambio();
			controladorCambioPassword = new ControladorCambioPassword(ventanaCambioPass,usuario);
			controladorCambioPassword.colocarDatos();
		}
		
	}
	
	public void colocarDatos() {
		ventanaPerfil.textFieldNombre.setText(usuario.getNombre()+" "+usuario.getApellidos());
		ventanaPerfil.textFieldCedula.setText(Integer.toString(usuario.getId()));
		ventanaPerfil.textFieldCargo.setText(usuario.getCargo());
		ventanaPerfil.textFieldSede.setText(Integer.toString(usuario.getId_sede()));
		ventanaPerfil.passwordField.setText(usuario.getPassword());
	}
	
	
	public void iniciarVentanaCambio() {
		ventanaCambioPass = new VentanaCambioPass();
		ventanaCambioPass.setTitle("Perfil");
		ventanaCambioPass.setLocationRelativeTo(null);
		ventanaCambioPass.setVisible(true);
	}
	

}

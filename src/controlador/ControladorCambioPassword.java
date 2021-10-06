package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.ConsultaUsuario;
import modelo.Usuario;
import vista.VentanaCambioPass;

public class ControladorCambioPassword implements ActionListener{
	
	VentanaCambioPass ventanaCambioPass;
	ConsultaUsuario consultaUsuario;
	Usuario usuario;
	
	public ControladorCambioPassword(VentanaCambioPass ventanaCambioPass, Usuario usuario) {
		this.ventanaCambioPass = ventanaCambioPass;
		this.ventanaCambioPass.btnConfirmar.addActionListener(this);
		this.ventanaCambioPass.btnVolverAtrs.addActionListener(this);
		this.usuario = usuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		 if(e.getSource() == ventanaCambioPass.btnConfirmar){
			 
			 boolean contraseñaActualCorrecta = ventanaCambioPass.textFieldPssActual.getText().equals(usuario.getPassword());
			 boolean casillasNuevaContraseñaIguales = ventanaCambioPass.textFieldPssNueva.getText().equals(ventanaCambioPass.textFieldConfirmarPss.getText());
			 
			 
			 if( contraseñaActualCorrecta && casillasNuevaContraseñaIguales) {
				 
				 //llamar metodo para cambiar password
				 consultaUsuario = new ConsultaUsuario();
				 String nuevaContraseña = ventanaCambioPass.textFieldPssNueva.getText();
				 boolean cambio = consultaUsuario.modificarContraseña(nuevaContraseña, usuario.getId());
				 limpiarDatos();
				 if(cambio) {
					 //actualizo la contraseña en el modelo usuario 
					 usuario.setPassword(nuevaContraseña);
					 
				 }
			 }
			 
			 
			 if(contraseñaActualCorrecta == false) {
				 JOptionPane.showMessageDialog(null, "Contraseña actual erronea");
				 limpiarDatos();
			 }
			 
			 
			 if(casillasNuevaContraseñaIguales == false) {
				 JOptionPane.showMessageDialog(null, "Los campos de contraseña nueva no coinciden");
				 limpiarDatos();
			 }
					 
			 
		 }
		 
		 
		 if(e.getSource() == ventanaCambioPass.btnVolverAtrs){
			 ventanaCambioPass.dispose();
		 }
		
	}
	
	void colocarDatos() {
		ventanaCambioPass.textFieldUsuario.setText(Integer.toString(usuario.getId()));
	}
	
	void limpiarDatos() {
		ventanaCambioPass.textFieldPssActual.setText(null);
		ventanaCambioPass.textFieldPssNueva.setText(null);
		ventanaCambioPass.textFieldConfirmarPss.setText(null);
	}

}

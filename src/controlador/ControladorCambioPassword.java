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
			 
			 boolean contrase�aActualCorrecta = ventanaCambioPass.textFieldPssActual.getText().equals(usuario.getPassword());
			 boolean casillasNuevaContrase�aIguales = ventanaCambioPass.textFieldPssNueva.getText().equals(ventanaCambioPass.textFieldConfirmarPss.getText());
			 
			 
			 if( contrase�aActualCorrecta && casillasNuevaContrase�aIguales) {
				 
				 //llamar metodo para cambiar password
				 consultaUsuario = new ConsultaUsuario();
				 String nuevaContrase�a = ventanaCambioPass.textFieldPssNueva.getText();
				 boolean cambio = consultaUsuario.modificarContrase�a(nuevaContrase�a, usuario.getId());
				 limpiarDatos();
				 if(cambio) {
					 //actualizo la contrase�a en el modelo usuario 
					 usuario.setPassword(nuevaContrase�a);
					 
				 }
			 }
			 
			 
			 if(contrase�aActualCorrecta == false) {
				 JOptionPane.showMessageDialog(null, "Contrase�a actual erronea");
				 limpiarDatos();
			 }
			 
			 
			 if(casillasNuevaContrase�aIguales == false) {
				 JOptionPane.showMessageDialog(null, "Los campos de contrase�a nueva no coinciden");
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

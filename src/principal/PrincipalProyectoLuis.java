package principal;

import controlador.ControladorLogin;

import vista.VentanaLogin;

public class PrincipalProyectoLuis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		VentanaLogin ventana = new VentanaLogin();
		ControladorLogin ctrl = new ControladorLogin(ventana);
		ctrl.iniciar();
		
		/*
		Sede sede = new Sede();
		VentanaGestionSedes ventana = new VentanaGestionSedes();
		ventana.setTitle("Gestion Sedes");
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		ControladorGestionSedes ctrls = new ControladorGestionSedes(ventana,sede);
		*/
		
		
	}

}

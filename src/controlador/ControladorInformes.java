package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Reporte;
import vista.VentanaGerente;
import vista.VentanaInformes;

public class ControladorInformes implements ActionListener{
	
	VentanaGerente ventanaGerente;
	VentanaInformes ventanaInformes;
	Reporte reporte;
	int index;
	
	public ControladorInformes(VentanaGerente ventanaGerente, VentanaInformes ventanaInformes) {
		this.ventanaGerente=ventanaGerente;
		this.ventanaInformes=ventanaInformes;
		this.ventanaInformes.btnRegresar.addActionListener(this);
		this.ventanaInformes.btnGrExcel.addActionListener(this);
		this.ventanaInformes.comboBox.addActionListener(this);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaInformes.btnRegresar) {
			ventanaGerente.setVisible(true);
			ventanaInformes.dispose();
		}
		
		
		if(e.getSource() == ventanaInformes.comboBox) {			
			index = ventanaInformes.comboBox.getSelectedIndex();
		}
		
		
		if(e.getSource() == ventanaInformes.btnGrExcel) {
			reporte = new Reporte();
			switch(index) {
			case 0:
				JOptionPane.showMessageDialog(null, "Por favor seleccione un tipo de reporte");
			case 1:
				reporte.reporteUsuarios();
			case 2:
				reporte.reporteEnvios();
			case 3:
				reporte.reporteEnviosporSedes();
			case 4:
				reporte.reporteVentasporVendedor();
			case 5: 
				reporte.reporteClientes();
			}
		}
	
		
		
	}

	

}

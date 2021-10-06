package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import controlador.ControladorMenuOpciones;
import controlador.ControladorPaquetes;
import vista.VentanaGerente;
import vista.VentanaPaquetes;

public class ConsultaVenta extends Conexion {
	
	
	public boolean registrarVenta (VentanaPaquetes ventana, Usuario usuario, Cliente cliente){
		
	
			double totalEnvios = Double.parseDouble(ventana.textFieldValorTotalEnvios.getText());
			double totalSeguros = Double.parseDouble(ventana.textFieldTotalSeguros.getText());
			double totalImpuestos = Double.parseDouble(ventana.textFieldTotaIImpuestos.getText());
			int idVendedor = usuario.getId();
			int idCliente = cliente.getIdCliente();
			int idSede = usuario.getId_sede();
			Date fecha = Date.valueOf(ventana.textFieldFecha.getText());
			double totalVenta = Double.parseDouble(ventana.textFieldTotalVenta.getText());
			
			
			Connection con = getConnection();
	        String sql = "INSERT INTO ventas ( total_impuestos, total_seguro, total_envios, vendedor, cliente, sede, fecha_venta, total_venta) "
	        		+ "values ('"+totalImpuestos+"', '"+totalSeguros+"','"+totalEnvios+"','"+idVendedor+"','"+idCliente+"','"+idSede+"','"+fecha+"','"+totalVenta+"')";
	        
	        try{
	           
	        	 Statement st = con.createStatement();
	             int ejecucion = st.executeUpdate(sql);
	             
	            if(ejecucion != 0) {
	         	   JOptionPane.showMessageDialog(null, "Registro venta exitoso");
	         	   return true;
	            }else {
	         	   JOptionPane.showMessageDialog(null, "Registro venta fallido");
	         	   return false;
	            }
	           
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	            return false;
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
        
    }
	
	
	public void registrarPaquetes (Usuario usuario, Cliente cliente, Paquete paquete, VentanaPaquetes ventanaPaquetes, ControladorPaquetes controladorPaquetes){
		
		int filas = ventanaPaquetes.table.getModel().getRowCount();
		
		System.out.println("este es el numero de filas" + filas);

		int idVenta = consecutivoVentas(cliente, usuario, ventanaPaquetes);
		
		System.out.println("este es el id de la venta" + idVenta);
		
		for(int i = 0; i < filas; i++) {
			
			controladorPaquetes.ponerValoresEnModeloPaquetes(i);
			
			System.out.println("Entre al bucle, este es el ciclo numero" + i);
			
			Date fecha = paquete.getFecha();
			double valorDeclarado = paquete.getValorDeclarado();
			String direccionOrigen = paquete.getDireccionOrigen();
			String direccionEntrega = paquete.getDireccionEntrega();
			String codigoPostal = paquete.getCodigoPostal();
			double peso = paquete.getPeso();
			String contenido = paquete.getContenido();
			double distancia = paquete.getDistancia();
			double valorEnvio = paquete.getValorEnvio();
			double Seguro = paquete.getSeguro();
			double impuestos = paquete.getImpuestos();
			double valorTotalEnvio = paquete.getValorTotalEnvio();
			int idCliente = paquete.getIdCliente();
			int idSede = paquete.getIdSede();
			
			
			Connection con = getConnection();
			
	        String sql = "INSERT INTO paquetes (fecha, valor_declarado, direccion_origen, direccion_entrega, codigo_postal, peso, contenido, valor_envio, seguro,"
	        		+ "impuestos, total_envio, venta, cliente, sede, distancia) "
	        		+ "values ('"+fecha+"', '"+valorDeclarado+"','"+direccionOrigen+"','"+direccionEntrega+"','"+codigoPostal+"','"+peso+"','"+contenido+"','"
	        		+valorEnvio+"', '"+Seguro+"', '"+impuestos+"', '"+valorTotalEnvio+"', '"+idVenta+"', '"+idCliente+"', '"+idSede+"', '"+distancia+"')";
	        
	        try{
	           
	        	 Statement st = con.createStatement();
	             int ejecucion = st.executeUpdate(sql);
	             
	            if(ejecucion != 0) {
	         	   JOptionPane.showMessageDialog(null, "Registro venta exitoso");
	     
	            }else {
	         	   JOptionPane.showMessageDialog(null, "Registro venta fallido");
	        
	            }
	           
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	    
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
    
		}
		
	}
	
	
	public int consecutivoVentas(Cliente cliente, Usuario usuario, VentanaPaquetes ventana ) {
		int consecutivo=0;
		
		
		Connection con = getConnection();
		int idVendedor = usuario.getId();
		int idCliente = cliente.getIdCliente();
		Date fecha = Date.valueOf(ventana.textFieldFecha.getText());
		double totalVenta = Double.parseDouble(ventana.textFieldTotalVenta.getText());
	
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select id_venta from ventas where vendedor='"+idVendedor+"' and cliente='"+idCliente+"' and fecha_venta='"+fecha+"' and total_venta='"+totalVenta+"'";
        
        try{
           
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           
           if(rs.next()){
        	   
        	   consecutivo = rs.getInt("id_venta");
        	   System.out.println(consecutivo);
               return consecutivo;
           }else {
        	   JOptionPane.showMessageDialog(null, "error encontrando id venta");
        	   return consecutivo;
           }
           
           
        }catch(SQLException e) {
            System.err.println(e);
            return consecutivo;
            
        } finally{
            try{
                con.close();
            }catch (SQLException e){
                System.err.println(e);
            }
        }
		
	}
	
	
	public int consecutivoVentasEnsayo() {

		int consecutivo=0;
		
		
		Connection con = getConnection();
		int idVendedor = 11111;
		int idCliente = 112233;
		Date fecha = Date.valueOf("2021-05-10");

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select id_venta from ventas where vendedor='"+idVendedor+"' and cliente='"+idCliente+"' and fecha_venta='"+fecha+"' ";
        
        try{
           
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           
           if(rs.next()){
        	   
        	   consecutivo = rs.getInt("id_venta");
        	   System.out.println(consecutivo);
               return consecutivo;
           }else {
        	   JOptionPane.showMessageDialog(null, "error encontrando id venta");
        	   return consecutivo;
           }
           
           
        }catch(SQLException e) {
            System.err.println(e);
            return consecutivo;
            
        } finally{
            try{
                con.close();
            }catch (SQLException e){
                System.err.println(e);
            }
        }

	}
}

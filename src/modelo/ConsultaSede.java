package modelo;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConsultaSede extends Conexion {
	
	public boolean registrar(Sede sede){
        
        String nombre = sede.getNombreSede();
        String direccion = sede.getDireccionSede();
        String estado = sede.getEstadoSede();
        String telefono = sede.getTelefonoSede();
        
        Connection con = getConnection();
        String sql = "INSERT INTO sedes (nombre_sede, direccion_sede, estado_sede, telefono_sede) values ('"+nombre+"', '"+direccion+"','"+estado+"','"+telefono+"')";
        
        try{
    
            Statement st = con.createStatement();
            int ejecucion = st.executeUpdate(sql);
            
           if(ejecucion != 0) {
        	   JOptionPane.showMessageDialog(null, "Registro exitoso");
        	   return true;
           }else {
        	   JOptionPane.showMessageDialog(null, "Registro fallido");
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
    
    
    public boolean modificar(Sede sede){
    	
    	int idSede = sede.getIdSede();
    	String nombre = sede.getNombreSede();
        String direccion = sede.getDireccionSede();
        String estado = sede.getEstadoSede();
        String telefono = sede.getTelefonoSede();
        Connection con = getConnection();
 
        String sql = "UPDATE sedes SET nombre_sede='"+nombre+"', direccion_sede='"+direccion+"', telefono_sede='"+telefono+"', estado_sede='"+estado+"' WHERE id_sede='"+idSede+"'";
        
        try{
        	
        	Statement st = con.createStatement();
            int ejecucion = st.executeUpdate(sql);
            
            if(ejecucion != 0) {
         	   JOptionPane.showMessageDialog(null, "Registro exitoso");
         	   return true;
            }else {
         	   JOptionPane.showMessageDialog(null, "Registro fallido");
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
    
    
    public boolean eliminar(Sede sede, int id){
        
        Connection con = getConnection();
        int idSede = id;
        String opcion ="inactivo";
        String sql = "UPDATE sedes SET estado_sede='"+opcion+"' WHERE id_sede='"+idSede+"'";
        
        try{
        	Statement st = con.createStatement();
            int ejecucion = st.executeUpdate(sql);
            if(ejecucion != 0) {
         	   JOptionPane.showMessageDialog(null, "Registro eliminado");
         	   return true;
            }else {
         	   JOptionPane.showMessageDialog(null, "Error, no se elimino el registro");
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
    
    
    public boolean buscar (Sede sede, int id){
        
    	int idSede = id;
        Connection con = getConnection();
        String sql = "SELECT * FROM sedes WHERE id_sede='"+idSede+"' ";
        
        try{
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
           
           if(rs.next()){
        	   sede.setIdSede(id);
               sede.setNombreSede(rs.getString("nombre_sede"));
               sede.setDireccionSede(rs.getString("direccion_sede"));
               sede.setTelefonoSede(rs.getString("telefono_sede"));
               sede.setEstadoSede(rs.getString("estado_sede"));
               return true;
           }
           
           return false;
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
    
    
    
    public boolean confirmarExistenciaSede(int id){
        
    	int idUsu = id;
        Connection con = getConnection();
        String sql = "SELECT * FROM sedes WHERE id_sede='"+idUsu+"' ";
        
        try{
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			System.out.println(rs+"este es el resultado de rs");
           
           if(rs.next()){
        	   System.out.println("si existe la sede");
               return true;
           }else {
        	   System.out.println("no existe la sede");
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
    
    

}

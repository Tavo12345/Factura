/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author usuario
 */
public class ConeccionCliente {
    Connection coneccion = null;
    
    public ConeccionCliente(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver"); 
            String usuario = "root";
            String paswor = "";            
            coneccion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/facturas", usuario, paswor);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConeccionCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Close(){
        try {
            coneccion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Operaciones sobre Clientes
    
    public void Insertar(int codCliente,String nomCliente, String dirCliente, int telCliente, String emailCliente){
        PreparedStatement insertar;  
        String sql;
        int pos;
        sql = "INSERT INTO cliente (codCliente, nomCliente, dirCliente, telCliente, emailCliente) " +
                "VALUES (?,?,?,?,?)";                                 
        try {            
            insertar = coneccion.prepareStatement(sql);
            insertar.setInt(1, codCliente);
            insertar.setString(2, nomCliente);
            insertar.setString(3, dirCliente);
            insertar.setInt(4, telCliente);
            insertar.setString(5, emailCliente);
            pos = insertar.executeUpdate();
            insertar.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Modificar(int codCliente, String nomCliente, String dirCliente, int telCliente, String emailCliente){
        PreparedStatement modificar;  
        String sql;
        int pos;
        sql = "UPDATE cliente SET nomCliente = ?, dirCliente = ?, telCliente = ?, emailCliente = ? WHERE codCliente = ?";
        try {            
            modificar = coneccion.prepareStatement(sql);            
            modificar.setString(1, nomCliente);
            modificar.setString(2, dirCliente);
            modificar.setInt(3, telCliente);
            modificar.setString(4, emailCliente);
            modificar.setInt(5, codCliente);
            pos = modificar.executeUpdate();
            modificar.close();           
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public model.Cliente Consulta(int codCliente){
        model.Cliente cliente = new model.Cliente(0, null, null, 0, null);
        PreparedStatement consulta;
        try {
            consulta = coneccion.prepareStatement("SELECT * FROM cliente WHERE codCliente  = '" + codCliente + "'");
            ResultSet readLine = consulta.executeQuery();
            while(readLine.next()){
                cliente.setCodCliente(readLine.getInt("codCliente"));
                cliente.setNomCliente(readLine.getString("nomCliente"));
                cliente.setDirCliente(readLine.getString("dirCliente"));
                cliente.setTelCliente(readLine.getInt("telCliente"));
                cliente.setEmailCliente(readLine.getString("emailCliente")); 
            }
            consulta.close();
            readLine.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
    
    public model.Cliente Consulta(String nomCliente){
        model.Cliente cliente = new model.Cliente(0, null, null, 0, null);
        PreparedStatement consulta;
        try {
            consulta = coneccion.prepareStatement("SELECT * FROM cliente WHERE nomCliente  = '" + nomCliente + "'");
            ResultSet readLine = consulta.executeQuery();
            while(readLine.next()){
                cliente.setCodCliente(readLine.getInt("codCliente"));
                cliente.setNomCliente(readLine.getString("nomCliente"));
                cliente.setDirCliente(readLine.getString("dirCliente"));
                cliente.setTelCliente(readLine.getInt("telCliente"));
                cliente.setEmailCliente(readLine.getString("emailCliente")); 
            }
            consulta.close();
            readLine.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
    
}

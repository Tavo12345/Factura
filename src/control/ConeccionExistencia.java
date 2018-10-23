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
public class ConeccionExistencia {
    Connection coneccion = null;
    
    public ConeccionExistencia(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            String usuario = "root";
            String paswor = "";            
            coneccion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/facturas", usuario, paswor);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConeccionExistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionExistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Close(){
        try {
            coneccion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionExistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Operaciones sobre Existencias
    
    public void Insertar(int codItem,int cantItem, int costUItem){
        PreparedStatement insertar;  
        String sql;
        int pos;
        sql = "INSERT INTO existencia (codItem, cantItem, costUItem) " +
                "VALUES (?,?,?)";                                 
        try {            
            insertar = coneccion.prepareStatement(sql);
            insertar.setInt(1, codItem);
            insertar.setInt(2, cantItem);
            insertar.setInt(3, costUItem);
            pos = insertar.executeUpdate();
            insertar.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionExistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Modificar(int codItem,int cantItem, int costUItem){
        PreparedStatement modificar;  
        String sql;
        int pos;
        sql = "UPDATE existencia SET cantItem = ?, costUItem = ? WHERE codItem = ?";
        try {            
            modificar = coneccion.prepareStatement(sql);            
            modificar.setInt(1, cantItem);            
            modificar.setInt(2, costUItem);
            modificar.setInt(3, codItem);
            pos = modificar.executeUpdate();
            modificar.close();           
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionExistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public model.Existencia Consulta(int codItem){
        model.Existencia existencia = new model.Existencia(0, 0, 0);
        PreparedStatement consulta;
        try {
            consulta = coneccion.prepareStatement("SELECT * FROM existencia WHERE codItem  = '" + codItem + "'");
            ResultSet readLine = consulta.executeQuery();
            while(readLine.next()){
                existencia.setCodItem(readLine.getInt("codItem"));
                existencia.setCantItem(readLine.getInt("cantItem"));
                existencia.setCostUItem(readLine.getInt("costUItem"));
            }
            consulta.close();
            readLine.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionExistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existencia;
    }    
    
}

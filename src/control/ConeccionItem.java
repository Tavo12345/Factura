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
public class ConeccionItem {
    Connection coneccion = null;
    
    public ConeccionItem(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            String usuario = "root";
            String paswor = "";            
            coneccion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/facturas", usuario, paswor);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConeccionItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Close(){
        try {
            coneccion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Operaciones sobre Items
    
    public void Insertar(int codItem,String nomItem, String tipoItem, int valorUItem){
        PreparedStatement insertar;  
        String sql;
        int pos;
        sql = "INSERT INTO item (codItem, nomItem, tipoItem, valorUItem) " +
                "VALUES (?,?,?,?)";                                 
        try {            
            insertar = coneccion.prepareStatement(sql);
            insertar.setInt(1, codItem);
            insertar.setString(2, nomItem);
            insertar.setString(3, tipoItem);
            insertar.setInt(4, valorUItem);
            pos = insertar.executeUpdate();
            insertar.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Modificar(int codItem,String nomItem, int valorUItem){
        PreparedStatement modificar;  
        String sql;
        int pos;
        sql = "UPDATE item SET nomItem = ?, valorUItem = ? WHERE codItem = ?";
        try {            
            modificar = coneccion.prepareStatement(sql);            
            modificar.setString(1, nomItem);            
            modificar.setInt(2, valorUItem);
            modificar.setInt(3, codItem);
            pos = modificar.executeUpdate();
            modificar.close();           
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public model.Item Consulta(int codItem){
        model.Item item = new model.Item(0, null, null, 0);
        PreparedStatement consulta;
        try {
            consulta = coneccion.prepareStatement("SELECT * FROM item WHERE codItem  = '" + codItem + "'");
            ResultSet readLine = consulta.executeQuery();
            while(readLine.next()){
                item.setCodItem(readLine.getInt("codItem"));
                item.setNomItem(readLine.getString("nomItem"));
                item.setTipoItem(readLine.getString("tipoItem"));
                item.setValorUItem(readLine.getInt("valorUItem"));
            }
            consulta.close();
            readLine.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }
    
    public model.Item Consulta(String nomItem){
        model.Item item = new model.Item(0, null, null, 0);
        PreparedStatement consulta;
        try {
            consulta = coneccion.prepareStatement("SELECT * FROM item WHERE nomItem  = '" + nomItem + "'");
            ResultSet readLine = consulta.executeQuery();
            while(readLine.next()){
                item.setCodItem(readLine.getInt("codItem"));
                item.setNomItem(readLine.getString("nomItem"));
                item.setTipoItem(readLine.getString("tipoItem"));
                item.setValorUItem(readLine.getInt("valorUItem"));
            }
            consulta.close();
            readLine.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }
    
}

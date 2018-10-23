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
public class ConeccionEntrada {
    Connection coneccion = null;
    
    public ConeccionEntrada(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            String usuario = "root";
            String paswor = "";            
            coneccion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/facturas", usuario, paswor);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConeccionEntrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Close(){
        try {
            coneccion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Operaciones sobre Entradas
    
    public void Insertar(int codItem, int cantItemEnt, int costUItemEnt, String fechEnt){
        PreparedStatement insertar;  
        String sql;
        int pos;
        sql = "INSERT INTO entrada (codItem, cantItemEnt, costUItemEnt, fechEnt) " +
                "VALUES (?,?,?,?)";                                 
        try {            
            insertar = coneccion.prepareStatement(sql);
            insertar.setInt(1, codItem);
            insertar.setInt(2, cantItemEnt);
            insertar.setInt(3, costUItemEnt);
            insertar.setString(4, fechEnt);
            pos = insertar.executeUpdate();
            insertar.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
    public model.Entrada Consulta(int codEnt){
        model.Entrada entrada = new model.Entrada(0, 0, 0, 0, null);
        PreparedStatement consulta;
        try {
            consulta = coneccion.prepareStatement("SELECT * FROM entrada WHERE codEnt  = '" + codEnt + "'");
            ResultSet readLine = consulta.executeQuery();
            while(readLine.next()){
                entrada.setCodEnt(readLine.getInt("codEnt"));
                entrada.setCodItem(readLine.getInt("codItem"));
                entrada.setCantItemEnt(readLine.getInt("cantItemEnt"));
                entrada.setCostUItemEnt(readLine.getInt("costUItemEnt"));
                entrada.setFechEnt(readLine.getString("fechEnt"));
            }
            consulta.close();
            readLine.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entrada;
    }
    
}

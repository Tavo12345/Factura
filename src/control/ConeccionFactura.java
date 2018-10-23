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
public class ConeccionFactura {
    Connection coneccion = null;
    
    public ConeccionFactura(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            String usuario = "root";
            String paswor = "";            
            coneccion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/facturas", usuario, paswor);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConeccionFactura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Close(){
        try {
            coneccion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Operaciones sobre Facturas
    
    public void Insertar(int codFact, int codCliente, int codDetalle, String fechFact){
        PreparedStatement insertar;  
        String sql;
        int pos;
        sql = "INSERT INTO factura (codFact,codCliente, codDetalle, fechFact) " +
                "VALUES (?,?,?,?)";                                 
        try {            
            insertar = coneccion.prepareStatement(sql);
            insertar.setInt(1, codFact);
            insertar.setInt(2, codCliente);
            insertar.setInt(3, codDetalle);
            insertar.setString(4, fechFact);
            pos = insertar.executeUpdate();
            insertar.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
    public model.Factura Consulta(int codFact){
        model.Factura factura = new model.Factura(0, 0, 0, null);
        PreparedStatement consulta;
        try {
            consulta = coneccion.prepareStatement("SELECT * FROM factura WHERE codFact  = '" + codFact + "'");
            ResultSet readLine = consulta.executeQuery();
            while(readLine.next()){
                factura.setCodFact(readLine.getInt("codFact"));
                factura.setCodCliente(readLine.getInt("codCliente"));
                factura.setCodDetalle(readLine.getInt("codDetalle"));
                factura.setFechFact(readLine.getString("fechFact"));
            }
            consulta.close();
            readLine.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return factura;
    }
    
    public model.Factura Consulta(){
        model.Factura factura = new model.Factura(0, 0, 0, null);
        PreparedStatement consulta;
        try {
            consulta = coneccion.prepareStatement("SELECT * FROM factura WHERE 1 ORDER BY  `codEnt` DESC");
            ResultSet readLine = consulta.executeQuery();
            while(readLine.next()){
                factura.setCodFact(readLine.getInt("codFact"));
                factura.setCodCliente(readLine.getInt("codCliente"));
                factura.setCodDetalle(readLine.getInt("codDetalle"));
                factura.setFechFact(readLine.getString("fechFact"));
            }
            consulta.close();
            readLine.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return factura;
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ConeccionDetalle {
    Connection coneccion = null;
    
    
    public ConeccionDetalle(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            String usuario = "root";
            String paswor = "";            
            coneccion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/facturas", usuario, paswor);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConeccionDetalle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Close(){
        try {
            coneccion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Operaciones sobre Detalles
    
    public void Insertar(int codDetalle, int codItem, int cantItemFact, int costUItemFact, int valorUVentItem){
        PreparedStatement insertar;  
        String sql;
        int pos;
        sql = "INSERT INTO detalle (codDetalle, codItem, cantItemFact, costUItemFact, valorUVentItem) " +
                "VALUES (?,?,?,?,?)";                                 
        try {            
            insertar = coneccion.prepareStatement(sql);
            insertar.setInt(1, codDetalle);
            insertar.setInt(2, codItem);
            insertar.setInt(3, cantItemFact);
            insertar.setInt(4, costUItemFact);
            insertar.setInt(5, valorUVentItem);
            pos = insertar.executeUpdate();
            insertar.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<model.Detalle> Consulta(int codDetalle){
        ArrayList<model.Detalle> listaDetalle = new ArrayList<model.Detalle>();
        model.Detalle detalle = new model.Detalle(0, 0, 0, 0, 0);
        PreparedStatement consulta;
        try {
            consulta = coneccion.prepareStatement("SELECT * FROM detalle WHERE codDetalle  = '" + codDetalle + "'");
            ResultSet readLine = consulta.executeQuery();
            while(readLine.next()){
                detalle.setCodDetalle(readLine.getInt("codDetalle"));
                detalle.setCodItem(readLine.getInt("codItem"));
                detalle.setCantItemFact(readLine.getInt("cantItemFact"));
                detalle.setCostUItemFact(readLine.getInt("costUItemFact"));
                detalle.setValorUVentItem(readLine.getInt("valorUVentItem"));
                listaDetalle.add(detalle);
            }
            consulta.close();
            readLine.close();            
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return listaDetalle;
    }
    
    
}

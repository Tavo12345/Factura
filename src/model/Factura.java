/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author usuario
 */
public class Factura {
    private int     codFact;
    private int     codCliente;
    private int     codDetalle;
    private String  fechFact;

    public Factura(int codFact, int codCliente, int codDetalle, String fechFact) {
        this.codFact = codFact;
        this.codCliente = codCliente;
        this.codDetalle = codDetalle;
        this.fechFact = fechFact;
    }

    public int getCodFact() {
        return codFact;
    }

    public void setCodFact(int codFact) {
        this.codFact = codFact;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(int codDetalle) {
        this.codDetalle = codDetalle;
    }

    public String getFechFact() {
        return fechFact;
    }

    public void setFechFact(String fechFact) {
        this.fechFact = fechFact;
    }
        
}

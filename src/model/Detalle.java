/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author usuario
 */
public class Detalle {
    private int codDetalle;
    private int codItem;
    private int cantItemFact;
    private int costUItemFact;
    private int valorUVentItem;

    public Detalle(int codDetalle, int codItem, int cantItemFact, int costUItemFact, int valorUVentItem) {
        this.codDetalle = codDetalle;
        this.codItem = codItem;
        this.cantItemFact = cantItemFact;
        this.costUItemFact = costUItemFact;
        this.valorUVentItem = valorUVentItem;
    }

    public int getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(int codDetalle) {
        this.codDetalle = codDetalle;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public int getCantItemFact() {
        return cantItemFact;
    }

    public void setCantItemFact(int cantItemFact) {
        this.cantItemFact = cantItemFact;
    }

    public int getCostUItemFact() {
        return costUItemFact;
    }

    public void setCostUItemFact(int costUItemFact) {
        this.costUItemFact = costUItemFact;
    }

    public int getValorUVentItem() {
        return valorUVentItem;
    }

    public void setValorUVentItem(int valorUVentItem) {
        this.valorUVentItem = valorUVentItem;
    }
        
}

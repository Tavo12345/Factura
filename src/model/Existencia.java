/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author usuario
 */
public class Existencia {
    private int codItem;
    private int cantItem;
    private int costUItem;

    public Existencia(int codItem, int cantItem, int costUItem) {
        this.codItem = codItem;
        this.cantItem = cantItem;
        this.costUItem = costUItem;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public int getCantItem() {
        return cantItem;
    }

    public void setCantItem(int cantItem) {
        this.cantItem = cantItem;
    }

    public int getCostUItem() {
        return costUItem;
    }

    public void setCostUItem(int costUItem) {
        this.costUItem = costUItem;
    }    
    
}

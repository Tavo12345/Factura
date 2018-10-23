/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author usuario
 */
public class Entrada {
    private int     codEnt;
    private int     codItem;
    private int     cantItemEnt;
    private int     costUItemEnt;
    private String  fechEnt;

    public Entrada(int codEnt, int codItem, int cantItemEnt, int costUItemEnt, String fechEnt) {
        this.codEnt = codEnt;
        this.codItem = codItem;
        this.cantItemEnt = cantItemEnt;
        this.costUItemEnt = costUItemEnt;
        this.fechEnt = fechEnt;
    }

    public int getCodEnt() {
        return codEnt;
    }

    public void setCodEnt(int codEnt) {
        this.codEnt = codEnt;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public int getCantItemEnt() {
        return cantItemEnt;
    }

    public void setCantItemEnt(int cantItemEnt) {
        this.cantItemEnt = cantItemEnt;
    }

    public int getCostUItemEnt() {
        return costUItemEnt;
    }

    public void setCostUItemEnt(int costUItemEnt) {
        this.costUItemEnt = costUItemEnt;
    }

    public String getFechEnt() {
        return fechEnt;
    }

    public void setFechEnt(String fechEnt) {
        this.fechEnt = fechEnt;
    }
        
}

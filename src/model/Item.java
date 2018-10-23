/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author usuario
 */
public class Item {
    private int     codItem;
    private String  nomItem;
    private String  tipoItem;
    private int     valorUItem;

    public Item(int codItem, String nomItem, String tipoItem, int valorUItem) {
        this.codItem = codItem;
        this.nomItem = nomItem;
        this.tipoItem = tipoItem;
        this.valorUItem = valorUItem;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public String getNomItem() {
        return nomItem;
    }

    public void setNomItem(String nomItem) {
        this.nomItem = nomItem;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public int getValorUItem() {
        return valorUItem;
    }

    public void setValorUItem(int valorUItem) {
        this.valorUItem = valorUItem;
    }    
    
}

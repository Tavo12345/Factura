/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author usuario
 */
public class Cliente {
    private int     codCliente;
    private String  nomCliente;
    private String  dirCliente;
    private int     telCliente;
    private String  emailCliente;

    public Cliente(int codCliente, String nomCliente, String dirCliente, int telCliente, String emailCliente) {
        this.codCliente = codCliente;
        this.nomCliente = nomCliente;
        this.dirCliente = dirCliente;
        this.telCliente = telCliente;
        this.emailCliente = emailCliente;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getDirCliente() {
        return dirCliente;
    }

    public void setDirCliente(String dirCliente) {
        this.dirCliente = dirCliente;
    }

    public int getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(int telCliente) {
        this.telCliente = telCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
        
}

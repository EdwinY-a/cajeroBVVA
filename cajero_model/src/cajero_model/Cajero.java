/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero_model;

/**
 *
 * @author pasit
 */
public class Cajero {
    int idCajero;
    String nombreBanco;
    int cantidad;
    String codigoRegistro;
    Banco banco;

    public Cajero() {
    }

    public Cajero(int idCajero, String nombreBanco, int cantidad, String codigoRegistro, Banco banco) {
        this.idCajero = idCajero;
        this.nombreBanco = nombreBanco;
        this.cantidad = cantidad;
        this.codigoRegistro = codigoRegistro;
        this.banco = banco;
    }

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "Cajero{" + "idCajero=" + idCajero + ", nombreBanco=" + nombreBanco + ", cantidad=" + cantidad + ", codigoRegistro=" + codigoRegistro + ", banco=" + banco + '}';
    }

    
}

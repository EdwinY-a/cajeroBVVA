/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero_model;

/**
 *
 * @author pasit
 */
public class RegistroTransaccion {
    int idRegistroTransaccion;
    int monto;
    String fechayHoraRegistro;
    Banco banco;

    public RegistroTransaccion() {
    }

    public RegistroTransaccion(int idRegistroTransaccion, int monto, String fechayHoraRegistro, Banco banco) {
        this.idRegistroTransaccion = idRegistroTransaccion;
        this.monto = monto;
        this.fechayHoraRegistro = fechayHoraRegistro;
        this.banco = banco;
    }

    public int getIdRegistroTransaccion() {
        return idRegistroTransaccion;
    }

    public void setIdRegistroTransaccion(int idRegistroTransaccion) {
        this.idRegistroTransaccion = idRegistroTransaccion;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getFechayHoraRegistro() {
        return fechayHoraRegistro;
    }

    public void setFechayHoraRegistro(String fechayHoraRegistro) {
        this.fechayHoraRegistro = fechayHoraRegistro;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "RegistroTransaccion{" + "idRegistroTransaccion=" + idRegistroTransaccion + ", monto=" + monto + ", fechayHoraRegistro=" + fechayHoraRegistro + ", banco=" + banco + '}';
    }

    
   
}

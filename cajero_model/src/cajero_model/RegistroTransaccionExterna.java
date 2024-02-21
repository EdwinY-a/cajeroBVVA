/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero_model;

/**
 *
 * @author pasit
 */
public class RegistroTransaccionExterna {
    int idRegistroTransaccionExterna;
    int monto;
    String fechayHoraRegistro;
    Banco banco;

    public RegistroTransaccionExterna() {
    }

    public RegistroTransaccionExterna(int idRegistroTransaccionExterna, int monto, String fechayHoraRegistro, Banco banco) {
        this.idRegistroTransaccionExterna = idRegistroTransaccionExterna;
        this.monto = monto;
        this.fechayHoraRegistro = fechayHoraRegistro;
        this.banco = banco;
    }

    public int getIdRegistroTransaccionExterna() {
        return idRegistroTransaccionExterna;
    }

    public void setIdRegistroTransaccionExterna(int idRegistroTransaccionExterna) {
        this.idRegistroTransaccionExterna = idRegistroTransaccionExterna;
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
        return "RegistroTransaccionExterna{" + "idRegistroTransaccionExterna=" + idRegistroTransaccionExterna + ", monto=" + monto + ", fechayHoraRegistro=" + fechayHoraRegistro + ", banco=" + banco + '}';
    }

    
}

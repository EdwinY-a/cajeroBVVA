package cajero_model;

/**
 *
 * @author pasit
 */
public class Banco {

    int idBanco;
    String numeroTarjeta;
    int dinero;
    int NIP;
    String nombrePersona;

    public Banco() {
    }

    public Banco(int idBanco, String numeroTarjeta, int dinero, int NIP, String nombrePersona) {
        this.idBanco = idBanco;
        this.numeroTarjeta = numeroTarjeta;
        this.dinero = dinero;
        this.NIP = NIP;
        this.nombrePersona = nombrePersona;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getNIP() {
        return NIP;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    @Override
    public String toString() {
        return "Banco{" + "idBanco=" + idBanco + ", numeroTarjeta=" + numeroTarjeta + ", dinero=" + dinero + ", NIP=" + NIP + ", nombrePersona=" + nombrePersona + '}';
    }

    
}

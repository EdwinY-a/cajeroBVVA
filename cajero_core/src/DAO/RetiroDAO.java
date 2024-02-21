/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import cajero_model.Banco;
import cajero_model.Cajero;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.cajero.core.conexion.ConexionBD;
import java.sql.SQLException;

/**
 *
 * @author pasit
 */
public class RetiroDAO {

    public Cajero insert(Cajero c) throws Exception {
        System.out.println("AQUI VAN LOS DATOS INTERNO"+c.toString());

        String sql = "{call insertarCliente(?, ?, ?, ?)}";

        String codigoGenerado = "";
        int idTransaccion = -1;
        ConexionBD connMySQL = new ConexionBD();

        try ( 
                Connection conn = connMySQL.open();  
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, c.getCantidad());
            cstmt.setInt(2, c.getBanco().getIdBanco());
            cstmt.registerOutParameter(3, Types.INTEGER);
            cstmt.registerOutParameter(4, Types.VARCHAR);

            cstmt.executeUpdate();

            idTransaccion = cstmt.getInt(3);
            codigoGenerado = cstmt.getString(4);

            c.setCodigoRegistro(codigoGenerado);
            c.setIdCajero(idTransaccion);
        } catch (SQLException e) {
            throw new Exception("Error al ejecutar la operación de inserción", e);
        } finally {
            connMySQL.close();
        }

        return c;
    }

public Cajero update(Cajero c) throws Exception {
    String sql = "{call actualizarMontos(?, ?, ?, ?)}";
    
    System.out.println("UPDATE   " + c);

    ConexionBD connMySQL = new ConexionBD();

    try (Connection conn = connMySQL.open();
         CallableStatement cstmt = conn.prepareCall(sql)) {

        cstmt.setInt(1, c.getBanco().getDinero());
        cstmt.setInt(2, c.getCantidad());
        cstmt.setInt(3, c.getBanco().getIdBanco());
        cstmt.setInt(4, c.getIdCajero());

        cstmt.executeUpdate();

        return c;
    } catch (SQLException e) {
        throw new Exception("Error al ejecutar la operación de actualización", e);
    } finally {
        connMySQL.close();
    }
}
public Cajero updateInterno(Cajero c) throws Exception {
    String sql = "{call actualizarMontosInterno(?, ?, ?, ?)}";
    
    System.out.println("UPDATE   " + c);

    ConexionBD connMySQL = new ConexionBD();

    try (Connection conn = connMySQL.open();
         CallableStatement cstmt = conn.prepareCall(sql)) {

        cstmt.setInt(1, c.getBanco().getDinero());
        cstmt.setInt(2, c.getCantidad());
        cstmt.setInt(3, c.getBanco().getIdBanco());
        cstmt.setInt(4, c.getIdCajero());

        cstmt.executeUpdate();

        return c;
    } catch (SQLException e) {
        throw new Exception("Error al ejecutar la operación de actualización", e);
    } finally {
        connMySQL.close();
    }
}


    public Cajero insertExterno(Cajero c) throws Exception {
        System.out.println("AQUI VAN LOS DATOS"+c.toString());

        String sql = "{call insertarClienteExterno(?, ?, ?, ?)}";

        String codigoGenerado = "";
        int idTransaccion = -1;
        ConexionBD connMySQL = new ConexionBD();

        try ( 
                Connection conn = connMySQL.open();  
                CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, c.getCantidad());
            cstmt.setInt(2, c.getBanco().getIdBanco());
            cstmt.setString(3, c.getCodigoRegistro());
            cstmt.registerOutParameter(4, Types.VARCHAR);

            cstmt.executeUpdate();

            idTransaccion = cstmt.getInt(4);

            c.setCodigoRegistro(codigoGenerado);
            c.setIdCajero(idTransaccion);
        } catch (SQLException e) {
            throw new Exception("Error al ejecutar la operación de inserción", e);
        } finally {
            connMySQL.close();
        }

        return c;
    }
    
    public Cajero updateExterno(Cajero c) throws Exception {
    String sql = "{call actualizarMontosExterno(?, ?)}";
    
    System.out.println("UPDATE   " + c);

    ConexionBD connMySQL = new ConexionBD();

    try (Connection conn = connMySQL.open();
         CallableStatement cstmt = conn.prepareCall(sql)) {

        cstmt.setInt(1, c.getCantidad());
        cstmt.setInt(2, c.getIdCajero());

        cstmt.executeUpdate();

        return c;
    } catch (SQLException e) {
        throw new Exception("Error al ejecutar la operación de actualización", e);
    } finally {
        connMySQL.close();
    }
}

    public Cajero validarCajero(String numeroTarjeta) throws Exception {
        String sql = "SELECT * FROM v_datos WHERE numeroTarjeta = ?;";
        ConexionBD connMySQL = new ConexionBD();
        Connection conn = connMySQL.open();

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, numeroTarjeta);

        ResultSet rs = pstmt.executeQuery();
        Cajero caje = null;

        while (rs.next()) {
            caje = fillCajero(rs);
        }

        rs.close();
        pstmt.close();
        connMySQL.close();
        System.out.println(caje);
        return caje;
    }

    private Cajero fillCajero(ResultSet rs) throws Exception {
        Banco b = new Banco();
        Cajero c = new Cajero();

        b.setIdBanco(rs.getInt("idBanco"));
        b.setNombrePersona(rs.getString("nombrePersona"));
        b.setNumeroTarjeta(rs.getString("numeroTarjeta"));
        b.setDinero(rs.getInt("dinero"));
        b.setNIP(rs.getInt("NIP"));

        c.setBanco(b);
        c.setIdCajero(rs.getInt("idCajero"));
        c.setNombreBanco(rs.getString("nombreBanco"));
        c.setCantidad(rs.getInt("cantidad"));

        return c;
    }

}

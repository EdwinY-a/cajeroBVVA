/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.cajero.core;

import CQRS.RetiroCQRS;
import DAO.RetiroDAO;
import appServices.RetiroAppServices;
import cajero_model.Banco;
import cajero_model.Cajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.utl.cajero.core.conexion.ConexionBD;

/**
 *
 * @author pasit
 */
public class ControllerRetiro {

    public Cajero registrarTransaccion(Cajero retiro) throws Exception {
        RetiroAppServices app = new RetiroAppServices();
        Cajero c = app.registrarTransaccion(retiro);
        return c;
    }

    public Cajero actualizarMontos(Cajero retiro) throws Exception {
        RetiroAppServices app = new RetiroAppServices();
        Cajero c = app.actualizarMontos(retiro);
        return c;
    }

    public Cajero registrarTransaccionExterno(Cajero retiro) throws Exception {
        RetiroAppServices app = new RetiroAppServices();
        Cajero c = app.registrarTransaccionExterno(retiro);
        return c;
    }

    public Cajero validarCajero(String numeroTarjeta) throws Exception {

        RetiroAppServices app = new RetiroAppServices();
        Cajero cg = app.buscarCajero(numeroTarjeta);
        return cg;
    }
    
    public Cajero registrarInterno(Cajero retiro) throws Exception {
        RetiroAppServices app = new RetiroAppServices();
        Cajero c = app.registrarTransaccionInterno(retiro);
        return c;
    }

    public Cajero actualizarInterno(Cajero retiro) throws Exception {
        RetiroAppServices app = new RetiroAppServices();
        Cajero c = app.actualizarMontosInterno(retiro);
        return c;
    }

}

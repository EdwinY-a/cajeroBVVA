/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appServices;

import CQRS.RetiroCQRS;
import DAO.RetiroDAO;
import cajero_model.Banco;
import cajero_model.Cajero;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author pasit
 */
public class RetiroAppServices {
    public Cajero registrarTransaccion(Cajero retiro) throws Exception{
        RetiroCQRS ucqrs = new RetiroCQRS();
        Cajero c = ucqrs.registrarTransaccion(retiro);

        return c; 
    }
    public Cajero registrarTransaccionExterno(Cajero retiro) throws Exception{
        RetiroCQRS ucqrs = new RetiroCQRS();
        Cajero c = ucqrs.registrarTransaccionExterno(retiro);

        return c; 
    }
    
    public Cajero actualizarMontos(Cajero retiro) throws Exception{
        RetiroCQRS ucqrs = new RetiroCQRS();
        Cajero c = ucqrs.actualizarMontosExternos(retiro);
        
        return c; 
    }
    
    public Cajero buscarCajero(String numeroTarjeta) throws Exception{
        RetiroDAO dao = new RetiroDAO();
        Cajero c = dao.validarCajero(numeroTarjeta);
        return c; 
    }
    
    public Cajero registrarTransaccionInterno(Cajero retiro) throws Exception{
        RetiroCQRS ucqrs = new RetiroCQRS();
        Cajero c = ucqrs.registrarTransaccionInterno(retiro);

        return c; 
    }
    public Cajero actualizarMontosInterno(Cajero retiro) throws Exception{
        RetiroCQRS ucqrs = new RetiroCQRS();
        Cajero c = ucqrs.actualizarMontosExternos(retiro);
        
        return c; 
    }
    
}

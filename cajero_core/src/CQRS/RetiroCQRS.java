/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CQRS;

import DAO.RetiroDAO;
import cajero_model.Banco;
import cajero_model.Cajero;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.utl.cajero.core.ControllerRetiro;

/**
 *
 * @author pasit
 */
public class RetiroCQRS {

    public Cajero registrarTransaccion(Cajero retiro) throws Exception {
        RetiroDAO dao = new RetiroDAO();
        Cajero cajero = dao.validarCajero(retiro.getBanco().getNumeroTarjeta());
        
        if (cajero == null) {
            throw new Exception("Numero de Tarjeta Incorrecta");
        }
        
        if (cajero.getBanco().getNIP() != retiro.getBanco().getNIP()) {
            throw new Exception("NIP Incorrecto");
        }
        
        if (retiro.getBanco().getDinero() < 0 ) {
            throw new Exception("No cuentas con dinero suficiente");
        }
        
        if (cajero.getBanco().getDinero() < retiro.getBanco().getDinero()) {
            throw new Exception("No cuentas con dinero suficiente en tu cuenta");
        }

        if (cajero.getCantidad() < retiro.getCantidad()) {
            throw new Exception("El cajero no cuenta con suficiente dinero");
        }

        
        retiro.getBanco().setIdBanco(cajero.getBanco().getIdBanco());
        retiro.getBanco().setDinero(retiro.getCantidad());
        retiro.setIdCajero(cajero.getIdCajero());
        actualizarMontos(retiro);
        Cajero c = dao.insert(retiro);
        
        
        return c;
    }


    public Cajero actualizarMontos(Cajero retiro) throws Exception {
        RetiroDAO dao = new RetiroDAO();
        Cajero c = dao.update(retiro);
        return c;
    }
    
    public Cajero registrarTransaccionInterno(Cajero retiro) throws Exception {
        RetiroDAO dao = new RetiroDAO();
        Cajero cajero = dao.validarCajero(retiro.getBanco().getNumeroTarjeta());
        
        if (cajero == null) {
            throw new Exception("Numero de Tarjeta Incorrecta");
        }
        
        if (cajero.getBanco().getNIP() != retiro.getBanco().getNIP()) {
            throw new Exception("NIP Incorrecto");
        }
        
        if (retiro.getBanco().getDinero() < 0 ) {
            throw new Exception("No cuentas con dinero suficiente");
        }
        
        if (cajero.getBanco().getDinero() < retiro.getBanco().getDinero()) {
            throw new Exception("No cuentas con dinero suficiente en tu cuenta");
        }

        if (cajero.getCantidad() < retiro.getCantidad()) {
            throw new Exception("El cajero no cuenta con suficiente dinero");
        }

        
        retiro.getBanco().setIdBanco(cajero.getBanco().getIdBanco());
        retiro.getBanco().setDinero(retiro.getCantidad());
        retiro.setIdCajero(cajero.getIdCajero());
        actualizarMontosInterno(retiro);
        Cajero c = dao.insert(retiro);
        
        
        return c;
    }


    public Cajero actualizarMontosInterno(Cajero retiro) throws Exception {
        RetiroDAO dao = new RetiroDAO();
        Cajero c = dao.updateInterno(retiro);
        return c;
    }
    
    
    public Cajero registrarTransaccionExterno(Cajero retiro) throws Exception {
        retiro.getBanco().setIdBanco(1);
        RetiroDAO dao = new RetiroDAO();
        actualizarMontosExternos(retiro);
        Cajero c = dao.insertExterno(retiro);
        
        return c;
    }


    public Cajero actualizarMontosExternos(Cajero retiro) throws Exception {
        retiro.setIdCajero(1);
        RetiroDAO dao = new RetiroDAO();
        Cajero c = dao.updateExterno(retiro);
        return c;
    }

}

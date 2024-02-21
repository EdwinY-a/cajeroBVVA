/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.cajero.rest;

import cajero_model.Banco;
import cajero_model.Cajero;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utl.cajero.core.ControllerRetiro;

/**
 *
 * @author pasit
 */
@Path("retiro")
public class RESTRetiro {

    @Path("externo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response TransaccionExterno(@FormParam("datos") @DefaultValue("") String datos) {
        String out = null;
        Gson gson = new Gson();
        Cajero retiro = null;
        ControllerRetiro cr = new ControllerRetiro();
        System.out.println(datos);

        try {
            retiro = gson.fromJson(datos, Cajero.class);
            Cajero c = cr.registrarTransaccionExterno(retiro);

            out = gson.toJson(c);

        } catch (JsonParseException jpe) {
            jpe.printStackTrace();
            //WebCraule
            out = """
                  {"exception": "Formato de Datos Incorrecta."}
                  """;
        } catch (Exception e) {
            e.printStackTrace();
            out = """
                  {"exception" : "%s"}
                  """;
            out = String.format(out, e.toString());
        }
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(out).build();
    }
    
    @Path("interno")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response Transaccion2(@FormParam("datos") @DefaultValue("") String datos) {
        String out = null;
        Gson gson = new Gson();
        Cajero retiro = null;
        ControllerRetiro cr = new ControllerRetiro();
        System.out.println(datos);

        try {
            retiro = gson.fromJson(datos, Cajero.class);
            Cajero c = cr.registrarInterno(retiro);

            out = gson.toJson(c);

        } catch (JsonParseException jpe) {
            jpe.printStackTrace();
            //WebCraule
            out = """
                  {"exception": "Formato de Datos Incorrecta."}
                  """;
        } catch (Exception e) {
            e.printStackTrace();
            out = """
                  {"exception" : "%s"}
                  """;
            out = String.format(out, e.toString());
        }
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(out).build();
    }
    
    @Path("montoExterno")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response montosExterno(@FormParam("datos") @DefaultValue("") String datos) {
        String out = null;
        Gson gson = new Gson();
        Cajero retiro = null;
        ControllerRetiro cr = new ControllerRetiro();
        System.out.println(datos);

        try {
            retiro = gson.fromJson(datos, Cajero.class);
            Cajero c = cr.actualizarMontos(retiro);

            out = gson.toJson(c);

        } catch (JsonParseException jpe) {
            jpe.printStackTrace();
            //WebCraule
            out = """
                  {"exception": "Formato de Datos Incorrecta."}
                  """;
        } catch (Exception e) {
            e.printStackTrace();
            out = """
                  {"exception" : "%s"}
                  """;
            out = String.format(out, e.toString());
        }
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(out).build();
    }

    @Path("validacion")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response validar(@FormParam("datos") @DefaultValue("") String datos) {
        String out = null;
        Gson gson = new Gson();
        Cajero retiro = null;
        ControllerRetiro cr = new ControllerRetiro();
        System.out.println(datos);

        try {
            retiro = gson.fromJson(datos, Cajero.class);
            Cajero c = cr.registrarTransaccion(retiro);

            out = gson.toJson(c);

        } catch (JsonParseException jpe) {
            jpe.printStackTrace();
            //WebCraule
            out = """
                  {"exception": "Formato de Datos Incorrecta."}
                  """;
        } catch (Exception e) {
            e.printStackTrace();
            out = """
                  {"exception" : "%s"}
                  """;
            out = String.format(out, e.toString());
        }
        return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "*").entity(out).build();
    }

}

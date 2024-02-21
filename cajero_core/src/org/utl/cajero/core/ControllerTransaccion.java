///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package org.utl.cajero.core;
//
//import cajero_model.Banco;
//import cajero_model.RegistroTransaccion;
//import cajero_model.RegistroTransaccionExterna;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import org.utl.cajero.core.conexion.ConexionBD;
//
///**
// *
// * @author pasit
// */
//public class ControllerTransaccion {
//    public List<RegistroTransaccion> getAll(String filtro) throws Exception {
//
//        String sql = "SELECT * FROM v_transaccion;";
//        ConexionBD connMySQL = new ConexionBD();
//        Connection conn = connMySQL.open();
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        ResultSet rs = pstmt.executeQuery();
//        List<RegistroTransaccion> retiro = new ArrayList<>();
//
//        while (rs.next()) {
//            retiro.add(fill(rs));
//        }
//
//        rs.close();
//        pstmt.close();
//        connMySQL.close();
//
//        return retiro;
//    }
//
//    private RegistroTransaccion fill(ResultSet rs) throws Exception {
//        RegistroTransaccion retiro = new RegistroTransaccion();
//        Banco b = new Banco();
//        
//        b.setIdBanco(rs.getInt("idBanco"));
//        b.setNombrePersona(rs.getString("nombrePersona"));
//        b.setNumeroTarjeta(rs.getString("numeroTarjeta"));
//        b.setDinero(rs.getInt("dinero"));
//        b.setNIP(rs.getInt("NIP"));
//        b.setNombreBanco(rs.getString("nombreBanco"));
//        
//        retiro.setIdRegistroTransaccion(rs.getInt("idBanco"));
//        retiro.setMonto(rs.getInt("nombrePersona"));
//        retiro.setFechayHoraRegistro(rs.getString("numeroTarjeta"));
//        retiro.setBanco(b);
//
//        return retiro;
//    }
//    
//    public List<RegistroTransaccionExterna> getAllExterna(String filtro) throws Exception {
//
//        String sql = "SELECT * FROM v_transaccionExterna;";
//        ConexionBD connMySQL = new ConexionBD();
//        Connection conn = connMySQL.open();
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        ResultSet rs = pstmt.executeQuery();
//        List<RegistroTransaccionExterna> retiroEx = new ArrayList<>();
//
//        while (rs.next()) {
//            retiroEx.add(fillExterna(rs));
//        }
//
//        rs.close();
//        pstmt.close();
//        connMySQL.close();
//
//        return retiroEx;
//    }
//
//    private RegistroTransaccionExterna fillExterna(ResultSet rs) throws Exception {
//        RegistroTransaccionExterna retiroEx = new RegistroTransaccionExterna();
//        Banco b = new Banco();
//        
//        b.setIdBanco(rs.getInt("idBanco"));
//        b.setNombrePersona(rs.getString("nombrePersona"));
//        b.setNumeroTarjeta(rs.getString("numeroTarjeta"));
//        b.setDinero(rs.getInt("dinero"));
//        b.setNIP(rs.getInt("NIP"));
//        b.setNombreBanco(rs.getString("nombreBanco"));
//        
//        retiroEx.setIdRegistroTransaccionExterna(rs.getInt("idBanco"));
//        retiroEx.setMonto(rs.getInt("nombrePersona"));
//        retiroEx.setFechayHoraRegistro(rs.getString("numeroTarjeta"));
//        retiroEx.setBanco(b);
//
//        return retiroEx;
//    }
//}

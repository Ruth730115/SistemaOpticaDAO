/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;
import Model.Venta;
import Model.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import opticaDAO.VentaDAO;
import util.ConexioBD;

/**
 *
 * @author TECH EXPRESS
 */
public class VentaDAOImpl implements VentaDAO {

    @Override
    public boolean registrarVenta(Venta venta) {

        String sql =
        "INSERT INTO ventas(cliente_id,subtotal,impuesto,total) VALUES(?,?,?,?)";

        try {

            Connection con =
                    ConexioBD.getConexion();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, venta.getClienteId());
            ps.setDouble(2, venta.getSubtotal());
            ps.setDouble(3, venta.getImpuesto());
            ps.setDouble(4, venta.getTotal());

            return ps.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();

        }

        return false;
    }   

    @Override
    public boolean registrarDetalle(DetalleVenta detalle) {

        System.out.println("Entró a registrarDetalle");

        String sql =
            "INSERT INTO detalleventa "
            + "(venta_id, cliente_id, producto_id, medicion_id) "
            + "VALUES (?, ?, ?, ?)";

        try {

        Connection con = ConexioBD.getConexion();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, detalle.getVentaId());
        ps.setInt(2, detalle.getClienteId());
        ps.setInt(3, detalle.getProductoId());
        ps.setInt(4, detalle.getMedicionId());

        System.out.println("Insertando detalle...");

        return ps.executeUpdate() > 0;

    } catch(Exception e){

        e.printStackTrace();

    }
    
    return false;
}
}
        
   

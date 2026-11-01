/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao.impl;

import opticaDAO.productoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import Model.producto;
import util.ConexioBD;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author RUTH FLORES
 */


public class productoDAOImpl implements productoDAO {

    @Override
    public boolean registrar(producto p) {

        String sql =
            "INSERT INTO productos(nombre,tipo,marca,precio,stock) VALUES(?,?,?,?,?)";

        try {

            Connection con =
                ConexioBD.getConexion();

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTipo());
            ps.setString(3, p.getMarca());
            ps.setDouble(4, p.getPrecio());
            ps.setInt(5, p.getStock());
            
            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }

    @Override
    public List<producto> listar() {
            List<producto> lista = new ArrayList<>();

            String sql = "SELECT * FROM productos";

    try {

        Connection con = ConexioBD.getConexion();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {

            producto p = new producto();

            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setTipo(rs.getString("tipo"));
            p.setMarca(rs.getString("marca"));
            p.setPrecio(rs.getDouble("precio"));
            p.setStock(rs.getInt("stock"));

            lista.add(p);
        }

    } catch(Exception e) {
        e.printStackTrace();
    }

    return lista;
    }

    @Override
    public boolean actualizar(producto p) {

    String sql =
    "UPDATE productos SET nombre=?, tipo=?, marca=?, precio=?, stock=? WHERE id=?";

    try {

        Connection con = ConexioBD.getConexion();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, p.getNombre());
        ps.setString(2, p.getTipo());
        ps.setString(3, p.getMarca());
        ps.setDouble(4, p.getPrecio());
        ps.setInt(5, p.getStock());
        ps.setInt(6, p.getId());

        return ps.executeUpdate() > 0;

    } catch(Exception e) {
        e.printStackTrace();
    }

    return false;
}
 
    @Override
    public boolean eliminar(int id) {

    String sql =
    "DELETE FROM productos WHERE id=?";

    try {

        Connection con = ConexioBD.getConexion();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        return ps.executeUpdate() > 0;

    } catch(Exception e) {
        e.printStackTrace();
    }

    return false;
}
       

    @Override
    public producto buscarPorId(int id) {

    String sql =
    "SELECT * FROM productos WHERE id=?";

    try {

        Connection con = ConexioBD.getConexion();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            producto p = new producto();

            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setTipo(rs.getString("tipo"));
            p.setMarca(rs.getString("marca"));
            p.setPrecio(rs.getDouble("precio"));
            p.setStock(rs.getInt("stock"));

            return p;
        }

    } catch(Exception e) {
        e.printStackTrace();
    }
    return null;
}
    
    @Override
    public boolean actualizarStock(int idProducto, int cantidadVendida){

    String sql =
    "UPDATE productos SET stock = stock - ? WHERE id = ?";

    try {

        Connection con = ConexioBD.getConexion();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, cantidadVendida);
        ps.setInt(2, idProducto);

        return ps.executeUpdate() > 0;

    } catch (Exception e) {

        e.printStackTrace();

    }

    return false;
}
}      
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opticaDAO;
import Model.Venta;
import Model.DetalleVenta;
/**
 *
 * @author TECH EXPRESS
 */

public interface VentaDAO {

    boolean registrarVenta(Venta venta);
    
    boolean registrarDetalle(DetalleVenta detalle);
     

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opticaDAO;

import java.util.List;
import Model.producto;
/**
 *
 * @author TECH EXPRESS
 */

public interface productoDAO {

    boolean registrar(producto p);

    List<producto> listar();

    boolean actualizar(producto p);

    boolean eliminar(int id);

    producto buscarPorId(int id);
    
    boolean actualizarStock(int idProducto, int cantidadVendida);
}


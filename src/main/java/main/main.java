/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Model.producto;
import opticaDAO.productoDAO;
import dao.impl.productoDAOImpl;
import java.util.List;
/**
 *
 * @author RUTH FLORES
 */

public class main {

public static void main(String[] args) {

    //registrar
    producto p = new producto();

    p.setNombre("Aro RayBan");
    p.setTipo("Aro");
    p.setMarca("RayBan");
    p.setPrecio(150);
    p.setStock(10);

    productoDAO dao = new productoDAOImpl();

    boolean resultado = dao.registrar(p);

    if(resultado){
        System.out.println("Producto registrado");
    }else{
        System.out.println("Error al registrar");
    }
    
   
    
    //buscar
    producto productoBuscado = dao.buscarPorId(1);

    if(productoBuscado != null) {

        System.out.println(productoBuscado.getNombre());
        System.out.println(productoBuscado.getMarca());

    }
    
    //listar
    List<producto> productos = dao.listar();

    for(producto prod : productos) {

        System.out.println(prod.getNombre());

    }
    
    //eliminar
    dao.eliminar(1);
    producto peli = dao.buscarPorId(1);

    if(peli != null) {

        System.out.println(p.getNombre());
        System.out.println(p.getMarca());

    }
    
    //actualizar
    producto productoActualizar = new producto();

    productoActualizar.setId(1);
    productoActualizar.setNombre("Aro Updated");
    productoActualizar.setTipo("Aro");
    productoActualizar.setMarca("Oakley");
    productoActualizar.setPrecio(180);
    productoActualizar.setStock(15);

    dao.actualizar(productoActualizar);
}
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TECH EXPRESS
 */

public class ConexioBD {
    private static final String URL = "jdbc:sqlserver://localhost;"
            + "databaseName=OpticaDB;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456";
    private static Connection conexion = null;
    private ConexioBD(){}
    
    public static Connection getConexion(){
        try{
            if(conexion == null || conexion.isClosed()){
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                //establecer conexion
                conexion = DriverManager.getConnection(URL,USER,PASSWORD);
                System.out.println("->Conexion exitosa a SQL");
            }
        }catch(ClassNotFoundException e){
            System.err.println("Error no se encontro el Driver de nssql-jdbc"
                    + e.getMessage());
        }catch(SQLException e){
            System.err.println("Error al conectar con SQL"
            + e.getMessage());
        }
        return conexion;
    }
    public static void cerrarConexion(){
        try{
            if(conexion != null && !conexion.isClosed()){
                conexion.close();
                System.out.println("->La conexion con SQL fue cerrada");
            }
        }catch(SQLException e){
            System.err.println("Error al cerrar la conexion" + e.getMessage());
        }
    }
}

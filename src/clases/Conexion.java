/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.*;

/**
 *
 * @author doug1as
 */
public class Conexion {
    
    // Conexion Local
    public static Connection conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://35.185.84.123/sql9354347", "root", "caracasfc");
            return cn;
        }catch(SQLException e){
            
            System.out.println("Error en conxion local " + e);
            
        }
        return (null);
    }
    
}

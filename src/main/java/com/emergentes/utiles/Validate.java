
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate extends ConexionDB{
    Connection con = this.conectar();
    PreparedStatement pr;
    public boolean checkUser(String usuario, String password){
        boolean resultado = false;
        try {
            
            String sql = "select * from usuario where usuario=? and password=sha1(?)";
            
            pr= con.prepareStatement(sql);
            pr.setString(1, usuario);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            resultado = rs.next();
            return resultado;
        } catch (SQLException ex) {
            System.out.println("Error al autentificar");
        }
        return resultado;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ClienteDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    
    PreparedStatement ps;
    
    public boolean RegistrarCliente(Cliente cl){
        String sql = "INSERT INTO clientes (dni, nombre, telefono, direccion, razon) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getDni());
            ps.setString(2, cl.getNombre());
              ps.setInt(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
              ps.setString(5, cl.getRazon());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
}

   
   


package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;


public class ProductosDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProductos(Productos pro){
        String sql = "INSERT INTO productos (codigo, nombre, proveedor, stock, precio) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getProveedor());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public void ConsultarProveedor(JComboBox proveedor){
        String sql = "SELECT nombre FROM proveedor";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                proveedor.addItem(rs.getString("nombre"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}

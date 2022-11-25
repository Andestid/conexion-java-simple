
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class Controladores {
    public boolean registrarCliente(int id, String apellido, String nombre, String telefono)
    {
        String sql = "INSERT INTO profesores (id,apellido,nombre,telefono) VALUES (?,?,?,?)";
        
        Connection conectar;
        PreparedStatement pst;
        
        try
        {
            conectar = Conexion.getConnection();
            
            pst = conectar.prepareStatement(sql);
            
            pst.setInt(1,id);
            pst.setString(2, apellido);
            pst.setString(3, nombre);
            pst.setString(4, telefono);
            
            int result = pst.executeUpdate();
            
            if (result != 0)
            {
                JOptionPane.showMessageDialog(null,"Los datos se han guardado satisfactoriamente");
                
                return true;

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error en la transaccion");
                
                return false;
            }
            
        }
        catch(SQLException e)
        {            
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
            return false;
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.*;
import BaseDatos.proveedores;
/**
 *
 * @author zombozo
 */
public class TareasDBproveedores {
    
    String tabla=StringTablaProveedor.NombreTabla;
    public void guardar(Connection conexion, proveedores tarea){
        try{
            PreparedStatement consulta;
            consulta=conexion.prepareStatement(" INSERT INTO "+ this.tabla+StringTablaProveedor.retornaColumnas+
                    "VALUES (?,?)");
                    consulta.setString(1, proveedores.getNombre_proveedor());
        }catch(SQLException e){
            
        }
    }
}

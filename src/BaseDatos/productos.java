/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zombozo
 */
public class productos {



private String	nombre_producto;
private String        fabricante;
private int	contenedor;
public static        String        SQL_NombreTabla="productos";
public static        String        SQL_id_producto="Id_producto";
public static        String        SQL_nombreProducto="nombre_de_producto";
public static        String        SQL_fabricante="fabricante";
public static        String        SQL_tipoContenedor="tipo_contenedor";
public static         String                mensaje;


public productos(){
  
}

    public int getContenedor() {
        return contenedor;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setContenedor(int contenedor) {
        this.contenedor = contenedor;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

   
    public static boolean creaDBproducto(){
        boolean estado=true;
    try {
        
        Statement Conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        String consulta="create table "+SQL_NombreTabla+"("+SQL_id_producto+" int(10) primary key auto_increment,"+SQL_nombreProducto+" varchar(30),"+
                SQL_fabricante+" varchar(40),"+SQL_tipoContenedor+" varchar(40))";
        Conexion.execute(consulta);
    } catch (SQLException ex) {
        estado=false;
    }
    return estado;
    }
    
    
    
    public boolean insertaProducto(){
        boolean estado=true;
        try{
            Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            String consulta=" insert into "+SQL_NombreTabla+"("+SQL_nombreProducto+","+SQL_fabricante+","+SQL_tipoContenedor+") values('"+
                    this.nombre_producto+"','"+this.fabricante+"','"+this.contenedor+"')";
            conexion.execute(consulta);
        }catch(Exception e){
            estado=false;
            mensaje=" error: la maquina dice :"+e.getMessage();
        }
        return estado;
    }
}

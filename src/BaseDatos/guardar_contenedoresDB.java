/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author zombozo
 */
public class guardar_contenedoresDB {
    public static String NombreTabla="contenedores";
    public static String id="ID_contendor";
    public static String NombreContenedor="Nombre_contenedor";
    public static String informacion="Info";
    
    private String string_nombreContenedor="";
    private String string_informacion="";

    
    public guardar_contenedoresDB(){
        
    }
    public String getString_informacion() {
        return string_informacion;
    }

    public String getString_nombreContenedor() {
        return string_nombreContenedor;
    }

    public void setString_informacion(String string_informacion) {
        this.string_informacion = string_informacion;
    }

    public void setString_nombreContenedor(String string_nombreContenedor) {
        this.string_nombreContenedor = string_nombreContenedor;
    }
    
    public static void CrearDB(){
        String sql;
        try{
           Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);
		   // creando estring de consulta
           sql="create table "+NombreTabla+"("+id+" int(10) primary key identity(1,1),"+NombreContenedor+" varchar(50),"+informacion+" varchar(50))";
		   // ejecutando la consulta
           conexion.execute(sql);
		   
		   // cerrando la consulta
           conexion.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       }
    
    public Boolean guardar(){
        boolean estado=false;
        try{
            Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_FORWARD_ONLY);
            String sql="insert into "+NombreTabla+"("+NombreContenedor+","+informacion+") values('"+this.string_nombreContenedor+"','"+this.string_informacion+"')";
            estado=conexion.execute(sql);
            conexion.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return estado;
    }
}

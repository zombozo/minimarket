/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import sun.rmi.runtime.Log;


public  class proveedores {
public static  String  NombreDB="proveedores";
private int	 Id_proveedor;
private static String	 Nombre_proveedor;
private String	 info;
public  static  String mensaje;
public  static  String ColumnaId="Id_Proveedor";
public  static  String ColumnaNombre="nombre_proveedor";
public  static  String ColumnaInfo="info";

public proveedores(int id, String nombre, String infor){
    this.Id_proveedor=id;
    this.Nombre_proveedor=nombre;
    this.info=infor;
}

public proveedores(){
    
}

    public int getId_proveedor() {
        return Id_proveedor;
    }

    public void setId_proveedor(int Id_proveedor) {
        this.Id_proveedor = Id_proveedor;
    }

    public static String getNombre_proveedor() {
        return Nombre_proveedor;
    }

    public void setNombre_proveedor(String Nombre_proveedor) {
        this.Nombre_proveedor = Nombre_proveedor;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

public boolean guardaProveedorDB(){
    boolean estado=true;
    try{
        Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
    String consulta="insert into "+this.NombreDB+"("+this.ColumnaNombre+","+this.ColumnaInfo+") values('"+
            this.Nombre_proveedor+"','"+this.info+"')";
    conexion.execute(consulta);
    }catch(Exception e){
        estado=false;
        mensaje="el error dice: "+e.getMessage();
    }
            
    
    return estado;
}
public static void creaDb(){
    try{
    Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
    conexion.execute("create table proveedores(id_proveedor int(5) primary key auto_increment,nombre_proveedor varchar(50),info varchar(100))");
    mensaje="se a creado la db";
    }catch(Exception e){
            mensaje="a ocurrido un error "+e.getMessage();
            }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

/**
 *
 * @author zombozo
 */
public class StringTablaProveedor {
    public static String NombreTabla="Proveedores";
    
    
    
    public static class columnas{
        public static String id="ID_Porveedor";
        public static String NombreProveedor="Nombre_Proveedor";
        public static String Info="info";
    }
    
    public static String CreaDBProveedores=" CREATE TABLE "+NombreTabla+ "( "+ columnas.id +" int(10) auto_increment primary key ,"+
            columnas.NombreProveedor+" varchar(50) ,"+columnas.Info+" varchar(250) )";
    
    public static String retornaColumnas="("+columnas.NombreProveedor+","+columnas.Info+")";
}

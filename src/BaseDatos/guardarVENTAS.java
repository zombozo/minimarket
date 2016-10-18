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
public class guardarVENTAS {
    private static String SQL_nombreTabla       ="ventas_realizadas";
    private static String SQL_id_venta          ="id_venta";
    private static String SQL_idProductoVendido ="id_producto";
    private static String SQL_cantidadVendida   ="cantidad_vendida";
    private static String SQL_precioCompra      ="Precio_compra";
    private static String SQL_precioVenta       ="Precio_venta";
    private static String SQL_fechaCompra       ="Fecha";
    
    private        String idProducto            ="";
    private        String cantidadVendida       ="";
    private        String precioCompra          ="";
    private        String PrecioVenta           ="";
    private        String FechaCompra           ="";
    public  static String mensaje               ="";
    
    public guardarVENTAS(){
        
    }
    public void setCantidadVendida(String cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(String PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }
    
    
    public void CrearDB(){
        try
        {
            Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_FORWARD_ONLY);
            String sql="create table "+SQL_nombreTabla+"("+SQL_id_venta+" int(10) primary key auto_increment ,"+SQL_idProductoVendido+" varchar(20),"+SQL_cantidadVendida
                    +" varchar(20),"+SQL_precioCompra+" varchar(10),"+SQL_precioVenta+" varchar(10),"+SQL_fechaCompra+" varchar(10))";
            conexion.execute(sql);
            conexion.close();
        }catch(Exception e){    }
    }
    /* ================================================================================*/
    public boolean guardar(){
        boolean estado=false;
        estado=this.PrecioVenta.isEmpty();
        estado|=this.cantidadVendida.isEmpty();
        estado|=this.idProducto.isEmpty();
        estado|=this.precioCompra.isEmpty();
        
        try{
            if(estado==false)
            {
                    Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_FORWARD_ONLY);
                    String sql="insert into  "+SQL_nombreTabla+"("+SQL_idProductoVendido+","+SQL_cantidadVendida
                            +","+SQL_precioCompra+","+SQL_precioVenta+','+SQL_fechaCompra+") values('"+this.idProducto+"','"+this.cantidadVendida
                            +"','"+this.precioCompra+"','"+this.PrecioVenta+"','"+this.FechaCompra+"')";
                    estado=conexion.execute(sql);
                    conexion.close();
            }else{
                mensaje="uno de los campos esta vacio , no podemos guardar esta venta, busque este producto de nuevo" ;
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return estado;
    }
    /* ================================================================================*/
    public String getFechaCompra() {
        return FechaCompra;
    }
    /* ================================================================================*/
    public void setFechaCompra(String FechaCompra) {
        this.FechaCompra = FechaCompra;
    }
    
        /* ================================================================================*/
    
}

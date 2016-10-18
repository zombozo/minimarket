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
public class compras {

private int	Id_producto;
private int	Total_producto;
private double	Precio_compra_Unidad;
private double	Precio_venta_unidad;
private String	Fecha_compra;
private int           Proveedor;
private String	info;

private static  String NombreTabla="compras";
private static  String SQL_Id_compra="id_compra";
private static  String SQL_proveedor="Proveedor";
public static   String SQL_Id_producto="Id_producto";
public static   String SQL_total_producto="Total_producto";
public static   String SQL_precio_compra_unidad="Precio_compra_Unidad";
public static   String SQL_precio_venta="Precio_venta_unidad";
public static   String SQL_fecha_compra="Fecha_compra";
public static   String SQL_info="info";  
public static   String mensajes;
public static   LogDeCompras log;

public compras(){

  
    
}
/* ================================================================================*/
  public compras(int id){
      
      
      try{
      Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_FORWARD_ONLY);
      String sql="select * from "+NombreTabla+" where "+SQL_Id_producto+" like '"+id+"'";
      ResultSet resultado=conexion.executeQuery(sql);
      if(resultado.first()){
      while(resultado.next()){
          this.Precio_compra_Unidad=resultado.getDouble(5);
          this.Precio_venta_unidad=resultado.getDouble(6);
          
      }
      }else{
          System.out.println("error el cursor esta vacio !! la id es "+id);
      }
      
      }catch(Exception e){
         System.out.println(e.getMessage());
      }
  }  

 /* ================================================================================*/  
    public int getId_producto() {
        return Id_producto;
    }

    public void setId_producto(int Id_producto) {
        this.Id_producto = Id_producto;
    }

    public int getTotal_producto() {
        return Total_producto;
    }

    public void setTotal_producto(int Total_producto) {
        this.Total_producto = Total_producto;
    }
    
    public double getPrecio_compra_Unidad() {
        return Precio_compra_Unidad;
    }

    public void setPrecio_compra_Unidad(double Precio_compra_Unidad) {
        this.Precio_compra_Unidad = Precio_compra_Unidad;
    }

    public double getPrecio_venta_unidad() {
        return Precio_venta_unidad;
    }

    public void setPrecio_venta_unidad(double Precio_venta_unidad) {
        this.Precio_venta_unidad = Precio_venta_unidad;
    }

    public String getFecha_compra() {
        return Fecha_compra;
    }

    public void setFecha_compra(String Fecha_compra) {
        this.Fecha_compra = Fecha_compra;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

  /* ================================================================================*/  
    public static boolean CreaDBcompras(){
         log=new LogDeCompras();
        boolean estado=false;
        try{
            Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            String consulta="create table "+NombreTabla+"("+SQL_Id_compra+" int(10) primary key auto_increment,"+SQL_Id_producto+" int(10),"+SQL_proveedor+" int(10),"+SQL_total_producto+" int(20),"+SQL_precio_compra_unidad+" double,"+SQL_precio_venta+" double,"+SQL_fecha_compra+" varchar(20),"+SQL_info+" varchar(100))";
            estado=conexion.execute(consulta);
        }catch(Exception e){
            System.out.println(""+e.getMessage());
            mensajes = "error la consulta dice: "+e.getMessage();
            estado=false;
        }
        return estado;
    }
   /* ================================================================================*/ 
    public boolean insertaNuevaCompra(){
       boolean estado=true;
       boolean estadoCompra=true;
       boolean estadoMarca=true;
       int id=0,totalProducto=0;
       guardarLog();
        try
        {
            Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultado=conexion.executeQuery("select * from "+NombreTabla+" where "+SQL_Id_producto+" like "+this.Id_producto);
            if(resultado.first()){
                do{
                    System.out.println(" se encontro "+resultado.getString(2));
                    id=resultado.getInt(2);
                    totalProducto=resultado.getInt(4);
                    if(resultado.getInt(3)==this.Proveedor){
                        estadoCompra=false;
                       break;
                    }
                       
                        
                    
                    
                }while(resultado.next());
                
            }
            resultado.close();
            
            if(estadoCompra){
            String consulta="insert into "+NombreTabla+"("+SQL_Id_producto+","+SQL_proveedor+","+SQL_total_producto+","+SQL_precio_compra_unidad+","+SQL_precio_venta+","+SQL_fecha_compra+","+SQL_info+") values('"+Id_producto+"','"+Proveedor+"','"+Total_producto+"','"+Precio_compra_Unidad+"','"+Precio_venta_unidad+"','"+Fecha_compra+"','"+info+"')"; 
                        conexion.execute(consulta);
                        conexion.close();
            }else{
                int tempo=Total_producto+totalProducto;
                conexion.executeUpdate("update "+NombreTabla+" set "+SQL_total_producto+"='"+tempo+"',"+SQL_precio_compra_unidad+"='"+this.Precio_compra_Unidad+"',"+SQL_precio_venta+"='"+this.Precio_venta_unidad+"',"+SQL_fecha_compra+"='"+this.Fecha_compra+"' where "+SQL_Id_producto+"="+id);
            System.out.println(" a entrado aca");
            }    
                        
            conexion.close();            
             
        }catch(Exception e){
            System.out.println(""+e.getMessage());
            estado=false;
            mensajes="error :"+e.getMessage();
            
        }
       
        return estado;
    }
/* ================================================================================*/
    public int getProveedor() {
        return Proveedor;
    }
/* ================================================================================*/
    public void setProveedor(int Proveedor) {
        this.Proveedor = Proveedor;
    }
    /* ================================================================================*/
public void actualizarCompra(int id,int nuevoTotal){
        try{
            Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_FORWARD_ONLY);
            String sql="update "+NombreTabla+" set "+SQL_total_producto+"='"+nuevoTotal+"' where "+SQL_Id_producto+"="+id;
            conexion.executeUpdate(sql);
            conexion.close();
        }catch(Exception e){
            
        }
    }
/* ================================================================================*/
public void guardarLog(){
    log.setIdProducto(""+this.Id_producto);
    log.setTotalProducto(""+this.Total_producto);
    log.setPrecioAnterior(""+this.Precio_compra_Unidad);
    log.setNuevoPrecio(""+this.Precio_venta_unidad);
    log.setFechaLog(Fecha_compra);
    log.guardar();
}
}
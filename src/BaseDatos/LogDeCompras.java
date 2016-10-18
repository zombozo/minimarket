/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.ResultSet;
import java.sql.Statement;


public class LogDeCompras {
    public String SQL_NombreTabla      ="LogCompras";
    public String SQL_IdLogCompras     ="_IdLogCompras";
    public String SQL_IdProducto       ="_IdProducto";
    public String SQL_TotalProducto    ="_TotalProducto";
    public String SQL_PrecioCompra   ="_PrecioCompra";
    public String SQL_PrecioVenta      ="PrecioVenta";
    public String SQL_FechaLog         ="_FechaLog";
    
    private String IdLogCompra          ="";
    private String IdProducto           ="";
    private String TotalProducto        ="";
    private String PrecioAnterior       ="";
    private String NuevoPrecio          ="";
    private String FechaLog             ="";
    private Statement conexion;
    
    public LogDeCompras(){
        try{
            conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_FORWARD_ONLY);
            this.crearDBLog();
        }catch(Exception e){
            System.out.println(""+e.getMessage());
        }
    }
    
    
    public void guardar()
    {
        String sql="insert into "+this.SQL_NombreTabla+
                            "("+this.SQL_IdProducto+","+this.SQL_TotalProducto+","+this.SQL_PrecioCompra+","+this.SQL_PrecioVenta+","+this.SQL_FechaLog+") values("
                               +this.getIdProducto()+","+this.getTotalProducto()+","+this.getPrecioAnterior()+","+this.getNuevoPrecio()+",'"+this.getFechaLog()+"')";
            try{
                    
                    
                     conexion.execute(sql);
                     conexion.close();
            }catch(Exception e){
            System.out.println("error en guardar log: "+e.getMessage()+" __"+sql);
            }
        
   }
    
    
    public void crearDBLog(){
        try{
                String sql="create table "+this.SQL_NombreTabla+"("+this.SQL_IdLogCompras+" int(10) primary key auto_increment,"+this.SQL_IdProducto+" int(10),"+this.SQL_TotalProducto+" int(10),"+this.SQL_PrecioCompra+" int(10),"+this.SQL_PrecioVenta+" int(10),"+this.SQL_FechaLog+" varchar(10))";
                conexion.execute(sql);
                
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getFechaLog() {
        return FechaLog;
    }

    public String getIdLogCompra() {
        return IdLogCompra;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public String getNuevoPrecio() {
        return NuevoPrecio;
    }

    public String getPrecioAnterior() {
        return PrecioAnterior;
    }

    public String getTotalProducto() {
        return TotalProducto;
    }

    public void setFechaLog(String FechaLog) {
        this.FechaLog = FechaLog;
    }

    public void setIdLogCompra(String IdLogCompra) {
        this.IdLogCompra = IdLogCompra;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public void setNuevoPrecio(String NuevoPrecio) {
        this.NuevoPrecio = NuevoPrecio;
    }

    public void setPrecioAnterior(String PrecioAnterior) {
        this.PrecioAnterior = PrecioAnterior;
    }

    public void setTotalProducto(String TotalProducto) {
        this.TotalProducto = TotalProducto;
    }
}

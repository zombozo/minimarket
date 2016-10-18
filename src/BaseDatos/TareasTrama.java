/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author zombozo
 */
public class TareasTrama {
    private String tramas;
    private String resultado;
    private String transaccion;
    public TareasTrama(){
        
    }
    
    public String creaDB(){
            try{
                Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_FORWARD_ONLY);
                String sql=" create table trama(id int(10) primary key auto_increment, trama varchar(75), resultado varchar(20), codigo_transaccion varchar(10))  ";
                conexion.execute(sql);
                conexion.close();
            }catch(Exception e){
                 //return e.getMessage();
            }
            
            return " creado con exito! ";
    }
    
    public void guardar(){
        try{
           Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_FORWARD_ONLY);
           String sql="INSERT INTO trama(trama, resultado) values('"+this.tramas+"','"+this.resultado+"','"+this.transaccion+"')";
           conexion.execute(sql);
           conexion.close();
        }catch(Exception e){
            
        }
        
    }

    public String getResultado() {
        return resultado;
    }

    public String getTramas() {
        return tramas;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setTramas(String tramas) {
        this.tramas = tramas;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }
    
}

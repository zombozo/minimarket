
package BaseDatos;


import java.sql.*;




public class ConectarMysql {  
    private static Connection conexion= null;
    public static Connection obtenerConexion(){
        if(conexion==null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/MiniMarket","root","");
            }catch(SQLException e){
                
            } catch (ClassNotFoundException ex) {
                
            }
            
            
        }
        return conexion;
        
    }
    
    public static void cerrar() throws SQLException{
        if(conexion!=null){
            conexion.close();
        }
    }
    
    public void crearDB(){
        
    }
}

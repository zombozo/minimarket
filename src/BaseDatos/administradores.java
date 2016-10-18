
package BaseDatos;

import java.sql.ResultSet;
import java.sql.Statement;


    public class administradores {
 public static String             nombreTabla="administradores";
 public static String             id_cuenta="Id_cuenta";
 public static String             nombre_completo="nombre_completo";
 public static String             Numero_telefonico="numero_telefonico";
 public static String             nombre_cuenta="nombre_cuenta";
 public static String             contraseña="contraseña";
 public static String             Nivel_de_permiso="nivel_permiso";
 public  static String             mensaje;

 private String             StringNombre;
 private String             StringTelefono;
 private String             StringCuenta;
 private String             StringContraseña;
 private int                Stringpermiso;

    
    public administradores(){
        
     
       
    }

    public String getStringContraseña() {
        return StringContraseña;
    }

    public String getStringCuenta() {
        return StringCuenta;
    }

    public String getStringNombre() {
        return StringNombre;
    }

    public String getStringTelefono() {
        return StringTelefono;
    }

    public int getStringpermiso() {
        return Stringpermiso;
    }

    public void setStringContraseña(String StringContraseña) {
        this.StringContraseña = StringContraseña;
    }

    public void setStringCuenta(String StringCuenta) {
        this.StringCuenta = StringCuenta;
    }

    public void setStringNombre(String StringNombre) {
        this.StringNombre = StringNombre;
    }

    public void setStringTelefono(String StringTelefono) {
        this.StringTelefono = StringTelefono;
    }

    public void setStringpermiso(int Stringpermiso) {
        this.Stringpermiso = Stringpermiso;
    }

    public static void CrearDB(){
        try{
            Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            String consulta="create table "+nombreTabla+"("+id_cuenta+" int(10) primary key auto_increment,"+
                    nombre_completo+" varchar(30),"+Numero_telefonico+" varchar(30),"+nombre_cuenta+" varchar(30),"+
                    contraseña+" varchar(30),"+Nivel_de_permiso+" int(5))";
                    conexion.execute(consulta);
                    conexion.close();
        }catch(Exception e){
            
        }
                
    }
    
    public boolean insertaAdministrador(){
        boolean estado=true;
        try{
            Statement conexion=ConectarMysql.obtenerConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            String consulta="insert into "+nombreTabla+"("+nombre_completo+","+Numero_telefonico+","+
                    nombre_cuenta+","+contraseña+","+Nivel_de_permiso+") values('"+this.StringNombre+"','"+
                    this.StringTelefono+"','"+this.StringCuenta+"','"+this.StringContraseña+"','"+this.Stringpermiso+"')";
            conexion.execute(consulta);
        
        }catch(Exception e){
            estado=false;
            mensaje=" error: la maquina dice :"+e.getMessage();
        }
      return estado;          
    }
}

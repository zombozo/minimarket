/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author zombozo
 */
public class ItemsMenu {
    JMenu menu;
    JMenuBar barra;
    ArrayList<JMenuItem> items;
    
    public ItemsMenu(){
        items=new ArrayList<>();
        barra=new JMenuBar();
        menu=new JMenu("Operaciones");
        barra.add(menu);
        
        items.add(new JMenuItem("Nueva Compra"));
        items.add(new JMenuItem("Nuevo Proveedor"));
        items.add(new JMenuItem("Nuevo Producto"));
        
        items.add(new JMenuItem("Nueva Venta"));
        items.add(new JMenuItem("Nuevo Contenedor"));
        items.add(new JMenuItem("Exportar Datos"));
        items.add(new JMenuItem("crear fabricante"));
        
       
    }
    
    public ArrayList items(){
        return items;
    }
    
    public boolean metodos(int a){
        String[] args={};
    
        if(a==0){
         Compra.main(args);

        }else if(a==1){
            PantallaProveedores.main(args);
        }else if(a==2){
            registroProducto.main(args);
        }else if(a==3){
            pantallaVentas.main(args);
                    
        }else if(a==4){
            contenedores.main(args);
        }else if(a==5){
           ExportarDatos.main(args);
        }else if(a==6){
            fabricante.main(args);
        }
        return true;
    }
}

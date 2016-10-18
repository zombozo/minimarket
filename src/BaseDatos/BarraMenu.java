/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;


import java.util.ArrayList;
import javax.swing.JMenu;

import javax.swing.JMenuItem;

/**
 *
 * @author zombozo
 */
public class BarraMenu {
    public static String NombresMenu;
   public static ArrayList<JMenuItem> items=new ArrayList<>();
   public static ArrayList<JMenu> Jmenus;
    
    public static void AgregaItem(String NombreItem){
        JMenuItem item=new JMenuItem(NombreItem);
        items.add(item);
    }
    public static void AgregaMenu(String NombreMenu){
        NombresMenu=NombreMenu;
        
        JMenu menu=new JMenu(NombreMenu);
        
        for(int a=0;a<items.size();a++){
            menu.add(items.get(a));
        }
        
        
    }
    
 public static ArrayList<JMenu> RetornaArraYItems(){
     
     
     return Jmenus;
 }
    public void agregarItemsAmenu(){
        
    }
}

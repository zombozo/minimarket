/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.util.Calendar;

/**
 *
 * @author zombozo
 */
public class variables_globales {
    public static String fecha() {
        Calendar calendario=Calendar.getInstance();
        int tempo=calendario.get(Calendar.DATE);
        int tempo2=calendario.get(Calendar.MONTH)+1;
        int tempo3=calendario.get(Calendar.YEAR);
        String dia,mes, año;
        if(tempo<10){
            dia="0"+tempo;
        }else{
            dia=""+tempo;
        }
        if(tempo2<10){
            mes="0"+tempo2;
        }else{
            mes=""+tempo2;
        }
        if(tempo3<10){
            año="0"+tempo3;
        }else{
            año=""+tempo3;
        }
        
        return ""+dia+"/"+mes+"/"+año;
    }
}

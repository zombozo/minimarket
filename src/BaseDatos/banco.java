/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author zombozo
 */
public class banco extends javax.swing.JFrame {
public boolean estado=true;
        String ips="";
       int puertos;
      static Socket soket;
      static PrintStream salida;
      static Scanner entrada;
       String trama;
       Thread hilo;  
       persona persona=new persona(1);
       
       
       
    /**
     * Creates new form banco
     */
    public banco() {
        initComponents();
        agregarItems();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ip = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        puerto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        cuenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        monto = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        Conectar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        operaciones = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ingresa los datos para lograr la consulta");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ip");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Puerto");

        puerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puertoActionPerformed(evt);
            }
        });

        jLabel4.setText("Log de la conexion");

        log.setColumns(20);
        log.setRows(5);
        jScrollPane1.setViewportView(log);

        jLabel5.setText("Codigo de la cuenta:");

        jLabel6.setText("Monto:");

        jButton2.setText("Ejecutar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Conectar.setText("Conectar");
        Conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConectarActionPerformed(evt);
            }
        });

        operaciones.setText("Operaciones");
        jMenuBar1.add(operaciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ip)
                                    .addComponent(puerto, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                                .addGap(117, 117, 117))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Conectar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addGap(0, 118, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Conectar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        String fecha=fecha();
        String hora=hora();
        /*   comprueba que los campos no esten vacios ,  si estan vacios obtiene los datos
        */
        estado=true;
        estado=this.cuenta.getText().isEmpty();
        estado |=this.monto.getText().isEmpty();
        if(estado==false){ // si es falso el estado ningun campo esta vacio
            String cuenta=this.cuenta.getText().toString();
        String monto=this.monto.getText().toString();
        String codigoNegocio="00001";
        String codigoSucursal="00001";
        String codTransaccion="003";
        String estado="000";
        if(monto.length()<10){
            int cantidad=monto.length();
            for(int a=cantidad;a<=10;a++){
                monto="0"+monto;
            }
        }
        
        if(cuenta.length()<10){ // comprueba el tamaño de el numero de la cuenta
            JOptionPane.showMessageDialog(rootPane, "el numero de cuenta no es valido");
        }
        
       trama=""+fecha+""+hora+""+cuenta+""+monto+""+codigoNegocio+""+codigoSucursal+""+codTransaccion+""+estado;
       persona.enviaConsulta();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void puertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_puertoActionPerformed

    private void ConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConectarActionPerformed
        // al clicar el boton de conectar 
        
        estado =this.ip.getText().isEmpty();
        estado |=this.puerto.getText().isEmpty();

        if(estado==false){ // si esta falso los campos estan llenos
            ips=ip.getText().toString();
            puertos=Integer.parseInt(puerto.getText().toString());
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "los datos para la conexion estan vacios ");
        }
        hilo=new persona(1);
        hilo.start();
    }//GEN-LAST:event_ConectarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(banco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(banco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(banco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(banco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new banco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Conectar;
    private javax.swing.JTextField cuenta;
    private javax.swing.JTextField ip;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea log;
    private javax.swing.JTextField monto;
    private javax.swing.JMenu operaciones;
    private javax.swing.JTextField puerto;
    // End of variables declaration//GEN-END:variables

private void agregarItems() {
         ArrayList<JMenuItem> items;
        ItemsMenu obtenerItems=new ItemsMenu();
        items=obtenerItems.items();
        for(int a=0;a<items.size();a++){
            
            int b=a;
            operaciones.add(items.get(a));
            items.get(a).addActionListener(new ActionListener(){
                boolean estados;
                @Override
                public void actionPerformed(ActionEvent e) {
                  // JOptionPane.showMessageDialog(rootPane, e.getActionCommand());
                 estados=obtenerItems.metodos(b);
                 if(estados==true){
                    cerrar();
                 }
                }
            });
       }
      
        
    }

   void cerrar(){
        this.dispose();
    }

    private String fecha() {
        String fecha="";
        String diass="";
        String mess="";
        Calendar calendario=Calendar.getInstance();
    int dia = calendario.get(Calendar.DATE);
    int mes=  calendario.get(Calendar.MONTH)+1;
    if(dia<10){
        diass="0"+dia;
       
    }else{
        diass=""+dia;
    }
    if(mes<10){
         mess="0"+mes;
     }else{
        mess=""+mes;
    }
    int ano=  calendario.get(Calendar.YEAR);
    fecha=diass+mess+ano;
        return fecha;
    }

    private String hora() {
        String hora,temp;
       Calendar calendario=Calendar.getInstance();
       int horas,minutos,segundos;
       horas=calendario.get(Calendar.HOUR_OF_DAY)+1;
       if(horas<10){
           temp="0"+horas;
       }else{
           temp=""+horas;
       }
       minutos=calendario.get(Calendar.MINUTE)+1;
       if(minutos<10){
           temp=temp+"0"+minutos;
       }else{
           temp=temp+minutos;
       }
       segundos=calendario.get(Calendar.SECOND);
       if(segundos<10){
           temp=temp+"0"+segundos;
       }else{
           temp=temp+segundos;
       }
       hora=temp;
       
       return hora;
    }
   
   
   
   public class persona extends Thread{
                    
       int id;
       
       public persona(int ids){this.id=ids;}
       
       
       public  void enviaConsulta(){
           if(soket.isClosed()){
               log.append("no se pueden enviar, la conexion esta cerrada");
            }else{
                 salida.println(trama);
           }
   }
       @Override
       public void run(){
           
           String respuesta;
           if(estado==false)
           {
                    try{
                     soket=new Socket(ips,puertos);
                     salida=new PrintStream(soket.getOutputStream());
                     entrada=new Scanner(soket.getInputStream());
                     
                     if(soket.isConnected()){
                         log.append("conectado");
                     }else{
                        log.append("no conectado");
                     }
                     do{
                     respuesta=entrada.nextLine();
                     System.out.println(respuesta);
                     log.append("\n servidor: "+respuesta);
                     String codigo_transaccion = trama.substring(47,50);
                     String estado=trama.substring(id);
                     if(respuesta!=null){
                         TareasTrama guardatrama=new TareasTrama();
                         guardatrama.setTramas(trama);
                         guardatrama.setResultado(estado);
                         guardatrama.setTransaccion(trama.substring(50,60));
                     }
                     lectorRespuesta(codigo_transaccion);
                     }while(soket.isClosed()!=true);
                    
                    // si la transaccion es valida agrega secuencial . fecha banco, hora bancon, 
                     //si tiene error regresa la misma cadena , cambiando estado y el resto de la cadena esta en ceros
                    // si se realiza una consulta el codigo de transaccion debe ir en ceros, y se envia en codigo de transaccion el tipo de transaccion ( pago, deposito y consulta
                    
                    }catch(IOException e){
                     log.append("\n error: "+e.getMessage());
                 } 
           }else{
               log.append("\n error ! no as dado una direccion para la conexion");
           }
           
       }

        private void lectorRespuesta(String respuesta) {
           if(respuesta.equals("000")){
               // ok
               JOptionPane.showMessageDialog(rootPane, "el servidor dice: se a realizado la transaccion corectamente");
           }else if(respuesta.equals("001")){
               //cuenta no valida
               JOptionPane.showMessageDialog(rootPane, "servidor: en No. de cuenta no es valido");
           }else if(respuesta.equals("002")){
               // fondos insuficientes
               JOptionPane.showMessageDialog(rootPane, "servidor: fondos insuficientes");
           }else if(respuesta.equals("003")){
               // registro invalido
               JOptionPane.showMessageDialog(rootPane, "servidor: no es valido el registo");
           }else if(respuesta.equals("004")){
               // tiempo fuera
               JOptionPane.showMessageDialog(rootPane, "servidor: error! la consulta a tardado demaciado tiempo ");
           }
        }
       
       
      
   }

   }

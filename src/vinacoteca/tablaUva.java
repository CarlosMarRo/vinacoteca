/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinacoteca;

import model.tipoUvaTableModel;
import Data.TipoUvaContenedor;
import vinacoteca.TipoUva;
import Data.VinoContenedor;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.vinoTableModel;

/**
 *
 * @author Carlos Marchante
 */
public class tablaUva extends javax.swing.JFrame {

    TipoUva tipoUva;
    TipoUvaContenedor tipoUvaContenedor =  new TipoUvaContenedor();
    tipoUvaTableModel tipouvatablemodel = new tipoUvaTableModel(tipoUvaContenedor);
    
        
    public tablaUva() {
        initComponents();
        
        //Permite seleccionar solo una fila.
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Muestra los datos 
        mostrarDatos();
        
        //Crear un comboBox para que sea el editor de la columna
        
    }
        
    
    public void mostrarDatos(){
        
        TipoUva tipoUva1 = new TipoUva(1,"Tempranillo","Uva tinta de piel gruesa","Negro azulado" );
        tipoUvaContenedor.getListaUvas().add(tipoUva1);
        TipoUva  tipoUva2= new TipoUva(2,"Mencia","Uva tinta de piel gruesa y Racimos pequeños","Negro azulado" );
        tipoUvaContenedor.getListaUvas().add(tipoUva2);
        TipoUva tipoUva3 = new TipoUva(3,"Albariño","Uva blanca de sabor suave y fresco","Amarillo Palliza" );
        tipoUvaContenedor.getListaUvas().add(tipoUva3);
        TipoUva tipoUva4 = new TipoUva(4,"Alarije","Uva blanca de sabor suave y fresco","Blanca");
        tipoUvaContenedor.getListaUvas().add(tipoUva4);
        TipoUva tipoUva5 = new TipoUva(5,"Airén", "Racimos grandes y apretados" , "Blanca");
        tipoUvaContenedor.getListaUvas().add(tipoUva5);
        TipoUva tipoUva6 = new TipoUva(6,"Albarello", "Uva blanca de racimos pequeños", "Blanca");
        tipoUvaContenedor.getListaUvas().add(tipoUva6); 
        
        //Rellenar la tabla con los datos.
        tipouvatablemodel = new tipoUvaTableModel(tipoUvaContenedor);
        jTable1.setModel(tipouvatablemodel);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Caracteristicas", "Color"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonGuardar.setText("Aceptar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButton2))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
         /* Aquí hay que actualizar los datos del objeto obtenido del ArrayList
+          a partir de los datos que se encuentren en pantalla*/
        
        
        //Actualiza en la tabla los datos modificados.
        tipouvatablemodel.fireTableRowsUpdated(jTable1.getSelectedRow(), jTable1.getSelectedRow());
    }//GEN-LAST:event_jButtonGuardarActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tablaUva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablaUva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablaUva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablaUva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablaUva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

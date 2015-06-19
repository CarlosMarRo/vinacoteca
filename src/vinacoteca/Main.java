/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinacoteca;

import vinacoteca.TipoUva;
import Data.TipoUvaContenedor;
import Data.Vino;
import Data.VinoContenedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.vinoTableModel;
import renderer.RendererPrecio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Carlos Marchante
 */
public class Main extends javax.swing.JFrame {

    private TipoUvaContenedor tipoUvaContenedor = new TipoUvaContenedor();
    private VinoContenedor vinoContenedor = new VinoContenedor();
    private Vino vino;
    private boolean creaVino = false;
    private static EntityManager entityManager;
    private Query consulta;
    private final vinoTableModel model = new vinoTableModel();

    public Main() {
       
        entityManager = Persistence.createEntityManagerFactory("VinacotecaPU").createEntityManager();
        
        initComponents();
        
        if (entityManager != null) {
            consulta = entityManager.createNamedQuery("Vino_1.findAll");
            VinoContenedor.setDataList(consulta.getResultList());
            consulta = entityManager.createNamedQuery("Uva.findAll");
            TipoUvaContenedor.setDataList(consulta.getResultList());

        }



        CargarDatos();

        //Campos de textos no editables.
        jTextFieldNombre.setEditable(false);
        jTextFieldFecha.setEditable(false);
        jTextFieldOrigen.setEditable(false);
        jTextFieldPrecio.setEditable(false);
        jCheckBoxDenominacion.setEnabled(false);
        jComboBox1.setEnabled(false);
        jPanel1.setEnabled(false);

        //Rellenar ComboBox de tipo de uvas
        jComboBox1.setModel(new DefaultComboBoxModel(tipoUvaContenedor.getListaUvas().toArray()));


        //Selecciona solo una fila
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Detecta el cambio de valor de la seleccion
        jTable1.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        mostrarRegistro();
                    }
                });


        jTable1.setModel(model);

        //Da formato a el precio
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new RendererPrecio());

    }

    public void mostrarRegistro() {
        int indexSelectedRow = jTable1.getSelectedRow();
        if (indexSelectedRow < 0) {
            jTextFieldNombre.setText("Sin Seleccion");
            jTextFieldOrigen.setText("Sin Seleccion");
            jTextFieldPrecio.setText("Sin Seleccion");
            jTextFieldFecha.setText("Sin Seleccion");

        } else {
            Vino v = (Vino) VinoContenedor.getListaVinos().get(indexSelectedRow);
            jTextFieldNombre.setText(v.getNombre());
            jTextFieldOrigen.setText(v.getOrigen());
            jTextFieldPrecio.setText(String.valueOf(v.getPrecio()));
            jTextFieldFecha.setText(v.getFecha());
        }
    }

    public void CargarDatos() {

        TipoUva tipoUva0 = new TipoUva();
        tipoUvaContenedor.getListaUvas().add(tipoUva0);
        TipoUva tipoUva1 = new TipoUva(1, "Tempranillo", "Uva tinta de piel gruesa", "Negro azulado");
        tipoUvaContenedor.getListaUvas().add(tipoUva1);
        TipoUva tipoUva2 = new TipoUva(2, "Mencia", "Uva tinta de piel gruesa y Racimos pequeños", "Negro azulado");
        tipoUvaContenedor.getListaUvas().add(tipoUva2);
        TipoUva tipoUva3 = new TipoUva(3, "Albariño", "Uva blanca de sabor suave y fresco", "Amarillo Palliza");
        tipoUvaContenedor.getListaUvas().add(tipoUva3);
        TipoUva tipoUva4 = new TipoUva(4, "Alarije", "Uva blanca de sabor suave y fresco", "Blanca");
        tipoUvaContenedor.getListaUvas().add(tipoUva4);
        TipoUva tipoUva5 = new TipoUva(5, "Airén", "Racimos grandes y apretados", "Blanca");
        tipoUvaContenedor.getListaUvas().add(tipoUva5);
        TipoUva tipoUva6 = new TipoUva(6, "Albarello", "Uva blanca de racimos pequeños", "Blanca");
        tipoUvaContenedor.getListaUvas().add(tipoUva6);

        vino = new Vino(1, "Corullón", 35.95, "Bierzo", "2012", tipoUva2, true);
        vinoContenedor.getListaVinos().add(vino);
        vino = new Vino(2, "Artadi Pagos Viejos", 61.85, "La Rioja", "2007", tipoUva1, false);
        vinoContenedor.getListaVinos().add(vino);
        vino = new Vino(3, "Iwine", 21.95, "Rias Baixas", "2014", tipoUva3, true);
        vinoContenedor.getListaVinos().add(vino);






    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAñadir = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldOrigen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldFecha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonAgregUva = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jCheckBoxDenominacion = new javax.swing.JCheckBox();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jButtonHistorial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonAñadir.setText("Añadir");
        jButtonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Imagen");

        jLabel1.setText("Nombre :");

        jLabel2.setText("Origen :");

        jTextFieldOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOrigenActionPerformed(evt);
            }
        });

        jLabel3.setText("Precio :");

        jLabel4.setText("Fecha :");

        jLabel5.setText("Tipo de Uva : ");

        jButtonAgregUva.setText("+");

        jLabel6.setText("Denominación :");

        jButtonGuardar.setText("Guardar");

        jButtonCancelar.setText("Cancelar");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxDenominacion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButtonGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar)))
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(jTextFieldNombre))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(jTextFieldOrigen))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(jTextFieldFecha))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAgregUva)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addComponent(jCheckBoxDenominacion))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAgregUva)))
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonHistorial.setText("Historial");
        jButtonHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAñadir)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonHistorial)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonModificar)
                            .addComponent(jButtonEliminar)
                            .addComponent(jButtonAñadir)
                            .addComponent(jButtonHistorial)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(198, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirActionPerformed
        //Hace una nueva transaccion
        entityManager.getTransaction().begin();
        //Añadimos los campos de los 

        String nombre = jTextFieldNombre.getText();
        String origen = jTextFieldOrigen.getText();
        String precio = jTextFieldPrecio.getText();
        String fecha = jTextFieldFecha.getText();

        //creamos el jugador
        Vino vino1 = new Vino(0, nombre, WIDTH, origen, fecha, null, creaVino);
        entityManager.persist(vino1);
        entityManager.getTransaction().commit();

        //Añadimos el jugador a la lista
        VinoContenedor.getListaVinos().add(vino1);
        model.fireTableDataChanged();


    }//GEN-LAST:event_jButtonAñadirActionPerformed

    private void jTextFieldOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOrigenActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        //Elimina el jugador de la lista
        VinoContenedor.getListaVinos().remove(jTable1.getSelectedRow());

        //Elimina el jugador de la base de datos
        entityManager.getTransaction().begin();
        Vino vino2 = (Vino) VinoContenedor.getListaVinos().get(jTable1.getSelectedRow());
        entityManager.remove(vino2);
        entityManager.getTransaction().commit();
        model.fireTableRowsDeleted(jTable1.getSelectedRow(), jTable1.getSelectedRow());
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHistorialActionPerformed
        Connection con;
        try {
            //nos conecta con el archivo
            con = DriverManager.getConnection("jdbc:mysql://localhost/vinacoteca", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Vino");

            try {
                Map parameters = new HashMap();
                JasperReport jasperReport = JasperCompileManager.compileReport(
                        //Poner el nombre del archivo que te crea el programa de jasperReport
                        "./vinacoteca.jrxml");
                JasperPrint jasperPrint = JasperFillManager.fillReport(
                        jasperReport, parameters, new JRResultSetDataSource(rs));
                JasperViewer.viewReport(jasperPrint);
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonHistorialActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregUva;
    private javax.swing.JButton jButtonAñadir;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonHistorial;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JCheckBox jCheckBoxDenominacion;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldOrigen;
    private javax.swing.JTextField jTextFieldPrecio;
    // End of variables declaration//GEN-END:variables
}

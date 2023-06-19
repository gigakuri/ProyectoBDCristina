/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package application;

import static application.MaquinaExpendedora.crearVentana;
import controllers.exceptions.NonexistentEntityException;
import copias.Utilidades;
import entities.Maquinas;
import entities.Productos;
import entities.Ventas;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author cristina
 */
public class PanelCopiasSeguridad extends javax.swing.JPanel {
    
    private static JFrame copiasSeguridad;

    /**
     * Creates new form PanelCopiasSeguridad
     */
    public PanelCopiasSeguridad() {
        initComponents();

        jList1.setListData(Utilidades.listarDirectorio("./copias"));
        copiasSeguridad = MaquinaExpendedora.crearVentana("Copias de Seguridad", this);
        copiasSeguridad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(750, 500));
        setMinimumSize(new java.awt.Dimension(750, 500));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(750, 500));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.setBackground(new java.awt.Color(255, 255, 255));
        jList1.setForeground(new java.awt.Color(0, 51, 51));
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 738, 413));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Seleccionar");
        jButton1.setRequestFocusEnabled(false);
        jButton1.setRolloverEnabled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        String linea = jList1.getSelectedValue();
        /* tiene que tener una copia seleccionada */
        if (linea != null) {
            //SE BORRAN LOS DATOS
            try {
                for (Ventas venta : Consultas.ventaJPA.findVentasEntities()) {
                    Consultas.ventaJPA.destroy(venta.getIdVenta());
                }
                for (Productos producto : Consultas.productoJPA.findProductosEntities()) {
                    Consultas.productoJPA.destroy(producto.getIdProducto());
                }
                for (Maquinas maquina : Consultas.maquinaJPA.findMaquinasEntities()) {
                    Consultas.maquinaJPA.destroy(maquina.getIdMaquina());
                }
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(PanelCopiasSeguridad.class.getName()).log(Level.SEVERE, null, ex);
            }

            //SE LEEN LOS DATOS DE LOS FICHEROS .CSV
            List<String> datosMaquinas = Utilidades.leerFicheroTexto(linea.trim(), "Maquinas");
            List<String> datosProductos = Utilidades.leerFicheroTexto(linea.trim(), "Productos");
            List<String> datosVentas = Utilidades.leerFicheroTexto(linea.trim(), "Ventas");

            //SE CREAN LAS LISTAS DE OBJETOS Y SE VUELCAN LOS DATOS
            List<Maquinas> listaMaquinas = Utilidades.generarMaquinas(datosMaquinas);
            for (Maquinas maquina : listaMaquinas) {
                Consultas.maquinaJPA.create(maquina);
            }
            
            List<Productos> listaProductos = Utilidades.generarProductos(datosProductos);
            for (Productos producto : listaProductos) {
                Consultas.productoJPA.create(producto);
            }
            
            List<Ventas> listaVentas = Utilidades.generarVentas(datosVentas);
            for (Ventas venta : listaVentas) {
                Consultas.ventaJPA.create(venta);
            }
            
            //CERRAR COPIAS Y ABRIR PANEL PRINCIPAL
            copiasSeguridad.dispose();
            try {
                new PanelMaquinaExpendedora();
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(PanelCopiasSeguridad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package application;

import controllers.exceptions.NonexistentEntityException;
import entities.Ventas;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author cristina
 */
public class PanelMaquinaExpendedora extends javax.swing.JPanel {

    private static String tipoPago;

    /**
     * Creates new form PanelMaquinaExpendedora
     */
    public PanelMaquinaExpendedora() throws NonexistentEntityException {
        initComponents();
        ListCellRenderer cellRenderer = new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                String text = value.toString();
                StringBuilder wrappedText = new StringBuilder("<html>");
                int comas = 0;

                for (int i = 0; i < text.length(); i++) {
                    char c = text.charAt(i);
                    wrappedText.append(c);
                    if (c == ',') {
                        comas++;
                    }

                    if (comas >= 4 && i < text.length() - 1) {
                        wrappedText.append("<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                        comas = 0;
                    }
                }

                wrappedText.append("</html>");
                renderer.setText(wrappedText.toString());

                return renderer;
            }
        };

        jList3.setCellRenderer(cellRenderer);

        jLabel5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botonCruz2.png")));;
            }
        });

        //Apartado de selección de máquinas oculto
        jLabel5.setVisible(false);
        jTextField2.setVisible(false);
        jButton4.setVisible(false);
        jList2.setVisible(false);
        jScrollPane3.setVisible(false);

        //Apartado de ventas en oculto
        jLabel11.setVisible(false);
        jLabel10.setVisible(false);
        jButton3.setVisible(false);
        jButton2.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jScrollPane1.setVisible(false);
        jList3.setVisible(false);

        //Mostrar lista de máquinas
        jList2.setListData(Consultas.maquinaJPA.verMaquinas());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setMaximumSize(new java.awt.Dimension(1050, 650));
        setMinimumSize(new java.awt.Dimension(1050, 650));
        setPreferredSize(new java.awt.Dimension(1050, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1050, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(1050, 700));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarjeta", "Efectivo" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 70, 20));

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botonCruz.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel15MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 530, -1, 40));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Ventas");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 140, 40));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 50, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/comprar-ahora.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 70, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/apagar.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 570, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(204, 204, 204));

        jList1.setBackground(new java.awt.Color(255, 255, 255));
        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jList1.setForeground(new java.awt.Color(0, 0, 0));
        jList1.setMaximumSize(new java.awt.Dimension(47, 80));
        jList1.setMinimumSize(new java.awt.Dimension(47, 80));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 220, 340));

        jList2.setBackground(new java.awt.Color(255, 255, 255));
        jList2.setBorder(null);
        jList2.setForeground(new java.awt.Color(0, 0, 0));
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 170, 70));

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 70, 30));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/peluche.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 480, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Selecciona una máquina:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/maquina.png"))); // NOI18N
        jLabel4.setFocusable(false);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, 550));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/poster2.jpg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/poster.jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jList3.setBackground(new java.awt.Color(255, 255, 255));
        jList3.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jList3);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 260, 140));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Modificar venta");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 120, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Modifcar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Borrar venta");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 100, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Borrar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flechas-hacia-abajo.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flecha-der.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));

        jButton4.setBackground(new java.awt.Color(204, 255, 204));
        jButton4.setForeground(new java.awt.Color(0, 51, 0));
        jButton4.setText("✔");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setRequestFocusEnabled(false);
        jButton4.setRolloverEnabled(false);
        jButton4.setVerifyInputWhenFocusTarget(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 40, 30));

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bombillas.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, -10, -1, 180));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        // TODO add your handling code here:
        //ID DE LA MÁQUINA SELECCIONADA EN EL JTEXTFIELD
        String linea = jList2.getSelectedValue();
        String[] tokens = linea.split("\\|");
        jTextField2.setText(tokens[0].trim());

    }//GEN-LAST:event_jList2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        /* SI LA MÁQUINA ESTÁ APAGADA */
        if (jLabel1.getIcon().toString().equals(getClass().getResource("/Images/apagar.png").toString())) {
            //MOSTRAR SELECCIÓN DE MÁQUINAS
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/encender.png")));
            jList2.setVisible(true);
            jScrollPane3.setVisible(true);
            jLabel5.setVisible(true);
            jTextField2.setVisible(true);
            jButton4.setVisible(true);
        } else {
            /* SI LA MÁQUINA ESTÁ ENCENDIDA */
            //OCULTAR SELECCIÓN DE MÁQUINAS
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/apagar.png")));
            jList2.setVisible(false);
            jScrollPane3.setVisible(false);
            jLabel5.setVisible(false);
            jTextField2.setVisible(false);
            jButton4.setVisible(false);
            jList2.setSelectedValue(null, true);
            /* quita la selección */
            jTextField2.setText("");
            /* vacía la pantalla de la máquina seleccionada */

            //OCULTAR VENTAS
            jList3.setVisible(false);
            jScrollPane1.setVisible(false);
            jLabel11.setVisible(false);
            jLabel10.setVisible(false);
            jButton3.setVisible(false);
            jButton2.setVisible(false);
            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
            jList1.setListData(new String[1]);
            /* vacía lista de productos de la máquina */
            jTextField1.setText("");
            /* vacía la pantalla del producto seleccionado */
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        String linea = jList1.getSelectedValue();
        // Si selecciona un producto, puede crear la venta
        if (linea != null) {
            String[] tokens = linea.split("\\|");
            jTextField1.setText(tokens[0].trim());

            //Tipo de pago
            tipoPago = jComboBox1.getSelectedItem().toString();

            //CREAR VENTA
            Consultas.ventaJPA.create(new Ventas(Date.valueOf(LocalDate.now()),
                    Consultas.productoJPA.findProductos(Integer.valueOf(tokens[0].trim())).getPrecio(),
                    tipoPago, Consultas.productoJPA.findProductos(Integer.valueOf(tokens[0].trim()))));

            /*refrescar lista*/
            try {
                jList3.setListData(Consultas.ventaJPA.verVentas());
            } catch (NonexistentEntityException ex) {
                // Exception
            }
        }

    }//GEN-LAST:event_jLabel9MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        // Si no hay nada seleccionado, no hace nada
        String linea = jList3.getSelectedValue();
        if (linea != null) {
            String[] tokens = linea.split(" , ");

            //BORRAR VENTA
            try {
                Consultas.ventaJPA.destroy(Integer.parseInt(tokens[0].split("➔ ")[1].trim()));
                /*refrescar lista*/
                jList3.setListData(Consultas.ventaJPA.verVentas());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(PanelMaquinaExpendedora.class.getName()).log(Level.SEVERE, null, ex);
            }
            jButton3.setBackground(Color.white);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        // SI LA MÁQUINA ESTÁ ENCENDIDA
        if (jLabel1.getIcon().toString().equals(getClass().getResource("/Images/encender.png").toString())) {
            //MOSTRAR VENTAS
            jScrollPane1.setVisible(true);
            jList3.setVisible(true);
            jLabel11.setVisible(true);
            jLabel10.setVisible(true);
            jButton3.setVisible(true);
            jButton2.setVisible(true);
            jLabel13.setVisible(true);
            jLabel14.setVisible(true);

            try {
                jList3.setListData(Consultas.ventaJPA.verVentas());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(PanelMaquinaExpendedora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        String linea = jList1.getSelectedValue();
        if (linea != null) {
            String[] tokens = linea.split("\\|");
            jTextField1.setText(tokens[0].trim());
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
        //CAMBIAR IMAGEN
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botonCruz2.png")));
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:

        //OCULTAR VENTAS
        jScrollPane1.setVisible(false);
        jList3.setVisible(false);
        jLabel11.setVisible(false);
        jLabel10.setVisible(false);
        jButton3.setVisible(false);
        jButton2.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        // VER PRODUCTOS DE LA MÁQUINA SELECCIONADA
        /* si el jTextField2 está vacío, no hace nada */
        if (!jTextField2.getText().equals("")) {
            try {
                jList1.setListData(Consultas.maquinaJPA.verProductos(Integer.parseInt(jTextField2.getText())));
            } catch (NonexistentEntityException ex) {
                // Si no existe la máquina seleccionada
            }
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jLabel15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseReleased
        // TODO add your handling code here:
        //CAMBIAR IMAGEN
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/botonCruz.png")));
    }//GEN-LAST:event_jLabel15MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

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
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author cristina
 */
public class PanelMaquinaExpendedora extends javax.swing.JPanel {

    private static String tipoPago;
    private static JFrame ventana;

    /**
     * Creates new form PanelMaquinaExpendedora
     */
    public PanelMaquinaExpendedora() throws NonexistentEntityException {
        initComponents();
        ListCellRenderer cellRenderer = new DefaultListCellRenderer() {

            //FORMATO PARA LOS JLIST
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
        jLabel18.setVisible(false);
        jLabel23.setVisible(false);

        //Apartado de ventas en oculto
        jLabel11.setVisible(false);
        jLabel10.setVisible(false);
        jButton3.setVisible(false);
        jButton2.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jScrollPane1.setVisible(false);
        jList3.setVisible(false);

        //Apartado de modificación ventas en oculto
        jLabel12.setVisible(false);
        jLabel16.setVisible(false);
        jTextField3.setVisible(false);
        jTextField5.setVisible(false);
        jTextField6.setVisible(false);
        jButton5.setVisible(false);
        jLabel19.setVisible(false);
        jLabel20.setVisible(false);
        jLabel22.setVisible(false);
        jLabel24.setVisible(false);
        jComboBox2.setVisible(false);

        //Apartado de añadir producto en oculto
        jLabel28.setVisible(false);
        jLabel29.setVisible(false);
        jLabel30.setVisible(false);
        jLabel31.setVisible(false);
        jTextField4.setVisible(false);
        jTextField7.setVisible(false);
        /*selección de máquina*/
        for (Maquinas maquina : Consultas.maquinaJPA.findMaquinasEntities()) {
                    jComboBox3.addItem(maquina.getIdMaquina().toString());
                }
        jComboBox3.setVisible(false);
        jButton6.setVisible(false);
        jLabel32.setVisible(false);

        //OCULTAR MODIFICAR PRODUCTO
        jButton7.setVisible(false);
        jLabel33.setVisible(false);
        jTextField8.setVisible(false);
        
        // OCULTAR BACKUP Y RESTAURAR
        jButton8.setVisible(false);
        jButton9.setVisible(false);
        
        // OCULTAR ELIMINAR, EDITAR, INSERTAR PRODUCTOS
        jLabel25.setVisible(false);
        jLabel26.setVisible(false);
        jLabel27.setVisible(false);
        
        // OCULTAR COMPRAR, TIPOPAGO, VENTAS, X
        jLabel9.setVisible(false);
        jComboBox1.setVisible(false);
        jButton1.setVisible(false);
        jLabel15.setVisible(false);

        //Mostrar lista de máquinas
        jList2.setListData(Consultas.maquinaJPA.verMaquinas());
        
        ventana = crearVentana("Máquina expendedora", this);

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
        jLabel21 = new javax.swing.JLabel();
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
        jLabel26 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel21.setText("jLabel21");

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
        jButton1.setRequestFocusEnabled(false);
        jButton1.setRolloverEnabled(false);
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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 180, 70));

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 70, 30));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Selecciona una máquina:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mas.png"))); // NOI18N
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 60, 50));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jList3.setBackground(new java.awt.Color(255, 255, 255));
        jList3.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jList3);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 260, 140));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Modificar venta");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 120, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar.png"))); // NOI18N
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 580, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/maquina.png"))); // NOI18N
        jLabel4.setFocusable(false);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, 550));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/poster2.jpg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Modifcar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setRequestFocusEnabled(false);
        jButton2.setRolloverEnabled(false);
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
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Borrar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setRequestFocusEnabled(false);
        jButton3.setRolloverEnabled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/parche.jpg"))); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 280, 230));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flecha-hacia-arriba.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, -1, -1));

        jButton4.setBackground(new java.awt.Color(192, 87, 87));
        jButton4.setForeground(new java.awt.Color(51, 0, 0));
        jButton4.setText("✔");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(158, 87, 87), new java.awt.Color(158, 87, 87), null, null));
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

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 0));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 80, -1));

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bombillas.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, -10, -1, 180));

        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setForeground(new java.awt.Color(0, 0, 0));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 380, 70, -1));

        jTextField6.setBackground(new java.awt.Color(255, 255, 255));
        jTextField6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 430, 90, -1));

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("ID VENTA");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 60, -1));

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("IMPORTE");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 360, 60, -1));

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/parche.jpg"))); // NOI18N
        jLabel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 130));

        jComboBox2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 430, 130, 20));

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("PRODUCTO");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, 70, -1));

        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("TIPO DE PAGO");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 410, 90, -1));

        jButton5.setBackground(new java.awt.Color(192, 87, 87));
        jButton5.setForeground(new java.awt.Color(51, 0, 0));
        jButton5.setText("✔");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(158, 87, 87), new java.awt.Color(158, 87, 87), null, new java.awt.Color(51, 51, 51)));
        jButton5.setRequestFocusEnabled(false);
        jButton5.setRolloverEnabled(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 480, 40, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/parche-der.jpg"))); // NOI18N
        jLabel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 310, 190));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flecha-hacia-arriba.png"))); // NOI18N
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flecha-der-arriba.png"))); // NOI18N
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 550, -1, -1));

        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("NOMBRE");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, 60, -1));

        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 130, -1));

        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("PRECIO");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 60, -1));

        jTextField7.setBackground(new java.awt.Color(255, 255, 255));
        jTextField7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 80, -1));

        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("ID MÁQUINA");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 80, -1));

        jButton6.setBackground(new java.awt.Color(192, 87, 87));
        jButton6.setForeground(new java.awt.Color(51, 0, 0));
        jButton6.setText("✔");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(158, 87, 87), new java.awt.Color(158, 87, 87), null, new java.awt.Color(153, 153, 153)));
        jButton6.setRequestFocusEnabled(false);
        jButton6.setRolloverEnabled(false);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 160, 40, 30));

        jComboBox3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 100, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/poster.jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flecha-der-arriba.png"))); // NOI18N
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 230, -1, -1));

        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("STOCK");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 100, 40, -1));

        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        jTextField8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 120, 70, -1));

        jButton7.setBackground(new java.awt.Color(192, 87, 87));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton7.setForeground(new java.awt.Color(51, 0, 0));
        jButton7.setText("MODIFICAR");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(158, 87, 87), new java.awt.Color(158, 87, 87), null, new java.awt.Color(153, 153, 153)));
        jButton7.setRequestFocusEnabled(false);
        jButton7.setRolloverEnabled(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 170, 70, 30));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/parche-der.jpg"))); // NOI18N
        jLabel28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 220, 170));

        jButton8.setBackground(new java.awt.Color(0, 51, 51));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("BACKUP");
        jButton8.setRequestFocusEnabled(false);
        jButton8.setRolloverEnabled(false);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 600, 90, 40));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/peluche.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 480, -1, -1));

        jButton9.setBackground(new java.awt.Color(0, 51, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("RESTAURAR");
        jButton9.setRequestFocusEnabled(false);
        jButton9.setRolloverEnabled(false);
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 110, 40));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/maceta.png"))); // NOI18N
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, -1));

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
            jLabel18.setVisible(true);
            jLabel23.setVisible(true);
            // MOSTRAR BACKUP Y RESTAURAR
            jButton8.setVisible(true);
            jButton9.setVisible(true);
            // MOSTRAR ELIMINAR, EDITAR, INSERTAR PRODUCTOS
            jLabel25.setVisible(true);
            jLabel26.setVisible(true);
            jLabel27.setVisible(true);
            // MOSTRAR COMPRAR, TIPOPAGO, VENTAS, X
            jLabel9.setVisible(true);
            jComboBox1.setVisible(true);
            jButton1.setVisible(true);
            jLabel15.setVisible(true);
        } else {
            /* SI LA MÁQUINA ESTÁ ENCENDIDA */
            //OCULTAR SELECCIÓN DE MÁQUINAS
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/apagar.png")));
            jList2.setVisible(false);
            jScrollPane3.setVisible(false);
            jLabel5.setVisible(false);
            jTextField2.setVisible(false);
            jButton4.setVisible(false);
            jLabel18.setVisible(false);
            jLabel23.setVisible(false);
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

            //OCULTAR MODIFICACIÓN DE VENTAS
            jLabel12.setVisible(false);
            jLabel16.setVisible(false);
            jTextField3.setVisible(false);
            jTextField5.setVisible(false);
            jTextField6.setVisible(false);
            jButton5.setVisible(false);
            jLabel19.setVisible(false);
            jLabel20.setVisible(false);
            jLabel22.setVisible(false);
            jLabel24.setVisible(false);
            jComboBox2.setVisible(false);

            //OCULTAR AÑADIR PRODUCTO
            jLabel28.setVisible(false);
            jLabel29.setVisible(false);
            jLabel30.setVisible(false);
            jLabel31.setVisible(false);
            jTextField4.setVisible(false);
            jTextField7.setVisible(false);
            jComboBox3.setVisible(false);
            jButton6.setVisible(false);
            jLabel32.setVisible(false);

            //OCULTAR MODIFICAR PRODUCTO
            jButton7.setVisible(false);
            jLabel33.setVisible(false);
            jTextField8.setVisible(false);
            
            // OCULTAR BACKUP Y RESTAURAR
            jButton8.setVisible(false);
            jButton9.setVisible(false);
            
            // OCULTAR ELIMINAR, EDITAR, INSERTAR PRODUCTOS
            jLabel25.setVisible(false);
            jLabel26.setVisible(false);
            jLabel27.setVisible(false);
            
            // OCULTAR COMPRAR, TIPOPAGO, VENTAS, X
            jLabel9.setVisible(false);
            jComboBox1.setVisible(false);
            jButton1.setVisible(false);
            jLabel15.setVisible(false);
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
                Logger.getLogger(PanelMaquinaExpendedora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jLabel9MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        // Si no hay nada seleccionado, no hace nada
        String linea = jList3.getSelectedValue();
        if (linea != null) {
            String[] tokens = linea.split(" , ");

            //MOSTRAR APARTADO DE MODIFICAR VENTAS
            jLabel12.setVisible(true);
            jLabel16.setVisible(true);
            jTextField3.setVisible(true);
            jTextField5.setVisible(true);
            jTextField6.setVisible(true);
            jButton5.setVisible(true);
            jLabel12.setVisible(true);
            jLabel19.setVisible(true);
            jLabel20.setVisible(true);
            jLabel22.setVisible(true);
            jLabel24.setVisible(true);
            jComboBox2.setVisible(true);
            jComboBox2.setMaximumRowCount(4);
            /*selección de productos*/
            jComboBox2.removeAllItems();
            for (Productos producto : Consultas.productoJPA.findProductosEntities()) {
                jComboBox2.addItem(producto.getNombre());
            }
            //Muestra la id de la venta seleccionada
            jTextField3.setText(tokens[0].split("➔ ")[1].trim());

            /*muestra como seleccionado el producto de la venta a modificar */
            try{
                jComboBox2.setSelectedIndex(Consultas.ventaJPA.findVentas(Integer.valueOf(tokens[0].split("➔ ")[1].trim())).getIdProducto().getIdProducto() - 1);
            } catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        // Si no hay nada seleccionado, no hace nada
        String linea = jList3.getSelectedValue();
        if (linea != null) {
            String[] tokens = linea.split(" , ");

            //BORRAR VENTA
            try {
                Consultas.ventaJPA.destroy(Integer.valueOf(tokens[0].split("➔ ")[1].trim()));
                /*refrescar lista*/
                jList3.setListData(Consultas.ventaJPA.verVentas());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(PanelMaquinaExpendedora.class.getName()).log(Level.SEVERE, null, ex);
            }
//            jButton3.setBackground(Color.white);
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
        //MUESTRA LA ID DEL PRODUCTO SELECCIONADO
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

        //OCULTAR MODIFICACIÓN DE VENTAS
        jLabel12.setVisible(false);
        jLabel16.setVisible(false);
        jTextField3.setVisible(false);
        jTextField5.setVisible(false);
        jTextField6.setVisible(false);
        jButton5.setVisible(false);
        jLabel19.setVisible(false);
        jLabel20.setVisible(false);
        jLabel22.setVisible(false);
        jLabel24.setVisible(false);
        jComboBox2.setVisible(false);

        //OCULTAR AÑADIR PRODUCTO
        jLabel28.setVisible(false);
        jLabel29.setVisible(false);
        jLabel30.setVisible(false);
        jLabel31.setVisible(false);
        jTextField4.setVisible(false);
        jTextField7.setVisible(false);
        jComboBox3.setVisible(false);
        jButton6.setVisible(false);
        jLabel32.setVisible(false);

        //OCULTAR MODIFICAR PRODUCTO
        jButton7.setVisible(false);
        jLabel33.setVisible(false);
        jTextField8.setVisible(false);
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

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:

        //MODIFICAR VENTA
        Ventas aux = new Ventas();
        aux.setIdVenta(Integer.valueOf(jTextField3.getText()));
        aux.setFecha(Consultas.ventaJPA.findVentas(Integer.valueOf(jTextField3.getText())).getFecha());
        if (jTextField5 != null) {
            try {
                aux.setImporte(BigDecimal.valueOf(Double.parseDouble(jTextField5.getText())));
            } catch (NumberFormatException nf) {
                aux.setImporte(Consultas.ventaJPA.findVentas(Integer.valueOf(jTextField3.getText())).getImporte());
            }
        } else {
            aux.setImporte(Consultas.ventaJPA.findVentas(Integer.valueOf(jTextField3.getText())).getImporte());
        }
        if (jTextField6 != null && (jTextField6.getText().equalsIgnoreCase("Efectivo")
                | jTextField6.getText().equalsIgnoreCase("Tarjeta"))) {
            aux.setTipoPago(jTextField6.getText());
        } else {
            aux.setTipoPago(Consultas.ventaJPA.findVentas(Integer.valueOf(jTextField3.getText())).getTipoPago());
        }
        for (Productos producto : Consultas.productoJPA.findProductosEntities()) {
            if (producto.getNombre().equalsIgnoreCase(jComboBox2.getSelectedItem().toString())) {
                aux.setIdProducto(producto);
            }
        }

        //Cambia la venta
        try {
            Consultas.ventaJPA.edit(aux);
            jTextField3.setText("");
            jTextField5.setText("");
            jTextField6.setText("");

            /*refrescar lista*/
            jList3.setListData(Consultas.ventaJPA.verVentas());
        } catch (Exception ex) {
            Logger.getLogger(PanelMaquinaExpendedora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton5MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
        // SI LA MÁQUINA ESTÁ ENCENDIDA
        if (jLabel1.getIcon().toString().equals(getClass().getResource("/Images/encender.png").toString())
                && !jLabel28.isVisible()) {
            /*y no está visible el apartado de modificar*/
            //MOSTRAR APARTADO AÑADIR PRODUCTO
            jLabel28.setVisible(true);
            jLabel29.setVisible(true);
            jLabel30.setVisible(true);
            jLabel31.setVisible(true);
            jTextField4.setVisible(true);
            jTextField7.setVisible(true);
            jComboBox3.setVisible(true);
            jButton6.setVisible(true);
            jLabel32.setVisible(true);
        }

    }//GEN-LAST:event_jLabel25MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        //CREAR NUEVO PRODUCTO
        /*si el nombre no está vacío*/
        if (jTextField4.getText() != null) {
            /*el precio tiene que ser menor de 10€ para añadir el producto*/
            if (Double.parseDouble(jTextField7.getText()) < 10) {
                Productos aux = new Productos();

                aux.setNombre(jTextField4.getText());
                aux.setPrecio(BigDecimal.valueOf(Double.parseDouble(jTextField7.getText())));
                aux.setIdMaquina(Consultas.maquinaJPA.findMaquinas(Integer.valueOf(jComboBox3.getSelectedItem().toString())));
                aux.setStock(20);

                try {
                    /*añade el producto*/
                    Consultas.productoJPA.create(aux);
                    jTextField4.setText("");
                    jTextField7.setText("");

                    /*refrescar lista*/
                    jList1.setListData(Consultas.maquinaJPA.verProductos(Integer.parseInt(jComboBox3.getSelectedItem().toString())));
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(PanelMaquinaExpendedora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }//GEN-LAST:event_jButton6MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
        String linea = jList1.getSelectedValue();
        /* Si selecciona un producto, puede borrarlo */
        if (linea != null) {
            try {
                String[] tokens = linea.split("\\|");
                jTextField1.setText(tokens[0].trim());

                //BORRAR PRODUCTO
                /*primero hay que borrar las ventas relacionadas con el producto, 
                comprobando que hayan ventas de ese producto, y si las hay, se borran*/
                for (Ventas venta : Consultas.ventaJPA.findVentasEntities()) {

                    if (Objects.equals(venta.getIdProducto().getIdProducto(), Integer.valueOf(tokens[0].trim()))) {
                        Consultas.ventaJPA.destroy(venta.getIdVenta());
                    }
                }
                /*eliminamos el producto seleccionado*/
                Consultas.productoJPA.destroy(Integer.valueOf(tokens[0].trim()));

                /*refrescar lista productos*/
                try {
                    jList1.setListData(Consultas.maquinaJPA.verProductos(Integer.parseInt(jTextField2.getText())));
                } catch (NumberFormatException nf) {
                    jList1.setListData(Consultas.maquinaJPA.verProductos(Integer.parseInt(jComboBox3.getSelectedItem().toString())));
                }
                /*refrescar lista ventas*/
                jList3.setListData(Consultas.ventaJPA.verVentas());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(PanelMaquinaExpendedora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        //MODIFICAR PRODUCTO
        String linea = jList1.getSelectedValue();
        String[] tokens = linea.split("\\|");
        Productos productoSeleccionado = Consultas.productoJPA.findProductos(Integer.valueOf(tokens[0].trim()));
        Productos aux = new Productos();
        /*el ID no cambia*/
        aux.setIdProducto(productoSeleccionado.getIdProducto());

        /*si el nombre no está vacío*/
        if (!"".equals(jTextField4.getText())) {
            aux.setNombre(jTextField4.getText());
        } else {
            aux.setNombre(productoSeleccionado.getNombre());
        }
        /*el precio tiene que ser menor de 10€ para modificar el producto*/
        if (Double.parseDouble(jTextField7.getText()) < 10 | !"".equals(jTextField7.getText())) {
            aux.setPrecio(BigDecimal.valueOf(Double.parseDouble(jTextField7.getText())));
        } else {
            aux.setPrecio(productoSeleccionado.getPrecio());
        }
            aux.setIdMaquina(Consultas.maquinaJPA.findMaquinas(Integer.valueOf(jComboBox3.getSelectedItem().toString())));
        /*si el stock no está vacío*/
        if (!"".equals(jTextField8.getText())) {
            aux.setStock(Integer.valueOf(jTextField8.getText()));
        } else {
            aux.setStock(productoSeleccionado.getStock());
        }

        try {
            /*cambia el producto*/
            Consultas.productoJPA.edit(aux);
            jTextField4.setText("");
            jTextField7.setText("");
            jTextField8.setText("");

            /*refrescar lista*/
            jList1.setListData(Consultas.maquinaJPA.verProductos(Integer.parseInt(jComboBox3.getSelectedItem().toString())));
        } catch (Exception ex) {
            Logger.getLogger(PanelMaquinaExpendedora.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton7MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
        //MOSTRAR MODIFICAR PRODUCTO
        // SI LA MÁQUINA ESTÁ ENCENDIDA
        if (jLabel1.getIcon().toString().equals(getClass().getResource("/Images/encender.png").toString())) {
            String linea = jList1.getSelectedValue();

            // Si selecciona un producto, puede modificarlo
            if (linea != null && !jLabel28.isVisible()) {

                //MOSTRAR APARTADO AÑADIR PRODUCTO
                jLabel28.setVisible(true);
                jLabel29.setVisible(true);
                jLabel30.setVisible(true);
                jLabel31.setVisible(true);
                jTextField4.setVisible(true);
                jTextField7.setVisible(true);
                jComboBox3.setVisible(true);
                jButton7.setVisible(true);
                jLabel32.setVisible(true);
                jLabel33.setVisible(true);
                jTextField8.setVisible(true);
            }
        }

    }//GEN-LAST:event_jLabel27MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
        //BACKUPS
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH'h'-mm'm'-ss's'");
        
        //CREA EL DIRECTORIO
        Utilidades.crearDirectorio("copias");
        Utilidades.crearDirectorio("./copias/" + LocalDateTime.now().format(formatter));
        
        //CREA LOS FICHEROS
        /*guarda los datos en una lista y escribe los csv*/
        List<Maquinas> listaMaquinas = Consultas.maquinaJPA.findMaquinasEntities();
        Utilidades.generarCSV("./copias/" + LocalDateTime.now().format(formatter) + "/Maquinas" + ".csv", listaMaquinas.toArray());
        List<Productos> listaProductos = Consultas.productoJPA.findProductosEntities();
        Utilidades.generarCSV("./copias/" + LocalDateTime.now().format(formatter) + "/Productos" + ".csv", listaProductos.toArray());
        List<Ventas> listaVentas = Consultas.ventaJPA.findVentasEntities();
        Utilidades.generarCSV("./copias/" + LocalDateTime.now().format(formatter) + "/Ventas" + ".csv", listaVentas.toArray());

    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
        //LISTAR DIRECTORIO COPIAS
        new PanelCopiasSeguridad();
        
        //CERRAR VENTANA
        ventana.dispose();
    }//GEN-LAST:event_jButton9MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
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
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}

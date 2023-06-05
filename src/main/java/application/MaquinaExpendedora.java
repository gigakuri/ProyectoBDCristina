/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author cristina
 */
public class MaquinaExpendedora {
    
    public static void main(String[] args) {
        
        JFrame ventanaPrincipal = crearVentana("Máquina expendedora", new PanelMaquinaExpendedora());
        
    }
    
    public static JFrame crearVentana(String title, JPanel panel) {
        // Construimos la ventana
        JFrame ventana = new JFrame(title);
        // La ventana no se puede redimensionar
        ventana.setResizable(false);
        // Incluimos el panel en la ventana
        ventana.add(panel);
        // Ajusta el frame al contenido
        ventana.pack();
        // Actualiza la interfaz
        ventana.repaint();
        // Centramos la ventana
        ventana.setLocationRelativeTo(null);
        // Hacemos visible la ventana
        ventana.setVisible(true);
        //Acción por defecto al pulsar el botón de cierre de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return ventana;
    }
    
}

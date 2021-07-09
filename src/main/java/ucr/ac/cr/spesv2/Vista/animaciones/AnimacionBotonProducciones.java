/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Vista.animaciones;

import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import ucr.ac.cr.spesv2.Vista.PanelesMenuPrincipal.PanelNavegador;

/**
 *
 * @author jpcdl
 */
public class AnimacionBotonProducciones extends Animaciones{

   



    
    
    @Override
    public void mouseEntered(MouseEvent arg0) {
//        System.out.println("ucr.ac.cr.spesv2.Vista.animaciones.BotonUsuario.mouseEntered()");
        JButton boton = (JButton) arg0.getSource();
        boton.setIcon(super.renderEscala.escalarImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonProduccionesover.png"))));
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
//        System.out.println("ucr.ac.cr.spesv2.Vista.animaciones.BotonUsuario.mouseExited()");
        JButton boton = (JButton) arg0.getSource();
        boton.setIcon(super.renderEscala.escalarImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonProducciones.png")))); 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Vista.PanelesMenuPrincipal;

import java.awt.event.ActionListener;
import ucr.ac.cr.spesv2.Controlador.Controlador;
import ucr.ac.cr.spesv2.Vista.PanelPadre;
import ucr.ac.cr.spesv2.Vista.render.RenderEscala;


/**
 *
 * @author Diego Mora
 */
public class PanelBotones extends PanelPadre {

    /**
     * Creates new form PanelBotones
     */
    private RenderEscala render;
    private ActionListener acttion;
    public PanelBotones() {
        render = new RenderEscala(1920);
        initComponents();
    }

    public void escuchar(ActionListener manejador) {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setIcon(render.escalarImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Recurso 30botones2.png"))));
        btnAgregar.setActionCommand("add");
        btnAgregar.setBorder(null);
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setFocusPainted(false);
        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 90));
        remove(btnAgregar);
        add(btnAgregar,new org.netbeans.lib.awtextra.AbsoluteConstraints(render.escalarCordenada(0), render.escalarCordenada(0), -1, -1));

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(render.escalarImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Recurso 32botones2.png"))));
        btnEditar.setActionCommand("modificar");
        btnEditar.setBorder(null);
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 80, 80));
        remove(btnEditar);
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,render.escalarCordenada( 120), -1, -1));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(render.escalarImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Recurso 33botones2.png"))));
        btnEliminar.setActionCommand("eliminar");
        btnEliminar.setBorder(null);
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 90, 90));
        remove(btnEliminar);
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, render.escalarCordenada(230), -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void escuchar(Controlador manejador) {
        if (acttion != null) {
            btnAgregar.removeActionListener(acttion);
            btnEditar.removeActionListener(acttion);
            btnEliminar.removeActionListener(acttion);

        }

        btnAgregar.addActionListener(manejador);
        btnEditar.addActionListener(manejador);
        btnEliminar.addActionListener(manejador);
        
        acttion = manejador;
    }
}

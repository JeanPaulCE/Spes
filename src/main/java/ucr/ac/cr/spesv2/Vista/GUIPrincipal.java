/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import ucr.ac.cr.spesv2.Controlador.Controlador;
import ucr.ac.cr.spesv2.Controlador.ControladorGui;
import ucr.ac.cr.spesv2.Vista.PanelesMenuPrincipal.PanelBotones;
import ucr.ac.cr.spesv2.Vista.PanelesMenuPrincipal.PanelNavegador;
import ucr.ac.cr.spesv2.Vista.PanelesMenuPrincipal.PanelTablas;
import ucr.ac.cr.spesv2.Vista.render.RenderEscala;
import ucr.ac.cr.spesv2.Vista.render.RenderPaint;

/**
 *
 * @author xerodox
 */
public class GUIPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form GUIPrincipal
     */
    private Dimension dim;
    private RenderEscala render;

    public GUIPrincipal() {
        render = new RenderEscala(1920);
        initComponents();
        panelNavegador1.setFrame(this);
        //loanding.setOpaque(true);
        loanding.setVisible(false);

        this.setSize(render.ancho, render.alto);
        this.setLocationRelativeTo(null);

        escuchar(new ControladorGui(this));
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTablas1 = new PanelTablas();
        panelNavegador1 = new PanelNavegador();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelBotones1 = new PanelBotones();
        loanding = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelTablas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));
        getContentPane().remove(panelTablas1);
        getContentPane().add(panelTablas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(
                render.escalarCordenada(360), render.escalarCordenada(170), -1, -1));
        getContentPane().add(panelNavegador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 1190, -1));
        getContentPane().remove(panelNavegador1);
        getContentPane().add(panelNavegador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(
                render.escalarCordenada(680), render.escalarCordenada(50), -1, -1));

        jLabel2.setIcon(render.escalarImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))));
        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(render.escalarCordenada(1804), render.escalarCordenada(978)));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));
        getContentPane().remove(jLabel2);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(render.escalarCordenada(60),
                render.escalarCordenada(50), -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(panelBotones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));
        getContentPane().remove(panelBotones1);
        getContentPane().add(panelBotones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(
                render.escalarCordenada(200), render.escalarCordenada(240), -1, -1));

        loanding.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loading-25.gif"))); // NOI18N
        jPanel1.add(loanding, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 300, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPrincipal().setVisible(true);
            }
        });
    }

    public void escuchar(Controlador controlador) {
        panelNavegador1.escuchar(controlador);
        panelTablas1.escuchar(controlador);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        RenderPaint motor = new RenderPaint(this);
        motor.start();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel loanding;
    public PanelBotones panelBotones1;
    public PanelNavegador panelNavegador1;
    public PanelTablas panelTablas1;
    // End of variables declaration//GEN-END:variables
}

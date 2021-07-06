/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Vista.PanelesRegistros;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import ucr.ac.cr.spesv2.Controlador.Controlador;

import ucr.ac.cr.spesv2.Vista.PanelPadre;
import ucr.ac.cr.spesv2.Vista.render.Fuentes;
import ucr.ac.cr.spesv2.Vista.render.RenderEscala;

/**
 *
 * @author Emmanuel Méndez R
 */
public class PanelUsuario extends PanelPadre {

    /**
     * Creates new form PanelUsuario
     */
    private RenderEscala render;
    private Fuentes fuentes = new Fuentes();
    public PanelUsuario() {
        render = new RenderEscala(1920);
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreUsuario = new javax.swing.JTextField();
        txtClave = new javax.swing.JTextField();
        cbxPerfil = new javax.swing.JComboBox<>();
        btnConfirmar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblNombreUsuario = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtPerfil = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreUsuario.setBackground(new java.awt.Color(229, 229, 229));
        txtNombreUsuario.setActionCommand("");
        add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 220, 30));

        txtClave.setBackground(new java.awt.Color(229, 229, 229));
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 220, 30));

        cbxPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxPerfil.setBorder(null);
        cbxPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(cbxPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 220, 30));

        btnConfirmar.setFont(fuentes.fuente(Fuentes.montserratRegular, 0, render.escalarCordenada(32)));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setBorderPainted(false);
        btnConfirmar.setContentAreaFilled(false);
        add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 180, 50));

        btnSalir.setFont(fuentes.fuente(Fuentes.montserratRegular, 0, render.escalarCordenada(32)));
        btnSalir.setText("Salir");
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 160, 50));

        btnBuscar.setIcon(render.escalarImageIcon(render.escalarImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Recurso 382.png")), 50)));
        btnBuscar.setActionCommand("Buscar");
        btnBuscar.setContentAreaFilled(false);
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, -1, 50));

        lblNombreUsuario.setFont(fuentes.fuente(Fuentes.montserratRegular, 0, render.escalarCordenada(32)));
        lblNombreUsuario.setText("Usuario:");
        add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 130, 30));

        lblId.setFont(fuentes.fuente(Fuentes.montserratRegular, 0, render.escalarCordenada(32)));
        lblId.setText("ID:");
        add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 50, 30));

        txtId.setBackground(new java.awt.Color(229, 229, 229));
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 220, 30));

        txtPerfil.setFont(fuentes.fuente(Fuentes.montserratRegular, 0, render.escalarCordenada(32)));
        txtPerfil.setText("Perfil:");
        add(txtPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 100, 30));

        lblClave.setFont(fuentes.fuente(Fuentes.montserratRegular, 0, render.escalarCordenada(32)));
        lblClave.setText("Clave:");
        add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    public void escuchar(Controlador controlador){
        btnBuscar.addActionListener(controlador);
        btnConfirmar.addActionListener(controlador);
        btnSalir.addActionListener(controlador);
        controlador.setPanel(this);
        setCbxPerfil(controlador.getPerfiles());
    }
    
    public String getTxtID(){
        return txtId.getText();
    }
    
    public void enableBotones(){
        btnConfirmar.setEnabled(true);
        btnSalir.setEnabled(true);
    }
    public void disableBotones(){
        btnConfirmar.setEnabled(false);
        btnSalir.setEnabled(false);
    }
    
    public void setTxtId(String id){
        txtId.setText(id);
    }

    public String getTxtClave() {
        return txtClave.getText();
    }

    public String getTxtNombreUsuario() {
        return txtNombreUsuario.getText();
    }

    public String getPerfil() {
        return cbxPerfil.getItemAt(cbxPerfil.getSelectedIndex());
    }
    
    public void setTxtUsuario(String nombreUsuario){
        txtNombreUsuario.setText(nombreUsuario);
    }
    
    public void setCbxPerfil(String perfiles[]){
        cbxPerfil.setModel(new DefaultComboBoxModel(perfiles));
    }
    
    public void setPtxtClave(String clave){
        txtClave.setText(clave);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxPerfil;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JLabel txtPerfil;
    // End of variables declaration//GEN-END:variables
}
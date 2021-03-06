/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Vista.PanelesMenuPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import ucr.ac.cr.spesv2.Controlador.Controlador;
import ucr.ac.cr.spesv2.Controlador.ControladorAccionesUsuario;
import ucr.ac.cr.spesv2.Vista.PanelPadre;
import ucr.ac.cr.spesv2.Vista.render.GestionCeldas;
import ucr.ac.cr.spesv2.Vista.render.GestionEncabezado;

import ucr.ac.cr.spesv2.Vista.render.RenderEscala;

/**
 *
 * @author jpcdl
 */
public class PanelTablas extends PanelPadre {

    private int filasTabla;
    private int columnasTabla;
    private RenderEscala render;
    private Controlador controlador;

    /**
     * Creates new form PanelTablas
     */
    public PanelTablas() {
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

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(render.escalarImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Recurso 392.png"))));
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 280, 40));
        remove(jLabel2);
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(render.escalarCordenada(10), render.escalarCordenada(40), render.escalarCordenada(280), render.escalarCordenada(40)));

        jTextField1.setBackground(null);
        jTextField1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jTextField1.setText("...");
        jTextField1.setAutoscrolls(false);
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, 270, 40));
        remove(jTextField1);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(render.escalarCordenada(10), render.escalarCordenada(22), render.escalarCordenada(270), render.escalarCordenada(40)));

        jButton1.setBackground(null);
        jButton1.setIcon(render.escalarImageIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Recurso 382.png"))));
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));
        remove(jButton1);
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(render.escalarCordenada(340), 0, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prueba", "Prueba2", "Prueba3", "Prueba4", "Prueba5"
            }
        ));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1510, 569));
        remove(jScrollPane1);
        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,render.escalarCordenada(90), render.escalarCordenada(1510), render.escalarCordenada(569)));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public void setTabla(String[] etiquetas, String[][] datos) {
        jTable1.setModel(new DefaultTableModel(datos, etiquetas));

        filasTabla = jTable1.getRowCount();
        columnasTabla = jTable1.getColumnCount();

        for (int i = 0; i < etiquetas.length; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba

            jTable1.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas());
        }

        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setRowHeight(25);//tama??o de las celdas

        JTableHeader jtableHeader = jTable1.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezado());
        jTable1.setTableHeader(jtableHeader);

        jScrollPane1.setViewportView(jTable1);

    }

    public String getSearch() {
        return jTextField1.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public String getSelectedRow() {
        return jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString();
    }

    @Override
    public void escuchar(Controlador controlador) {
        if (this.controlador != null) {
            jButton1.removeActionListener(controlador);
            jTable1.removeMouseListener(controlador);
        }
        this.controlador = controlador;
        jButton1.addActionListener(controlador);
        jTable1.addMouseListener(controlador);
    }

    public void tabEscuchar(ControladorAccionesUsuario controladorBotonesUsuario) {
       jTable1.addMouseListener(controlador);
       jButton1.addActionListener(controlador);
       
    }
}

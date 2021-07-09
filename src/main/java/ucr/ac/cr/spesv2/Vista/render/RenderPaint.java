/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Vista.render;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author jpcdl
 */
public class RenderPaint extends Thread{
    private JFrame ventana;

    public RenderPaint(JFrame ventana) {
        this.ventana = ventana;
    }
    
    
    
    @Override
    public void run() {
        try {
            //System.err.println("--");
            ventana.repaint();
            sleep(60);
        } catch (InterruptedException ex) {
            Logger.getLogger(RenderPaint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}

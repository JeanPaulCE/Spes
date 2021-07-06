/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Vista.animaciones;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import ucr.ac.cr.spesv2.Vista.PanelesMenuPrincipal.PanelNavegador;
import ucr.ac.cr.spesv2.Vista.render.RenderImg;

/**
 *
 * @author jpcdl
 */
public class hiloAnimacionLinea extends Thread {

   
    private JLabel linea;
    private RenderImg renderImg;
    private int x;
    private int ancho;
    private double escalaObjetivo;
    private PanelNavegador panel;

    public hiloAnimacionLinea(String animacion,JLabel linea, int x, int ancho,PanelNavegador panelNavegador, RenderImg renderImg) {
        super(animacion);
        this.linea = linea;
        this.x = x;
        this.ancho = ancho;
        this.panel = panelNavegador;
        this.renderImg = renderImg;
       
    }

    @Override
    public void run() {
        int xLinea = linea.getX();
        int anchoLinea = linea.getWidth();
        escalaObjetivo = ( (double)ancho / anchoLinea);
       
        
        double escala = 1;
        double yaNoSeNombres = escalaObjetivo - escala;

        int contadorObjetivo = 0;
        int contador = 0;
        
        if (xLinea < x) {
            contadorObjetivo = x - xLinea;
        } else if (xLinea > x) {
            contadorObjetivo = xLinea - x;
        }
        int xLineaT = xLinea;
        while (contador<contadorObjetivo&&!isInterrupted()) {
            double porcentajeContador = (double)((double)100 * (double)contador) / (double)contadorObjetivo;
            double aSumar = (double)((double)yaNoSeNombres*(double)porcentajeContador)/100;
            //System.out.println((double)escala+(double)aSumar);
            linea.setIcon(renderImg.escalar((ImageIcon) linea.getIcon(), (double)escala+(double)aSumar));
            if (xLinea < x) {      
                xLineaT+=6;
                linea.setLocation(xLineaT, linea.getY());
                
            } else if (xLinea > x) {
                xLineaT-=6;
                linea.setLocation(xLineaT, linea.getY());
                
            }
            try {
                sleep(1);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(hiloAnimacionLinea.class.getName()).log(Level.SEVERE, null, ex);
            }
            contador+=6 ;
        }
        int lx = linea.getX();
        int ly = linea.getY();
        panel.remove(linea);
        panel.add(linea,new org.netbeans.lib.awtextra.AbsoluteConstraints( lx, ly, -1, -1));
        
    }

}

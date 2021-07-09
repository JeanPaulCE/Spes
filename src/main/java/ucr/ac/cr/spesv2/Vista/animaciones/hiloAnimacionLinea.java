/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Vista.animaciones;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import ucr.ac.cr.spesv2.Vista.PanelesMenuPrincipal.PanelNavegador;
import ucr.ac.cr.spesv2.Vista.render.RenderImg;

/**
 *
 * @author jpcdl
 */
public class hiloAnimacionLinea extends Thread {

    private Linea linea;


    private int xObjetivo;
    private int xActual;

    private int anchoObjetivo;
    private int anchoActual;
    
    private double escalaObjetivo;
    private double escalaActual;
    

   
   

    private boolean status = false;
    private PanelNavegador panel;

    public hiloAnimacionLinea(String animacion, Linea linea, PanelNavegador panelNavegador,int xObjetivo, int wObjetivo) {
        super(animacion);
        this.linea = linea;
        this.panel = panelNavegador;
        this.anchoObjetivo = wObjetivo;
        this.xObjetivo = xObjetivo;
        status = true;
        

    }

    @Override
    public void run() {

        if (status) {
            int sumador = 0;
            xActual = linea.getX();
            anchoActual = linea.getWidth();
            double avance = 0;
            int porRecorrer = 0;
            int recorrido;
            
            double escalaTemp;
            
            
            if (xObjetivo > xActual) {
                sumador = 2;
                porRecorrer = xObjetivo - xActual;
            } else {
                sumador = -2;
                porRecorrer = xActual - xObjetivo;
            }
            
            escalaObjetivo = (double)(anchoObjetivo*100)/linea.getWidthOriginal();
            escalaActual = (double)(anchoActual*100)/linea.getWidthOriginal();
            if (anchoObjetivo > anchoActual) {
                
                escalaTemp = escalaObjetivo - escalaActual;
                
            } else {
                
                escalaTemp = escalaActual-escalaObjetivo;
            }
         
            System.out.println("ucr.ac.cr.spesv2.Vista.animaciones.hiloAnimacionLinea.run()");
            System.out.println(escalaTemp);
            System.out.println(anchoActual);
            System.out.println(escalaActual);
            System.out.println(escalaObjetivo);
            System.out.println("ucr.ac.cr.spesv2.Vista.animaciones.hiloAnimacionLinea.run()");
            
            while (status && avance<100) {
                xActual += sumador;

                if (sumador > 0) {
                    recorrido = xObjetivo - xActual;
                } else {
                    recorrido = xActual - xObjetivo;
                }
                
                avance = (double) 100-(recorrido * 100) / porRecorrer;
                linea.setLocation(xActual, linea.getY());
                
                //System.out.println("hA--"+avance);
                
                double nuevaEscala = 0;
                if (anchoObjetivo > anchoActual) {
                    nuevaEscala = (double)escalaActual+((escalaTemp*avance)/100);
                }else{
                    nuevaEscala = (double)escalaActual-((escalaTemp*avance)/100);
                }
                
                
                System.out.print(nuevaEscala+" \n\n");
                //Icon img = renderImg.escalar((ImageIcon) linea.getIcon(),(nuevaEscala/100));
                linea.setEscala((nuevaEscala/100));
                //linea.setIcon(img);
                
                try {
                    sleep(2);
                    
                } catch (Exception e) {

                }

            }
            System.out.print("\n\n END\n");
            System.out.println("ucr.ac.cr.spesv2.Vista.animaciones.hiloAnimacionLinea.run()");
            status = false;
        }
        
        
        this.interrupt();
    }

    public void status() {
        this.status = !this.status;
    }

}

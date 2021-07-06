/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import ucr.ac.cr.spesv2.Vista.GUIPrincipal;

/**
 *
 * @author jpcdl
 */
public class ControladorGui extends Controlador{

    public EntityManagerFactory emf =  Persistence.createEntityManagerFactory("SPESv2");
    
    public GUIPrincipal guiPrincipal;
   
    private Controlador controladorSecundario;
    private String vista;
    
    public ControladorGui(GUIPrincipal ventana) {
        this.guiPrincipal = ventana;    
      
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
      //guiPrincipal.loanding.setVisible(true);
        ((JButton)arg0.getSource()).setEnabled(false);
      
        switch(arg0.getActionCommand().toLowerCase()){
           
            case "usuario":
                if (vista!="usuario") {
                    controladorSecundario = new ControladorAccionesUsuario(this);
                    vista = "usuario";
                    guiPrincipal.panelBotones1.escuchar(controladorSecundario);
                    guiPrincipal.panelTablas1.escuchar(controladorSecundario);
                }
                
                break;
           case "prudcciones":
//               controladorSecundario = new ControladorAccionesProducciones(this);
//                vista = "produciones";
//                guiPrincipal.panelBotones1.escuchar(controladorSecundario);
//                guiPrincipal.panelTablas1.escuchar(controladorSecundario);
            default:
                break;
        
        }
        ((JButton)arg0.getSource()).setEnabled(true);
        //guiPrincipal.loanding.setVisible(false);
        //guiPrincipal.repaint();
    }

    public void updateTabla(String[][] datos,String[] etiquetas) {
        if (datos.length>0) {
                guiPrincipal.panelTablas1.setTabla(etiquetas, datos);
        }else{
        guiPrincipal.panelTablas1.setTabla(etiquetas,new String[][]{{"","",""}});
        }
    }

    
    
    
    
    
}

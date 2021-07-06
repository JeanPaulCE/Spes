/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import ucr.ac.cr.spesv2.Modelo.Colaborador;
import ucr.ac.cr.spesv2.Modelo.Perfil;
import ucr.ac.cr.spesv2.Modelo.Usuario;
import ucr.ac.cr.spesv2.Modelo.registros.RegistroColaboradores;
import ucr.ac.cr.spesv2.Modelo.registros.RegistroPerfiles;
import ucr.ac.cr.spesv2.Modelo.registros.RegistroUsuarios;
import ucr.ac.cr.spesv2.Vista.GuiRegistro;
import ucr.ac.cr.spesv2.Vista.PanelesRegistros.PanelUsuario;

/**
 *
 * @author jpcdl
 */
public class ControladorAccionesUsuario extends Controlador {

    private ControladorGui controladorGui;
    private PanelUsuario panel;
    private RegistroPerfiles registroPerfiles;
    private Usuario usuarioGeneral;
    private RegistroUsuarios registroUsuarios;
    private GuiRegistro guiRegistro;
    private RegistroColaboradores registroColaboradores;
    
    
    public ControladorAccionesUsuario(ControladorGui controlador) {
        controladorGui = controlador;
        
        registroUsuarios = new RegistroUsuarios(controladorGui.emf);
        registroPerfiles = new RegistroPerfiles(controladorGui.emf);
        registroColaboradores = new RegistroColaboradores(controladorGui.emf);
        
        controladorGui.updateTabla(registroUsuarios.getDatosTabla(), Usuario.ETIQUETAS);
    }

    @Override
    public void setPanel(PanelUsuario panel) {
        this.panel = panel;
    }

    @Override
    public String[] getPerfiles() {
        return registroPerfiles.getTiposPerfil();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        switch(arg0.getActionCommand().toLowerCase()){
            case "add":
               guiRegistro = new GuiRegistro(this,"usuario");
               guiRegistro.setVisible(true);
                break;
            case "modificar":
               guiRegistro = new GuiRegistro(this,"usuario");
              
               panel.setTxtUsuario(usuarioGeneral.getNombre());
               panel.setCbxPerfil(registroPerfiles.getTiposPerfil());
               panel.setTxtId(usuarioGeneral.getColaboradorId().getId()+"");
              
               guiRegistro.setVisible(true);
           
                
                break;
            case "eliminar":
                if (usuarioGeneral!=null) {
                    registroUsuarios.delet(usuarioGeneral);
                    controladorGui.updateTabla(registroUsuarios.getDatosTabla(), Usuario.ETIQUETAS);
                }
                break;   
                
            
            
            case "confirmar":
                panel.disableBotones();
                try {
                    
                        if (panel.getTxtClave().length()>0) {
                            Usuario user = new Usuario(panel.getTxtNombreUsuario(), panel.getTxtClave());
                            
                            user.setPerfilId((Perfil) registroPerfiles.buscar(panel.getPerfil()));
                         
                            user.setColaboradorId((Colaborador) registroColaboradores.buscar(panel.getTxtID()));
                            if (registroUsuarios.buscar(user.getNombre())!=null) {
                                registroUsuarios.edit(user);
                                controladorGui.updateTabla(registroUsuarios.getDatosTabla(), Usuario.ETIQUETAS);
                                guiRegistro.dispose();
                                return;
                            }else {
                               
                                registroUsuarios.add(user);
                                controladorGui.updateTabla(registroUsuarios.getDatosTabla(), Usuario.ETIQUETAS);
                                guiRegistro.dispose();
                                return;
                            }
                        }
                    
                } catch (Exception e) {

                }
                JOptionPane.showConfirmDialog(panel, "ERROR revisa los datos", "Error", 0);
                panel.enableBotones();
                
              break;
            case "salir":
                guiRegistro.dispose();
                break;
            
        
        }
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        String id = controladorGui.guiPrincipal.panelTablas1.getSelectedRow();
        usuarioGeneral = (Usuario)registroUsuarios.buscar(id);
    }

}

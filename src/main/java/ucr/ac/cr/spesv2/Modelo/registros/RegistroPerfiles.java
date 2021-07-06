/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Modelo.registros;

import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import ucr.ac.cr.spesv2.Controlador.JPA.PerfilJpaController;
import ucr.ac.cr.spesv2.Modelo.Elemento;
import ucr.ac.cr.spesv2.Modelo.Perfil;

/**
 *
 * @author jpcdl
 */
public class RegistroPerfiles  extends Registro{

    private PerfilJpaController perfilJpa;
    private ArrayList<Perfil> listaPerfiles;

    public RegistroPerfiles(EntityManagerFactory emf) {
        perfilJpa = new PerfilJpaController(emf);
        listaPerfiles = (ArrayList<Perfil>) perfilJpa.findPerfilEntities();
    }

    @Override
    public Elemento buscar(String id) {

        for (Perfil perfil : listaPerfiles) {
            try {
                if (perfil.getId().equals(Integer.parseInt(id))) {
                    System.out.println("ucr.ac.cr.spesv2.Modelo.registros.RegistroPerfiles.buscar()///");
                    return perfil;
                }
            } catch (Exception e) {
                if (perfil.getTipoUsuario().equals(id)) {
                    System.out.println("ucr.ac.cr.spesv2.Modelo.registros.RegistroPerfiles.buscar()====");
                    return perfil;
                }
            }

        }
        return null;
    }
    
    @Override
    public boolean add(Elemento elemento){
        Perfil perfil = (Perfil) elemento;
        listaPerfiles.add(perfil);
        try {
            perfilJpa.create(perfil);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean edit(Elemento elemento){
        Perfil perfil = (Perfil) elemento;
        for (int i = 0; i < listaPerfiles.size(); i++) {
            Perfil element = listaPerfiles.get(i);
            if (element.getId().equals(perfil.getId())) {
                listaPerfiles.remove(i);
                listaPerfiles.add(i, perfil);
            }  
        }
        try {
            perfilJpa.edit(perfil);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean delet(Elemento elemento){
        Perfil perfil = (Perfil) elemento;
        try {
            listaPerfiles.remove(perfil);
            perfilJpa.destroy(perfil.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    

    @Override
    public String[][] getDatosTabla() {
        String[][] datos = new String[listaPerfiles.size()][Perfil.ETIQUETAS.length];
        int contador = 0;
        for (Perfil perfile : listaPerfiles) {
            datos[contador][0] = perfile.getId() + "";
            datos[contador][1] = perfile.getTipoUsuario();
            contador++;
        }
        return datos;
    }
    
    public String[] getTiposPerfil(){
        String[] typosPerfil = new String[listaPerfiles.size()];
        for (int i = 0; i < listaPerfiles.size(); i++) {
            typosPerfil[i] = listaPerfiles.get(i).getTipoUsuario();
        }
        return typosPerfil;
    }

}

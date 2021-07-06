/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Modelo.registros;

import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import ucr.ac.cr.spesv2.Controlador.JPA.ColaboradorJpaController;
import ucr.ac.cr.spesv2.Modelo.Colaborador;
import ucr.ac.cr.spesv2.Modelo.Elemento;

/**
 *
 * @author jpcdl
 */
public class RegistroColaboradores extends Registro {

    private ColaboradorJpaController ColaboradorJpa;
    private ArrayList<Colaborador> listaColaboradores;

    public RegistroColaboradores(EntityManagerFactory emf) {
        ColaboradorJpa = new ColaboradorJpaController(emf);
        listaColaboradores = (ArrayList<Colaborador>) ColaboradorJpa.findColaboradorEntities();
        
    }

    
    
    @Override
    public Elemento buscar(String id) {
        try {
            for (Colaborador colaborador : listaColaboradores) {
                if (colaborador.getId().equals(Integer.parseInt(id))) {
                    return colaborador;
                }
            }
        } catch (Exception e) {
            System.out.println("ucr.ac.cr.spesv2.Modelo.registros.RegistroColaboradores.buscar()");
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean add(Elemento elemento) {
        try {
            listaColaboradores.add((Colaborador) elemento);
            ColaboradorJpa.create((Colaborador) elemento);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean edit(Elemento elemento) {
        Colaborador colab = (Colaborador) buscar(elemento.getDatos(0));
        try {
            listaColaboradores.remove(colab);
            listaColaboradores.add((Colaborador) elemento);
            ColaboradorJpa.edit(colab);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public boolean delet(Elemento elemento) {
        try {
            listaColaboradores.remove(elemento);
            ColaboradorJpa.destroy(((Colaborador)elemento).getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String[][] getDatosTabla() {
        String[][] datos = new String[listaColaboradores.size()][Colaborador.ETIQUETAS.length];
        for (int i = 0; i < listaColaboradores.size(); i++) {
            for (int j = 0; j < Colaborador.ETIQUETAS.length; j++) {
                datos[i][j]= listaColaboradores.get(i).getDatos(j);
            }
        }
        return datos;
    }

}

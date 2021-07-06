/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Modelo.registros;

import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import ucr.ac.cr.spesv2.Controlador.JPA.UsuarioJpaController;
import ucr.ac.cr.spesv2.Modelo.Elemento;
import ucr.ac.cr.spesv2.Modelo.Usuario;

/**
 *
 * @author jpcdl
 */
public class RegistroUsuarios extends Registro {

    private UsuarioJpaController usuarioJpa;
    private ArrayList<Usuario> listaUsuarios;

    public RegistroUsuarios(EntityManagerFactory emf) {
        usuarioJpa = new UsuarioJpaController(emf);
        listaUsuarios = (ArrayList<Usuario>) usuarioJpa.findUsuarioEntities();

    }

    @Override
    public Elemento buscar(String id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public boolean add(Elemento elemento) {
        try {
            listaUsuarios.add((Usuario) elemento);
            usuarioJpa.create((Usuario) elemento);
            return true;
        } catch (Exception e) {
            System.out.println("ucr.ac.cr.spesv2.Modelo.registros.RegistroUsuarios.add()");
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean edit(Elemento elemento) {
        try {
            Usuario user = (Usuario) buscar(((Usuario) elemento).getNombre());
            listaUsuarios.remove(user);
            listaUsuarios.add((Usuario) elemento);
            usuarioJpa.edit((Usuario) elemento);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean delet(Elemento elemento) {
        try {
            listaUsuarios.remove((Usuario) elemento);
            usuarioJpa.destroy(((Usuario) elemento).getNombre());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String[][] getDatosTabla() {
        String[][] datos = new String[listaUsuarios.size()][Usuario.ETIQUETAS.length];

        for (int i = 0; i < listaUsuarios.size(); i++) {
            datos[i][0] = listaUsuarios.get(i).getDatos(0);
            datos[i][1] = listaUsuarios.get(i).getDatos(1);
            datos[i][2] = listaUsuarios.get(i).getDatos(2);
        }

        return datos;
    }

}

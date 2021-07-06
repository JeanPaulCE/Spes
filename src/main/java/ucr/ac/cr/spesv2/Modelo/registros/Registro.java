/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Modelo.registros;

import ucr.ac.cr.spesv2.Modelo.Elemento;
import ucr.ac.cr.spesv2.Modelo.Perfil;

/**
 *
 * @author jpcdl
 */
public abstract class Registro {

    public abstract Elemento buscar(String id);

    public abstract boolean add(Elemento elemento);

    public abstract boolean edit(Elemento elemento);

    public abstract boolean delet(Elemento elemento);

    public abstract String[][] getDatosTabla();
}

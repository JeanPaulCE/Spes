/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.spesv2.Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jpcdl
 */
@Entity
@Table(name = "colaborador")

public class Colaborador extends Elemento implements Serializable {
    
    public static final String[] ETIQUETAS = new String[]{"ID","Nombre","Funcion","Area"};//0,1,2,3
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "funcion")
    private String funcion;
    @Basic(optional = false)
    @Column(name = "area")
    private String area;
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    @Basic(optional = false)
    @Column(name = "telefono_celular")
    private String telefonoCelular;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "distrito")
    private String distrito;
    @Basic(optional = false)
    @Column(name = "canton")
    private String canton;
    @Basic(optional = false)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @Column(name = "direccion_exacta")
    private String direccionExacta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradorId")
    private Collection<Usuario> usuarioCollection;

    public Colaborador() {
    }

    public Colaborador(Integer id) {
        this.id = id;
    }

    public Colaborador(Integer id, String nombre, String funcion, String area, String telefonoCelular, String ciudad, String distrito, String canton, String provincia, String direccionExacta) {
        this.id = id;
        this.nombre = nombre;
        this.funcion = funcion;
        this.area = area;
        this.telefonoCelular = telefonoCelular;
        this.ciudad = ciudad;
        this.distrito = distrito;
        this.canton = canton;
        this.provincia = provincia;
        this.direccionExacta = direccionExacta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.spesv2.Modelo.Colaborador[ id=" + id + " ]";
    }

    @Override
    public String getDatos(int etiqueta) {
        switch(etiqueta){
            case 0:
                return getId()+"";
            case 1:
                return getNombre();
            case 2:
                return getFuncion();
            case 3:
                return getArea();
            default:
                return "Etiqueda desconocida";      
        }
    }
    
}

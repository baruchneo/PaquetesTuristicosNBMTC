/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "paquete_turistico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaqueteTuristico.findAll", query = "SELECT p FROM PaqueteTuristico p"),
    @NamedQuery(name = "PaqueteTuristico.findByIdPaqueteTuristico", query = "SELECT p FROM PaqueteTuristico p WHERE p.idPaqueteTuristico = :idPaqueteTuristico"),
    @NamedQuery(name = "PaqueteTuristico.findByNombre", query = "SELECT p FROM PaqueteTuristico p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PaqueteTuristico.findByCodigo", query = "SELECT p FROM PaqueteTuristico p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "PaqueteTuristico.findByDescripcion", query = "SELECT p FROM PaqueteTuristico p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PaqueteTuristico.findByUbicacion", query = "SELECT p FROM PaqueteTuristico p WHERE p.ubicacion = :ubicacion"),
    @NamedQuery(name = "PaqueteTuristico.findByDisponibilidad", query = "SELECT p FROM PaqueteTuristico p WHERE p.disponibilidad = :disponibilidad"),
    @NamedQuery(name = "PaqueteTuristico.findByCosto", query = "SELECT p FROM PaqueteTuristico p WHERE p.costo = :costo"),
    @NamedQuery(name = "PaqueteTuristico.findByOferta", query = "SELECT p FROM PaqueteTuristico p WHERE p.oferta = :oferta"),
    @NamedQuery(name = "PaqueteTuristico.findByEstado", query = "SELECT p FROM PaqueteTuristico p WHERE p.estado = :estado"),
    @NamedQuery(name = "PaqueteTuristico.findByPublicado", query = "SELECT p FROM PaqueteTuristico p WHERE p.publicado = :publicado")})
public class PaqueteTuristico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paquete_turistico")
    private Integer idPaqueteTuristico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disponibilidad")
    private int disponibilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private double costo;
    @Column(name = "oferta")
    private Boolean oferta;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @Column(name = "publicado")
    private Boolean publicado;
    @ManyToMany(mappedBy = "paqueteTuristicoCollection")
    private Collection<CompraServiciosPaquetes> compraServiciosPaquetesCollection;
    @JoinTable(name = "servicios_paquetes", joinColumns = {
        @JoinColumn(name = "id_paquete_turistico", referencedColumnName = "id_paquete_turistico")}, inverseJoinColumns = {
        @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")})
    @ManyToMany
    private Collection<Servicio> servicioCollection;
    @OneToMany(mappedBy = "idPaqueteTuristico")
    private Collection<Registro> registroCollection;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public PaqueteTuristico() {
    }

    public PaqueteTuristico(Integer idPaqueteTuristico) {
        this.idPaqueteTuristico = idPaqueteTuristico;
    }

    public PaqueteTuristico(Integer idPaqueteTuristico, String nombre, String codigo, String descripcion, String ubicacion, int disponibilidad, double costo) {
        this.idPaqueteTuristico = idPaqueteTuristico;
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.disponibilidad = disponibilidad;
        this.costo = costo;
    }

    public Integer getIdPaqueteTuristico() {
        return idPaqueteTuristico;
    }

    public void setIdPaqueteTuristico(Integer idPaqueteTuristico) {
        this.idPaqueteTuristico = idPaqueteTuristico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Boolean getOferta() {
        return oferta;
    }

    public void setOferta(Boolean oferta) {
        this.oferta = oferta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getPublicado() {
        return publicado;
    }

    public void setPublicado(Boolean publicado) {
        this.publicado = publicado;
    }

    @XmlTransient
    public Collection<CompraServiciosPaquetes> getCompraServiciosPaquetesCollection() {
        return compraServiciosPaquetesCollection;
    }

    public void setCompraServiciosPaquetesCollection(Collection<CompraServiciosPaquetes> compraServiciosPaquetesCollection) {
        this.compraServiciosPaquetesCollection = compraServiciosPaquetesCollection;
    }

    @XmlTransient
    public Collection<Servicio> getServicioCollection() {
        return servicioCollection;
    }

    public void setServicioCollection(Collection<Servicio> servicioCollection) {
        this.servicioCollection = servicioCollection;
    }

    @XmlTransient
    public Collection<Registro> getRegistroCollection() {
        return registroCollection;
    }

    public void setRegistroCollection(Collection<Registro> registroCollection) {
        this.registroCollection = registroCollection;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaqueteTuristico != null ? idPaqueteTuristico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaqueteTuristico)) {
            return false;
        }
        PaqueteTuristico other = (PaqueteTuristico) object;
        if ((this.idPaqueteTuristico == null && other.idPaqueteTuristico != null) || (this.idPaqueteTuristico != null && !this.idPaqueteTuristico.equals(other.idPaqueteTuristico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.PaqueteTuristico[ idPaqueteTuristico=" + idPaqueteTuristico + " ]";
    }
    
}

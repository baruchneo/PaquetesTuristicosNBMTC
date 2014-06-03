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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "mensajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m"),
    @NamedQuery(name = "Mensajes.findByIdMensaje", query = "SELECT m FROM Mensajes m WHERE m.idMensaje = :idMensaje"),
    @NamedQuery(name = "Mensajes.findByEnunciado", query = "SELECT m FROM Mensajes m WHERE m.enunciado = :enunciado"),
    @NamedQuery(name = "Mensajes.findByEmailOrigen", query = "SELECT m FROM Mensajes m WHERE m.emailOrigen = :emailOrigen"),
    @NamedQuery(name = "Mensajes.findByEmailDestino", query = "SELECT m FROM Mensajes m WHERE m.emailDestino = :emailDestino"),
    @NamedQuery(name = "Mensajes.findByMensaje", query = "SELECT m FROM Mensajes m WHERE m.mensaje = :mensaje"),
    @NamedQuery(name = "Mensajes.findByTipoMensaje", query = "SELECT m FROM Mensajes m WHERE m.tipoMensaje = :tipoMensaje")})
public class Mensajes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_mensaje")
    private Integer idMensaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "enunciado")
    private String enunciado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "email_origen")
    private String emailOrigen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "email_destino")
    private String emailDestino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "mensaje")
    private String mensaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo_mensaje")
    private String tipoMensaje;
    @JoinTable(name = "personas_mensajes", joinColumns = {
        @JoinColumn(name = "id_mensaje", referencedColumnName = "id_mensaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")})
    @ManyToMany
    private Collection<Persona> personaCollection;
    @OneToMany(mappedBy = "idMensaje")
    private Collection<Registro> registroCollection;

    public Mensajes() {
    }

    public Mensajes(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Mensajes(Integer idMensaje, String enunciado, String emailOrigen, String emailDestino, String mensaje, String tipoMensaje) {
        this.idMensaje = idMensaje;
        this.enunciado = enunciado;
        this.emailOrigen = emailOrigen;
        this.emailDestino = emailDestino;
        this.mensaje = mensaje;
        this.tipoMensaje = tipoMensaje;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getEmailOrigen() {
        return emailOrigen;
    }

    public void setEmailOrigen(String emailOrigen) {
        this.emailOrigen = emailOrigen;
    }

    public String getEmailDestino() {
        return emailDestino;
    }

    public void setEmailDestino(String emailDestino) {
        this.emailDestino = emailDestino;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @XmlTransient
    public Collection<Registro> getRegistroCollection() {
        return registroCollection;
    }

    public void setRegistroCollection(Collection<Registro> registroCollection) {
        this.registroCollection = registroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensaje != null ? idMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.idMensaje == null && other.idMensaje != null) || (this.idMensaje != null && !this.idMensaje.equals(other.idMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.Mensajes[ idMensaje=" + idMensaje + " ]";
    }
    
}

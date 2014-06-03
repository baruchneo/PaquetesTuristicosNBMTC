/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "tipo_registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRegistro.findAll", query = "SELECT t FROM TipoRegistro t"),
    @NamedQuery(name = "TipoRegistro.findByIdTipoRegistro", query = "SELECT t FROM TipoRegistro t WHERE t.idTipoRegistro = :idTipoRegistro"),
    @NamedQuery(name = "TipoRegistro.findByTipo", query = "SELECT t FROM TipoRegistro t WHERE t.tipo = :tipo")})
public class TipoRegistro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_registro")
    private Integer idTipoRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoRegistro")
    private Collection<Registro> registroCollection;

    public TipoRegistro() {
    }

    public TipoRegistro(Integer idTipoRegistro) {
        this.idTipoRegistro = idTipoRegistro;
    }

    public TipoRegistro(Integer idTipoRegistro, String tipo) {
        this.idTipoRegistro = idTipoRegistro;
        this.tipo = tipo;
    }

    public Integer getIdTipoRegistro() {
        return idTipoRegistro;
    }

    public void setIdTipoRegistro(Integer idTipoRegistro) {
        this.idTipoRegistro = idTipoRegistro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash += (idTipoRegistro != null ? idTipoRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRegistro)) {
            return false;
        }
        TipoRegistro other = (TipoRegistro) object;
        if ((this.idTipoRegistro == null && other.idTipoRegistro != null) || (this.idTipoRegistro != null && !this.idTipoRegistro.equals(other.idTipoRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.TipoRegistro[ idTipoRegistro=" + idTipoRegistro + " ]";
    }
    
}

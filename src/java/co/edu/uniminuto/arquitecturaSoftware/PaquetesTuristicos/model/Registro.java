/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r"),
    @NamedQuery(name = "Registro.findByIdRegistroLog", query = "SELECT r FROM Registro r WHERE r.idRegistroLog = :idRegistroLog"),
    @NamedQuery(name = "Registro.findByTitulo", query = "SELECT r FROM Registro r WHERE r.titulo = :titulo"),
    @NamedQuery(name = "Registro.findByDescripcion", query = "SELECT r FROM Registro r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Registro.findByFechaRegistro", query = "SELECT r FROM Registro r WHERE r.fechaRegistro = :fechaRegistro")})
public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_registro_log")
    private Integer idRegistroLog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "id_tipo_registro", referencedColumnName = "id_tipo_registro")
    @ManyToOne(optional = false)
    private TipoRegistro idTipoRegistro;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne
    private Servicio idServicio;
    @JoinColumn(name = "id_paquete_turistico", referencedColumnName = "id_paquete_turistico")
    @ManyToOne
    private PaqueteTuristico idPaqueteTuristico;
    @JoinColumn(name = "id_mensaje", referencedColumnName = "id_mensaje")
    @ManyToOne
    private Mensajes idMensaje;
    @JoinColumn(name = "id_compra_serv_paqt", referencedColumnName = "id_compra_serv_paqt")
    @ManyToOne
    private CompraServiciosPaquetes idCompraServPaqt;

    public Registro() {
    }

    public Registro(Integer idRegistroLog) {
        this.idRegistroLog = idRegistroLog;
    }

    public Registro(Integer idRegistroLog, String titulo, String descripcion, Date fechaRegistro) {
        this.idRegistroLog = idRegistroLog;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdRegistroLog() {
        return idRegistroLog;
    }

    public void setIdRegistroLog(Integer idRegistroLog) {
        this.idRegistroLog = idRegistroLog;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public TipoRegistro getIdTipoRegistro() {
        return idTipoRegistro;
    }

    public void setIdTipoRegistro(TipoRegistro idTipoRegistro) {
        this.idTipoRegistro = idTipoRegistro;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public PaqueteTuristico getIdPaqueteTuristico() {
        return idPaqueteTuristico;
    }

    public void setIdPaqueteTuristico(PaqueteTuristico idPaqueteTuristico) {
        this.idPaqueteTuristico = idPaqueteTuristico;
    }

    public Mensajes getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Mensajes idMensaje) {
        this.idMensaje = idMensaje;
    }

    public CompraServiciosPaquetes getIdCompraServPaqt() {
        return idCompraServPaqt;
    }

    public void setIdCompraServPaqt(CompraServiciosPaquetes idCompraServPaqt) {
        this.idCompraServPaqt = idCompraServPaqt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistroLog != null ? idRegistroLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.idRegistroLog == null && other.idRegistroLog != null) || (this.idRegistroLog != null && !this.idRegistroLog.equals(other.idRegistroLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.Registro[ idRegistroLog=" + idRegistroLog + " ]";
    }
    
}

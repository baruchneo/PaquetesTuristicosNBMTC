/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "compra_servicios_paquetes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompraServiciosPaquetes.findAll", query = "SELECT c FROM CompraServiciosPaquetes c"),
    @NamedQuery(name = "CompraServiciosPaquetes.findByIdCompraServPaqt", query = "SELECT c FROM CompraServiciosPaquetes c WHERE c.idCompraServPaqt = :idCompraServPaqt"),
    @NamedQuery(name = "CompraServiciosPaquetes.findByCodigo", query = "SELECT c FROM CompraServiciosPaquetes c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "CompraServiciosPaquetes.findByFechaCompra", query = "SELECT c FROM CompraServiciosPaquetes c WHERE c.fechaCompra = :fechaCompra"),
    @NamedQuery(name = "CompraServiciosPaquetes.findByModoPago", query = "SELECT c FROM CompraServiciosPaquetes c WHERE c.modoPago = :modoPago"),
    @NamedQuery(name = "CompraServiciosPaquetes.findByTotal", query = "SELECT c FROM CompraServiciosPaquetes c WHERE c.total = :total"),
    @NamedQuery(name = "CompraServiciosPaquetes.findByIva", query = "SELECT c FROM CompraServiciosPaquetes c WHERE c.iva = :iva"),
    @NamedQuery(name = "CompraServiciosPaquetes.findBySubTotal", query = "SELECT c FROM CompraServiciosPaquetes c WHERE c.subTotal = :subTotal"),
    @NamedQuery(name = "CompraServiciosPaquetes.findByEstado", query = "SELECT c FROM CompraServiciosPaquetes c WHERE c.estado = :estado")})
public class CompraServiciosPaquetes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_compra_serv_paqt")
    private Integer idCompraServPaqt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "modo_pago")
    private String modoPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva")
    private double iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_total")
    private double subTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @JoinTable(name = "paquete_compra_serv_paqt", joinColumns = {
        @JoinColumn(name = "id_compra_serv_paqt", referencedColumnName = "id_compra_serv_paqt")}, inverseJoinColumns = {
        @JoinColumn(name = "id_paquete_turistico", referencedColumnName = "id_paquete_turistico")})
    @ManyToMany
    private Collection<PaqueteTuristico> paqueteTuristicoCollection;
    @JoinTable(name = "servicio_compra_paqt_serv", joinColumns = {
        @JoinColumn(name = "id_compra_serv_paqt", referencedColumnName = "id_compra_serv_paqt")}, inverseJoinColumns = {
        @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")})
    @ManyToMany
    private Collection<Servicio> servicioCollection;
    @OneToMany(mappedBy = "idCompraServPaqt")
    private Collection<Registro> registroCollection;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(optional = false)
    private Proveedor idProveedor;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public CompraServiciosPaquetes() {
    }

    public CompraServiciosPaquetes(Integer idCompraServPaqt) {
        this.idCompraServPaqt = idCompraServPaqt;
    }

    public CompraServiciosPaquetes(Integer idCompraServPaqt, String codigo, Date fechaCompra, String modoPago, double total, double iva, double subTotal, String estado) {
        this.idCompraServPaqt = idCompraServPaqt;
        this.codigo = codigo;
        this.fechaCompra = fechaCompra;
        this.modoPago = modoPago;
        this.total = total;
        this.iva = iva;
        this.subTotal = subTotal;
        this.estado = estado;
    }

    public Integer getIdCompraServPaqt() {
        return idCompraServPaqt;
    }

    public void setIdCompraServPaqt(Integer idCompraServPaqt) {
        this.idCompraServPaqt = idCompraServPaqt;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getModoPago() {
        return modoPago;
    }

    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<PaqueteTuristico> getPaqueteTuristicoCollection() {
        return paqueteTuristicoCollection;
    }

    public void setPaqueteTuristicoCollection(Collection<PaqueteTuristico> paqueteTuristicoCollection) {
        this.paqueteTuristicoCollection = paqueteTuristicoCollection;
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

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
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
        hash += (idCompraServPaqt != null ? idCompraServPaqt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraServiciosPaquetes)) {
            return false;
        }
        CompraServiciosPaquetes other = (CompraServiciosPaquetes) object;
        if ((this.idCompraServPaqt == null && other.idCompraServPaqt != null) || (this.idCompraServPaqt != null && !this.idCompraServPaqt.equals(other.idCompraServPaqt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.arquitecturaSoftware.PaquetesTuristicos.model.CompraServiciosPaquetes[ idCompraServPaqt=" + idCompraServPaqt + " ]";
    }
    
}

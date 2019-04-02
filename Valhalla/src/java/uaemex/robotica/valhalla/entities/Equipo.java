/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uaemex.robotica.valhalla.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author zeroxcharlie
 */
@Entity
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findById", query = "SELECT e FROM Equipo e WHERE e.id = :id")
    , @NamedQuery(name = "Equipo.findByDeudaInicial", query = "SELECT e FROM Equipo e WHERE e.deudaInicial = :deudaInicial")
    , @NamedQuery(name = "Equipo.findByCajas", query = "SELECT e FROM Equipo e WHERE e.cajas = :cajas")
    , @NamedQuery(name = "Equipo.findByDeudaActual", query = "SELECT e FROM Equipo e WHERE e.deudaActual = :deudaActual")
    , @NamedQuery(name = "Equipo.findByCreatedAt", query = "SELECT e FROM Equipo e WHERE e.createdAt = :createdAt")
    , @NamedQuery(name = "Equipo.findByUpdatedAt", query = "SELECT e FROM Equipo e WHERE e.updatedAt = :updatedAt")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "deuda_inicial")
    private Double deudaInicial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cajas")
    private String cajas;
    @Column(name = "deuda_actual")
    private Double deudaActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoId")
    private Collection<Prestamo> prestamoCollection;
    @JoinColumn(name = "clase_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clase claseId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoId")
    private Collection<Registro> registroCollection;

    public Equipo() {
    }

    public Equipo(Integer id) {
        this.id = id;
    }

    public Equipo(Integer id, String cajas, Date createdAt, Date updatedAt) {
        this.id = id;
        this.cajas = cajas;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDeudaInicial() {
        return deudaInicial;
    }

    public void setDeudaInicial(Double deudaInicial) {
        this.deudaInicial = deudaInicial;
    }

    public String getCajas() {
        return cajas;
    }

    public void setCajas(String cajas) {
        this.cajas = cajas;
    }

    public Double getDeudaActual() {
        return deudaActual;
    }

    public void setDeudaActual(Double deudaActual) {
        this.deudaActual = deudaActual;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public Collection<Prestamo> getPrestamoCollection() {
        return prestamoCollection;
    }

    public void setPrestamoCollection(Collection<Prestamo> prestamoCollection) {
        this.prestamoCollection = prestamoCollection;
    }

    public Clase getClaseId() {
        return claseId;
    }

    public void setClaseId(Clase claseId) {
        this.claseId = claseId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uaemex.robotica.valhalla.entities.Equipo[ id=" + id + " ]";
    }
    
}

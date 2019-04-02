/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uaemex.robotica.valhalla.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author zeroxcharlie
 */
@Entity
@Table(name = "prestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p")
    , @NamedQuery(name = "Prestamo.findById", query = "SELECT p FROM Prestamo p WHERE p.id = :id")
    , @NamedQuery(name = "Prestamo.findByEsKit", query = "SELECT p FROM Prestamo p WHERE p.esKit = :esKit")
    , @NamedQuery(name = "Prestamo.findByComentario", query = "SELECT p FROM Prestamo p WHERE p.comentario = :comentario")
    , @NamedQuery(name = "Prestamo.findByPrestamofecha", query = "SELECT p FROM Prestamo p WHERE p.prestamofecha = :prestamofecha")
    , @NamedQuery(name = "Prestamo.findByPrestamocantidad", query = "SELECT p FROM Prestamo p WHERE p.prestamocantidad = :prestamocantidad")
    , @NamedQuery(name = "Prestamo.findByDevolucionfecha", query = "SELECT p FROM Prestamo p WHERE p.devolucionfecha = :devolucionfecha")
    , @NamedQuery(name = "Prestamo.findByDevolucioncantidad", query = "SELECT p FROM Prestamo p WHERE p.devolucioncantidad = :devolucioncantidad")
    , @NamedQuery(name = "Prestamo.findByCreatedAt", query = "SELECT p FROM Prestamo p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Prestamo.findByUpdatedAt", query = "SELECT p FROM Prestamo p WHERE p.updatedAt = :updatedAt")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "es_kit")
    private Boolean esKit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "prestamofecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prestamofecha;
    @Column(name = "prestamocantidad")
    private Integer prestamocantidad;
    @Column(name = "devolucionfecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date devolucionfecha;
    @Column(name = "devolucioncantidad")
    private Integer devolucioncantidad;
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
    @JoinColumn(name = "articulo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Articulo articuloId;
    @JoinColumn(name = "devolucion_prestador_id", referencedColumnName = "id")
    @ManyToOne
    private Prestador devolucionPrestadorId;
    @JoinColumn(name = "equipo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipo equipoId;
    @JoinColumn(name = "prestamo_prestador_id", referencedColumnName = "id")
    @ManyToOne
    private Prestador prestamoPrestadorId;

    public Prestamo() {
    }

    public Prestamo(Integer id) {
        this.id = id;
    }

    public Prestamo(Integer id, String comentario, Date createdAt, Date updatedAt) {
        this.id = id;
        this.comentario = comentario;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEsKit() {
        return esKit;
    }

    public void setEsKit(Boolean esKit) {
        this.esKit = esKit;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getPrestamofecha() {
        return prestamofecha;
    }

    public void setPrestamofecha(Date prestamofecha) {
        this.prestamofecha = prestamofecha;
    }

    public Integer getPrestamocantidad() {
        return prestamocantidad;
    }

    public void setPrestamocantidad(Integer prestamocantidad) {
        this.prestamocantidad = prestamocantidad;
    }

    public Date getDevolucionfecha() {
        return devolucionfecha;
    }

    public void setDevolucionfecha(Date devolucionfecha) {
        this.devolucionfecha = devolucionfecha;
    }

    public Integer getDevolucioncantidad() {
        return devolucioncantidad;
    }

    public void setDevolucioncantidad(Integer devolucioncantidad) {
        this.devolucioncantidad = devolucioncantidad;
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

    public Articulo getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Articulo articuloId) {
        this.articuloId = articuloId;
    }

    public Prestador getDevolucionPrestadorId() {
        return devolucionPrestadorId;
    }

    public void setDevolucionPrestadorId(Prestador devolucionPrestadorId) {
        this.devolucionPrestadorId = devolucionPrestadorId;
    }

    public Equipo getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(Equipo equipoId) {
        this.equipoId = equipoId;
    }

    public Prestador getPrestamoPrestadorId() {
        return prestamoPrestadorId;
    }

    public void setPrestamoPrestadorId(Prestador prestamoPrestadorId) {
        this.prestamoPrestadorId = prestamoPrestadorId;
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
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uaemex.robotica.valhalla.entities.Prestamo[ id=" + id + " ]";
    }
    
}

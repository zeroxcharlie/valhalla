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
@Table(name = "acceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acceso.findAll", query = "SELECT a FROM Acceso a")
    , @NamedQuery(name = "Acceso.findById", query = "SELECT a FROM Acceso a WHERE a.id = :id")
    , @NamedQuery(name = "Acceso.findByEntrada", query = "SELECT a FROM Acceso a WHERE a.entrada = :entrada")
    , @NamedQuery(name = "Acceso.findBySalida", query = "SELECT a FROM Acceso a WHERE a.salida = :salida")
    , @NamedQuery(name = "Acceso.findByObjetivo", query = "SELECT a FROM Acceso a WHERE a.objetivo = :objetivo")
    , @NamedQuery(name = "Acceso.findByCreatedAt", query = "SELECT a FROM Acceso a WHERE a.createdAt = :createdAt")
    , @NamedQuery(name = "Acceso.findByUpdatedAt", query = "SELECT a FROM Acceso a WHERE a.updatedAt = :updatedAt")})
public class Acceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrada;
    @Column(name = "salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date salida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "objetivo")
    private String objetivo;
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
    @JoinColumn(name = "alumno_id", referencedColumnName = "id")
    @ManyToOne
    private Alumno alumnoId;
    @JoinColumn(name = "externo_id", referencedColumnName = "id")
    @ManyToOne
    private Externo externoId;

    public Acceso() {
    }

    public Acceso(Integer id) {
        this.id = id;
    }

    public Acceso(Integer id, String objetivo, Date createdAt, Date updatedAt) {
        this.id = id;
        this.objetivo = objetivo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
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

    public Alumno getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Alumno alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Externo getExternoId() {
        return externoId;
    }

    public void setExternoId(Externo externoId) {
        this.externoId = externoId;
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
        if (!(object instanceof Acceso)) {
            return false;
        }
        Acceso other = (Acceso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uaemex.robotica.valhalla.entities.Acceso[ id=" + id + " ]";
    }
    
}

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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "prestador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestador.findAll", query = "SELECT p FROM Prestador p")
    , @NamedQuery(name = "Prestador.findById", query = "SELECT p FROM Prestador p WHERE p.id = :id")
    , @NamedQuery(name = "Prestador.findByRol", query = "SELECT p FROM Prestador p WHERE p.rol = :rol")
    , @NamedQuery(name = "Prestador.findByNombre", query = "SELECT p FROM Prestador p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Prestador.findByApellidoPaterno", query = "SELECT p FROM Prestador p WHERE p.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Prestador.findByApellidoMaterno", query = "SELECT p FROM Prestador p WHERE p.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "Prestador.findByInicio", query = "SELECT p FROM Prestador p WHERE p.inicio = :inicio")
    , @NamedQuery(name = "Prestador.findByTermino", query = "SELECT p FROM Prestador p WHERE p.termino = :termino")
    , @NamedQuery(name = "Prestador.findByActivo", query = "SELECT p FROM Prestador p WHERE p.activo = :activo")
    , @NamedQuery(name = "Prestador.findByEmail", query = "SELECT p FROM Prestador p WHERE p.email = :email")
    , @NamedQuery(name = "Prestador.findByPassword", query = "SELECT p FROM Prestador p WHERE p.password = :password")
    , @NamedQuery(name = "Prestador.findByTelefono", query = "SELECT p FROM Prestador p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Prestador.findByCreatedAt", query = "SELECT p FROM Prestador p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Prestador.findByUpdatedAt", query = "SELECT p FROM Prestador p WHERE p.updatedAt = :updatedAt")})
public class Prestador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol")
    private int rol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Column(name = "termino")
    @Temporal(TemporalType.DATE)
    private Date termino;
    @Column(name = "activo")
    private Boolean activo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "telefono")
    private String telefono;
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
    @OneToMany(mappedBy = "devolucionPrestadorId")
    private Collection<Prestamo> prestamoCollection;
    @OneToMany(mappedBy = "prestamoPrestadorId")
    private Collection<Prestamo> prestamoCollection1;

    public Prestador() {
    }

    public Prestador(Integer id) {
        this.id = id;
    }

    public Prestador(Integer id, int rol, String nombre, String apellidoPaterno, String apellidoMaterno, String email, String password, String telefono, Date createdAt, Date updatedAt) {
        this.id = id;
        this.rol = rol;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    @XmlTransient
    public Collection<Prestamo> getPrestamoCollection1() {
        return prestamoCollection1;
    }

    public void setPrestamoCollection1(Collection<Prestamo> prestamoCollection1) {
        this.prestamoCollection1 = prestamoCollection1;
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
        if (!(object instanceof Prestador)) {
            return false;
        }
        Prestador other = (Prestador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uaemex.robotica.valhalla.entities.Prestador[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Marchante
 */
@Entity
@Table(name = "UVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uva.findAll", query = "SELECT u FROM Uva u"),
    @NamedQuery(name = "Uva.findByCodTipoUva", query = "SELECT u FROM Uva u WHERE u.codTipoUva = :codTipoUva"),
    @NamedQuery(name = "Uva.findByNombre", query = "SELECT u FROM Uva u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Uva.findByCaracteristica", query = "SELECT u FROM Uva u WHERE u.caracteristica = :caracteristica"),
    @NamedQuery(name = "Uva.findByColor", query = "SELECT u FROM Uva u WHERE u.color = :color")})
public class Uva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_TIPO_UVA")
    private Integer codTipoUva;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "CARACTERISTICA")
    private String caracteristica;
    @Column(name = "COLOR")
    private String color;
    @OneToMany(mappedBy = "codTipoUva")
    private Collection<Vino_1> vinoCollection;

    public Uva() {
    }

    public Uva(Integer codTipoUva) {
        this.codTipoUva = codTipoUva;
    }

    public Uva(Integer codTipoUva, String nombre, String caracteristica) {
        this.codTipoUva = codTipoUva;
        this.nombre = nombre;
        this.caracteristica = caracteristica;
    }

    public Integer getCodTipoUva() {
        return codTipoUva;
    }

    public void setCodTipoUva(Integer codTipoUva) {
        this.codTipoUva = codTipoUva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @XmlTransient
    public Collection<Vino_1> getVinoCollection() {
        return vinoCollection;
    }

    public void setVinoCollection(Collection<Vino_1> vinoCollection) {
        this.vinoCollection = vinoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoUva != null ? codTipoUva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uva)) {
            return false;
        }
        Uva other = (Uva) object;
        if ((this.codTipoUva == null && other.codTipoUva != null) || (this.codTipoUva != null && !this.codTipoUva.equals(other.codTipoUva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.Uva[ codTipoUva=" + codTipoUva + " ]";
    }
    
}

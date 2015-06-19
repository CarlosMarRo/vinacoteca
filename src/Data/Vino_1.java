/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Marchante
 */
@Entity
@Table(name = "vino")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vino_1.findAll", query = "SELECT v FROM Vino_1 v"),
    @NamedQuery(name = "Vino_1.findByCodVino", query = "SELECT v FROM Vino_1 v WHERE v.codVino = :codVino"),
    @NamedQuery(name = "Vino_1.findByNombre", query = "SELECT v FROM Vino_1 v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Vino_1.findByPrecio", query = "SELECT v FROM Vino_1 v WHERE v.precio = :precio"),
    @NamedQuery(name = "Vino_1.findByOrigen", query = "SELECT v FROM Vino_1 v WHERE v.origen = :origen"),
    @NamedQuery(name = "Vino_1.findByFecha", query = "SELECT v FROM Vino_1 v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Vino_1.findByDenominacion", query = "SELECT v FROM Vino_1 v WHERE v.denominacion = :denominacion")})
public class Vino_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Cod_Vino")
    private String codVino;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Precio")
    private double precio;
    @Basic(optional = false)
    @Column(name = "Origen")
    private String origen;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "denominacion")
    private boolean denominacion;
    @JoinColumn(name = "Cod_Tipo_Uva", referencedColumnName = "Cod_Tipo_Uva")
    @ManyToOne
    private Uva codTipoUva;

    public Vino_1() {
    }

    public Vino_1(String codVino) {
        this.codVino = codVino;
    }

    public Vino_1(String codVino, String nombre, double precio, String origen, Date fecha, boolean denominacion) {
        this.codVino = codVino;
        this.nombre = nombre;
        this.precio = precio;
        this.origen = origen;
        this.fecha = fecha;
        this.denominacion = denominacion;
    }

    public String getCodVino() {
        return codVino;
    }

    public void setCodVino(String codVino) {
        this.codVino = codVino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(boolean denominacion) {
        this.denominacion = denominacion;
    }

    public Uva getCodTipoUva() {
        return codTipoUva;
    }

    public void setCodTipoUva(Uva codTipoUva) {
        this.codTipoUva = codTipoUva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVino != null ? codVino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vino_1)) {
            return false;
        }
        Vino_1 other = (Vino_1) object;
        if ((this.codVino == null && other.codVino != null) || (this.codVino != null && !this.codVino.equals(other.codVino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.Vino_1[ codVino=" + codVino + " ]";
    }
    
}

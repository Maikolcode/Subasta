/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sub.subasta.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ROOT
 */
@Entity
@Table(name = "subasta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subasta.findAll", query = "SELECT s FROM Subasta s")})
public class Subasta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subasta")
    private Integer idSubasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_ofrecido")
    private double valorOfrecido;
    @JoinColumn(name = "codigo_cliente", referencedColumnName = "id_clientes")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clientes codigoCliente;
    @JoinColumn(name = "codigo_moneda", referencedColumnName = "id_moneda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Moneda codigoMoneda;
    @JoinColumn(name = "codigo_producto", referencedColumnName = "id_productos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Productos codigoProducto;

    public Subasta() {
    }

    public Subasta(Integer idSubasta) {
        this.idSubasta = idSubasta;
    }

    public Subasta(Integer idSubasta, double valorOfrecido) {
        this.idSubasta = idSubasta;
        this.valorOfrecido = valorOfrecido;
    }

    public Integer getIdSubasta() {
        return idSubasta;
    }

    public void setIdSubasta(Integer idSubasta) {
        this.idSubasta = idSubasta;
    }

    public double getValorOfrecido() {
        return valorOfrecido;
    }

    public void setValorOfrecido(double valorOfrecido) {
        this.valorOfrecido = valorOfrecido;
    }

    public Clientes getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Clientes codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Moneda getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(Moneda codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public Productos getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Productos codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubasta != null ? idSubasta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subasta)) {
            return false;
        }
        Subasta other = (Subasta) object;
        if ((this.idSubasta == null && other.idSubasta != null) || (this.idSubasta != null && !this.idSubasta.equals(other.idSubasta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sub.subasta.entity.Subasta[ idSubasta=" + idSubasta + " ]";
    }
    
}

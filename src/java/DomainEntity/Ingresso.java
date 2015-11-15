/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainEntity;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author Igor
 */
@Entity
@Table(name = "ingresso")
@NamedQueries({
    @NamedQuery(name = "Ingresso.findAll", query = "SELECT i FROM Ingresso i"),
    @NamedQuery(name = "Ingresso.findById", query = "SELECT i FROM Ingresso i WHERE i.id = :id"),
    @NamedQuery(name = "Ingresso.findByValor", query = "SELECT i FROM Ingresso i WHERE i.valor = :valor"),
    @NamedQuery(name = "Ingresso.findByDataHoraCompra", query = "SELECT i FROM Ingresso i WHERE i.dataHoraCompra = :dataHoraCompra")})
public class Ingresso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "dataHoraCompra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraCompra;
    @JoinColumn(name = "secaoId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Secao secaoId;

    public Ingresso() {
    }

    public Ingresso(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataHoraCompra() {
        return dataHoraCompra;
    }

    public void setDataHoraCompra(Date dataHoraCompra) {
        this.dataHoraCompra = dataHoraCompra;
    }

    public Secao getSecaoId() {
        return secaoId;
    }

    public void setSecaoId(Secao secaoId) {
        this.secaoId = secaoId;
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
        if (!(object instanceof Ingresso)) {
            return false;
        }
        Ingresso other = (Ingresso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DomainEntity.Ingresso[ id=" + id + " ]";
    }
    
}

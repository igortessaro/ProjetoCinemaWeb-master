/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainEntity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Igor
 */
@Entity
@Table(name = "sala")
@NamedQueries({
    @NamedQuery(name = "Sala.findAll", query = "SELECT s FROM Sala s"),
    @NamedQuery(name = "Sala.findById", query = "SELECT s FROM Sala s WHERE s.id = :id"),
    @NamedQuery(name = "Sala.findByNumero", query = "SELECT s FROM Sala s WHERE s.numero = :numero"),
    @NamedQuery(name = "Sala.findByQuantidadeAssentos", query = "SELECT s FROM Sala s WHERE s.quantidadeAssentos = :quantidadeAssentos"),
    @NamedQuery(name = "Sala.findByTresD", query = "SELECT s FROM Sala s WHERE s.tresD = :tresD")})
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidadeAssentos")
    private int quantidadeAssentos;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "tresD")
    private boolean tresD;
    
    @Transient 
    private String tresDDescricao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salaId")
    private Collection<Secao> secaoCollection;

    public Sala() {
    }

    public Sala(Integer id) {
        this.id = id;
    }

    public Sala(Integer id, int numero, int quantidadeAssentos, boolean tresD) {
        this.id = id;
        this.numero = numero;
        this.quantidadeAssentos = quantidadeAssentos;
        this.tresD = tresD;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQuantidadeAssentos() {
        return quantidadeAssentos;
    }

    public void setQuantidadeAssentos(int quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public boolean getTresD() {
        return tresD;
    }

    public void setTresD(boolean tresD) {
        this.tresD = tresD;
    }

    public String getTresDDescricao() {
        return this.tresD ? "Sim" : "Não";
    }

    public void setTresDDescricao(String TresDDescricao) {
        this.tresDDescricao = TresDDescricao;
    }
    
    public Collection<Secao> getSecaoCollection() {
        return secaoCollection;
    }

    public void setSecaoCollection(Collection<Secao> secaoCollection) {
        this.secaoCollection = secaoCollection;
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
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DomainEntity.Sala[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainEntity;

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
import javax.persistence.Transient;

/**
 *
 * @author Igor
 */
@Entity
@Table(name = "secao")
@NamedQueries({
    @NamedQuery(name = "Secao.findAll", query = "SELECT s FROM Secao s"),
    @NamedQuery(name = "Secao.findById", query = "SELECT s FROM Secao s WHERE s.id = :id"),
    @NamedQuery(name = "Secao.findByDataHoraInicio", query = "SELECT s FROM Secao s WHERE s.dataHoraInicio = :dataHoraInicio"),
    @NamedQuery(name = "Secao.findByTempoDuracaoMinutos", query = "SELECT s FROM Secao s WHERE s.tempoDuracaoMinutos = :tempoDuracaoMinutos")})
public class Secao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dataHoraInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraInicio;
    @Column(name = "tempoDuracaoMinutos")
    private Integer tempoDuracaoMinutos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "secaoId")
    private Collection<Ingresso> ingressoCollection;
    @JoinColumn(name = "salaId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Sala salaId;
    @JoinColumn(name = "filmeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Filme filmeId;

    public Secao() {
    }

    public Secao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Integer getTempoDuracaoMinutos() {
        return tempoDuracaoMinutos;
    }

    public void setTempoDuracaoMinutos(Integer tempoDuracaoMinutos) {
        this.tempoDuracaoMinutos = tempoDuracaoMinutos;
    }

    public Collection<Ingresso> getIngressoCollection() {
        return ingressoCollection;
    }

    public void setIngressoCollection(Collection<Ingresso> ingressoCollection) {
        this.ingressoCollection = ingressoCollection;
    }

    public Sala getSalaId() {
        return salaId;
    }

    public void setSalaId(Sala salaId) {
        this.salaId = salaId;
    }

    public Filme getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Filme filmeId) {
        this.filmeId = filmeId;
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
        if (!(object instanceof Secao)) {
            return false;
        }
        Secao other = (Secao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (filmeId != null && salaId != null) {
            return "Seção [ id=" + id + ", filme= " + filmeId.getNome() + ", sala= " + salaId.getNumero() + " ]";
        }else{
            return "DomainEntity.Secao[ id=" + id + " ]";
        }
    }

}

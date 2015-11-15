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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Igor
 */
@Entity
@Table(name = "filme")
@NamedQueries({
    @NamedQuery(name = "Filme.findAll", query = "SELECT f FROM Filme f"),
    @NamedQuery(name = "Filme.findById", query = "SELECT f FROM Filme f WHERE f.id = :id"),
    @NamedQuery(name = "Filme.findByNome", query = "SELECT f FROM Filme f WHERE f.nome = :nome"),
    @NamedQuery(name = "Filme.findByGenero", query = "SELECT f FROM Filme f WHERE f.genero = :genero"),
    @NamedQuery(name = "Filme.findByAno", query = "SELECT f FROM Filme f WHERE f.ano = :ano"),
    @NamedQuery(name = "Filme.findByDiretor", query = "SELECT f FROM Filme f WHERE f.diretor = :diretor")})
public class Filme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "sinopse")
    private String sinopse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "diretor")
    private String diretor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filmeId")
    private Collection<Secao> secaoCollection;

    public Filme() {
    }

    public Filme(Integer id) {
        this.id = id;
    }

    public Filme(Integer id, String nome, String genero, String sinopse, int ano, String diretor) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
        this.ano = ano;
        this.diretor = diretor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
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
        if (!(object instanceof Filme)) {
            return false;
        }
        Filme other = (Filme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DomainEntity.Filme[ id=" + id + " ]";
    }
    
}

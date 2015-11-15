package Controllers;

import Domain.Filme;
import Domain.Genero;
import Domain.Sala;
import DomainEntity.Secao;
import Exception.BusinessException;
import Service.SecaoService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SecaoController {

    private static final String urlDefault = "/faces/views/cadastros/secao/search.xhtml";
    private static final String urlEdit = "/faces/views/cadastros/secao/detail.xhtml";
    
    private SecaoService service;
    
    public SecaoController() {
        this.service = new SecaoService();
        this.secaoList = this.service.obterTodos();
    }
    
    private Secao secao;

    private Secao secaoDetail;

    private List<Secao> secaoList;
    
    private boolean actionNew;

    public boolean isActionNew() {
        return actionNew;
    }

    public void setActionNew(boolean actionNew) {
        this.actionNew = actionNew;
    } 

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    public Secao getSecaoDetail() {
        return secaoDetail;
    }

    public void setSecaoDetail(Secao secaoDetail) {
        this.secaoDetail = secaoDetail;
    }

    public List<Secao> getSecaoList() {
        return secaoList;
    }

    public void setSecaoList(List<Secao> secaoList) {
        this.secaoList = secaoList;
    }
    
    public String search() {
        return urlDefault + "?faces-redirect=true";
    }

    public String excluir(Secao secao) {
        this.service.remover(secao);
        this.secaoList = this.service.obterTodos();

        return urlDefault + "?faces-redirect=true";
    }
    
    public String edit(Secao secao) {
        this.secao = secao;
        this.secaoDetail = this.service.obter(secao.getId());
        this.actionNew = false;
        return urlEdit + "?faces-redirect=true";
    }

    public String novo() {
        this.secaoDetail = new Secao();
        this.actionNew = true;
        return urlEdit + "?faces-redirect=true";
    }

    public String salvar() {
        if (this.actionNew) {
            this.adicionarNovo(this.secaoDetail);
        } else {
            this.atualizar(this.secaoDetail);
        }

        return urlDefault + "?faces-redirect=true";
    }

    private void adicionarNovo(Secao secao) {
        try {
            this.service.salvar(secao);
        } catch (BusinessException ex) {
            Logger.getLogger(SecaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.secaoList = this.service.obterTodos();
    }

    private void atualizar(Secao secao) {
        try {
            this.service.salvar(secao);
        } catch (BusinessException ex) {
            Logger.getLogger(SecaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.secaoList = this.service.obterTodos();
    }
    
    public Secao findSecaoByDecricao(String descricao){

        for (Secao s : this.secaoList) {
            if (s != null) {
                if (s.toString().toLowerCase().trim().equals(descricao.toLowerCase().trim())) {
                    return (s);
                }
            }
        }
        return null;
    }
    
}

package Controllers;

import DomainEntity.Sala;
import Exception.BusinessException;
import Service.SalaService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SalaController {

    private static final String urlDefault = "/faces/views/cadastros/sala/search.xhtml";
    private static final String urlEdit = "/faces/views/cadastros/sala/detail.xhtml";

    private SalaService service;
    
    public SalaController() {
        this.service = new SalaService();
        this.salaList = this.service.obterTodos();
    }

    private Sala sala;

    private Sala salaDetail;

    private List<Sala> salaList;

    private boolean actionNew;

    public boolean isActionNew() {
        return actionNew;
    }

    public void setActionNew(boolean actionNew) {
        this.actionNew = actionNew;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Sala getSalaDetail() {
        return salaDetail;
    }

    public void setSalaDetail(Sala salaDetail) {
        this.salaDetail = salaDetail;
    }

    public List<Sala> getSalaList() {
        return salaList;
    }

    public void setSalaList(List<Sala> salaList) {
        this.salaList = salaList;
    }

    public String search() {
        return urlDefault + "?faces-redirect=true";
    }

    public String excluir(Sala sala) {
        this.service.remover(sala);
        this.salaList = this.service.obterTodos();

        return urlDefault + "?faces-redirect=true";
    }

    public String edit(Sala sala) {
        this.sala = sala;
        this.salaDetail = this.service.obter(sala.getId());
        this.actionNew = false;
        return urlEdit + "?faces-redirect=true";
    }

    public String novo() {
        this.salaDetail = new Sala();
        this.actionNew = true;
        return urlEdit + "?faces-redirect=true";
    }

    public String salvar() {
        if (this.actionNew) {
            this.adicionarNovo(this.salaDetail);
        } else {
            this.atualizar(this.salaDetail);
        }

        return urlDefault + "?faces-redirect=true";
    }

    private void adicionarNovo(Sala sala) {
        try {
            this.service.salvar(sala);
        } catch (BusinessException ex) {
            Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.salaList = this.service.obterTodos();
    }

    private void atualizar(Sala sala) {
        try {
            this.service.atualizar(sala);
        } catch (BusinessException ex) {
            Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.salaList = this.service.obterTodos();
    }

    public Sala findSalaByNumero(String numero) {
        int numeroInt = 0;
        numeroInt = Integer.parseInt(numero);
        return this.service.obterPorNumero(numeroInt);
    }
}

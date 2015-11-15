package Controllers;

import DomainEntity.Ingresso;
import Exception.BusinessException;
import Service.VendaService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class VendaController {

    public VendaController() {
        this.service = new VendaService();
        this.ingressoList = this.service.obterTodos();
    }

    private static final String urlDefault = "/faces/views/cadastros/venda/search.xhtml";
    private static final String urlEdit = "/faces/views/cadastros/venda/detail.xhtml";

    private final VendaService service;
    
    private Ingresso ingresso;

    private Ingresso ingressoDetail;

    private List<Ingresso> ingressoList;

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public Ingresso getIngressoDetail() {
        return ingressoDetail;
    }

    public void setIngressoDetail(Ingresso ingressoDetail) {
        this.ingressoDetail = ingressoDetail;
    }

    public List<Ingresso> getIngressoList() {
        return ingressoList;
    }

    public void setIngressoList(List<Ingresso> ingresssoList) {
        this.ingressoList = ingresssoList;
    }

    public String novo() {
        this.ingressoDetail = new Ingresso();
        return urlEdit + "?faces-redirect=true";
    }

    public String search() {
        return urlDefault + "?faces-redirect=true";
    }

    public String salvar() {
        this.adicionarNovo(this.ingressoDetail);

        return urlDefault + "?faces-redirect=true";
    }

    private void adicionarNovo(Ingresso entity) {
        try {
            this.service.salvar(entity);
        } catch (BusinessException ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.ingressoList = this.service.obterTodos();
    }
}

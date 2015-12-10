package Controllers;

import DomainEntity.Filme;
import Domain.Genero;
import Exception.BusinessException;
import Service.FilmeService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class FilmeController {

    private static final String urlDefault = "/faces/views/cadastros/filme/search.xhtml";
    private static final String urlEdit = "/faces/views/cadastros/filme/detail.xhtml";

    private final FilmeService service;

    public FilmeController() {
        this.service = new FilmeService();
        this.actionNew = false;
        this.filmeList = this.service.obterTodos();
    }

    private Filme filme;

    private Filme filmeDetail;

    private List<Filme> filmeList;

    private boolean actionNew;

    public boolean isActionNew() {
        return actionNew;
    }

    public void setActionNew(boolean actionNew) {
        this.actionNew = actionNew;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Filme> getFilmeList() {
        return filmeList;
    }

    public void setFilmeList(List<Filme> filmeList) {
        this.filmeList = filmeList;
    }

    public Filme getFilmeDetail() {
        return filmeDetail;
    }

    public void setFilmeDetail(Filme filmeDetail) {
        this.filmeDetail = filmeDetail;
    }

    public String search() {
        return urlDefault + "?faces-redirect=true";
    }

    public String excluirFilme(Filme filme) {
        this.service.remover(filme);
        this.filmeList = this.service.obterTodos();

        return urlDefault + "?faces-redirect=true";
    }

    public String editFilme(Filme filme) {
        this.filme = filme;
        this.filmeDetail = this.service.obter(filme.getId());
        this.actionNew = false;
        return urlEdit + "?faces-redirect=true";
    }

    public String newFilme() {
        this.filmeDetail = new Filme();
        this.actionNew = true;
        return urlEdit + "?faces-redirect=true";
    }

    public String salvar() {
        if (this.actionNew) {
            if (!this.adicionarFilmeNovo(this.filmeDetail)) {
                return urlEdit + "?faces-redirect=true";
            }
            return urlDefault + "?faces-redirect=true";
        } else {
            this.atualizarFilme(this.filmeDetail);
        }

        return urlDefault + "?faces-redirect=true";
    }

    private boolean adicionarFilmeNovo(Filme filme) {
        boolean result = true;

        try {
            this.service.salvar(filme);
        } catch (BusinessException ex) {
            String erro = ex.getMessage();

            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "[ERRO]: " + erro,
                    "Informe um filme NOVO!");
            this.adicionarMensagemErro(mensagem);

            result = false;
        }

        if (result) {
            this.filmeList = this.service.obterTodos();
        }

        return result;
    }

    private void atualizarFilme(Filme filme) {
        try {
            this.service.atualizar(filme);
            this.filmeList = this.service.obterTodos();
        } catch (BusinessException ex) {
            String erro = ex.getMessage();

            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "[ERRO]: " + erro,
                    erro);
            this.adicionarMensagemErro(mensagem);
        }
    }

    public Filme findFilmeByNome(String nome) {
        return this.service.obter(nome);
    }

    private void adicionarMensagemErro(FacesMessage mensagem) {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage("mensagemFilme", mensagem);
    }
}

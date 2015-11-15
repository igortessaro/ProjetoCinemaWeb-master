package Controllers;

import Domain.TipoUsuario;
import Domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginController {

    //private static final String urlAdm = "/faces/adminView.xhtml";

    //private static final String urlUser = "/faces/userView.xhtml";

    private static final String urlLogin = "/faces/login.xhtml";
    
    private static final String urlDefault = "/faces/views/index.xhtml";
    
    public LoginController() {        
        //this.listaUsuarios = DbContext.getUsuarioList();
        
        listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add(new Usuario("abcde", "123", TipoUsuario.Administrador));
        listaUsuarios.add(new Usuario("fulano", "123", TipoUsuario.Comum));
        listaUsuarios.add(new Usuario("sicrano", "123", TipoUsuario.Comum));
        listaUsuarios.add(new Usuario("beltrano", "123", TipoUsuario.Comum));

        
        this.Usuario = new Usuario();
        this.logado = false;
    }
    
    private List<Usuario> listaUsuarios;

    private boolean logado;
    
    private boolean manterLogado;
    
    private Usuario Usuario;
    
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> ListaUsuarios) {
        this.listaUsuarios = ListaUsuarios;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public boolean getManterLogado(){
        return this.manterLogado;
    }
    
    public void setManterLogado(boolean manterLogado){
        this.manterLogado = manterLogado;
    }
    
    public String fazerLogin() {
        if (listaUsuarios.contains(this.Usuario)) {
            Usuario usuarioLogado = null;

            for (Usuario user : listaUsuarios) {
                if (user.equals(this.Usuario)) {
                    this.Usuario = usuarioLogado = user;
                }
            }

            if (usuarioLogado != null) {
                switch (usuarioLogado.getTipoUsuario()) {
                    case Comum:
                        this.logado = true;
                        return "/faces/views/index.xhtml?faces-redirect=true";
                    case Administrador:
                        this.logado = true;
                        return "/faces/views/index.xhtml?faces-redirect=true";
                    default:
                        FacesMessage mensagem = new FacesMessage(
                                FacesMessage.SEVERITY_ERROR,
                                "Não foi possivel identificar o tipo do usuário!",
                                "Logue novamente!");
                        this.adicionarMensagemErro(mensagem);
                        return "login";
                }
            }

            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Usuário não encontrado!",
                    "Tente novamente mais tarde!");
            this.adicionarMensagemErro(mensagem);
            return "login";
        } else {
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Login Inválido!",
                    "Usuário e/ou senha estão errados! Digite sua senha novamente!");
            this.adicionarMensagemErro(mensagem);
            return "login";
        }
    }

    private void adicionarMensagemErro(FacesMessage mensagem) {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage("mensagemLogin", mensagem);
    }

    public String logout() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().invalidateSession();
        this.logado = false;
        return (urlLogin+"?faces-redirect=true");
    }

    public Boolean estaLogado() {
        return this.logado;
    }

    public String getUrl() {
        if (this.Usuario == null && !this.estaLogado()) {
            return urlLogin;
        }

        if (this.usuarioAdministrador()) {
            return urlDefault;
        }

        return urlDefault;
    }

    public boolean usuarioAdministrador() {
        if (this.Usuario == null) {
            return false;
        }

        return this.Usuario.getTipoUsuario() == TipoUsuario.Administrador;
    }    
}

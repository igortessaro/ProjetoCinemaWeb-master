package Domain;

import java.util.Objects;

public class Usuario {
    private String Login;

    private String Senha;

    private TipoUsuario TipoUsuario;

    private String TipoUsuarioDescricao;

    public Usuario() {

    }

    public Usuario(String login, String senha, TipoUsuario tipoUsuario) {
        this.Login = login;
        this.Senha = senha;
        this.TipoUsuario = tipoUsuario;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        this.Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        this.Senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    public String getTipoUsuarioDescricao() {
        String result;

        if (this.TipoUsuario != null) {
            switch (this.TipoUsuario) {
                case Administrador:
                    result = "Administrador";
                    break;
                case Comum:
                    result = "Usuário";
                    break;
                case Nenhum:
                default:
                    result = "";
            }
        } else {
            result = "";
        }

        return result;
    }

    public void setTipoUsuarioDescricao(String TipoUsuarioDescricao) {
        this.TipoUsuarioDescricao = TipoUsuarioDescricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Usuario other = (Usuario) obj;

        return !(!Objects.equals(this.Login, other.Login)
                || !Objects.equals(this.Senha, other.Senha));
        //|| !Objects.equals(this.TipoUsuario, other.TipoUsuario));
    }
}

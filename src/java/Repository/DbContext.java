package Repository;

import Domain.Filme;
import Domain.Sala;
import Domain.Secao;
import Domain.TipoUsuario;
import Domain.Usuario;
import java.util.ArrayList;
import java.util.List;

public final class DbContext {
    public DbContext(){
        // Inicialização dos Ususários.
        this.usuarioList = new ArrayList<Usuario>();
        this.usuarioList.add(new Usuario("abcde", "123", TipoUsuario.Administrador));
        this.usuarioList.add(new Usuario("fulano", "123", TipoUsuario.Comum));
        this.usuarioList.add(new Usuario("sicrano", "123", TipoUsuario.Comum));
        this.usuarioList.add(new Usuario("beltrano", "123", TipoUsuario.Comum));
    }
    
    private static List<Usuario> usuarioList;
    
    private static List<Filme> filmeList;
    
    private static List<Sala> salaList;
    
    private static List<Secao> secaoList;

    public static List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public static void setUsuarioList(List<Usuario> usuarioList) {
        DbContext.usuarioList = usuarioList;
    }

    public static List<Filme> getFilmeList() {
        return filmeList;
    }

    public static void setFilmeList(List<Filme> filmeList) {
        DbContext.filmeList = filmeList;
    }

    public static List<Sala> getSalaList() {
        return salaList;
    }

    public static void setSalaList(List<Sala> salaList) {
        DbContext.salaList = salaList;
    }

    public static List<Secao> getSecaoList() {
        return secaoList;
    }

    public static void setSecaoList(List<Secao> secaoList) {
        DbContext.secaoList = secaoList;
    } 
}

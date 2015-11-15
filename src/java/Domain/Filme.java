package Domain;

import java.util.Objects;

public class Filme {

    public Filme() {
    }

    public Filme(String nome, Genero genero, int ano, String diretorNome, String sinopse) {
        this.Nome = nome;
        this.Genero = genero;
        this.Ano = ano;
        this.DiretorNome = diretorNome;
        this.Sinopse = sinopse;
    }

    public Filme(Filme filme) {
        this.Nome = filme.getNome();
        this.Genero = filme.getGenero();
        this.Ano = filme.getAno();
        this.DiretorNome = filme.getDiretorNome();
        this.Sinopse = filme.getSinopse();
    }

    private String Nome;

    private Genero Genero;

    private int Ano;

    private String DiretorNome;

    private String Sinopse;

    private String GeneroNome;
    
    private String GeneroString;

    public String getGeneroString() {
        return GeneroString;
    }

    public void setGeneroString(String GeneroString) {
        this.GeneroString = GeneroString;
    }

    public String getGeneroNome() {
        String result = "";
        String naoEncontrado = "Gênero não encontrado";

        if (this.Genero == null) {
            return naoEncontrado;
        }

        switch (this.Genero) {
            case Acao:
                result = "Ação";
                break;
            case Comedia:
                result = "Comédia";
                break;
            case Drama:
                result = "Drama";
                break;
            case Romance:
                result = "Romance";
                break;
            case Terror:
                result = "Terror";
                break;
            default:
                result = naoEncontrado;
                break;
        }

        return result;
    }

    public void setGeneroNome(String generoNome) {
        //this.GeneroNome = generoNome;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Genero getGenero() {
        return Genero;
    }

    public void setGenero(Genero Genero) {
        this.Genero = Genero;
    }
    
    public void setGenero(String genero) {
        
        if(genero == null) return;
        
        switch (genero) {
            case "4":
                this.Genero = Genero.Acao;
                break;
            case "1":
                this.Genero = Genero.Comedia;
                break;
            case "2":
                this.Genero = Genero.Drama;
                break;
            case "5":
                this.Genero = Genero.Romance;
                break;
            case "3":
                this.Genero = Genero.Terror;
                break;
        }
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public String getDiretorNome() {
        return DiretorNome;
    }

    public void setDiretorNome(String DiretorNome) {
        this.DiretorNome = DiretorNome;
    }

    public String getSinopse() {
        return Sinopse;
    }

    public void setSinopse(String Sinopse) {
        this.Sinopse = Sinopse;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Filme other = (Filme) obj;

        return !(!Objects.equals(this.Nome, other.Nome));
    }

    public void atualizar(Filme filme) {
        this.Ano = filme.getAno();
        this.DiretorNome = filme.getDiretorNome();
        //this.Genero = filme.getGenero();
        this.setGenero(filme.getGeneroString());
        this.Sinopse = filme.getSinopse();
    }
}

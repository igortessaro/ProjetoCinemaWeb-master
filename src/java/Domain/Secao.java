package Domain;

public class Secao {

    public Secao() {
    }

    public Secao(Secao secao) {
        this.atualizar(secao);
    }
    
    public Secao(Sala sala, Filme filme, String dataHoraInicio, int tempoDeDuracao){
        this.Sala = sala;
        this.Filme = filme;
        this.DataHoraInicio = dataHoraInicio;
        this.TempoDeDuracao = tempoDeDuracao;
    }

    private Sala Sala;

    private Filme Filme;

    private String DataHoraInicio;

    private int TempoDeDuracao;

    public Sala getSala() {
        return Sala;
    }

    public void setSala(Sala Sala) {
        this.Sala = Sala;
    }

    public Filme getFilme() {
        return Filme;
    }

    public void setFilme(Filme Filme) {
        this.Filme = Filme;
    }

    public String getDataHoraInicio() {
        return DataHoraInicio;
    }

    public void setDataHoraInicio(String DataHoraInicio) {
        this.DataHoraInicio = DataHoraInicio;
    }

    public int getTempoDeDuracao() {
        return TempoDeDuracao;
    }

    public void setTempoDeDuracao(int TempoDeDuracao) {
        this.TempoDeDuracao = TempoDeDuracao;
    }

    public void atualizar(Secao secao) {
        this.DataHoraInicio = secao.getDataHoraInicio();
        this.Filme = secao.getFilme();
        this.Sala = secao.getSala();
        this.TempoDeDuracao = secao.getTempoDeDuracao();
    }
    
    @Override
    public String toString(){
        String filmeNome = this.Filme != null ? this.Filme.getNome() : "Filme não encontrado.";
        String sala = this.Sala != null ? Integer.toString(this.Sala.getNumero()) : "Sala não encontrada.";
        
        return this.TempoDeDuracao + 
                " minutos de duração, no dia " + 
                this.DataHoraInicio +
                ", para o filme " +
                filmeNome +
                ", na sala " +
                sala;
    }
}

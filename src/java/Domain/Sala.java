package Domain;

import java.util.Objects;

public class Sala {
    
    public Sala(){}
    
    public Sala(int numero, int quantidadeDeAssentos, boolean tresD) {
        this.Numero = numero;
        this.QuantidadeAssentos = quantidadeDeAssentos;
        this.TresD = tresD;
    }    
    
    public Sala(Sala sala) {
        this.Numero = sala.getNumero();
        this.QuantidadeAssentos = sala.getQuantidadeAssentos();
        this.TresD = sala.isTresD();
    }
    
    private int Numero;
    
    private int QuantidadeAssentos;

    private boolean TresD;
    
    private String TresDDescricao;
    
    @Override
    public String toString(){
        return String.format("Sala - Número: %s, Quantidade de Assentos: %s.", this.Numero, this.QuantidadeAssentos);
    }
    
    @Override
    public boolean  equals(Object obj){
         if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Sala other = (Sala) obj;

        return !(!Objects.equals(this.Numero, other.Numero));
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public int getQuantidadeAssentos() {
        return QuantidadeAssentos;
    }

    public void setQuantidadeAssentos(int QuantidadeAssentos) {
        this.QuantidadeAssentos = QuantidadeAssentos;
    }

    public boolean isTresD() {
        return TresD;
    }

    public void setTresD(boolean TresD) {
        this.TresD = TresD;
    }

    public String getTresDDescricao() {
        return this.TresD ? "Sim" : "Não";
    }

    public void setTresDDescricao(String TresDDescricao) {
        this.TresDDescricao = TresDDescricao;
    }
    
    public void atualizar(Sala sala){
        this.Numero = sala.getNumero();
        this.QuantidadeAssentos = sala.getQuantidadeAssentos();
        this.TresD = sala.isTresD();
    }
}

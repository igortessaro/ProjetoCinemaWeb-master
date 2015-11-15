package Domain;

public enum Genero {
    Comedia(1),
    Drama(2),
    Terror(3),
    Acao(4),
    Romance(5);
    
    private int numVal;

    Genero(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}

package model;

public enum TipoUsuario {
    ADMIN (1), USER (2);
    private final int valorTipo;
    
    private TipoUsuario(int valorTipo) {
        this.valorTipo = valorTipo;
    }
    
    public int getValor() {
        return valorTipo;
    }
}

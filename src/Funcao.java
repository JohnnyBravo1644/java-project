public enum Funcao {
    OPERADOR("Operador"),
    COORDENADOR("Coordenador"),
    DIRETOR("Diretor"),
    RECEPCIONISTA("Recepcionista"),
    CONTADOR("Contador"),
    GERENTE("Gerente"),
    ELETRICISTA("Eletricista");

    private final String nomeFuncao;

    Funcao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }
}
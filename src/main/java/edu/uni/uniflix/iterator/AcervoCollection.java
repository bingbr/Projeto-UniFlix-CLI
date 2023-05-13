package edu.uni.uniflix.iterator;

public interface AcervoCollection {
    void adicionar(Acervo ac);
    void remover(int posicao);
    void editar(int posicao, Acervo ac);
    int tamanho();
    boolean vazio();
    AcervoIterator iterator(AcervoTipoEnum tipo);
}

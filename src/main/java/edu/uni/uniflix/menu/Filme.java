package edu.uni.uniflix.menu;

import edu.uni.uniflix.iterator.AcervoTipoEnum;

public class Filme extends Catalogo {
    public Filme(Catalogo catalogo) {
        this.acervo = catalogo.acervo;
    }

    @Override
    public void exibir() {
        boolean tamanho = acervo.iterator(AcervoTipoEnum.FILME).vazio();
        Generic.exibir("FILME", tamanho, acervo, AcervoTipoEnum.FILME);
    }
}

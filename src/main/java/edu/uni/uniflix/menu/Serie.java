package edu.uni.uniflix.menu;

import edu.uni.uniflix.iterator.AcervoTipoEnum;

public class Serie extends Catalogo {
    public Serie(Catalogo catalogo) {
        this.acervo = catalogo.acervo;
    }

    @Override
    public void exibir() {
        boolean tamanho = acervo.iterator(AcervoTipoEnum.SERIE).vazio();
        Generic.exibir("SÉRIE", tamanho, acervo, AcervoTipoEnum.SERIE);
    }
}

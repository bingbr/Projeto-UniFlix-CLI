package edu.uni.uniflix.iterator;

import java.util.LinkedList;

public class AcervoCollectionImpl implements AcervoCollection {
    private LinkedList<Acervo> lista;
    
    public AcervoCollectionImpl() {
        lista = new LinkedList<>();
    }

    @Override
    public void adicionar(Acervo acervo) {
        this.lista.add(acervo);
    }

    @Override
    public void remover(int posicao) {
        this.lista.remove(posicao);
    }

    @Override
    public void editar(int posicao, Acervo acervo) {
        this.lista.set(posicao, acervo);
    }

    @Override
    public int tamanho() {
        return this.lista.size();
    }
    
    @Override
    public boolean vazio() {
        return this.lista.isEmpty();
    }

    @Override
    public AcervoIterator iterator(AcervoTipoEnum tipo) {
        return new AcervoIteratorImpl(tipo, this.lista);
    }

    private class AcervoIteratorImpl implements AcervoIterator {
        private AcervoTipoEnum tipo;
        private LinkedList<Acervo> acervos;
        private int posicao;

        public AcervoIteratorImpl(AcervoTipoEnum tipoEnum, LinkedList<Acervo> listaAcervo) {
            this.tipo = tipoEnum;
            this.acervos = listaAcervo;
        }

        @Override
        public boolean hasNext() {
            while (posicao < acervos.size()) {
                Acervo acervo = acervos.get(posicao);
                if (acervo.getTipo().equals(tipo) || tipo.equals(AcervoTipoEnum.TODOS))
                    return true;
                else
                    posicao++;
            }
            return false;
        }

        @Override
        public Acervo next() {
            Acervo acervo = acervos.get(posicao);
            posicao++;
            return acervo;
        }

        @Override
        public boolean vazio() {
            LinkedList<Acervo> filtrado = new LinkedList<>();
            for (Acervo acervo : acervos)
                if (acervo.getTipo().equals(tipo))
                    filtrado.add(acervo);
            return filtrado.isEmpty();
        }
    }
}

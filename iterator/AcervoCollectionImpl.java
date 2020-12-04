package iterator;

import java.util.LinkedList;

public class AcervoCollectionImpl implements AcervoCollection{

    private LinkedList<Acervo> listaAcervo;

    public AcervoCollectionImpl(){
        listaAcervo = new LinkedList<>();
    }

    public void adicionarAcervo(Acervo ac){
        this.listaAcervo.add(ac);
    }

    public void removerAcervo(int posicao){
        this.listaAcervo.remove(posicao);
    }

    public void editarAcervo(int posicao, Acervo ac){
        this.listaAcervo.set(posicao, ac);
    }

    public int tamanhoAcervo(){
        return this.listaAcervo.size();
    }

    @Override
    public AcervoIterator iterator(AcervoTipoEnum tipo){
        return new AcervoIteratorImpl(tipo, this.listaAcervo);
    }

    private class AcervoIteratorImpl implements AcervoIterator {

        private AcervoTipoEnum tipo;
        private LinkedList<Acervo> acervos;
        private int posicao;

        public AcervoIteratorImpl(AcervoTipoEnum ty, LinkedList<Acervo> listaAcervo) {
            this.tipo = ty;
            this.acervos = listaAcervo;
        }

        @Override
        public boolean hasNext(){
            while (posicao < acervos.size()) {
                Acervo ac = acervos.get(posicao);
                if (ac.getTipo().equals(tipo) || tipo.equals(AcervoTipoEnum.TODOS)) {
                    return true;
                } else {
                    posicao++;
                }
            }
            return false;
        }

        @Override
        public Acervo next() {
            Acervo ac = acervos.get(posicao);
            posicao++;
            return ac;
        }
    }
}

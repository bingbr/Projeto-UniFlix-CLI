package adapter;

public class PrecoAdapter extends PrecoDolar{
    
    @Override
    public void setPreco(double preco) {
        super.setPreco(preco * 5.02375);
    }
}

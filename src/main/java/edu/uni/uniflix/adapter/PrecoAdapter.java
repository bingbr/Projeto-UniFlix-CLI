package edu.uni.uniflix.adapter;

public class PrecoAdapter extends PrecoDolar {
    @Override
    public void setPreco(double preco) {
        super.setPreco(preco * 4.9446);
    }
}

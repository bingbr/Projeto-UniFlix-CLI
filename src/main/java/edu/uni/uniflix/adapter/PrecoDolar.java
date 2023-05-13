package edu.uni.uniflix.adapter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrecoDolar {
    private double preco;
    
    public double getPreco() {
        int decimais = 2;
        BigDecimal bigDecimal = new BigDecimal(preco).setScale(decimais, RoundingMode.HALF_EVEN);
        return bigDecimal.doubleValue();
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
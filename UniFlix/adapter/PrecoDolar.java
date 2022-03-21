package adapter;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrecoDolar {
    private double preco;
    private int decimais = 2;

    public double getPreco(){
        BigDecimal bigDecimal = new BigDecimal(preco).setScale(decimais, RoundingMode.HALF_EVEN);
        double arrendodado = bigDecimal.doubleValue();
        return arrendodado;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }
}
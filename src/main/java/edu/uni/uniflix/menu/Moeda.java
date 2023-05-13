package edu.uni.uniflix.menu;

import java.util.Scanner;

import edu.uni.uniflix.adapter.PrecoAdapter;

public class Moeda {
    PrecoAdapter precoReal = new PrecoAdapter();
    
    public void valor(Scanner ler) throws Exception {
        double preco = Generic.mensagem("\nDigite o preço em dólar do item: ", ler, "Preço", Double::parseDouble);
        converter(preco);
    }
    
    private void converter(double preco) {
        precoReal.setPreco(preco);
        resposta();
    }

    private void resposta() {
        System.out.println("O preço em real é de R$ " + precoReal.getPreco());
    }
}

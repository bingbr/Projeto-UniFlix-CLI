package edu.uni.uniflix.menu;

public class Erro {
    private static String tipo(Exception ex) {
        switch (ex.getClass().getSimpleName().toLowerCase()) {
            case "ioexception","numberformatexception":
                return "Você digitou um valor inválido!";
            case "inputmismatchexception":
                return ex.getMessage() + " inválido(a).";
            case "nosuchelementexception":
                return "Elemento inexistente!";
            case "illegalargumentexception":
                return "A posição inserida é inválida!";
            case "nullpointerexception":
                return "Impossível " + ex.getMessage() + " item em uma lista vazia!";
            default:
                System.out.println(ex.getClass().getSimpleName());
                return "Ops, ocorreu um erro!";
        }
    }

    public static void mensagem(Exception ex) {
        System.err.println("ERRO = " + tipo(ex));
    }
}
package edu.uni.uniflix;

import java.util.Scanner;

import edu.uni.uniflix.menu.Principal;

/**
 * <h1>Main</h1>
 *  Responsável por iniciar o programa.
 *  @author William
 *  @since  04/12/2020
 */
public class Main {
    public static void main(String[] args) {
        if (System.console() != null) {
            Scanner ler = new Scanner(System.in);
            System.out.print("Bem-vindo!");
            Principal menu = new Principal(ler);
            menu.iniciar();
        } else {
            System.exit(0);
        }
    }
}
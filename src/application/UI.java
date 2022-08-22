package application;

import board.Board;
import game.PlayerSymbol;

public class UI {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // se a casa tiver vazia, imprime "-"; ao contrário, imprime o símbolo ocupando a casa
    private static void printSymbol(PlayerSymbol symbol) {
        if (symbol == null) {
            System.out.print("-");
        } else {
            System.out.print(symbol);
        }
        System.out.print(" ");
    }

    // imprime o tabuleiro do jogo
    public static void printBoard(PlayerSymbol[][] symbols) {
        for (int i = 0; i < symbols.length; i++) {
            System.out.print((3 - i) + " ");
            for (int j = 0; j < symbols.length; j++) {
                printSymbol(symbols[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c");
    }


}

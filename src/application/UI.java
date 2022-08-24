package application;

import game.GamePosition;
import game.Match;
import game.PlayerSymbol;
import game.Type;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    // limpa a tela (na teoria, pq na prática não limpou nada)
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // se a casa tiver vazia, imprime "-"; ao contrário, imprime o símbolo ocupando a casa
    private static void printSymbol(PlayerSymbol symbol) {
        if (symbol == null) {
            System.out.print("-");
        } else {
            if (symbol.getType() == Type.O) {
                // imprime símbolo O na cor ciano
                System.out.print(ANSI_CYAN + symbol + ANSI_RESET);
            }
            else {
                // imprime símbolo X na cor roxa
                System.out.print(ANSI_PURPLE + symbol + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    // imprime o tabuleiro do jogo
    public static void printBoard(PlayerSymbol[][] symbols) {
        for (int i = 0; i < symbols.length; i++) {
            System.out.print((3 - i) + " "); //linhas
            for (int j = 0; j < symbols.length; j++) {
                printSymbol(symbols[i][j]); //tabuleiro em si
            }
            System.out.println();
        }
        System.out.println("  a b c"); //colunas
    }

    // imprime a partida no console
    public static void printMatch(Match match) {
        printBoard(match.getSymbols()); //imprime o tabuleiro
        System.out.println();

        if (!match.checkDraw()) {
            System.out.println("Current player: " + match.getCurrentPlayer()); //mostra jogador atual
            if (match.checkWin()) {
                System.out.println("PLAYER " + match.getCurrentPlayer() + " WINS!"); //mostra vitória
            }
        } else { //quando o tabuleiro estiver totalmente preenchido
            System.out.println("DRAW!");
            System.out.println("There are no moves left.");
        }
    }

    // lê a posição passada pelo jogador
    public static GamePosition readGamePosition(Scanner scan) {
        try {
            String s = scan.nextLine();
            char column = s.charAt(0); //separa a letra da posição
            int row = Integer.parseInt(s.substring(1)); //separa o número da posição

            return new GamePosition(column, row); //cria novo objeto com a posição passada pelo jogador
        }
        //se o jogador inserir uma posição inexistente no teclado, lança uma exceção
        catch (RuntimeException e) {
            throw new InputMismatchException("Invalid position: valid values range from a1 to c3.");
        }
    }


}

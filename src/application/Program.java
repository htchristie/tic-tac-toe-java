package application;

import exceptions.GameException;
import game.GamePosition;
import game.Match;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Match match = new Match();

        // enquanto não tiver empate nem vitória
        while (!match.isDraw() && !match.isWin()) {
            try {
                UI.clearScreen();
                UI.printMatch(match);
                System.out.println();
                System.out.print("Campo: ");
                GamePosition position = UI.readGamePosition(scan);
                match.placeNewSymbol(position);
                System.out.println();
            }
            catch (GameException | InputMismatchException e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(match);
    }
}

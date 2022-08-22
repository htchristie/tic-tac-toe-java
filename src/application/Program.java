package application;

import exceptions.GameException;
import game.GamePosition;
import game.Match;
import game.PlayerSymbol;
import game.Type;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Match match = new Match();

        while (true) {
            try {
                UI.clearScreen();
                UI.printMatch(match);
                System.out.println();
                System.out.print("Campo: ");
                GamePosition position = UI.readGamePosition(scan);
                match.placeNewSymbol(position);
            }
            catch (GameException e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }
    }
}

package application;

import game.Match;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Match match = new Match();
        UI.printBoard(match.getSymbols());
    }
}

package game;

import board.Board;

public class Match {
    private Board board;

    // inicia partida com um tabuleiro 3x3
    public Match() {
        this.board = new Board(3, 3);
    }

    public PlayerSymbol[][] getSymbols() {
        PlayerSymbol[][] mat = new PlayerSymbol[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (PlayerSymbol) board.findSymbol(i, j);
            }
        }
        return mat;
    }
}

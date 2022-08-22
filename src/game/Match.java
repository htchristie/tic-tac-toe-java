package game;

import board.Board;

public class Match {
    private Board board;

    // inicia partida com um tabuleiro 3x3
    public Match() {
        this.board = new Board(3, 3);
        test();
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

    // coloca o símbolo no tabuleiro, na posição de jogo passada
    public void placeNewSymbol(char column, int row, PlayerSymbol symbol) {
        board.placeSymbol(symbol, new GamePosition(column, row).toPosition());
    }

    public void test() {
        placeNewSymbol('a', 2, new PlayerSymbol(this.board, Type.O));
        placeNewSymbol('b', 2, new PlayerSymbol(this.board, Type.X));
        placeNewSymbol('c', 2, new PlayerSymbol(this.board, Type.O));
        placeNewSymbol('c', 1, new PlayerSymbol(this.board, Type.X));
    }
}

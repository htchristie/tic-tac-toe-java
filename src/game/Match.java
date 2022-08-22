package game;

import board.Board;
import board.Position;

public class Match {
    private Board board;
    private Type currentPlayer;

    // inicia partida com um tabuleiro 3x3
    public Match() {
        this.board = new Board(3, 3);
        currentPlayer = Type.X;
        //test();
    }

    public Board getBoard() {
        return board;
    }

    public Type getCurrentPlayer() {
        return currentPlayer;
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

    // coloca o símbolo no tabuleiro, na posição de jogo passada pelo jogador
    public void placeNewSymbol(GamePosition position) {
        PlayerSymbol symbol = new PlayerSymbol(this.board, currentPlayer);
        Position field = position.toPosition();
        board.placeSymbol(symbol, field);
        nextTurn();
    }

    private void nextTurn() {
        currentPlayer = (currentPlayer == Type.O) ? Type.X : Type.O;
    }

    /*public void test() {
        placeNewSymbol('a', 2, new PlayerSymbol(this.board, Type.O));
        placeNewSymbol('b', 2, new PlayerSymbol(this.board, Type.X));
        placeNewSymbol('c', 2, new PlayerSymbol(this.board, Type.O));
        placeNewSymbol('c', 1, new PlayerSymbol(this.board, Type.X));
    }*/
}

package game;

import board.Board;
import board.Symbol;

public class PlayerSymbol extends Symbol {
    private Type type;

    public PlayerSymbol(Board board, Type type) {
        super(board);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}


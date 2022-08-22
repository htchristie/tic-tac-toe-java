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

    @Override
    public String toString() {
        if (type == Type.O) {
            return "◯";
        } else {
            return "X";
        }
    }
}


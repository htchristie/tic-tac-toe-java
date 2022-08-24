package game;

import board.Position;
import exceptions.GameException;

import java.util.Objects;

public class GamePosition {

    // utiliza posição do tabuleiro do jogo ex. a3
    private char column;
    private int row;

    public GamePosition(char column, int row) {
        if (column < 'a' || column > 'c' || row < 1 || row > 3) {
            throw new GameException("Invalid position: valid values range from a1 to c3.");
        }

        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    // transforma posição do tabuleiro em posição de matriz
    protected Position toPosition() {
        return new Position(3 - row, column - 'a');
    }

    // transforma posição de matriz em posição do tabuleiro
    protected static GamePosition fromPosition(Position position) {
        return new GamePosition((char) ('a' + position.getColumn()), 3 - position.getRow());
    }

    @Override
    public String toString() {
        return "" + column + row;
        // "" serve pra avisar que o texto deve ser impresso como String (row é int)
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamePosition position = (GamePosition) o;
        return getColumn() == position.getColumn() && getRow() == position.getRow();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumn(), getRow());
    }
}

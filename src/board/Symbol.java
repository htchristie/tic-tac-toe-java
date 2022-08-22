package board;

public class Symbol {
    protected Position position;
    private Board board;

    public Symbol(Board board) {
        this.board = board;
    }

    protected Board getBoard() {
        return board;
    }
}

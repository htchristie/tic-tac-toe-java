package board;

public abstract class Symbol {
    protected Position position;
    private Board board;

    public Symbol(Board board) {
        this.board = board;
    }
}
